/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.transferobjects;

import java.sql.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import transferobjects.Property;

import static org.junit.Assert.*;

/**
 *
 * @author Christopher Labelle
 */
public class PropertyTest {
    
	Property instance;
	
    public PropertyTest() {
    	instance = new Property(
			1,
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
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setPropertyId method, of class Property.
     */
    @Test
    public void testSetPropertyId() {
        System.out.println("setPropertyId");
        int propertyId = 0;
        instance.setPropertyId(propertyId);
        assertEquals(propertyId, instance.getpropertyID());
    }

    /**
     * Test of setHostId method, of class Property.
     */
    @Test
    public void testSetHostId() {
        System.out.println("setHostId");
        int hostId = 0;
        instance.setHostId(hostId);
        assertEquals(hostId, instance.getHostID());
    }

    /**
     * Test of setAddress method, of class Property.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        String address = "";
        instance.setAddress(address);
        assertEquals(address, instance.getAddress());
    }

    /**
     * Test of setCity method, of class Property.
     */
    @Test
    public void testSetCity() {
        System.out.println("setCity");
        String city = "";
        instance.setCity(city);
        assertEquals(city, instance.getCity());
    }

    /**
     * Test of setPostalCode method, of class Property.
     */
    @Test
    public void testSetPostalCode() {
        System.out.println("setPostalCode");
        String postalCode = "";
        instance.setPostalCode(postalCode);
        assertEquals(postalCode, instance.getPostalCode());
    }

    /**
     * Test of setProvince method, of class Property.
     */
    @Test
    public void testSetProvince() {
        System.out.println("setProvince");
        String province = "";
        instance.setProvince(province);
        assertEquals(province, instance.getProvince());
    }

    /**
     * Test of setCountry method, of class Property.
     */
    @Test
    public void testSetCountry() {
        System.out.println("setCountry");
        String country = "";
        instance.setCountry(country);
        assertEquals(country, instance.getCountry());
    }

    /**
     * Test of setFamMembers method, of class Property.
     */
    @Test
    public void testSetFamMembers() {
        System.out.println("setFamMembers");
        int famMembers = 0;
        instance.setFamMembers(famMembers);
        assertEquals(famMembers, instance.getFamMembers());
    }

    /**
     * Test of setIsSmokerFriendly method, of class Property.
     */
    @Test
    public void testSetIsSmokerFriendly() {
        System.out.println("setIsSmokerFriendly");
        Boolean isSmokerFriendly = null;
        instance.setIsSmokerFriendly(isSmokerFriendly);
        assertEquals(isSmokerFriendly, instance.getIsSmokerFriendly());
    }

    /**
     * Test of setIsPetFriendly method, of class Property.
     */
    @Test
    public void testSetIsPetFriendly() {
        System.out.println("setIsPetFriendly");
        Boolean isPetFriendly = null;
        instance.setIsPetFriendly(isPetFriendly);
        assertEquals(isPetFriendly, instance.getIsPetFriendly());
    }

    /**
     * Test of setHydroIncl method, of class Property.
     */
    @Test
    public void testSetHydroIncl() {
        System.out.println("setHydroIncl");
        Boolean hydroIncl = null;
        instance.setHydroIncl(hydroIncl);
        assertEquals(hydroIncl, instance.getHydroIncl());
    }

    /**
     * Test of setWaterIncl method, of class Property.
     */
    @Test
    public void testSetWaterIncl() {
        System.out.println("setWaterIncl");
        Boolean waterIncl = null;
        instance.setWaterIncl(waterIncl);
        assertEquals(waterIncl, instance.getWaterIncl());
    }

    /**
     * Test of setGasIncl method, of class Property.
     */
    @Test
    public void testSetGasIncl() {
        System.out.println("setGasIncl");
        Boolean gasIncl = null;
        instance.setGasIncl(gasIncl);
        assertEquals(gasIncl, instance.getGasIncl());
    }

    /**
     * Test of setCableIncl method, of class Property.
     */
    @Test
    public void testSetCableIncl() {
        System.out.println("setCableIncl");
        Boolean cableIncl = null;
        instance.setCableIncl(cableIncl);
        assertEquals(cableIncl, instance.getCableIncl());
    }

    /**
     * Test of setInternet method, of class Property.
     */
    @Test
    public void testSetInternet() {
        System.out.println("setInternet");
        Boolean internet = null;
        instance.setInternet(internet);
        assertEquals(internet, instance.getInternet());
    }

    /**
     * Test of setParking method, of class Property.
     */
    @Test
    public void testSetParking() {
        System.out.println("setParking");
        Boolean parking = null;
        instance.setParking(parking);
        assertEquals(parking, instance.getParking());
    }

    /**
     * Test of setLaundry method, of class Property.
     */
    @Test
    public void testSetLaundry() {
        System.out.println("setLaundry");
        Boolean laundry = null;
        instance.setLaundry(laundry);
        assertEquals(laundry, instance.getLaundry());
    }

    /**
     * Test of setFamilyRoom method, of class Property.
     */
    @Test
    public void testSetFamilyRoom() {
        System.out.println("setFamilyRoom");
        Boolean familyRoom = null;
        instance.setFamilyRoom(familyRoom);
        assertEquals(familyRoom, instance.getFamilyRoom());
    }

    /**
     * Test of setPriBedroom method, of class Property.
     */
    @Test
    public void testSetPriBedroom() {
        System.out.println("setPriBedroom");
        Boolean priBedroom = null;
        instance.setPriBedroom(priBedroom);
        assertEquals(priBedroom, instance.getPriBedroom());
    }

    /**
     * Test of setShaBedroom method, of class Property.
     */
    @Test
    public void testSetShaBedroom() {
        System.out.println("setShaBedroom");
        Boolean shaBedroom = null;
        instance.setShaBedroom(shaBedroom);
        assertEquals(shaBedroom, instance.getShaBedroom());
    }

    /**
     * Test of setPriKitchen method, of class Property.
     */
    @Test
    public void testSetPriKitchen() {
        System.out.println("setPriKitchen");
        Boolean priKitchen = null;
        instance.setPriKitchen(priKitchen);
        assertEquals(priKitchen, instance.getPriKitchen());
    }

    /**
     * Test of setShaKitchen method, of class Property.
     */
    @Test
    public void testSetShaKitchen() {
        System.out.println("setShaKitchen");
        Boolean shaKitchen = null;
        instance.setShaKitchen(shaKitchen);
        assertEquals(shaKitchen, instance.getShaKitchen());
    }

    /**
     * Test of setPriWashroom method, of class Property.
     */
    @Test
    public void testSetPriWashroom() {
        System.out.println("setPriWashroom");
        Boolean priWashroom = null;
        instance.setPriWashroom(priWashroom);
        assertEquals(priWashroom, instance.getPriWashroom());
    }

    /**
     * Test of setShaWashroom method, of class Property.
     */
    @Test
    public void testSetShaWashroom() {
        System.out.println("setShaWashroom");
        Boolean shaWashroom = null;
        instance.setShaWashroom(shaWashroom);
        assertEquals(shaWashroom, instance.getShaWashroom());
    }

    /**
     * Test of setPrice method, of class Property.
     */
    @Test
    public void testSetPrice() {
        System.out.println("setPrice");
        double price = 0.0;
        instance.setPrice(price);
        assertEquals(price, instance.getPrice(), 0.0);
    }

    /**
     * Test of setStartDate method, of class Property.
     */
    @Test
    public void testSetStartDate() {
        System.out.println("setStartDate");
        Date startDate = null;
        instance.setStartDate(startDate);
        assertEquals(startDate, instance.getStartDate());
    }

    /**
     * Test of setEndDate method, of class Property.
     */
    @Test
    public void testSetEndDate() {
        System.out.println("setEndDate");
        Date endDate = null;
        instance.setEndDate(endDate);
        assertEquals(endDate, instance.getEndDate());
    }

    /**
     * Test of setChores method, of class Property.
     */
    @Test
    public void testSetChores() {
        System.out.println("setChores");
        String chores = "";
        instance.setChores(chores);
        assertEquals(chores, instance.getChores());
    }

    /**
     * Test of setAvailability method, of class Property.
     */
    @Test
    public void testSetAvailability() {
        System.out.println("setAvailability");
        int availability = 0;
        instance.setAvailability(availability);
        assertEquals(availability, instance.getAvailability());
    }
    
}
