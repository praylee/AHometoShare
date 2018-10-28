/*
 * File: RoomPostingView.java
 * Description: Dealing with host's room posting page and insert property's information into Property table and PropertyXResource table in database
 * Create: Oct 23,2018
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
import business.PropertyXResourceLayer;
import business.ResourceBusinessLayer;
import business.ValidationException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.Property;
import transferobjects.PropertyXResource;
import transferobjects.Resource;


/**
 *
 * @author Bin Yang
 */
public class RoomPostingView extends HttpServlet {
    
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
            throws ServletException, IOException, ParseException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String province = request.getParameter("province");
        String country = request.getParameter("country");
        String postalcode = request.getParameter("postalcode");     
        String startdate = request.getParameter("startdate");
        String enddate = request.getParameter("enddate");
        String fammembers = request.getParameter("fammembers");
        String availability = request.getParameter("availability");
        String SmokerFriendly = request.getParameter("isSmokerFriendly");
        String PetFriendly = request.getParameter("isPetFriendly");
        String hydro = request.getParameter("hydro");
        String water = request.getParameter("water");
        String gas = request.getParameter("gas");
        String cable = request.getParameter("cable");
        String internet = request.getParameter("internet");
        String parking = request.getParameter("parking");
        String laundry = request.getParameter("laundry");
        String familyroom = request.getParameter("familyroom");
        String privatebedroom = request.getParameter("privatebedroom");
        String sharedbedroom = request.getParameter("sharedbedroom");
        String privatekitchen = request.getParameter("privatekitchen");
        String sharedkitchen = request.getParameter("sharedkitchen");
        String privatewashroom = request.getParameter("privatewashroom");
        String sharedwashroom = request.getParameter("sharedwashroom");
        String chores = request.getParameter("chores");
        String price = request.getParameter("price");
        String email = request.getParameter("email");
        int resourceid = 0;
        
        HostBusinessLayer hostLayer = new HostBusinessLayer();
        PropertyBusinessLayer propertyLayer = new PropertyBusinessLayer();
        PropertyXResourceLayer propertyXresource = new PropertyXResourceLayer();

        List<Property> propertyList = propertyLayer.getAllProperty();
        int index = propertyList.size();
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date staDate = sdf.parse(startdate);
        java.sql.Date sDate = new java.sql.Date(staDate.getTime());
        
        java.sql.Date eDate;
        if (enddate.equals("")){
            eDate = new java.sql.Date(sdf.parse("31-12-2099").getTime());
        } else {
            eDate = new java.sql.Date(sdf.parse(enddate).getTime());
        }
        
        int hostid = hostLayer.getHostByEmail(email).getHostID();
        
        Property property = new Property(index+1,hostid,address,city,postalcode,province,country,Integer.parseInt(fammembers),Boolean.parseBoolean(SmokerFriendly),Boolean.parseBoolean(PetFriendly),Double.parseDouble(price),sDate,eDate,chores,Integer.parseInt(availability));
        //Property property = new Property(index+1,1,address,"Ottawa","K1l 3K4","ontario","Canada",3,true,false,1000.0,new java.sql.Date(System.currentTimeMillis()),new java.sql.Date(System.currentTimeMillis()),"clean",6);

