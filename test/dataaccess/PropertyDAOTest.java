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
public class PropertyDAOTest {
    
    public PropertyDAOTest() {
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
     * Test of getAllProperty method, of class PropertyDAO.
     */
    @Test
    public void testGetAllProperty() {
        System.out.println("getAllProperty");
        PropertyDAO instance = new PropertyDAOImpl();
        List<Property> expResult = null;
        List<Property> result = instance.getAllProperty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addProperty method, of class PropertyDAO.
     */
    @Test
    public void testAddProperty() {
        System.out.println("addProperty");
        Property property = null;
        PropertyDAO instance = new PropertyDAOImpl();
        instance.addProperty(property);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPropertyByPropertyId method, of class PropertyDAO.
     */
    @Test
    public void testGetPropertyByPropertyId() {
        System.out.println("getPropertyByPropertyId");
        int propertyId = 0;
        PropertyDAO instance = new PropertyDAOImpl();
        Property expResult = null;
        Property result = instance.getPropertyByPropertyId(propertyId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteProperty method, of class PropertyDAO.
     */
    @Test
    public void testDeleteProperty() {
        System.out.println("deleteProperty");
        int propertyId = 0;
        PropertyDAO instance = new PropertyDAOImpl();
        instance.deleteProperty(propertyId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateProperty method, of class PropertyDAO.
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
        PropertyDAO instance = new PropertyDAOImpl();
        instance.updateProperty(hostId, address, city, postalCode, province, country, famMembers, isSmokerFriendly, isPetFriendly, hydroIncl, waterIncl, gasIncl, cableIncl, internet, parking, laundry, familyRoom, priBedroom, shaBedroom, priKitchen, shaKitchen, priWashroom, shaWashroom, price, startDate, endDate, chores, availability, propertyId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class PropertyDAOImpl implements PropertyDAO {

        public List<Property> getAllProperty() {
            return null;
        }

        public void addProperty(Property property) {
        }

        public Property getPropertyByPropertyId(int propertyId) {
            return null;
        }

        public void deleteProperty(int propertyId) {
        }

        public void updateProperty(int hostId, String address, String city, String postalCode, String province, String country, int famMembers, Boolean isSmokerFriendly, Boolean isPetFriendly, Boolean hydroIncl, Boolean waterIncl, Boolean gasIncl, Boolean cableIncl, Boolean internet, Boolean parking, Boolean laundry, Boolean familyRoom, Boolean priBedroom, Boolean shaBedroom, Boolean priKitchen, Boolean shaKitchen, Boolean priWashroom, Boolean shaWashroom, double price, Date startDate, Date endDate, String chores, int availability, int propertyId) {
        }
    }
    
}
