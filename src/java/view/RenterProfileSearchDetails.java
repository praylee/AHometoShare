/*
 * File: RenterProfileSearchDetails.java
 * Description:
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
//        processRequest(request, response);

//                String valOfI = request.getParameter("valOfI");
        int propertyID = Integer.parseInt(request.getParameter("propID"));
        int hostID = Integer.parseInt(request.getParameter("hostID"));

        System.out.println("Host id is: " + hostID);
        System.out.println("Property id is: " + propertyID);
//        int inthostID = 0;
//        try {
//            inthostID = Integer.parseInt(hostID);
//        } catch (NumberFormatException e) {
//            e.printStackTrace();
//        }
        PropertyBusinessLayer propertyBusiness = new PropertyBusinessLayer();
        Property property = propertyBusiness.getPropertyById(propertyID);

        
        HostBusinessLayer hostBusiness = new HostBusinessLayer();
        Host host = hostBusiness.getHostByHostId(hostID); 
//        Host host = hostBusiness.getHostByEmail(hostEmail);
        
//        System.out.println(host.getFirstName());
        
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
