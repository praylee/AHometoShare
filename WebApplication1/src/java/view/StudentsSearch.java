/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import business.StudentsLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.Students;

/**
 *
 * @author Cynthia Sheng
 */
public class StudentsSearch extends HttpServlet {

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
            out.println("<title>SearchStudent</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<form action=\"StudentsSearch\" method=\"post\">");

            out.println("Student Number:<br>");
            out.println("<input type=\"text\" name=\"student_num\" value=\"\"><br>");

            out.println("<input type=\"submit\" name=\"search\" value=\"search\"><br><br>");

            StudentsLogic search = new StudentsLogic();
            List<Students> students = search.getAllStudents();

            if (getParameter(request, "search") != null) {
//                 String x = request.getParameter("student_num");
//                 student = search.getStudentByStudentID(x);
                for (Students student : students) {
                    out.println("Student Number:<br>");
                    out.println("<input type=\"text\" name=\"student_num1\" value=\'" + student.getStuID() + "\'><br>");

                    out.println("First name:<br>");
                    out.println("<input type=\"text\" name=\"firstname\" value=\'" + student.getFirstName() + "\'><br>");

                    out.println("Last name:<br>");
                    out.println("<input type=\"text\" name=\"lastname\" value=\'" + student.getLastName() + "\'><br>");

                    out.println("Date of Birth:<br>");
                    out.println("<input type=\"date\" name=\"dob\" value=\'" + student.getBirth() + "\'><br>");

                    out.println("Enrolled Date:<br>");
                    out.println("<input type=\"date\" name=\"enrolled\" value='" + student.getEnroll() + "\'><br><br>");

                    out.println("<input type=\"submit\" name=\"Delete\" value=\"Delete\">");
            out.println("<input type=\"submit\" name=\"Update\" value=\"Update\">");
                }
            }
            if (getParameter(request, "Delete") != null) {
                search.deleteStudent(getParameter(request, "student_num1"));
            }

            if(getParameter(request,"Update") !=null){
               search.updateStudent(getParameter(request,"student_num1"),getParameter(request,"firstname"),
                        getParameter(request,"lastname"),getParameter(request,"dob"),getParameter(request,"enrolled"));
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
