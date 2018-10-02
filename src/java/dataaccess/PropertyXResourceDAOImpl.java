/*
 * File: PropertyXResourceDAOImpl.java
 * Description:
 * Create: Sep,30,2018
 * Author: Bits & Bytes Team-Christopher Labelle,Liangliang Du,Melissa Rajala,Zhan Shen,Xia Sheng,Bin Yang
 * Clients: Michelle Bilek,Farheen Khan
 * Course: Software Development Project
 * Professor: Dr. Anu Thomas
 * Project: A Home to Share
 * Copyright @ 2018
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
import transferobjects.PropertyXResource;
/**
 *
 * @author Xia Sheng
 */
public class PropertyXResourceDAOImpl implements PropertyXResourceDAO{
    private static final String GET_ALL_PR = "SELECT id,property_id,resource_id FROM propertyxresource ORDER BY id";
    private static final String INSERT_PR = "INSERT INTO propertyxresource (id, property_id,resource_id) VALUES(?,?,?)";
    private static final String GET_BY_PR_ID = "SELECT id,property_id,resource_id FROM propertyxresource WHERE id = ?";
    private static final String DELETE_PR = "DELETE FROM propertyxresource WHERE id = ?";
    private static final String UPDATE_PR = "UPDATE propertyxresource SET property_id = ?, resource_id WHERE id = ?";
    
    @Override
    public List<PropertyXResource> getAllPropertyXResource(){
            List<PropertyXResource> PRs = Collections.EMPTY_LIST;
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try{
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(GET_ALL_PR);
            rs = pstmt.executeQuery();
            PRs = new ArrayList<>(400);
            while(rs.next()){
                PropertyXResource PR= new PropertyXResource();
                PR.setId(rs.getInt("id"));
                PR.setId(rs.getInt("property_id"));
                PR.setId(rs.getInt("resource_id"));              
                PRs.add(PR);
            }
        }catch(SQLException ex){
            Logger.getLogger(PropertyXResourceDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
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
        return PRs;
    }
    @Override
    public void addPropertyXResource(PropertyXResource PR){
        try {
            Connection con = new DataSource().createConnection();
            PreparedStatement pstmt = con.prepareStatement(INSERT_PR);
            pstmt.setInt(1, PR.getID());
            pstmt.setInt(2, PR.getPropertyID());
            pstmt.setInt(3, PR.getResourceID());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PropertyXResourceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public PropertyXResource getResourceByResourceId(int id){
       Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        PropertyXResource PR= new PropertyXResource();
        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(GET_BY_PR_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                PR.setId(rs.getInt("id"));
                PR.setId(rs.getInt("property_id"));
                PR.setId(rs.getInt("resource_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PropertyXResourceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
        return PR;
    }
      
    @Override
    public void deletePropertyXResource(int id){
       Connection con = null;
        PreparedStatement pstmt = null;

        try {
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(DELETE_PR);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PropertyXResourceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
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
    @Override
    public void updatePropertyXResource(int propertyId, int resourceId,int id){
      Connection con = null;
        PreparedStatement pstmt = null;
        try{
            DataSource ds = new DataSource();
            con = ds.createConnection();
            pstmt = con.prepareStatement(UPDATE_PR);
            
            pstmt.setInt(1,propertyId);
            pstmt.setInt(1,resourceId);
            pstmt.setInt(2,resourceId);
            
        pstmt.executeUpdate();
           
        }catch(SQLException ex){
            Logger.getLogger(PropertyXResourceDAOImpl.class.getName()).log(Level.SEVERE,null,ex);
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

