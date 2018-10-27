/**
 * File: PropertyXResourceDAOImpl.java
 * Description:This class implements interface PropertyXResourceDAO. This class is responsible to get data from Table PropertyXResource.
 * Create: Sep,30,2018
 * Author: Xia Sheng
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

public class PropertyXResourceDAOImpl implements PropertyXResourceDAO {

    // modify SQL to comply with the database fields.
    private static final String GET_ALL_PR = "SELECT property_id,resource_id FROM propertyxresource ORDER BY property_id";
    private static final String INSERT_PR = "INSERT INTO propertyxresource (property_id,resource_id) VALUES(?,?)";          
    private static final String GET_BY_PR_ID = "SELECT property_id,resource_id FROM propertyxresource WHERE property_id = ?";  
    private static final String DELETE_PR = "DELETE FROM propertyxresource WHERE property_id = ?"; 

    @Override
    public List<PropertyXResource> getAllPropertyXResource() {
        List<PropertyXResource> PRs = Collections.EMPTY_LIST;
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(GET_ALL_PR);
                ResultSet rs = pstmt.executeQuery();) {
            PRs = new ArrayList<>(400);
            while (rs.next()) {
                PropertyXResource PR = new PropertyXResource();
                PR.setPropertyId(rs.getInt("property_id"));
                PR.setResourceId(rs.getInt("resource_id"));
                PRs.add(PR);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PropertyXResourceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return PRs;
    }

    @Override
    public void addPropertyXResource(PropertyXResource PR) {
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(INSERT_PR);) {
            //pstmt.setInt(1, PR.getID());                 //Bin Yang, Oct 26, 2018
            pstmt.setInt(1, PR.getPropertyID());
            pstmt.setInt(2, PR.getResourceID());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PropertyXResourceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public PropertyXResource getResourceByPropertyId(int id) {                     //Bin Yang, Oct 23, 2018

        PropertyXResource PR = new PropertyXResource();
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(GET_BY_PR_ID);
                ResultSet rs = pstmt.executeQuery();) {
            pstmt.setInt(1, id);
            if (rs.next()) {
                PR.setPropertyId(rs.getInt("property_id"));
                PR.setResourceId(rs.getInt("resource_id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PropertyXResourceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);

        }
        return PR;
    }

    @Override
    public void deletePropertyXResource(int id) {
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(DELETE_PR);) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PropertyXResourceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
