/**
 * File: PropertyPictureDAO.java
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
import java.io.InputStream;
import java.sql.Blob;
import java.util.List;
import transferobjects.PropertyPicture;

public interface PropertyPictureDAO {
    List<PropertyPicture> getAllPictures();
    void addPicture(PropertyPicture propertypicture,InputStream blob);
    PropertyPicture getPictureById(int pictureId); 
    void deletePicture(int pictureId);           
    Blob getFirstPictureByProperty(int propertyId);
}
