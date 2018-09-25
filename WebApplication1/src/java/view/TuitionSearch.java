/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import business.TuitionLogic;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.Tuition;

/**
 *
 * @author Cynthia Sheng
 */
public class TuitionSearch extends HttpServlet {

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
            out.println("<title>TuitionSearch</title>");
            out.println("</head>");
            out.println("<body>");

            out.println("<form action=\"SearchTuition\" method=\"post\">");

            out.println("Student Number:<br>");
            out.println("<input type=\"text\" name=\"student_num\" value=\"\"><br>");

            out.println("<input type=\"submit\" name=\"search\" value=\"search\"><br><br>");

            TuitionLogic search = new TuitionLogic();
            List<Tuition> tuitions = search.getAllTuition();
            if (getParameter(request, "search") != null) {
                for (Tuition tuition : tuitions) {

                    out.println("Student Number:<br>");
                    out.println("<input type=\"text\" name=\"student_num1\" value=\'" + tuition.getStudentID() + "\'><br>");

                    out.println("Amount Paid:<br>");
                    out.println("<input type=\"text\" name=\"paid\" value=\'" + tuition.getPaid() + "\'><br>");

                    out.println("Amount remained:<br>");
                    out.println("<input type=\"text\" name=\"remain\" value=\'" + tuition.getRemain() + "\'><br><br>");

                    out.println("<input type=\"submit\" name=\"Delete\" value=\"Delete\">");
            out.println("<input type=\"submit\" name=\"Update\" value=\"Update\">");
                }
            }
            if (getParameter(request, "Delete") != null) {
                search.deleteTuition(getParameter(request, "student_num1"));
            }
            
            if(getParameter(request,"Update") !=null){
                search.updateTuition(getParameter(request,"student_num1"),getParameter(request,"paid"),getParameter(request,"remain"));
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
