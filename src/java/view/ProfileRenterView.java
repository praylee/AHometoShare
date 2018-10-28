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

import business.HostBusinessLayer;
import business.PropertyBusinessLayer;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import transferobjects.Host;
import transferobjects.Property;
import transferobjects.Renter;
import java.text.SimpleDateFormat;
import javax.servlet.RequestDispatcher;

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

            /*System.out.println("Made it to Renter Profile!");
        
            PropertyBusinessLayer propertyBusiness = new PropertyBusinessLayer();
            List<Property> propertiesList = propertyBusiness.getAllProperty();
              
              
            HostBusinessLayer hostBusiness = new HostBusinessLayer();
            List<Host> hostList = hostBusiness.getAllHost();

            
            List<Entry<Host,Property>> pairList = new ArrayList<Entry<Host, Property>>();

            for (Property property: propertiesList) {
                int hostID = property.getHostID();
                Host propertyOwner = null;
                for (Host host: hostList) {
                    if (host.getHostID() == hostID) {
                        propertyOwner = host;
                        break;
                    }
                }
                Entry<Host, Property> entry = new SimpleEntry<Host, Property>(propertyOwner, property);
                pairList.add(entry);
                
            }
              
//            request.setAttribute("properties", propertiesList); //send list of properties
//            request.setAttribute("hosts", hostList); //send list of hosts
            request.setAttribute("hostproperties", pairList); //send list of both Host and Property pairs

            RequestDispatcher rd = request.getRequestDispatcher("renterProfileSearch.jsp"); //for now go right here
            rd.forward(request,response); */ 
            
            //COMMENTED OUT ABOVE AS SEARCH LISTINGS IS ON PROFILE PAGE AND NOT ITS OWN PAGE
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
