/*
 * File: ProfileRenterView.java
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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.RequestDispatcher;
import transferobjects.Host;
import transferobjects.Property;

/**
 *
 * @author Melissa Rajala
 */
public class PropertyProfile extends HttpServlet {

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
        System.out.println("Made it to Renter Profile Search!");
        
        PropertyBusinessLayer propertyBusiness = new PropertyBusinessLayer();
        List<Property> propertiesList = propertyBusiness.getAllProperty();
              
              
        HostBusinessLayer hostBusiness = new HostBusinessLayer();
        List<Host> hostList = hostBusiness.getAllHost();
            
        List<Map.Entry<Host,Property>> pairList = new ArrayList<Map.Entry<Host, Property>>();

        for (Property property: propertiesList) {
            int hostID = property.getHostID();
            Host propertyOwner = null;
            for (Host host: hostList) {
                if (host.getHostID() == hostID) {
                    propertyOwner = host;
                    break;
                }
            }
            Map.Entry<Host, Property> entry = new AbstractMap.SimpleEntry<Host, Property>(propertyOwner, property);
            pairList.add(entry);
                
        }
              
        request.setAttribute("hostproperties", pairList); //send list of both Host and Property pairs

        RequestDispatcher rd = request.getRequestDispatcher("propertyProfile.jsp"); 
        rd.forward(request,response); 
            


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
