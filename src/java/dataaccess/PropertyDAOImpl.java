/**
 * File: PropertyDAOImpl.java
 * Description:This class implements interface PropertyDAO. This class is responsible to get data from Table Property.
 * Create: Sep,30,2018
 * Author: Xia Sheng
 * Clients: Michelle Bilek,Farheen Khan
 * Course: Software Development Project
 * Professor: Dr. Anu Thomas
 * Project: A Home to Share
 * Copyright @ 2018
 */
package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.sql.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transferobjects.Property;

public class PropertyDAOImpl implements PropertyDAO {

    private static final String GET_ALL_PROPERTY = "SELECT property_id, host_id,address, city, postal_code, province, "
            + "country, family_members, smoker, pets, hydro, water, gas, cable, internet, parking, laundry, family_room, private_bedroom, shared_bedroom, "
            + "private_kitchen, shared_kitchen, private_washroom, shared_washroom, price, host_start_date, host_end_date, shared_chore, availability "
            + "FROM property ORDER BY property_id";

    private static final String INSERT_PROPERTY = "INSERT INTO property ( "
            + "property_id, host_id,address, city, postal_code,province,country,family_members,smoker, "
            + "pets,hydro, water, gas, cable, internet, parking, laundry, family_room, private_bedroom, shared_bedroom, "
            + "private_kitchen, shared_kitchen, private_washroom, shared_washroom,price, host_start_date,host_end_date,shared_chore,availability "
            + ") VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  
    private static final String GET_BY_PROPERTY_ID = "SELECT "
            + "property_id, host_id,address, city, postal_code,province,country,family_members,smoker, "
            + "pets,hydro, water, gas, cable, internet, parking, laundry, family_room, private_bedroom, shared_bedroom, "
            + "private_kitchen, shared_kitchen, private_washroom, shared_washroom,price, host_start_date,host_end_date,shared_chore,availability "
            + "FROM property WHERE property_id = ?";
    private static final String DELETE_PROPERTY = "DELETE FROM property WHERE property_id = ?";
    private static final String UPDATE_PROPERTY = "UPDATE property SET "
            + "host_id = ? ,address = ?, city = ?, postal_code= ?,province= ?,country= ?,family_members= ?,smoker= ?, "
            + "pets= ?,hydro=?, water=?, gas=?, cable=?, internet=?, parking=?, laundry=?, family_room=?, private_bedroom=?, shared_bedroom=?, "
            + "private_kitchen=?, shared_kitchen=?, private_washroom=?, shared_washroom=?,price= ?, host_start_date= ?,host_end_date= ?,shared_chore= ?,availability= ? "
            + "WHERE property_id= ?";

