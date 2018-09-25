/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import business.RegistryLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.Registry;

/**
 *
 * @author Cynthia Sheng
 */
public class RegistrySearch extends HttpServlet {

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
            out.println("<title>RegistrySearch</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<form action=\"RegistrySearch\" method=\"post\">");

            out.println("Student Number:<br>");
            out.println("<input type=\"text\" name=\"student_num\" value=\"\"><br>");

            out.println("<input type=\"submit\" name=\"search\" value=\"search\"><br><br>");

            RegistryLogic search = new RegistryLogic();
            List<Registry> registries = search.getAllRegistry();

            if (getParameter(request, "search") != null) {

                for (Registry registry : registries) {
                    
                    out.println("Student Number:<br>");
                    out.println("<input type=\"text\" name=\"student_num1\" value=\'" + registry.getStID() + "\'><br>");

                    out.println("Course Code:<br>");
                    out.println("<input type=\"text\" name=\"course_num\" value=\'" + registry.getCourseID() + "\'><br>");

                    out.println("Term:<br>");
                    out.println("<input type=\"text\" name=\"term\" value=\'" + registry.getTerm() + "\'><br>");

                    out.println("Year:<br>");
                    out.println("<input type=\"text\" name=\"year\" value=\'" + registry.getYear() + "\'><br><br>");

                    out.println("<input type=\"submit\" name=\"Delete\" value=\"Delete\"><br>");
            out.println("<input type=\"submit\" name=\"Update\" value=\"Update\">");
                }
            }
            if (getParameter(request, "Delete") != null) {
                search.deleteRegistry(getParameter(request, "student_num1"));
            }

            if(getParameter(request,"Update") !=null){
                search.updateRegistry(getParameter(request,"student_num1"),getParameter(request,"course_num"),getParameter(request,"year"),getParameter(request,"term"));
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
