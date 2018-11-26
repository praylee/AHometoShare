/*
 * File: ProfileRenterView.java
 * Description:
 * Create: Sep,30,2018
 * Author: Bits & Bytes Team-Christopher Labelle,Liangliang Du,Melissa Rajala,Zhan Shen,Xia Sheng,Bin Yang
 * Clients: Michelle Bilek,Farheen Khan
 * Course: Software Development Project
 * Professor: Dr. Anu Thomas
 * Project: A Home to Share
 * Copyright @ 2018
 */
package view;

import business.RenterBusinessLayer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.Renter;

/**
 *
 * @author Chris Labelle
 */
public class ProfileRenterView extends HttpServlet {

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
            /*
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
            */

            if(updateOk) {
                RenterBusinessLayer renterBusiness = new RenterBusinessLayer();
                renterBusiness.updateRenter(firstName, lastName, phone, gender, birthYear, 
                        isStudent, isEmployed, isSmoker, 
                        Integer.parseInt(session.getAttribute("renterId").toString()));

                Renter renter = renterBusiness.getRenterByEmail(session.getAttribute("email").toString());
                session.setSessionAttributes(renter, true);
                try{session.removeAttribute("invalidReason");}
                catch(NullPointerException e){}
                response.sendRedirect("renterProfile.jsp");
            }
            else {
                session.setAttribute("invalidReason", invalidReason);
                response.sendRedirect("renterProfile.jsp");
            }   
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
