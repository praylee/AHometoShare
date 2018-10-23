/*
 * File: ResourceBusinessLayer.java
 * Description: transfer function between Java and database
 * Create: Oct 23,2018
 * Author: Bin Yang
 * Clients: Michelle Bilek,Farheen Khan
 * Course: Software Development Project
 * Professor: Dr. Anu Thomas
 * Project: A Home to Share
 * Copyright @ 2018
 */
package business;

import dataaccess.ResourceDAO;
import dataaccess.ResourceDAOImpl;
import java.sql.Date;
import java.util.List;
import transferobjects.Resource;

/**
 *
 * @author 29751
 */
public class ResourceBusinessLayer {
    
    private ResourceDAO resourceDAO = null;
    
    public ResourceBusinessLayer() {
        resourceDAO = new ResourceDAOImpl();
    }
      
    public List<Resource> getAllResource(){
        return resourceDAO.getAllResource();
    }
    
    public void addResource(Resource resource) throws ValidationException {
        try {
            validateFields(resource);
            resourceDAO.addResource(resource);
        }
        catch(ValidationException e) {
            throw e;
        }
    }
    
    public Resource getRESOURCEByResourceId(int resourceId){
        return resourceDAO.getResourceByResourceId(resourceId);
    } 
    
    public void deleteResource(int resourceId){
        resourceDAO.deleteResource(resourceId);
    }
    
    public void updateResource(String type, int resourceId){
        resourceDAO.updateResource(type,resourceId);
    }
    
    private void validateFields(Resource resource) throws ValidationException {
        // check int value whether out of range
    }  
}
