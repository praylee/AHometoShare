/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import transferobjects.Property;

/**
 *
 * @author chris
 */
public class PropertyDAOImplTest {
    
    public PropertyDAOImplTest() {
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
     * Test of getAllProperty method, of class PropertyDAOImpl.
     */
    @Test
    public void testGetAllProperty() {
        System.out.println("getAllProperty");
        PropertyDAOImpl instance = new PropertyDAOImpl();
        List<Property> expResult = null;
        List<Property> result = instance.getAllProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addProperty method, of class PropertyDAOImpl.
     */
    @Test
    public void testAddProperty() {
        System.out.println("addProperty");
        Property property = null;
        PropertyDAOImpl instance = new PropertyDAOImpl();
        instance.addProperty(property);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPropertyByPropertyId method, of class PropertyDAOImpl.
     */
    @Test
    public void testGetPropertyByPropertyId() {
        System.out.println("getPropertyByPropertyId");
        int propertyId = 0;
        PropertyDAOImpl instance = new PropertyDAOImpl();
        Property expResult = null;
        Property result = instance.getPropertyByPropertyId(propertyId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPropertyByHostId method, of class PropertyDAOImpl.
     */
    @Test
    public void testGetPropertyByHostId() {
        System.out.println("getPropertyByHostId");
        int hostId = 0;
        PropertyDAOImpl instance = new PropertyDAOImpl();
        Property expResult = null;
        Property result = instance.getPropertyByHostId(hostId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteProperty method, of class PropertyDAOImpl.
     */
    @Test
    public void testDeleteProperty() {
        System.out.println("deleteProperty");
        int propertyId = 0;
        PropertyDAOImpl instance = new PropertyDAOImpl();
        instance.deleteProperty(propertyId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateProperty method, of class PropertyDAOImpl.
     */
    @Test
    public void testUpdateProperty() {
        System.out.println("updateProperty");
        int hostId = 0;
        String address = "";
        String city = "";
        String postalCode = "";
        String province = "";
        String country = "";
        int famMembers = 0;
        Boolean isSmokerFriendly = null;
        Boolean isPetFriendly = null;
        Boolean hydroIncl = null;
        Boolean waterIncl = null;
        Boolean gasIncl = null;
        Boolean cableIncl = null;
        Boolean internet = null;
        Boolean parking = null;
        Boolean laundry = null;
        Boolean familyRoom = null;
        Boolean priBedroom = null;
        Boolean shaBedroom = null;
        Boolean priKitchen = null;
        Boolean shaKitchen = null;
        Boolean priWashroom = null;
        Boolean shaWashroom = null;
        double price = 0.0;
        Date startDate = null;
        Date endDate = null;
        String chores = "";
        int availability = 0;
        int propertyId = 0;
        PropertyDAOImpl instance = new PropertyDAOImpl();
        instance.updateProperty(hostId, address, city, postalCode, province, country, famMembers, isSmokerFriendly, isPetFriendly, hydroIncl, waterIncl, gasIncl, cableIncl, internet, parking, laundry, familyRoom, priBedroom, shaBedroom, priKitchen, shaKitchen, priWashroom, shaWashroom, price, startDate, endDate, chores, availability, propertyId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
