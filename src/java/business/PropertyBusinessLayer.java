/*
 * File: PropertyBusinessLayer.java
 * Description:
 * Create: Sep,30,2018
 * Author: Melissa Rajala
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
    
    public void addProperty(Property property) {
        propertyDAO.addProperty(property);
    }
    
    public Property getPropertyById(int propertyId){
        return propertyDAO.getPropertyByPropertyId(propertyId);
    } 
    
    public void deleteProperty(int propertyId){
        propertyDAO.deleteProperty(propertyId);
    }
    public void updatePropertyupdateProperty(int hostId, String address, String city, String postalCode, String province,String country,int famMembers,Boolean isSmokerFriendly, Boolean isPetFriendly,double price,Date startDate,Date endDate,String chores,int availability,int propertyId) {
        propertyDAO.updateProperty(hostId, address, city, postalCode, province, country, famMembers, isSmokerFriendly, isPetFriendly, price, startDate, endDate, chores, availability, propertyId);
    }


}
