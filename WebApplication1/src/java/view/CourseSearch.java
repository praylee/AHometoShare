/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import business.CoursesLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.Course;

/**
 *
 * @author Cynthia Sheng
 */
@WebServlet(name = "SearchCourse", urlPatterns = {"/SearchCourse"})
public class CourseSearch extends HttpServlet {

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
            out.println("<title>SearchCourse</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<form action=\"SearchCourse\" method=\"post\">");
            
            out.println("Course Code:<br>");
            out.println("<input type=\"text\" name=\"course_num\" value=\"\"><br>");
             
           out.println("<input type=\"submit\" name=\"search\" value=\"search\"><br><br>");
            
           CoursesLogic search = new CoursesLogic();
           List<Course> courses = search.getAllCourses();
           if(getParameter(request,"search") !=null){ 
           for (Course course : courses) {
                              
            out.println("Course Code:<br>");
            out.println("<input type=\"text\" name=\"course_num1\" value=\'"+course.getCode()+"\'><br>");
                        
           out.println("Course Name:<br>");
            out.println("<input type=\"text\" name=\"course_name1\" value=\'"+course.getName()+"\'><br><br>");

            out.println("<input type=\"submit\" name=\"Delete\" value=\"Delete\">");
            out.println("<input type=\"submit\" name=\"Update\" value=\"Update\">");
            }
           }  
            if(getParameter(request,"Delete") !=null){
                search.deleteCourse(getParameter(request,"course_num1"));
            }
            
            if(getParameter(request,"Update") !=null){
                search.updateCourse(getParameter(request,"course_num1"),getParameter(request,"course_name1"));
            }

           out.println("</form>"); 
            out.println("</body>");
            out.println("</html>");
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
