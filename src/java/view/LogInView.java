/*
 * File: LogInView.java
 * Description:
 * Create: Oct 5,2018
 * Author: Melissa Rajala
 * Clients: Michelle Bilek,Farheen Khan
 * Course: Software Development Project
 * Professor: Dr. Anu Thomas
 * Project: A Home to Share
 * Copyright @ 2018
 */
package view;

import business.RenterBusinessLayer;
import dataaccess.RenterDAOImpl;
import java.io.IOException;

import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import transferobjects.Renter;

import business.RenterBusinessLayer;


/**
 *
 * @author Chris
 */
public class LogInView extends HttpServlet {

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

        String email = request.getParameter("email");
        String password = request.getParameter("pswd");
//        RenterBusinessLayer renterBusiness = new RenterBusinessLayer();
//        if(renterBusiness.passwordCorrect(email, password)) {
//            Renter renter = renterBusiness.getRenterByEmail(email);
//            request.setAttribute("fName", renter.getFirstName());
//            request.setAttribute("lName", renter.getLastName());
//            RequestDispatcher rd = request.getRequestDispatcher("renterProfile.jsp");  //go to renterProfile if login successful
//            rd.forward(request,response);
//        }
//        else {
//            //here you can pass error messages back to login screen
//            RequestDispatcher rd = request.getRequestDispatcher("login.html");  //go to renterProfile if login successful
//            rd.forward(request,response);
//        }
        
        request.setAttribute("fName", "Christopher"); // just for practice without database
        request.setAttribute("lName", "Labelle");
        request.setAttribute("email", email);
        request.setAttribute("password", password);
        RequestDispatcher rd = request.getRequestDispatcher("renterProfile.jsp");  //go to renterProfile if login successful
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
             
        response.setContentType("text/html;charset=UTF-8");

        
        String email = request.getParameter("email");
        String password = request.getParameter("pswd");

        
        RenterBusinessLayer renterBusiness = new RenterBusinessLayer();
        Renter renter;
        renter = renterBusiness.getRenterByRenterId(1);

        response.sendRedirect("renterProfile.html");
        
        if (renter.getPassWord().equals(password)) { //username and password match
//            response.sendRedirect("/renterProfile.html");
//            RequestDispatcher rs = request.getRequestDispatcher("renterProfile.html");
//            rs.forward(request, response);
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
