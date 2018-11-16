/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.sql.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import transferobjects.Renter;

/**
 *
 * @author chris
 */
public class RenterBusinessLayerTest {
    
    public RenterBusinessLayerTest() {
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
     * Test of getAllRenter method, of class RenterBusinessLayer.
     */
    @Test
    public void testGetAllRenter() {
        System.out.println("getAllRenter");
        RenterBusinessLayer instance = new RenterBusinessLayer();
        List<Renter> expResult = null;
        List<Renter> result = instance.getAllRenter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRenterByRenterId method, of class RenterBusinessLayer.
     */
    @Test
    public void testGetRenterByRenterId() {
        System.out.println("getRenterByRenterId");
        int renterId = 0;
        RenterBusinessLayer instance = new RenterBusinessLayer();
        Renter expResult = null;
        Renter result = instance.getRenterByRenterId(renterId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRenterByRenterUname method, of class RenterBusinessLayer.
     */
    @Test
    public void testGetRenterByRenterUname() {
        System.out.println("getRenterByRenterUname");
        String username = "";
        RenterBusinessLayer instance = new RenterBusinessLayer();
        Renter expResult = null;
        Renter result = instance.getRenterByRenterUname(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRenter method, of class RenterBusinessLayer.
     */
    @Test
    public void testAddRenter() throws Exception {
        System.out.println("addRenter");
        Renter renter = null;
        RenterBusinessLayer instance = new RenterBusinessLayer();
        instance.addRenter(renter);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRenterByEmail method, of class RenterBusinessLayer.
     */
    @Test
    public void testGetRenterByEmail() {
        System.out.println("getRenterByEmail");
        String email = "";
        RenterBusinessLayer instance = new RenterBusinessLayer();
        Renter expResult = null;
        Renter result = instance.getRenterByEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of renterExists method, of class RenterBusinessLayer.
     */
    @Test
    public void testRenterExists() {
        System.out.println("renterExists");
        String email = "";
        RenterBusinessLayer instance = new RenterBusinessLayer();
        boolean expResult = false;
        boolean result = instance.renterExists(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of passwordCorrect method, of class RenterBusinessLayer.
     */
    @Test
    public void testPasswordCorrect() {
        System.out.println("passwordCorrect");
        String email = "";
        String password = "";
        RenterBusinessLayer instance = new RenterBusinessLayer();
        boolean expResult = false;
        boolean result = instance.passwordCorrect(email, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRenter method, of class RenterBusinessLayer.
     */
    @Test
    public void testDeleteRenter() {
        System.out.println("deleteRenter");
        int renterId = 0;
        RenterBusinessLayer instance = new RenterBusinessLayer();
        instance.deleteRenter(renterId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRenter method, of class RenterBusinessLayer.
     */
    @Test
    public void testUpdateRenter_18args() throws Exception {
        System.out.println("updateRenter");
        String email = "";
        String passWord = "";
        String firstName = "";
        String lastName = "";
        String phone = "";
        int gender = 0;
        String dateBirth = "";
        Boolean isStudent = null;
        Boolean isEmployed = null;
        Boolean isSmoker = null;
        Date startDate = null;
        Date endDate = null;
        int availability = 0;
        double lowPrice = 0.0;
        double highPrice = 0.0;
        String referralSource = "";
        Boolean hasCRCheck = null;
        int renterId = 0;
        RenterBusinessLayer instance = new RenterBusinessLayer();
        instance.updateRenter(email, passWord, firstName, lastName, phone, gender, dateBirth, isStudent, isEmployed, isSmoker, startDate, endDate, availability, lowPrice, highPrice, referralSource, hasCRCheck, renterId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRenter method, of class RenterBusinessLayer.
     */
    @Test
    public void testUpdateRenter_13args() {
        System.out.println("updateRenter");
        String firstName = "";
        String lastName = "";
        String phone = "";
        int gender = 0;
        String dateBirth = "";
        Boolean isStudent = null;
        Boolean isEmployed = null;
        Boolean isSmoker = null;
        Date startDate = null;
        Date endDate = null;
        double lowPrice = 0.0;
        double highPrice = 0.0;
        int renterId = 0;
        RenterBusinessLayer instance = new RenterBusinessLayer();
        instance.updateRenter(firstName, lastName, phone, gender, dateBirth, isStudent, isEmployed, isSmoker, startDate, endDate, lowPrice, highPrice, renterId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRenter method, of class RenterBusinessLayer.
     */
    @Test
    public void testUpdateRenter_String_int() {
        System.out.println("updateRenter");
        String passWord = "";
        int renterId = 0;
        RenterBusinessLayer instance = new RenterBusinessLayer();
        instance.updateRenter(passWord, renterId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