        propertyLayer.addProperty(property);
        // Only do this if user was successfully added to database!!!!
        request.setAttribute("Info", "Room posting Successful.");
        RequestDispatcher rd = request.getRequestDispatcher("hostProfile.jsp");  //go to registerConfirm if signUp successful
        rd.forward(request,response);

        
        if (hydro != null && hydro.equals("true")){
            resourceid = 1;
            PropertyXResource pxr = new PropertyXResource(index+1, resourceid);
            try {
                propertyXresource.addPropertyXResource(pxr);
            } catch (ValidationException ex) {
                Logger.getLogger(RoomPostingView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
        
        if (water != null && water.equals("true")){
            resourceid = 5;
            PropertyXResource pxr = new PropertyXResource(index+1, resourceid);
            try {
                propertyXresource.addPropertyXResource(pxr);
            } catch (ValidationException ex) {
                Logger.getLogger(RoomPostingView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        if (gas != null && gas.equals("true")){
            resourceid = 4;
            PropertyXResource pxr = new PropertyXResource(index+1, resourceid);
            try {
                propertyXresource.addPropertyXResource(pxr);
            } catch (ValidationException ex) {
                Logger.getLogger(RoomPostingView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (cable != null && cable.equals("true")){
            resourceid = 3;
            PropertyXResource pxr = new PropertyXResource(index+1, resourceid);
            try {
                propertyXresource.addPropertyXResource(pxr);
            } catch (ValidationException ex) {
                Logger.getLogger(RoomPostingView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        if (internet != null && internet.equals("true")){
            resourceid = 2;
            PropertyXResource pxr = new PropertyXResource(index+1, resourceid);
            try {
                propertyXresource.addPropertyXResource(pxr);
            } catch (ValidationException ex) {
                Logger.getLogger(RoomPostingView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        if (parking != null && parking.equals("true")){
            resourceid = 8;
            PropertyXResource pxr = new PropertyXResource(index+1, resourceid);
            try {
                propertyXresource.addPropertyXResource(pxr);
            } catch (ValidationException ex) {
                Logger.getLogger(RoomPostingView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        if (laundry != null && laundry.equals("true")){
            resourceid = 6;
            PropertyXResource pxr = new PropertyXResource(index+1, resourceid);
            try {
                propertyXresource.addPropertyXResource(pxr);
            } catch (ValidationException ex) {
                Logger.getLogger(RoomPostingView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        if (familyroom != null && familyroom.equals("true")){
            resourceid = 7;
            PropertyXResource pxr = new PropertyXResource(index+1, resourceid);
            try {
                propertyXresource.addPropertyXResource(pxr);
            } catch (ValidationException ex) {
                Logger.getLogger(RoomPostingView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        if (privatebedroom != null && privatebedroom.equals("true")){
            resourceid = 9;
            PropertyXResource pxr = new PropertyXResource(index+1, resourceid);
            try {
                propertyXresource.addPropertyXResource(pxr);
            } catch (ValidationException ex) {
                Logger.getLogger(RoomPostingView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        if (sharedbedroom != null && sharedbedroom.equals("true")){
            resourceid = 12;
            PropertyXResource pxr = new PropertyXResource(index+1, resourceid);
            try {
                propertyXresource.addPropertyXResource(pxr);
            } catch (ValidationException ex) {
                Logger.getLogger(RoomPostingView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        if (privatekitchen != null && privatekitchen.equals("true")){
            resourceid = 11;
            PropertyXResource pxr = new PropertyXResource(index+1, resourceid);
            try {
                propertyXresource.addPropertyXResource(pxr);
            } catch (ValidationException ex) {
                Logger.getLogger(RoomPostingView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        if (sharedkitchen != null && sharedkitchen.equals("true")){
            resourceid = 14;
            PropertyXResource pxr = new PropertyXResource(index+1, resourceid);
            try {
                propertyXresource.addPropertyXResource(pxr);
            } catch (ValidationException ex) {
                Logger.getLogger(RoomPostingView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        if (privatewashroom != null && privatewashroom.equals("true")){
            resourceid = 10;
            PropertyXResource pxr = new PropertyXResource(index+1, resourceid);
            try {
                propertyXresource.addPropertyXResource(pxr);
            } catch (ValidationException ex) {
                Logger.getLogger(RoomPostingView.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
        
        if (sharedwashroom != null && sharedwashroom.equals("true")){
            resourceid = 13;
            PropertyXResource pxr = new PropertyXResource(index+1, resourceid);
            try {
                propertyXresource.addPropertyXResource(pxr);
            } catch (ValidationException ex) {
                Logger.getLogger(RoomPostingView.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(RoomPostingView.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(RoomPostingView.class.getName()).log(Level.SEVERE, null, ex);
        }
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
