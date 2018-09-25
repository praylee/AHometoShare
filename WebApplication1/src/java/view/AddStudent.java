/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import business.ValidationException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.Students;
import business.StudentsLogic;
/**
 * AddStudent is a servlet controller that provides view to add student, and use the {@link StudentsLogic} for business operation.
 * @author Cynthia Sheng
 */

public class AddStudent extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Add Student</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<form action=\"AddStudent\" method=\"post\">");
            out.println("Student Number:<br>");
            out.println("<input type=\"text\" name=\"student_num\" value=\"\"><br>");
            
            out.println("First name:<br>");
            out.println("<input type=\"text\" name=\"firstname\" value=\"\"><br>");
           
            out.println("Last name:<br>");
            out.println("<input type=\"text\" name=\"lastname\" value=\"\"><br>");
            
            out.println("Date of Birth:<br>");
            out.println("<input type=\"date\" name=\"date_birth\" min=\"1900-01-01\" max=\"2018-01-04\"><br>");
            
             out.println("Enrolled Date:<br>");
            out.println("<input type=\"date\" name=\"enrolled\" min=\"1900-01-01\" max=\"2018-01-04\"><br><br>");
            
            out.println("<input type=\"submit\" value=\"Submit\">");
            out.println("</form>");
            
            out.println("</body>");
            out.println("</html>");
            
            Students student = new Students(getParameter(request,"student_num"),getParameter(request,"firstname"),
            getParameter(request,"lastname"),getParameter(request,"date_birth"),getParameter(request,"enrolled"));
            StudentsLogic addStudent = new StudentsLogic();
            try {
                addStudent.addStudent(student);
            } catch (ValidationException ex) {
                Logger.getLogger(AddStudent.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
   
  
    private String getParameter(HttpServletRequest request, String ID) {
        String param = request.getParameter(ID);
        if (param != null) {
            return param.trim();
        }
        return null;
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
