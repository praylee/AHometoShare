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

import business.HostBusinessLayer;
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
import transferobjects.Host;


/**
 *
 * @author Chris
 * Modified by Liangliang Du: checking user is a renter or host by email 
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
        
        String email = request.getParameter("loginEmail");
        String password = request.getParameter("loginPassword");
        RenterBusinessLayer renterBusiness = new RenterBusinessLayer();
        HostBusinessLayer hostBusiness = new HostBusinessLayer();

        Renter emailIsRenter = renterBusiness.getRenterByEmail(email);
        Host emailIsHost = hostBusiness.getHostByEmail(email);
        
        if(emailIsRenter!= null && emailIsHost == null){ //user is a Renter
                if(renterBusiness.passwordCorrect(email, password)) {
                    Renter renter = renterBusiness.getRenterByEmail(email);
                    request.setAttribute("fName", "Welcome your Renter Profile, "+renter.getFirstName());
                    request.setAttribute("lName", renter.getLastName());
                    request.setAttribute("Info","This is your Renter Profile.");
                    request.setAttribute("subInfo","This will be information about you.");
                    RequestDispatcher rd = request.getRequestDispatcher("renterProfile.jsp");  //go to renterProfile if login successful
                    rd.forward(request,response);
                }
                else {
                    //here you can pass error messages back to login screen
                    request.setAttribute("fName", "Login Failed. Please go back to login.");
                    request.setAttribute("Info", "Login Failed.");
                    request.setAttribute("subInfo", "Please go back to login.");
                    RequestDispatcher rd = request.getRequestDispatcher("renterProfile.jsp");  //go to renterProfile if login not successful
                    rd.forward(request,response);       
                }  
        }
        else if(emailIsRenter == null && emailIsHost != null){ //user is a Host
                if(hostBusiness.passwordCorrect(email, password)) {
                    Host host = hostBusiness.getHostByEmail(email);
                    request.setAttribute("fName", "Welcome your Host Profile, "+host.getFirstName());
                    request.setAttribute("lName", host.getLastName());
                    request.setAttribute("Info","This is your Host Profile.");
                    request.setAttribute("subInfo","This will be information about you.");
                    RequestDispatcher rd = request.getRequestDispatcher("hostProfile.jsp");  //go to renterProfile if login successful
                    rd.forward(request,response);
                }
                else {
                    //here you can pass error messages back to login screen
                    request.setAttribute("fName", "Login Failed. Please go back to login.");
                    request.setAttribute("Info", "Login Failed.");
                    request.setAttribute("subInfo", "Please go back to login.");
                    RequestDispatcher rd = request.getRequestDispatcher("hostProfile.jsp");  //go to renterProfile if login not successful
                    rd.forward(request,response);       
                }  
            }
        else{
                request.setAttribute("fName", "Cannot find your login info. Please sign up first.");
                request.setAttribute("Info", "Login Failed.");
                request.setAttribute("subInfo", "Please go back to login.");
                RequestDispatcher rd = request.getRequestDispatcher("hostProfile.jsp");  //go to renterProfile if login not successful
                rd.forward(request,response);       
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
             
        response.setContentType("text/html;charset=UTF-8");


        

        
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
