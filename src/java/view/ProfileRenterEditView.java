/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import business.RenterBusinessLayer;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import transferobjects.Renter;

/**
 *
 * @author chris
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
        
        HttpSession session = request.getSession();
            
            boolean updateOk = true;
            String invalidReason = null;
            
            String firstName = request.getParameter("firstname");
            String lastName = request.getParameter("lastname");
            String phone = request.getParameter("phoneNum");
            int gender = Integer.parseInt(request.getParameter("gender"));
            String birthYear = request.getParameter("yearBorn");
            
            boolean isStudent;
            try {isStudent = request.getParameterValues("isStudent")[0].equals("on");}
            catch(NullPointerException e) {isStudent = false;}
            
            boolean isEmployed;
            try {isEmployed = request.getParameterValues("isEmployed")[0].equals("on");}
            catch(NullPointerException e) {isEmployed = false;}
            
            boolean isSmoker;
            try {isSmoker = request.getParameterValues("isSmoker")[0].equals("on");}
            catch(NullPointerException e) {isSmoker = false;}
            
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
            Date startDate = null;
            Date endDate = null;
            try {
                    startDate = formatter.parse(request.getParameter("startDate"));
                    endDate = formatter.parse(request.getParameter("endDate"));
            } catch (ParseException e) {
                
                try {
                    startDate = formatter.parse(session.getAttribute("startDate").toString());
                    endDate = formatter.parse(session.getAttribute("endDate").toString());
                }
                catch(ParseException pe) {}
                    updateOk = false;
                    invalidReason = "Improper date format";
            }
            java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
            java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());

            double lowPrice = Double.parseDouble(session.getAttribute("lowPrice").toString());
            double highPrice = Double.parseDouble(session.getAttribute("highPrice").toString());
            try {
                lowPrice = Double.parseDouble(request.getParameter("lowPrice"));
                highPrice = Double.parseDouble(request.getParameter("highPrice"));
            }
            catch(NumberFormatException e) {
                updateOk = false;
                invalidReason = "Invalid price parameter.";
            }
            
            if(updateOk) {
                RenterBusinessLayer renterBusiness = new RenterBusinessLayer();
                renterBusiness.updateRenter(firstName, lastName, phone, gender, birthYear, 
                        isStudent, isEmployed, isSmoker, sqlStartDate, sqlEndDate, lowPrice, highPrice, Integer.parseInt(session.getAttribute("renterId").toString()));
                
                Renter renter = renterBusiness.getRenterByEmail(session.getAttribute("email").toString());
                this.setRenterSessionAttributes(session, renter);
                response.sendRedirect("renterProfile.jsp");
            }
            else {
                request.setAttribute("invalidReason", invalidReason);
                RequestDispatcher rd = request.getRequestDispatcher("renterProfile.jsp");  // send error message
                rd.forward(request,response);
            }
    }
    
    private void setRenterSessionAttributes(HttpSession session, Renter renter) {
        session.setAttribute("isLoggedIn", "true");
        session.setAttribute("userType", "renter");
        session.setAttribute("renterId", renter.getRenterID());
        session.setAttribute("email", renter.getEmail());
        session.setAttribute("firstName", renter.getFirstName());
        session.setAttribute("lastName", renter.getLastName());
        session.setAttribute("phone", renter.getPhone());
        session.setAttribute("gender", renter.getGender());
        session.setAttribute("dateBirth", renter.getDateBirth());
        session.setAttribute("isStudent", renter.getIsStudent());
        session.setAttribute("isEmployed", renter.getIsEmployed());
        session.setAttribute("isSmoker", renter.getIsSmoker());
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        session.setAttribute("startDate", formatter.format(renter.getStartDate()));
        session.setAttribute("endDate", formatter.format(renter.getEndDate()));
        session.setAttribute("lowPrice", renter.getLowPrice());
        session.setAttribute("highPrice", renter.getHighPrice());
        session.setAttribute("referralSource", renter.getReferralSource());
        session.setAttribute("hasCRCheck", renter.getHasCRCheck());

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
