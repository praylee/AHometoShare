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
import transferobjects.Registry;

/**
 * {@link RegistryDAO} interface implementation.
 *
 * @author Cynthia Sheng
 */
public class RegistryDAOImpl implements RegistryDAO {

    private static final String GET_ALL_REGISTRY = "SELECT student_num, course_num, term, year FROM Registry ORDER BY student_num";
    private static final String INSERT_REGISTRY = "INSERT INTO Registry (student_num, course_num, term, year) VALUES(?, ?, ?, ?)";
    private static final String GET_REGISTRY_BY_CODE_STUDENTS = "SELECT student_num, course_num, term, year FROM Registry WHERE student_num = ?";
    private static final String DELETE_REGISTRY = "DELETE FROM Registry WHERE student_num = ?";
    private static final String UPDATE_REGISTRY = "UPDATE Registry SET course_num = ?,term= ?, year = ?  WHERE student_num = ?";

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Registry> getAllRegistry() {
        @SuppressWarnings("unchecked")
        List<Registry> registries = Collections.EMPTY_LIST;
        Registry registry;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(GET_ALL_REGISTRY);
            rs = pstmt.executeQuery();
            registries = new ArrayList<>(100);
            while (rs.next()) {
                registry = new Registry();
                registry.setStID(rs.getString("student_num"));
                registry.setCourseID(rs.getString("course_num"));
                registry.setTerm(rs.getString("term"));
                registry.setYear(rs.getString("year"));
                registries.add(registry);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        return registries;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addRegistry(Registry registry) {
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(INSERT_REGISTRY);) {
            pstmt.setString(1, registry.getStID());
            pstmt.setString(2, registry.getCourseID());
            pstmt.setString(3, registry.getTerm());
            pstmt.setString(4, registry.getYear());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RegistryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * returns first instance of id
     *
     * @param studentID student ID
     * @return Registry with the specified ID or null if not found
     */
    @Override
    public Registry getRegistryByStudentID(String studentID) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Registry registry = new Registry();
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(GET_REGISTRY_BY_CODE_STUDENTS);
            pstmt.setString(1, studentID);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                registry.setStID(rs.getString("student_num"));
                registry.setCourseID(rs.getString("course_num"));
                registry.setTerm(rs.getString("term"));
                registry.setYear(rs.getString("year"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RegistryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        return registry;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateRegistry(String studentID, String courseID, String term, String year) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(UPDATE_REGISTRY);
            pstmt.setString(1, studentID);
            pstmt.setString(2, courseID);
            pstmt.setString(1, term);
            pstmt.setString(2, year);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(RegistryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteRegistry(String studentID) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(DELETE_REGISTRY);
            pstmt.setString(1, studentID);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(RegistryDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
