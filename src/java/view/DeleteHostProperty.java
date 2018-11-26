/*
 * File: RenterProfileSearchDetails.java
 * Description:
 * Create: NOV 17,2018
 * Author: Bin Yang
 * Clients: Michelle Bilek,Farheen Khan
 * Course: Software Development Project
 * Professor: Dr. Anu Thomas
 * Project: A Home to Share
 * Copyright @ 2018
 */
package view;

import business.HostBusinessLayer;
import business.PropertyBusinessLayer;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.Host;
import transferobjects.Property;

/**
 *
 * @author Melissa Rajala
 */
public class DeleteHostProperty extends HttpServlet {

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
        System.out.println("Made it to Host Property Details (Renter Searching)!");
        
        HostSession session = new HostSession(request.getSession());
        if(session.getAttribute("hostId") == null) {
            System.out.println("Session has expried.");
            session.endSession();
            response.sendRedirect("index.jsp");
        }
        else {
            // do something
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

        
        int propertyID = Integer.parseInt(request.getParameter("propID"));
        String propertyAddress = request.getParameter("address");
        
        PropertyBusinessLayer propertyBusiness = new PropertyBusinessLayer();
        propertyBusiness.deleteProperty(propertyID);
        
        PropertyProfile profile = new PropertyProfile();
        profile.processRequest(request, response);

        //request.setAttribute("deleteSuccess", "Your property had been deleted"); 
        
        //RequestDispatcher rd = request.getRequestDispatcher("propertyProfile.jsp"); 
        //rd.forward(request,response); 
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
