/*
 * File: PropertyXResourceLayer.java
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

import dataaccess.PropertyXResourceDAO;
import dataaccess.PropertyXResourceDAOImpl;
import java.sql.Date;
import java.util.List;
import transferobjects.PropertyXResource;

/**
 *
 * @author 29751
 */
public class PropertyXResourceLayer {
    
    private PropertyXResourceDAO propertyxresourceDAO = null;
    
    public PropertyXResourceLayer() {
        propertyxresourceDAO = new PropertyXResourceDAOImpl();
    }
      
    public List<PropertyXResource> getAllPropertyXResource(){
        return propertyxresourceDAO.getAllPropertyXResource();
    }
    
    public void addPropertyXResource(PropertyXResource propertyxresource) throws ValidationException {
        try {
            validateFields(propertyxresource);
            propertyxresourceDAO.addPropertyXResource(propertyxresource);
        }
        catch(ValidationException e) {
            throw e;
        }
    }
    
    public PropertyXResource getResourceByPropertyId(int propertyId){
        return propertyxresourceDAO.getResourceByPropertyId(propertyId);
    } 
    
    public void deletePropertyXResource(int propertyId){
        propertyxresourceDAO.deletePropertyXResource(propertyId);
    }
    
    private void validateFields(PropertyXResource propertyxresource) throws ValidationException {
        // if email doesn't match [\w\d\._\-!#$%&'*+/=?^_`{|}~]+@[\w\d\.\[\]]+  then throw exception
        // if password doesn't match whatever we need it to     then throw exception
        // if price range isn't a number, or is a negative number   then throw exception
    } 
}
