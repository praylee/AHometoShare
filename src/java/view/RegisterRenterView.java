/*
 * File: RegisterRenterView.java
 * Description: Deal with Renter Register form information with database object
 * Create: Sep,30,2018
 * Author: Liangliang Du
 * Clients: Michelle Bilek,Farheen Khan
 * Course: Software Development Project
 * Professor: Dr. Anu Thomas
 * Project: A Home to Share
 * Copyright @ 2018
 */
package view;

import business.RenterBusinessLayer;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.Renter;
import business.ValidationException;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author 29751
 */
public class RegisterRenterView extends HttpServlet {

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
        
        String fName = request.getParameter("firstName");
        String lName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phoneNum = request.getParameter("phoneNum");
        String gender = request.getParameter("gender");
        String yearBorn = request.getParameter("yearBorn");
        String pets = request.getParameter("pet");
        String Smoker = request.getParameter("smoker");
        String ownCar = request.getParameter("ownCar");
        String working = request.getParameter("working");
        String enrollSchool = request.getParameter("enrollSchool");
        String criminal = request.getParameter("criminal");
        String homeLocation = request.getParameter("homeLocation");
        String roomDetails = request.getParameter("roomDetails");
//        Date birth = java.sql.Date.valueOf(request.getParameter("birth"));
//        Date enrolled = java.sql.Date.valueOf(request.getParameter("enrolled"));
      
        RenterBusinessLayer renterLayer = new RenterBusinessLayer();
        Renter renter = new Renter(1,"chrislabelle@gmail.com", "password","Chris","Chris","5555555555",1,new java.sql.Date(938478278),false,false,false,new java.sql.Date(System.currentTimeMillis()),new java.sql.Date(System.currentTimeMillis()),4,2,2,"newspaper",true);

//        try{
//            renterLayer.addRenter(renter);
//        }
//        catch(ValidationException e) {
//            
//        }
        
        // Only do this if user was successfully added to database!!!!
        RequestDispatcher rd = request.getRequestDispatcher("registerConfirm.jsp");  //go to registerConfirm if signUp successful
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
