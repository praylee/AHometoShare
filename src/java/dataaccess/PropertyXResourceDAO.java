/**
 * File: PropertyXResourceDAO.java
 * Description:This is an abstract Data Access Object interface defines the standard operations to be performed.
 * Create: Sep,30,2018
 * Author: Xia Sheng
 * Clients: Michelle Bilek,Farheen Khan
 * Course: Software Development Project
 * Professor: Dr. Anu Thomas
 * Project: A Home to Share
 * Copyright @ 2018
 */
package dataaccess;
import java.util.List;
import transferobjects.PropertyXResource;

public interface PropertyXResourceDAO {
    List<PropertyXResource> getAllPropertyXResource();
    void addPropertyXResource(PropertyXResource PR);
    //PropertyXResource getResourceByResourceId(int id);  //Bin Yang, Oct 23, 2018  
    PropertyXResource getResourceByPropertyId(int id);
    void deletePropertyXResource(int id);
}
