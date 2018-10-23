/**
 * File: ResourceDAOImpl.java
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
import transferobjects.Resource;

/**
 * This class implements interface ResourceDAO. This class is responsible to get
 * data from Table Resource.
 *
 * @author Xia Sheng
 */
public class ResourceDAOImpl implements ResourceDAO {

    private static final String GET_ALL_RESOURCE = "SELECT resource_id, type FROM resource ORDER BY resource_id";
    private static final String INSERT_RESOURCE = "INSERT INTO resource (resource_id, type) VALUES(?,?)";
    private static final String GET_BY_RESOURCE_ID = "SELECT resource_id, type FROM resource WHERE resource_id = ?";
    private static final String DELETE_RESOURCE = "DELETE FROM resource WHERE resource_id = ?";
    private static final String UPDATE_RESOURCE = "UPDATE resource SET type = ? WHERE resource_id = ?";

    @Override
    public List<Resource> getAllResource() {
        List<Resource> resources = Collections.EMPTY_LIST;
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(GET_ALL_RESOURCE);
                ResultSet rs = pstmt.executeQuery();) {
            resources = new ArrayList<>(400);
            while (rs.next()) {
                Resource resource = new Resource();
                resource.setResourceId(rs.getInt("resource_id"));
                resource.setType(rs.getString("type"));
                resources.add(resource);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResourceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resources;
    }

    @Override
    public void addResource(Resource resource) {
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(INSERT_RESOURCE);) {
            pstmt.setInt(1, resource.getResourceID());
            pstmt.setString(2, resource.getType());
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ResourceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Resource getResourceByResourceId(int resourceId) {

        Resource resource = new Resource();
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(GET_BY_RESOURCE_ID);
                ResultSet rs = pstmt.executeQuery();) {
            pstmt.setInt(1, resourceId);
            if (rs.next()) {
                resource.setResourceId(rs.getInt("resource_id"));
                resource.setType(rs.getString("type"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResourceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resource;
    }

    @Override
    public void deleteResource(int resourceId) {              //Bin Yang, Oct 23, 2018
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(DELETE_RESOURCE);) {
            pstmt.setInt(1, resourceId);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ResourceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateResource(String type, int resourceId) {
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(UPDATE_RESOURCE);) {
            pstmt.setString(1, type);
            pstmt.setInt(2, resourceId);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ResourceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
