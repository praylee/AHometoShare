/*
 * File: ProfileHostView.java
 * Description:
 * Create: Sep,30,2018
 * Author: Xia Sheng
 * Clients: Michelle Bilek,Farheen Khan
 * Course: Software Development Project
 * Professor: Dr. Anu Thomas
 * Project: A Home to Share
 * Copyright @ 2018
 */
package view;

import business.HostBusinessLayer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.Host;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Xia Sheng
 */
public class ProfileHostView extends HttpServlet {

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
            

           HostSession session = new HostSession(request.getSession());           
            boolean updateOk = true;
            String invalidReason = null;
            
            String firstName = request.getParameter("firstname");
            String lastName = request.getParameter("lastname");
            String phone = request.getParameter("phone");
            int gender = Integer.parseInt(request.getParameter("gender"));
            String birthYear = request.getParameter("dateBirth");
            String referralSource=request.getParameter("referralSource");
            
            boolean retired;
            try {retired = request.getParameterValues("isRetired")[0].equals("on");}
            catch(NullPointerException e) {retired = false;}
            
            boolean pets;
            try {pets = request.getParameterValues("isPets")[0].equals("on");}
            catch(NullPointerException e) {pets = false;}
            
            boolean smoker;
            try {smoker = request.getParameterValues("isSmoker")[0].equals("on");}
            catch(NullPointerException e) {smoker = false;}
            
            if(updateOk) {
                HostBusinessLayer hostBusiness = new HostBusinessLayer();
                hostBusiness.updateHost(firstName, lastName, phone, gender, birthYear, 
                        retired, pets, smoker, referralSource,Integer.parseInt(session.getAttribute("hostId").toString()));
                
                Host host = hostBusiness.getHostByEmail(session.getAttribute("email").toString());
                session.setSessionAttributes(host, true);
                try{session.removeAttribute("invalidReason");}
            catch(NullPointerException e){}
            response.sendRedirect("hostProfile.jsp");
        }
            else {
                request.setAttribute("invalidReason", invalidReason);
                RequestDispatcher hp = request.getRequestDispatcher("hostProfile.jsp");  // send error message
                hp.forward(request,response);
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
