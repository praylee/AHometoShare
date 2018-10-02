/*
 * File: PropertyXResourceDAO.java
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
import java.util.List;
import transferobjects.PropertyXResource;
/**
 *
 * @author Xia Sheng
 */
public interface PropertyXResourceDAO {
    List<PropertyXResource> getAllPropertyXResource();
    void addPropertyXResource(PropertyXResource PR);
    PropertyXResource getResourceByResourceId(int id);  
    void deletePropertyXResource(int id);
    void updatePropertyXResource(int propertyId, int resourceId,int id);
}
