/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dataaccess;

import java.sql.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dataaccess.PropertyDAO;
import dataaccess.PropertyDAOImpl;
import transferobjects.Property;

import static org.junit.Assert.*;

/**
 *
 * @author Christopher Labelle
 */
public class PropertyDAOImplTest {
    
	PropertyDAO instance;
	Property property;
	int propertyId;
	
    public PropertyDAOImplTest() {
    	instance = new PropertyDAOImpl();
    	List<Property> properties = instance.getAllProperty();
    	propertyId = properties.size() > 0 ? properties.size() + 1 : 1;
    	property = new Property(
			propertyId,
			1,
			"address",
			"city",
			"postalCode",
			"province",
			"country",
			1,
			true,
			true,
			true,
			true,
			true,
			true,
			true,
			true,
			true,
			true,
			true,
			true,
			true,
			true,
			true,
			true,
			1.0,
			new java.sql.Date(0),
			new java.sql.Date(0),
			"chores",
			1
		);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    	//instance = new PropertyDAOImpl();
    }
    
    @After
    public void tearDown() {
    	//instance = null;
    }

    /**
     * Test of getAllProperty method, of class PropertyDAOImpl.
     */
    @Test
    public void testGetAllProperty() {
        System.out.println("getAllProperty");
        List<Property> expResult = null;
        List<Property> result = instance.getAllProperty();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of addProperty method, of class PropertyDAOImpl.
     */
    @Test
    public void testAddProperty() {
        System.out.println("addProperty");
        instance.addProperty(property);
    }

    /**
     * Test of getPropertyByPropertyId method, of class PropertyDAOImpl.
     */
    @Test
    public void testGetPropertyByPropertyId() {
        System.out.println("getPropertyByPropertyId");
        Property expResult = null;
        Property result = instance.getPropertyByPropertyId(propertyId);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of getPropertyByHostId method, of class PropertyDAOImpl.
     */
    @Test
    public void testGetPropertyByHostId() {
        System.out.println("getPropertyByHostId");
        int hostId = 1;
        List<Property> expResult = null;
        List<Property> result = instance.getPropertyByHostId(hostId);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of deleteProperty method, of class PropertyDAOImpl.
     */
    @Test
    public void testDeleteProperty() {
        System.out.println("deleteProperty");
        int propertyId = 0;
        instance.deleteProperty(propertyId);
    }

    /**
     * Test of updateProperty method, of class PropertyDAOImpl.
     */
    @Test
    public void testUpdateProperty() {
        System.out.println("updateProperty");
        int hostId = 1;
        String address = "newAddress";
        String city = "newCity";
        String postalCode = "newPC";
        String province = "newProvince";
        String country = "newCountry";
        int famMembers = 2;
        Boolean isSmokerFriendly = false;
        Boolean isPetFriendly = false;
        Boolean hydroIncl = false;
        Boolean waterIncl = false;
        Boolean gasIncl = false;
        Boolean cableIncl = false;
        Boolean internet = false;
        Boolean parking = false;
        Boolean laundry = false;
        Boolean familyRoom = false;
        Boolean priBedroom = false;
        Boolean shaBedroom = false;
        Boolean priKitchen = false;
        Boolean shaKitchen = false;
        Boolean priWashroom = false;
        Boolean shaWashroom = false;
        double price = 5.0;
        Date startDate = new java.sql.Date(10);
        Date endDate = new java.sql.Date(10);
        String chores = "newChores";
        int availability = 5;
        int propertyId = this.propertyId;
        instance.updateProperty(hostId, address, city, postalCode, province, country, famMembers, isSmokerFriendly, isPetFriendly, hydroIncl, waterIncl, gasIncl, cableIncl, internet, parking, laundry, familyRoom, priBedroom, shaBedroom, priKitchen, shaKitchen, priWashroom, shaWashroom, price, startDate, endDate, chores, availability, propertyId);
    }
    
}
