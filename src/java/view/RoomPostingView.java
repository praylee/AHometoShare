/*
 * File: RoomPostingView.java
 * Description: Dealing with host's room posting page and insert property's information into Property table and PropertyXResource table in database
 * Create: Oct 23,2018
 * Author: Bin Yang
 * Modified by Liangliang Du for adding pictures
 * Clients: Michelle Bilek,Farheen Khan
 * Course: Software Development Project
 * Professor: Dr. Anu Thomas
 * Project: A Home to Share
 * Copyright @ 2018
 */

package view;

import business.HostBusinessLayer;
import business.PropertyBusinessLayer;
import business.PropertyPictureBusinessLayer;
import business.PropertyXResourceLayer;
import business.ResourceBusinessLayer;
import business.ValidationException;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.List;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import transferobjects.Property;
import transferobjects.PropertyPicture;
import transferobjects.PropertyXResource;
import transferobjects.Resource;


/**
 *
 * @author Bin Yang
 */

@MultipartConfig(maxFileSize=16177216)
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
            throws ServletException, IOException, ParseException, ValidationException {
        
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
        //int resourceid = 0;
        
        HostBusinessLayer hostLayer = new HostBusinessLayer();
        PropertyBusinessLayer propertyLayer = new PropertyBusinessLayer();
        //PropertyXResourceLayer propertyXresource = new PropertyXResourceLayer();

        List<Property> propertyList = propertyLayer.getAllProperty();
        int index = propertyList.size();
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date staDate = sdf.parse(startdate);
        java.sql.Date sDate = new java.sql.Date(staDate.getTime());
        
        java.sql.Date eDate;
        if (enddate.equals("")){
            eDate = new java.sql.Date(sdf.parse("2099-12-31").getTime());
        } else {
            eDate = new java.sql.Date(sdf.parse(enddate).getTime());
        }
        
        int hostid = hostLayer.getHostByEmail(email).getHostID();
        
        Property property = new Property(index+1,hostid,address,city,postalcode,province,country,Integer.parseInt(fammembers),Boolean.parseBoolean(SmokerFriendly),Boolean.parseBoolean(PetFriendly),
                Boolean.parseBoolean(hydro),Boolean.parseBoolean(water),Boolean.parseBoolean(gas),Boolean.parseBoolean(cable),Boolean.parseBoolean(internet),
                Boolean.parseBoolean(parking),Boolean.parseBoolean(laundry),Boolean.parseBoolean(familyroom),Boolean.parseBoolean(privatebedroom),Boolean.parseBoolean(sharedbedroom),
                Boolean.parseBoolean(privatekitchen),Boolean.parseBoolean(sharedkitchen),Boolean.parseBoolean(privatewashroom),Boolean.parseBoolean(sharedwashroom),Double.parseDouble(price),sDate,eDate,chores,Integer.parseInt(availability));
        //Property property = new Property(index+1,1,address,"Ottawa","K1l 3K4","ontario","Canada",3,true,false,1000.0,new java.sql.Date(System.currentTimeMillis()),new java.sql.Date(System.currentTimeMillis()),"clean",6);

        propertyLayer.addProperty(property);
    
        // save image into database     

        PropertyPictureBusinessLayer pPictureLayer = new PropertyPictureBusinessLayer();

        List<PropertyPicture> pictureList = pPictureLayer.getAllPictures();
        int pindex = pictureList.size();
        int property_id = index+1;

        Part part=request.getPart("inputfile");  
        String picture = request.getParameter("inputfile");
        if(part != null){
            PropertyPicture propertypicture = new PropertyPicture(pindex+1,property_id,picture);
            InputStream is = part.getInputStream();
            pPictureLayer.addPicture(propertypicture,is);
        } 
        
        
        // Only do this if user was successfully added to database!!!!
        request.setAttribute("Info", "Room posting Successful.");
        RequestDispatcher rd = request.getRequestDispatcher("hostProfile.jsp");  //go to registerConfirm if signUp successful
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(RoomPostingView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ValidationException ex) {
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
        } catch (ValidationException ex) {
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
