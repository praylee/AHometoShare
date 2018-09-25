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
import transferobjects.Course;

/**
 *
 * {@link CourseDAO} interface implementation.
 *
 * @author Shawn, Xia
 */
public class CourseDAOImpl implements CourseDAO {

    private static final String GET_ALL_COURSES = "SELECT course_num, name FROM Courses ORDER BY course_num";
    private static final String INSERT_COURSES = "INSERT INTO Courses (course_num, name) VALUES(?, ?)";
    private static final String DELETE_COURSES = "DELETE FROM Courses WHERE course_num = ?";
    private static final String UPDATE_COURSES = "UPDATE Courses SET name = ? WHERE course_num = ?";
    private static final String GET_BY_CODE_COURSES = "SELECT course_num, name FROM Courses WHERE course_num = ?";

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Course> getAllCourses() {
        @SuppressWarnings("unchecked")
        List<Course> courses = Collections.EMPTY_LIST;
        Course course;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(GET_ALL_COURSES);
            rs = pstmt.executeQuery();
            courses = new ArrayList<>(100);
            while (rs.next()) {
                course = new Course();
                course.setCode(rs.getString("course_num"));
                course.setName(rs.getString("name"));
                courses.add(course);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        return courses;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addCourse(Course course) {
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(INSERT_COURSES);) {
            pstmt.setString(1, course.getCode());
            pstmt.setString(2, course.getName());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CourseDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Course getCourseByCourseID(String code) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Course course = null;
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(GET_BY_CODE_COURSES);
            pstmt.setString(1, code);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                course = new Course();
                course.setCode(rs.getString("course_num"));
                course.setName(rs.getString("name"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        return course;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateCourse(String code, String name) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(UPDATE_COURSES);
            pstmt.setString(1, code);
            pstmt.setString(2, name);

            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(StudentsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    public void deleteCourse(String code) {
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(DELETE_COURSES);
            pstmt.setString(1, code);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(StudentsDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
