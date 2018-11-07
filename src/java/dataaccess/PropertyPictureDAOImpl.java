/**
 * File: PropertyPictureDAOImpl.java
 * Description:This is an abstract Data Access Object interface defines the standard operations to be performed.
 * Create: Oct,28,2018
 * Author: Liangliang Du
 * Clients: Michelle Bilek,Farheen Khan
 * Course: Software Development Project
 * Professor: Dr. Anu Thomas
 * Project: A Home to Share
 * Copyright @ 2018
 */
package dataaccess;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.PropertyPicture;
import transferobjects.Resource;


public class PropertyPictureDAOImpl implements PropertyPictureDAO {

    private static final String GET_ALL_PICTURE = "SELECT picture_id, property_id, picture FROM propertypicture ORDER BY picture_id";
 //   private static final String INSERT_PICTURE = "INSERT INTO propertypicture (picture_id, property_id, picture) VALUES(?,?,LOAD_FILE(?))";
    private static final String INSERT_PICTURE = "INSERT INTO propertypicture (picture_id, property_id, picture) VALUES(?,?,?)";
    private static final String GET_PICTURE_BY_ID = "SELECT picture FROM propertypicture WHERE picture_id = ?";
    private static final String GET_FIRST_PICTURE_BY_PROPERTY = "SELECT picture FROM propertypicture WHERE property_id = ?";
    private static final String DELETE_PICTURE = "DELETE FROM propertypicture WHERE picture_id = ?";


    @Override
    public List<PropertyPicture> getAllPictures() {
        List<PropertyPicture> propertypictures = Collections.EMPTY_LIST;
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(GET_ALL_PICTURE);
                ResultSet rs = pstmt.executeQuery();) {
            propertypictures = new ArrayList<>(400);
            while (rs.next()) {
                PropertyPicture propertypicture = new PropertyPicture();
                propertypicture.setPictureId(rs.getInt("picture_id"));
                propertypicture.setPropertyId(rs.getInt("property_id"));
                propertypicture.setPicture(rs.getString("picture"));
                propertypictures.add(propertypicture);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResourceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return propertypictures;
        }

    @Override
    public void addPicture(PropertyPicture propertypicture, InputStream blob) {
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(INSERT_PICTURE);) {
            pstmt.setInt(1, propertypicture.getPictureID());
             pstmt.setInt(2, propertypicture.getPropertyID());
            pstmt.setBlob(3, blob);           
           
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ResourceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }

   
    
    
    @Override
    public PropertyPicture getPictureById(int pictureId) {
        
        PropertyPicture propertypicture = new PropertyPicture();
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(GET_PICTURE_BY_ID);) {
            pstmt.setInt(1, pictureId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                propertypicture.setPictureId(rs.getInt("pictureId"));
                propertypicture.setPropertyId(rs.getInt("property_id"));
                propertypicture.setPicture(rs.getString("picture"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResourceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return propertypicture;
    }
    
    @Override
    public Blob getFirstPictureByProperty(int propertyId) {
        
   
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(GET_FIRST_PICTURE_BY_PROPERTY);) {
            pstmt.setInt(1, propertyId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.first()) {
              Blob picture = rs.getBlob("picture");
               
              return picture;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResourceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void deletePicture(int pictureId) {
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(DELETE_PICTURE);) {
            pstmt.setInt(1, pictureId);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ResourceDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
