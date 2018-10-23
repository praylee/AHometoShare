/*
 * File: PropertyBusinessLayer.java
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

import dataaccess.PropertyDAO;
import dataaccess.PropertyDAOImpl;
import java.sql.Date;
import java.util.List;
import transferobjects.Property;

/**
 *
 * @author 29751
 */
public class PropertyBusinessLayer {

    private PropertyDAO propertyDAO = null;
    
    public PropertyBusinessLayer() {
        propertyDAO = new PropertyDAOImpl();
    }
      
    public List<Property> getAllProperty(){
        return propertyDAO.getAllProperty();
    }
    
    public void addProperty(Property property) throws ValidationException {
        try {
            validateFields(property);
            propertyDAO.addProperty(property);
        }
        catch(ValidationException e) {
            throw e;
        }
    }
    
    public Property getPropertyByPropertyId(int hostId){
        return propertyDAO.getPropertyByPropertyId(hostId);
    } 
    
    public void deleteProperty(int propertyId){
        propertyDAO.deleteProperty(propertyId);
    }
    
    public void updateProperty(int hostId, String address, String city, String postalCode, String province,String country,int famMembers,Boolean isSmokerFriendly, Boolean isPetFriendly,double price,Date startDate,Date endDate,String chores,int availability,int propertyId){
        propertyDAO.updateProperty(hostId, address, city, postalCode, province,country,famMembers,isSmokerFriendly, isPetFriendly,price,startDate,endDate,chores,availability,propertyId);
    }
    
    private void validateFields(Property property) throws ValidationException {
        // if email doesn't match [\w\d\._\-!#$%&'*+/=?^_`{|}~]+@[\w\d\.\[\]]+  then throw exception
        // if password doesn't match whatever we need it to     then throw exception
        // if price range isn't a number, or is a negative number   then throw exception
    }    
}
