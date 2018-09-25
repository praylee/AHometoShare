/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.CoursesLogic;
import business.ValidationException;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.Course;
/**
 *
 * @author Cynthia Sheng
 */
public class AddCourse extends HttpServlet {

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
            out.println("<title>AddCourse</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<form action=\"AddCourse\" method=\"post\">");
            
            out.println("Course Code:<br>");
            out.println("<input type=\"text\" name=\"course_num\" value=\"\"><br>");
            
            out.println("Course Name:<br>");
            out.println("<input type=\"text\" name=\"course_name\" value=\"\"><br>");
            
            out.println("<input type=\"submit\" value=\"Submit\">");
            out.println("</form>");
            
            out.println("</body>");
            out.println("</html>");
            
            Course course = new Course(getParameter(request,"course_name"),getParameter(request,"course_num"));
            CoursesLogic addCourse= new CoursesLogic();
            try {
                addCourse.addCourse(course);
            } catch (ValidationException ex) {
                Logger.getLogger(AddCourse.class.getName()).log(Level.SEVERE, null, ex);
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
