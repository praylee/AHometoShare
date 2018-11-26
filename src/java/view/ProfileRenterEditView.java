/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import business.RenterBusinessLayer;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Christopher Labelle
 */
public class ProfileRenterEditView extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        RenterSession session = new RenterSession(request.getSession());
        
        if(session.getAttribute("renterId") == null) {
            System.out.println("Session has expried.");
            session.endSession();
            response.sendRedirect("index.jsp");
        }
        else {
        
            String email = request.getParameter("email");
            String btnUpdate = request.getParameter("update");
            String btnDelete = request.getParameter("delete");

            RenterBusinessLayer renterBusiness = new RenterBusinessLayer();

            if(btnUpdate != null){ //click update password button

                String old_password = request.getParameter("old_pwd");
                String new_password = request.getParameter("new_pwd");
                String confirm_new_pwd = request.getParameter("confirm_new_pwd");


                if(renterBusiness.passwordCorrect(email, old_password)){ //check old password entered matches or not

                    String upperCaseChars = "(.*[A-Z].*)";           
                    String lowerCaseChars = "(.*[a-z].*)";        
                    String numbers = "(.*[0-9].*)";

                    if(new_password.length()<6 || !new_password.matches(upperCaseChars) || !new_password.matches(lowerCaseChars) || !new_password.matches(numbers)){
                        request.setAttribute("new_pwd_info", "Password must be at least 6 characters and it must contain at least one captial letter and  one number. E.g.: Canada123");

                    }
                    else {
                        if(new_password.equals(old_password))
                            request.setAttribute("new_pwd_info", "Please enter a different password with the old password.");
                        else if(!confirm_new_pwd.equals(new_password))
                            request.setAttribute("confirm_pwd_info", "Your password and confirmation password do not match.");
                        else{ //update password into database
                            try{
                                renterBusiness.updateRenter(new_password,renterBusiness.getRenterByEmail(email).getRenterID()); 

                                if(renterBusiness.passwordCorrect(email, new_password))
                                   request.setAttribute("update_info", "Password was updated successfully.");
                                else
                                   request.setAttribute("update_info", "Password was not updated successfully."); 
                            }catch(Exception e){
                                request.setAttribute("update_info", "Update password failed. Please check database connection.");
                            }
                        }              
                    }
                    RequestDispatcher rd = request.getRequestDispatcher("renterAccountSettings.jsp");  
                    rd.forward(request,response);
                }
                else{
                    request.setAttribute("old_pwd_info", "The password you have entered does not match your current password.");
                    RequestDispatcher rd = request.getRequestDispatcher("renterAccountSettings.jsp");  
                    rd.forward(request,response);  
                }
            }
            if(btnDelete != null){ // click delete account button
                renterBusiness.deleteRenter(renterBusiness.getRenterByEmail(email).getRenterID());  
                response.sendRedirect("LogoutRedirect");
            }
//        boolean updateOk = true;
//        String invalidReason = null;
//        HttpSession session = request.getSession();
//        RenterBusinessLayer renterBusiness = new RenterBusinessLayer();
//        Renter renter = renterBusiness.getRenterByEmail(session.getAttribute("email").toString());
//        String ogPassword = request.getParameter("old_pwd");
//        String newPassword = request.getParameter("new_pwd");
//        String confNewPassword = request.getParameter("confirm_new_pwd");
//        
//        System.out.print(renterBusiness.passwordCorrect(renter.getEmail(), ogPassword));
//        
//        if(!renterBusiness.passwordCorrect(renter.getEmail(), ogPassword)) {
//            System.out.print(renterBusiness.passwordCorrect(renter.getEmail(), ogPassword));
//            updateOk = false;
//            invalidReason = "Original password not correct. Changes rolled back.";
//        }
//        
//        if(!newPassword.equals(confNewPassword)) {
//            updateOk = false;
//            invalidReason = "New password does not match confirmed entry.";
//        }
//        
//        if(updateOk) {
//            renterBusiness.updateRenter(newPassword, Integer.parseInt(session.getAttribute("renterId").toString()));
//
//            try{session.removeAttribute("invalidReason");}
//            catch(NullPointerException e){}
//            response.sendRedirect("renterProfile.jsp");
//        }
//        else {
//            session.setAttribute("invalidReason", invalidReason);
//            response.sendRedirect("renterAccountSettings.jsp");
//        }     
        }
    }
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
