/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.business;

import java.sql.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.RenterBusinessLayer;
import business.ValidationException;

import static org.junit.Assert.*;

import transferobjects.Host;
import transferobjects.Renter;

/**
 *
 * @author Melissa Rajala
 */
public class RenterBusinessLayerTest {
	
	int renterID = 5;

    Date sd = java.sql.Date.valueOf("2019-01-01");
    Date ed = java.sql.Date.valueOf("2020-01-01");
	
	RenterBusinessLayer instance = new RenterBusinessLayer();
    
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
    	instance.deleteRenter(renterID);
        System.out.println("Deleted renter with id: " + renterID);
    	
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllRenter method, of class RenterBusinessLayer.
     * @throws ValidationException 
     */
    @Test
    public void testGetAllRenter() throws ValidationException {
        System.out.println("getAllRenter");

        String result = null;

        
        Renter renter1 = new Renter(renterID, "renter1@test.com", "12345","Keith", "Smith", "613-555-6698", 1, "1990", true, true, false, sd, ed, 1, 300, 600, "friend", false);
        instance.addRenter(renter1);
        
        String expResult = renter1.getEmail();

        List<Renter> list = instance.getAllRenter();
        
        for (Renter renter: list) {
        	if (renter.getRenterID() == renterID) {
        		result = renter.getEmail();
        	}
        }

        assertEquals(expResult, result);
        
    }

    /**
     * Test of getRenterByRenterId method, of class RenterBusinessLayer.
     * @throws ValidationException 
     */
    @Test
    public void testGetRenterByRenterId() throws ValidationException {
        System.out.println("getRenterByRenterId");

        Renter renter = new Renter(renterID, "renter1@test.com", "12345","Keith", "Smith", "613-555-6698", 1, "1990", true, true, false, sd, ed, 1, 300, 600, "friend", false);
        instance.addRenter(renter);
        
        int result = instance.getRenterByRenterId(renterID).getRenterID();
        
        assertEquals(renterID, result);
    }


    /**
     * Test of addRenter method, of class RenterBusinessLayer.
     */
    @Test
    public void testAddRenter() throws Exception {
        System.out.println("addRenter");

        Renter renter = new Renter(renterID, "renter1@test.com", "12345","Keith", "Smith", "613-555-6698", 1, "1990", true, true, false, sd, ed, 1, 300, 600, "friend", false);
        instance.addRenter(renter);
        
        int result = instance.getRenterByRenterId(renterID).getRenterID();
        
        assertEquals(renterID, result);
    }

    /**
     * Test of getRenterByEmail method, of class RenterBusinessLayer.
     * @throws ValidationException 
     */
    @Test
    public void testGetRenterByEmail() throws ValidationException {
        System.out.println("getRenterByEmail");
        
        String email = "happy@test.com";
        
        Renter renter = new Renter(renterID, email, "12345","Keith", "Smith", "613-555-6698", 1, "1990", true, true, false, sd, ed, 1, 300, 600, "friend", false);
        instance.addRenter(renter);

        String result = instance.getRenterByEmail(email).getEmail();
        assertEquals(email, result);
    }

    /**
     * Test of renterExists method, of class RenterBusinessLayer.
     * @throws ValidationException 
     */
    @Test
    public void testRenterExists() throws ValidationException {
        System.out.println("renterExists");
        String email = "veggie@test.com";

        boolean expResult = true;
        
        Renter renter = new Renter(renterID, email, "12345","Keith", "Smith", "613-555-6698", 1, "1990", true, true, false, sd, ed, 1, 300, 600, "friend", false);
        instance.addRenter(renter);
        
        boolean result = instance.renterExists(email);
        assertEquals(expResult, result);

    }

    /**
     * Test of passwordCorrect method, of class RenterBusinessLayer.
     * @throws ValidationException 
     */
    @Test
    public void testPasswordCorrect() throws ValidationException {
        System.out.println("passwordCorrect");
        String email = "happy@test.com";
        String password = "dayz";

        boolean expResult = true;
        
        Renter renter = new Renter(renterID, email, password,"Keith", "Smith", "613-555-6698", 1, "1990", true, true, false, sd, ed, 1, 300, 600, "friend", false);
        instance.addRenter(renter);
        
        boolean result = instance.passwordCorrect(email, password);
        assertEquals(expResult, result);

    }

    /**
     * Test of deleteRenter method, of class RenterBusinessLayer.
     * @throws ValidationException 
     */
    @Test
    public void testDeleteRenter() throws ValidationException {
        System.out.println("deleteRenter");
        
        Renter renter = new Renter(renterID, "testing@test.com", "whales","Keith", "Smith", "613-555-6698", 1, "1990", true, true, false, sd, ed, 1, 300, 600, "friend", false);
        instance.addRenter(renter);
        
        instance.deleteRenter(renterID);;
        
        int result = instance.getRenterByRenterId(renterID).getRenterID();

        assertEquals(0, result);
    }

    /**
     * Test of updateRenter method, of class RenterBusinessLayer.
     */
    @Test
    public void testUpdateRenter_18args() throws Exception {
        System.out.println("updateRenter");

        String updatedEmail = "newrenter@test.com";
        
        Renter renter = new Renter(renterID, "testing@test.com", "whales","Keith", "Smith", "613-555-6698", 1, "1990", true, true, false, sd, ed, 1, 300, 600, "friend", false);
        instance.addRenter(renter);

        instance.updateRenter(updatedEmail, "whales","Keith", "Smith", "613-555-6698", 1, "1990", true, true, false, sd, ed, 1, 300, 600, "friend", false, renterID);
        
        String result = instance.getRenterByRenterId(renterID).getEmail();
        
        assertEquals(updatedEmail, result);

    }


    /**
     * Test of updateRenter method, of class RenterBusinessLayer.
     * @throws ValidationException 
     */
    @Test
    public void testUpdateRenter_9args() throws ValidationException {
        System.out.println("updateRenter");
        String firstName = "";
        String lastName = "";
        String phone = "";
        int gender = 0;
        String dateBirth = "2000";
        Boolean isStudent = true;
        Boolean isEmployed = true;
        Boolean isSmoker = false;

        Renter renter = new Renter(renterID, "testing@test.com", "whales","Keith", "Smith", "613-555-6698", 1, "1990", true, true, false, sd, ed, 1, 300, 600, "friend", false);
        instance.addRenter(renter);
        
        instance.updateRenter(firstName, lastName, phone, gender, dateBirth, isStudent, isEmployed, isSmoker, renterID);
        
        String result = instance.getRenterByRenterId(renterID).getDateBirth();
      
        assertEquals(dateBirth, result);

    }

    /**
     * Test of updateRenter method, of class RenterBusinessLayer.
     * @throws ValidationException 
     */
    @Test
    public void testUpdateRenter_String_int() throws ValidationException {
        System.out.println("updateRenter");
        String passWord = "boo";
        
        Renter renter = new Renter(renterID, "testing@test.com", "whales","Keith", "Smith", "613-555-6698", 1, "1990", true, true, false, sd, ed, 1, 300, 600, "friend", false);
        instance.addRenter(renter);

        instance.updateRenter(passWord, renterID);
        
        String result = instance.getRenterByRenterId(renterID).getPassWord(); //password is encrypted
        
//        assertEquals(passWord, result);

    }
    
}
