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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.Renter;
import business.ValidationException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
            throws ServletException, IOException, ParseException {
         
        response.setContentType("text/html;charset=UTF-8");
   
        String fName = request.getParameter("firstname");
        String lName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phoneNum = request.getParameter("phoneNum");
        String gender = request.getParameter("gender");     
        String yearBorn = request.getParameter("yearBorn");       
        String referralSource = request.getParameter("referralSrc");
        String passWord = request.getParameter("pwd1");
        String ConPassWord = request.getParameter("pwd2");
//        String reminder = "";
        
//        if(!ConPassWord.equalsIgnoreCase(passWord)) //passWord wrong match
//            reminder="The password not match, please reset.";
//        else
            {
         
            RenterBusinessLayer renterLayer = new RenterBusinessLayer();
            Renter emailRenter = renterLayer.getRenterByEmail(email);
//            if (emailRenter == null)//if email is not exist, register continue
            {
                List<Renter> renterList = renterLayer.getAllRenter();
                int index = renterList.size();
                Renter renter = new Renter(index+1,email, passWord,fName,lName,phoneNum,Integer.parseInt(gender),yearBorn,false,false,false,new java.sql.Date(System.currentTimeMillis()),new java.sql.Date(System.currentTimeMillis()),4,2,2,referralSource,true);
          //      Renter renter = new Renter(1,"chrislabelle@gmail.com", "password","Chris","Chris","5555555555",1,"1999",false,false,false,new java.sql.Date(System.currentTimeMillis()),new java.sql.Date(System.currentTimeMillis()),4,2,2,"newspaper",true);

                try{
                    renterLayer.addRenter(renter);
                    // Only do this if user was successfully added to database!!!!
                    request.setAttribute("Info", "Renter Registration Successful.");
                    RequestDispatcher rd = request.getRequestDispatcher("registerConfirm.jsp");  //go to registerConfirm if signUp successful
                    rd.forward(request,response);
                }
                catch(ValidationException e) {

                }
            }
//            else{//if email is already existed, need to change a new one
//                reminder = "Email is alrady registered.\nPlease use another Email to register or login with this Email.";
            }
        
//        try (PrintWriter out = response.getWriter()) {
//            out.println("<h1>"+reminder+" </h1>");
//        }
        
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
            Logger.getLogger(RegisterRenterView.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(RegisterRenterView.class.getName()).log(Level.SEVERE, null, ex);
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
