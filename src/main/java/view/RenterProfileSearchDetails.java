/*
 * File: RenterProfileSearchDetails.java
 * Description: The view layer for detailed information on a selected property
 * Create: Sep,30,2018
 * Author: Melissa Rajala
 * Clients: Michelle Bilek,Farheen Khan
 * Course: Software Development Project
 * Professor: Dr. Anu Thomas
 * Project: A Home to Share
 * Copyright @ 2018
 */
package view;

import business.HostBusinessLayer;
import business.PropertyBusinessLayer;
import business.RenterBusinessLayer;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.Host;
import transferobjects.Property;
import transferobjects.Renter;

/**
 *
 * @author Melissa Rajala
 */
public class RenterProfileSearchDetails extends HttpServlet {

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

        RenterSession session = new RenterSession(request.getSession());
        
        //checking for session expiration
        if(session.getAttribute("renterId") == null) {
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

        System.out.println("In get after request to book"); //process a renter booking request
        
        //host id of property for request
        String book = request.getParameter("bookingHost");
        
        if (book != null){
            int bookingHostID = Integer.parseInt(book); //get integer value of host id
            HostBusinessLayer hostBusiness = new HostBusinessLayer();
            Host bookingHost = hostBusiness.getHostByHostId(bookingHostID);  //get host from database

            //get current renter by session
            RenterSession rSession = new RenterSession(request.getSession());
            Object rIDObject = rSession.getAttribute("email");
        
            String rEmail = (String) rIDObject; //get current renter's email address
        
            RenterBusinessLayer renterBusiness = new RenterBusinessLayer();
            Renter bookingRenter = renterBusiness.getRenterByEmail(rEmail); //get current renter by email
        
            //send an email to A Home to Share for booking request
            EmailFactory email = new EmailFactory();
            email.sendBookingRequest("info@ahometoshare.ca", bookingRenter, bookingHost);
        
            
            request.setAttribute("host", bookingHost); //send host of property
            request.setAttribute("renter", bookingRenter); //send renter who is requesting
       
            RequestDispatcher rd = request.getRequestDispatcher("renterProfileSearchDetailsRequest.jsp"); 
            rd.forward(request,response);
        }
        
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

        //get host and property to display details - navigated here from RenterProfileSearch
        
        int propertyID = Integer.parseInt(request.getParameter("propID"));
        int hostID = Integer.parseInt(request.getParameter("hostID"));

        System.out.println("Host id is: " + hostID);
        System.out.println("Property id is: " + propertyID);

        PropertyBusinessLayer propertyBusiness = new PropertyBusinessLayer();
        Property property = propertyBusiness.getPropertyById(propertyID);

        
        HostBusinessLayer hostBusiness = new HostBusinessLayer();
        Host host = hostBusiness.getHostByHostId(hostID); 
        
        request.setAttribute("property", property); //send selected property
        request.setAttribute("host", host); //send host of property

        RequestDispatcher rd = request.getRequestDispatcher("renterProfileSearchDetails.jsp"); 
        rd.forward(request,response); 
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
