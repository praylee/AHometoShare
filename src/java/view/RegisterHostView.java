/*
 * File: RegisterHostView.java
 * Description:Dealing with host register form and insert into Host table in database
 * Create: Sep,30,2018
 * Author: Liangliang Du
 * Modifed:Oct,13,2018
 * Clients: Michelle Bilek,Farheen Khan
 * Course: Software Development Project
 * Professor: Dr. Anu Thomas
 * Project: A Home to Share
 * Copyright @ 2018
 */
package view;


import business.HostBusinessLayer;
import business.ValidationException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.Host;


/**
 *
 * @author 29751
 */
public class RegisterHostView extends HttpServlet {

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
        String fName = request.getParameter("firstname");
        String lName = request.getParameter("lastname");
        String email = request.getParameter("email");
        String phoneNum = request.getParameter("phoneNum");
        String gender = request.getParameter("gender");     
        String yearBorn = request.getParameter("yearBorn");       
        String referralSource = request.getParameter("referralSrc");
        String passWord = request.getParameter("pwd1");
        String ConPassWord = request.getParameter("pwd2");

        HostBusinessLayer hostLayer = new HostBusinessLayer();

        List<Host> hostList = hostLayer.getAllHost();
        int index = -1;
        if(hostList.size()>0)
            index = hostList.get(hostList.size()-1).getHostID();       
        Host host = new Host(index+1,email, passWord,fName,lName,phoneNum,Integer.parseInt(gender),yearBorn,false,false,false,referralSource);
          
        try{
            hostLayer.addHost(host);
            // Only do this if user was successfully added to database!!!!
            request.setAttribute("Info", "Host Registration Successful.");
            
            RequestDispatcher rd = request.getRequestDispatcher("registerConfirm.jsp");  //go to registerConfirm if signUp successful
            
            rd.forward(request,response);
        }
        catch(ValidationException e) {
            
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
