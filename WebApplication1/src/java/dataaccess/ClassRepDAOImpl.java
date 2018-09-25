/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.ClassRep;

/**
 * {@link ClassRepDAO} interface implementation.
 *
 * @author Cynthia Sheng
 */
public class ClassRepDAOImpl implements ClassRepDAO {

    private static final String GET_ALL_CLASSREP = "SELECT student_num, course_num, term, year FROM ClassRep ORDER BY student_num";
    //private static final String INSERT_CLASSREP= "INSERT INTO ClassRep (student_num, course_num, term, year) VALUES(?, ?, ?, ?)";
    private static final String DELETE_CLASSREP = "DELETE FROM ClassRep WHERE student_num = ?";
    //private static final String UPDATE_CLASSREP = "UPDATE ClassRep SET course_num = ?,term = ?, year = ?  WHERE student_num = ?";
    private static final String GET_CLASSREP_BY_CODE_STUDENTS = "SELECT student_num, course_num, term, year FROM ClassRep WHERE student_num = ?";

    @Override
    public List<ClassRep> getAllClassRep() {
        List<ClassRep> classReps = Collections.EMPTY_LIST;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(GET_ALL_CLASSREP);
            rs = pstmt.executeQuery();
            classReps = new ArrayList<>(400);
            while (rs.next()) {
                ClassRep classRep = new ClassRep();
                classRep.setStID(rs.getString("student_num"));
                classRep.setCourseID(rs.getString("course_num"));
                classRep.setTerm(rs.getString("term"));
                classRep.setYear(rs.getString("year"));

                classReps.add(classRep);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassRepDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return classReps;
    }

    @Override
    public ClassRep getClassRepByStudentID(String studentID) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ClassRep classRep = new ClassRep();
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(GET_CLASSREP_BY_CODE_STUDENTS);
            pstmt.setString(1, studentID);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                classRep.setStID(rs.getString("student_num"));
                classRep.setCourseID(rs.getString("course_num"));
                classRep.setTerm(rs.getString("term"));
                classRep.setYear(rs.getString("year"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClassRepDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return classRep;
    }

    @Override
    public void deleteClassRep(String studentID) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(DELETE_CLASSREP);
            pstmt.setString(1, studentID);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ClassRepDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            try {
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }

    }
}
