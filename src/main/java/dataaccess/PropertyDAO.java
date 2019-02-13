/**
 * File: PropertyDAO.java
 * Description:This is an abstract Data Access Object interface  defines the standard operations to be performed.
 * Create: Sep,30,2018
 * Author: Xia Sheng
 * Clients: Michelle Bilek,Farheen Khan
 * Course: Software Development Project
 * Professor: Dr. Anu Thomas
 * Project: A Home to Share
 * Copyright @ 2018
 */
package dataaccess;
import java.sql.Date;
import java.util.List;
import transferobjects.Property;

public interface PropertyDAO {
    List<Property> getAllProperty();
    void addProperty(Property property);
    Property getPropertyByPropertyId(int propertyId);
    void deleteProperty(int propertyId);
    void updateProperty(int hostId, String address, String city, String postalCode, String province,String country,int famMembers,Boolean isSmokerFriendly, Boolean isPetFriendly,Boolean hydroIncl,Boolean waterIncl,Boolean gasIncl,Boolean cableIncl,Boolean internet,Boolean parking,Boolean laundry,Boolean familyRoom,Boolean priBedroom,Boolean shaBedroom,Boolean priKitchen,Boolean shaKitchen,Boolean priWashroom,Boolean shaWashroom,double price,Date startDate,Date endDate,String chores,int availability,int propertyId);
    List<Property> getPropertyByHostId(int hostId);
}