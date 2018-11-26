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

import dataaccess.RenterDAO;
import dataaccess.RenterDAOImpl;
import transferobjects.Renter;

import static org.junit.Assert.*;

/**
 *
 * @author Christopher Labelle
 */
public class RenterDAOImplTest {
    
	RenterDAO instance;
	int renterId;
	Renter renter;
	
    public RenterDAOImplTest() {
    	instance = new RenterDAOImpl();
    	List<Renter> renters = instance.getAllRenter();
    	renterId = renters.size() > 0 ? renters.size() + 1 : 1;
    	renter = new Renter(
    			renterId,
    			"first@last.com",
    			"password",
    			"First",
    			"Last",
    			"555-555-5555",
    			1,
    			"1993",
    			true,
    			true,
    			false,
    			new java.sql.Date(0),
    			new java.sql.Date(0),
    			4,
    			2.0,
    			2.0,
    			"Reddit",
    			true
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
     * Test of getAllRenter method, of class RenterDAOImpl.
     */
    @Test
    public void testGetAllRenter() {
        System.out.println("getAllRenter");
        List<Renter> expResult = null;
        List<Renter> result = instance.getAllRenter();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of addRenter method, of class RenterDAOImpl.
     */
    @Test
    public void testAddRenter() {
        System.out.println("addRenter");
        instance.addRenter(renter);
    }

    /**
     * Test of getRenterByRenterId method, of class RenterDAOImpl.
     */
    @Test
    public void testGetRenterByRenterId() {
        System.out.println("getRenterByRenterId");
        int renterId = this.renterId;
        Renter expResult = null;
        Renter result = instance.getRenterByRenterId(renterId);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of deleteRenter method, of class RenterDAOImpl.
     */
    @Test
    public void testDeleteRenter() {
        System.out.println("deleteRenter");
        int renterId = this.renterId;
        instance.deleteRenter(renterId);
    }

    /**
     * Test of updateRenter method, of class RenterDAOImpl.
     */
    @Test
    public void testUpdateRenter_18args() {
        System.out.println("updateRenter");
        String email = "newemail";
        String passWord = "newpassword";
        String firstName = "newfirst";
        String lastName = "newlast";
        String phone = "newphone";
        int gender = 0;
        String dateBirth = "newyear";
        Boolean isStudent = false;
        Boolean isEmployed = false;
        Boolean isSmoker = false;
        Date startDate = new java.sql.Date(10);
        Date endDate = new java.sql.Date(10);
        int availability = 5;
        double lowPrice = 8.0;
        double highPrice = 8.0;
        String referralSource = "newsource";
        Boolean hasCRCheck = false;
        int renterId = this.renterId;
        instance.updateRenter(email, passWord, firstName, lastName, phone, gender, dateBirth, isStudent, isEmployed, isSmoker, startDate, endDate, availability, lowPrice, highPrice, referralSource, hasCRCheck, renterId);
    }

    /**
     * Test of updateRenter method, of class RenterDAOImpl.
     */
    @Test
    public void testUpdateRenter_5args() {
        System.out.println("updateRenter");
        Date startDate = new java.sql.Date(100);
        Date endDate = new java.sql.Date(100);
        double lowPrice = 60.0;
        double highPrice = 70.0;
        int renterId = this.renterId;
        instance.updateRenter(startDate, endDate, lowPrice, highPrice, renterId);
    }

    /**
     * Test of updateRenter method, of class RenterDAOImpl.
     */
    @Test
    public void testUpdateRenter_9args() {
        System.out.println("updateRenter");
        String firstName = "newfirst";
        String lastName = "newlast";
        String phone = "newphone";
        int gender = 0;
        String dateBirth = "newyear";
        Boolean isStudent = false;
        Boolean isEmployed = true;
        Boolean isSmoker = false;
        int renterId = this.renterId;
        instance.updateRenter(firstName, lastName, phone, gender, dateBirth, isStudent, isEmployed, isSmoker, renterId);
    }

    /**
     * Test of updateRenter method, of class RenterDAOImpl.
     */
    @Test
    public void testUpdateRenter_String_int() {
        System.out.println("updateRenter");
        String passWord = "newpassword";
        int renterId = this.renterId;
        instance.updateRenter(passWord, renterId);
    }

    /**
     * Test of getRenterByEmail method, of class RenterDAOImpl.
     */
    @Test
    public void testGetRenterByEmail() {
        System.out.println("getRenterByEmail");
        String email = renter.getEmail();
        Renter expResult = null;
        Renter result = instance.getRenterByEmail(email);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of passwordCorrect method, of class RenterDAOImpl.
     */
    @Test
    public void testPasswordCorrect() {
        System.out.println("passwordCorrect");
        String email = renter.getEmail();
        String password = renter.getPassWord();
        boolean expResult = true;
        boolean result = instance.passwordCorrect(email, password);
        assertEquals(expResult, result);
    }
    
}
