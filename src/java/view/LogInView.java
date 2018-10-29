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
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import transferobjects.Renter;
import business.RenterBusinessLayer;
import transferobjects.Host;


/**
 *
 * @author Chris
 * Modified by Liangliang Du: checking user is a renter or host by email 
 * Modified by Xia Sheng: add host login session
 * Modified by Melissa Rajala: add property and host information for search capability
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
                    RenterSession session = new RenterSession(request.getSession());
                    session.setSessionAttributes(renter, true); // store renterinfo in Session
                    
                    response.sendRedirect("renterProfile.jsp");
                }
                else {
                    //here you can pass error messages back to login screen
                    request.setAttribute("email", email);
                    request.setAttribute("info", "Password does not match username");
                    //request.setAttribute("subInfo", "Please go back to login.");
                    request.setAttribute("isLoginValid", false);
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");  //go to back to index if login not successful
                    rd.forward(request,response);       
                }  
        }
        else if(emailIsRenter == null && emailIsHost != null){ //user is a Host
                if(hostBusiness.passwordCorrect(email, password)) {
                    Host host = hostBusiness.getHostByEmail(email);
                HostSession session = new HostSession(request.getSession());
                session.setSessionAttributes(host, true); // store host info in Session
                response.sendRedirect("hostProfile.jsp");
                }
                else {
                    //here you can pass error messages back to login screen
                    request.setAttribute("email", email);
                    request.setAttribute("info", "Password does not match username");
                    //request.setAttribute("subInfo", "Please go back to login.");
                    request.setAttribute("isLoginValid", false);
                    RequestDispatcher rd = request.getRequestDispatcher("index.jsp");  //go back to index if login not successful
                    rd.forward(request,response);       
                }  
            }
        else{
                //request.setAttribute("fName", "Cannot find your login info. Please sign up first.");
                request.setAttribute("info", "Email provided does not exist");
                //request.setAttribute("subInfo", "Please go back to login.");
                request.setAttribute("isLoginValid", false);
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");  //go back to index if login not successful
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
