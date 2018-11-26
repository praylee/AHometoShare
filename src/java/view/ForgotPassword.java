/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import business.HostBusinessLayer;
import business.RenterBusinessLayer;
import java.io.IOException;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.Host;
import transferobjects.Renter;

/**
 *
 * @author Christopher Labelle
 */
public class ForgotPassword extends HttpServlet {

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
        
        String email = request.getParameter("forgotPasswordEmail");
        System.out.println(email);
        
        RenterBusinessLayer renterBusiness = new RenterBusinessLayer();
        HostBusinessLayer hostBusiness = new HostBusinessLayer();
        
        boolean isRenter = renterBusiness.renterExists(email);
        boolean isHost = hostBusiness.hostExists(email);
        boolean validEmail = isRenter || isHost;
        System.out.println(validEmail);
        
        request.setAttribute("isForgotPasswordEmailValid", validEmail);
        
        if(validEmail) {
            String randomPassword = this.generateRandomString();
            
            if(isRenter) {
                Renter renter = renterBusiness.getRenterByEmail(email);
                renterBusiness.updateRenter(randomPassword, renter.getRenterID());
            }
            else {
                Host host = hostBusiness.getHostByEmail(email);
                hostBusiness.updateHost(randomPassword, host.getHostID());
            }
            
            EmailFactory.sendPasswordResetEmail(email, randomPassword);
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
        else {
            request.setAttribute("forgotPasswordFeedback", "The email address you have entered is not registered with A Home to Share");
            RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        }
    }
    
    private String generateRandomString() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        while (builder.length() < 11) {
            int index = (int) (random.nextFloat() * chars.length());
            builder.append(chars.charAt(index));
        }
        System.out.println(builder.toString());
        return builder.toString();
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
