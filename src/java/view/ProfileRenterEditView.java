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
        
        boolean updateOk = true;
        String invalidReason = null;
        HttpSession session = request.getSession();
        RenterBusinessLayer renterBusiness = new RenterBusinessLayer();
        Renter renter = renterBusiness.getRenterByEmail(session.getAttribute("email").toString());
        String ogPassword = request.getParameter("old_pwd");
        String newPassword = request.getParameter("new_pwd");
        String confNewPassword = request.getParameter("confirm_new_pwd");
        
        System.out.print(renterBusiness.passwordCorrect(renter.getEmail(), ogPassword));
        
        if(!renterBusiness.passwordCorrect(renter.getEmail(), ogPassword)) {
            System.out.print(renterBusiness.passwordCorrect(renter.getEmail(), ogPassword));
            updateOk = false;
            invalidReason = "Original password not correct. Changes rolled back.";
        }
        
        if(!newPassword.equals(confNewPassword)) {
            updateOk = false;
            invalidReason = "New password does not match confirmed entry.";
        }
        
        if(updateOk) {
            renterBusiness.updateRenter(newPassword, Integer.parseInt(session.getAttribute("renterId").toString()));

            try{session.removeAttribute("invalidReason");}
            catch(NullPointerException e){}
            response.sendRedirect("renterProfile.jsp");
        }
        else {
            session.setAttribute("invalidReason", invalidReason);
            response.sendRedirect("renterAccountSettings.jsp");
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