    @Override
    public List<Property> getAllProperty() {
        List<Property> properties = Collections.EMPTY_LIST;
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(GET_ALL_PROPERTY);
                ResultSet rs = pstmt.executeQuery();) {
            properties = new ArrayList<>(400);
            while (rs.next()) {
                Property property = new Property();
                property.setPropertyId(rs.getInt("property_id"));
                property.setHostId(rs.getInt("host_id"));
                property.setAddress(rs.getString("address"));
                property.setCity(rs.getString("city"));
                property.setPostalCode(rs.getString("postal_code"));
                property.setProvince(rs.getString("province"));
                property.setCountry(rs.getString("country"));
                property.setFamMembers(rs.getInt("family_members"));
                property.setIsSmokerFriendly(rs.getBoolean("smoker"));
                property.setIsPetFriendly(rs.getBoolean("pets"));
                property.setHydroIncl(rs.getBoolean("hydro"));
                property.setWaterIncl(rs.getBoolean("water"));
                property.setGasIncl(rs.getBoolean("gas"));
                property.setCableIncl(rs.getBoolean("cable"));
                property.setInternet(rs.getBoolean("internet"));
                property.setParking(rs.getBoolean("parking"));
                property.setLaundry(rs.getBoolean("laundry"));
                property.setFamilyRoom(rs.getBoolean("family_room"));
                property.setPriBedroom(rs.getBoolean("private_bedroom"));
                property.setShaBedroom(rs.getBoolean("shared_bedroom"));
                property.setPriKitchen(rs.getBoolean("private_kitchen"));
                property.setShaKitchen(rs.getBoolean("shared_kitchen"));
                property.setPriWashroom(rs.getBoolean("private_washroom"));
                property.setShaWashroom(rs.getBoolean("shared_washroom"));
                property.setPrice(rs.getDouble("price"));
                property.setStartDate(rs.getDate("host_start_date"));
                property.setStartDate(rs.getDate("host_end_date"));
                property.setChores(rs.getString("shared_chore"));
                property.setAvailability(rs.getInt("availability"));
                properties.add(property);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PropertyDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return properties;
    }

    @Override
    public void addProperty(Property property) {
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(INSERT_PROPERTY);) {
            pstmt.setInt(1, property.getpropertyID());
            pstmt.setInt(2, property.getHostID());
            pstmt.setString(3, property.getAddress());
            pstmt.setString(4, property.getCity());
            pstmt.setString(5, property.getPostalCode());
            pstmt.setString(6, property.getProvince());
            pstmt.setString(7, property.getCountry());
            pstmt.setInt(8, property.getFamMembers());
            pstmt.setBoolean(9, property.getIsSmokerFriendly());
            pstmt.setBoolean(10, property.getIsPetFriendly());
            pstmt.setBoolean(11, property.getHydroIncl());
            pstmt.setBoolean(12, property.getWaterIncl());
            pstmt.setBoolean(13, property.getGasIncl());
            pstmt.setBoolean(14, property.getCableIncl());
            pstmt.setBoolean(15, property.getInternet());
            pstmt.setBoolean(16, property.getParking());
            pstmt.setBoolean(17, property.getLaundry());
            pstmt.setBoolean(18, property.getFamilyRoom());
            pstmt.setBoolean(19, property.getPriBedroom());
            pstmt.setBoolean(20, property.getShaBedroom());
            pstmt.setBoolean(21, property.getPriKitchen());
            pstmt.setBoolean(22, property.getShaKitchen());
            pstmt.setBoolean(23, property.getPriWashroom());
            pstmt.setBoolean(24, property.getShaWashroom());
            pstmt.setDouble(25, property.getPrice());
            pstmt.setDate(26, property.getStartDate());
            pstmt.setDate(27, property.getEndDate());
            pstmt.setString(28, property.getChores());
            pstmt.setInt(29, property.getAvailability());

            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PropertyDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Property getPropertyByPropertyId(int propertyId) { 

        Property property = new Property();
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(GET_BY_PROPERTY_ID);) {
            pstmt.setInt(1, propertyId); //modified by Melissa Rajala
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                property.setPropertyId(rs.getInt("property_id"));
                property.setHostId(rs.getInt("host_id"));
                property.setAddress(rs.getString("address"));
                property.setCity(rs.getString("city"));
                property.setPostalCode(rs.getString("postal_code"));
                property.setProvince(rs.getString("province"));
                property.setCountry(rs.getString("country"));
                property.setFamMembers(rs.getInt("family_members"));
                property.setIsSmokerFriendly(rs.getBoolean("smoker"));
                property.setIsPetFriendly(rs.getBoolean("pets"));
                property.setHydroIncl(rs.getBoolean("hydro"));
                property.setWaterIncl(rs.getBoolean("water"));
                property.setGasIncl(rs.getBoolean("gas"));
                property.setCableIncl(rs.getBoolean("cable"));
                property.setInternet(rs.getBoolean("internet"));
                property.setParking(rs.getBoolean("parking"));
                property.setLaundry(rs.getBoolean("laundry"));
                property.setFamilyRoom(rs.getBoolean("family_room"));
                property.setPriBedroom(rs.getBoolean("private_bedroom"));
                property.setShaBedroom(rs.getBoolean("shared_bedroom"));
                property.setPriKitchen(rs.getBoolean("private_kitchen"));
                property.setShaKitchen(rs.getBoolean("shared_kitchen"));
                property.setPriWashroom(rs.getBoolean("private_washroom"));
                property.setShaWashroom(rs.getBoolean("shared_washroom"));
                property.setPrice(rs.getDouble("price"));
                property.setStartDate(rs.getDate("host_start_date"));
                property.setEndDate(rs.getDate("host_end_date"));
                property.setChores(rs.getString("shared_chore"));
                property.setAvailability(rs.getInt("availability"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PropertyDAOImpl.class.getName()).log(Level.SEVERE, null, ex);

        }
        return property;
    }

    @Override
    public void deleteProperty(int propertyId) {
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(DELETE_PROPERTY);) {
            pstmt.setInt(1, propertyId);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PropertyDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void updateProperty(int hostId, String address, String city, String postalCode, String province,String country,int famMembers,Boolean isSmokerFriendly, Boolean isPetFriendly,Boolean hydroIncl,Boolean waterIncl,Boolean gasIncl,Boolean cableIncl,Boolean internet,Boolean parking,Boolean laundry,Boolean familyRoom,Boolean priBedroom,Boolean shaBedroom,Boolean priKitchen,Boolean shaKitchen,Boolean priWashroom,Boolean shaWashroom,double price,Date startDate,Date endDate,String chores,int availability,int propertyId) {
        try (Connection con = new DataSource().createConnection();
                PreparedStatement pstmt = con.prepareStatement(UPDATE_PROPERTY);) {
            pstmt.setInt(1, hostId);
            pstmt.setString(2, address);
            pstmt.setString(3, city);
            pstmt.setString(4, postalCode);
            pstmt.setString(5, province);
            pstmt.setString(6, country);
            pstmt.setInt(7, famMembers);
            pstmt.setBoolean(8, isSmokerFriendly);
            pstmt.setBoolean(9, isPetFriendly);
            pstmt.setBoolean(10, hydroIncl);
            pstmt.setBoolean(11, waterIncl);
            pstmt.setBoolean(12, gasIncl);
            pstmt.setBoolean(13, cableIncl);
            pstmt.setBoolean(14, internet);
            pstmt.setBoolean(15, parking);
            pstmt.setBoolean(16, laundry);
            pstmt.setBoolean(17, familyRoom);
            pstmt.setBoolean(18, priBedroom);
            pstmt.setBoolean(19, shaBedroom);
            pstmt.setBoolean(20, priKitchen);
            pstmt.setBoolean(21, shaKitchen);
            pstmt.setBoolean(22, priWashroom);
            pstmt.setBoolean(23, shaWashroom);
            pstmt.setDouble(24, price);
            pstmt.setDate(25, startDate);
            pstmt.setDate(26, endDate);
            pstmt.setString(27, chores);
            pstmt.setInt(28, availability);
            pstmt.setInt(29, propertyId);
            pstmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PropertyDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
