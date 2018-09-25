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
import transferobjects.Tuition;
/**
 * {@link TuitionDAO} interface implementation
 * @author Cynthia Sheng
 */
public class TuitionDAOImpl implements TuitionDAO{    
    private static final String GET_ALL_TUITIONS = "SELECT student_num, paid, remainder FROM Tuition ORDER BY student_num";
    private static final String INSERT_TUITIONS = "INSERT INTO Tuition (student_num, paid, remainder) VALUES(?, ?, ?)";
    private static final String GET_TUITION_BY_CODE_STUDENTS= "SELECT student_num, paid, remainder FROM Tuition WHERE student_num = ?";
    private static final String DELETE_TUITIONS = "DELETE FROM Tuition WHERE student_num = ?";
    private static final String UPDATE_TUITIONS = "UPDATE Tuition SET paid = ?, remainder = ? WHERE student_num = ?";
       /**
     * {@inheritDoc}
     */
    @Override
    public List<Tuition> getAllTuition() {
        @SuppressWarnings("unchecked")
        List<Tuition> tuitions = Collections.EMPTY_LIST;
        Tuition tuition;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement( GET_ALL_TUITIONS);
            rs = pstmt.executeQuery();
            tuitions = new ArrayList<>(100);
            while( rs.next()){
                tuition = new Tuition();
                tuition.setStudentID( rs.getString("student_num"));
                tuition.setPaid( rs.getString("paid"));
                tuition.setRemain(rs.getString("remainder"));
                tuitions.add(tuition);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TuitionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        return tuitions;
    }
    /**
     * {@inheritDoc}
     */
    @Override
    public void addTuition(Tuition tuition) {
        try( 
            Connection con = new DataSource().createConnection();
            PreparedStatement pstmt = con.prepareStatement( INSERT_TUITIONS);){
            pstmt.setString(1, tuition.getStudentID());
            pstmt.setString(2, tuition.getPaid());
            pstmt.setString(3, tuition.getRemain());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(TuitionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
        /**
     * {@inheritDoc}
     */
    @Override
       public Tuition getTuitionByStudentID(String studentID){
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        Tuition tuition = new Tuition();
        try{
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(GET_TUITION_BY_CODE_STUDENTS);
            pstmt.setString(1, studentID);
            rs = pstmt.executeQuery();
            
          while( rs.next()){
                tuition.setStudentID( rs.getString("student_num"));
                tuition.setPaid( rs.getString("paid"));
                tuition.setRemain(rs.getString("remainder"));      
            }
        }catch(SQLException ex){
            Logger.getLogger(TuitionDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
        }finally{
            try{
            if(rs !=null){
                rs.close();
            }
          }catch(SQLException ex){
                    System.out.println(ex.getMessage());
          }
            try{
                if(pstmt !=null){
                    pstmt.close();
                }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
            try{
                if(con !=null){
                    con.close();
                }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }         
        }
        return tuition;
    }
    /**
     * {@inheritDoc}
     */
     @Override
     public void deleteTuition(String studentID){ 
        Connection con = null;
        PreparedStatement pstmt = null;
      ResultSet rs = null;
        Tuition tuition; 
        try{
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(DELETE_TUITIONS);
            pstmt.setString(1, studentID);
            pstmt.executeUpdate();          
        }catch(SQLException ex){
            Logger.getLogger(TuitionDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
        }finally{
           
            try{
                if(pstmt !=null){
                    pstmt.close();
                }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
            try{
                if(con !=null){
                    con.close();
                }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }         
        }                
     }
         /**
     * {@inheritDoc}
     */
     @Override
      public void updateTuition(String studentID, String paid,String remain){
            Connection con = null;
            PreparedStatement pstmt = null;
      
        try{
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(UPDATE_TUITIONS);
            pstmt.setString(1, studentID);
            pstmt.setString(2, paid);
            pstmt.setString(3, remain);
            pstmt.executeUpdate();          
        }catch(SQLException ex){
            Logger.getLogger(TuitionDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
        }finally{
           
            try{
                if(pstmt !=null){
                    pstmt.close();
                }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }
            try{
                if(con !=null){
                    con.close();
                }
            }catch(SQLException ex){
                System.out.println(ex.getMessage());
            }         
        }
        
      }
    
}






