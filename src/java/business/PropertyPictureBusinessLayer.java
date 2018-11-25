/**
 * File: PropertyPictureBusinessLayer.java
 * Description:This is an abstract Data Access Object interface defines the standard operations to be performed.
 * Create: Oct,28,2018
 * Author: Liangliang Du
 * Clients: Michelle Bilek,Farheen Khan
 * Course: Software Development Project
 * Professor: Dr. Anu Thomas
 * Project: A Home to Share
 * Copyright @ 2018
 */
package business;


import dataaccess.PropertyPictureDAO;
import dataaccess.PropertyPictureDAOImpl;
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;
import transferobjects.PropertyPicture;

/**
 *
 * @author 29751
 */
public class PropertyPictureBusinessLayer {
    
    private PropertyPictureDAO pPictureDAO = null;
    
    public PropertyPictureBusinessLayer() {
        pPictureDAO = new PropertyPictureDAOImpl();
    }
      
    public List<PropertyPicture> getAllPictures(){
        return pPictureDAO.getAllPictures();
    }

    public void addPicture(PropertyPicture propertypicture,InputStream blob) throws ValidationException {
        try {
            validateFields(propertypicture);
            pPictureDAO.addPicture(propertypicture,blob);
        }
        catch(ValidationException e) {
            throw e;
        }
    }
    
     public List<PropertyPicture> getAllPicturesByProperty(int propertyId){
        return pPictureDAO.getAllPicturesByProperty(propertyId);
    } 
     
    public List<Blob> getAllPicturesById(int pictureId) {
        return pPictureDAO.getAllPicturesById(pictureId);
    }
    
    public void deletePicture(int pictureId){
        pPictureDAO.deletePicture(pictureId);
    }
    
    public Blob getFirstPictureByProperty(int propertyId) {
         return pPictureDAO.getFirstPictureByProperty(propertyId);
     }
    
    private void validateFields(PropertyPicture propertypicture) throws ValidationException {
        // check int value whether out of range
    }  
}
