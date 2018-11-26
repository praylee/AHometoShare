/*
 * File: PropertyBusinessLayer.java
 * Description: Business layer for the Property
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
 * @author Melissa
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
    
    public List<Property> getPropertyByHostId(int hostId){
        return propertyDAO.getPropertyByHostId(hostId);
    }
    
    public void deleteProperty(int propertyId){
        propertyDAO.deleteProperty(propertyId);
    }
    public void updateProperty(int hostId, String address, String city, String postalCode, String province,String country,int famMembers,Boolean isSmokerFriendly, Boolean isPetFriendly,Boolean hydroIncl,Boolean waterIncl,Boolean gasIncl,Boolean cableIncl,Boolean internet,Boolean parking,Boolean laundry,Boolean familyRoom,Boolean priBedroom,Boolean shaBedroom,Boolean priKitchen,Boolean shaKitchen,Boolean priWashroom,Boolean shaWashroom,double price,Date startDate,Date endDate,String chores,int availability,int propertyId) {
        propertyDAO.updateProperty(hostId, address, city, postalCode, province, country, famMembers, isSmokerFriendly, isPetFriendly,hydroIncl,waterIncl,gasIncl,cableIncl,internet,parking,laundry,familyRoom,priBedroom,shaBedroom,priKitchen,shaKitchen,priWashroom,shaWashroom,price, startDate, endDate, chores, availability, propertyId);
    }


}
