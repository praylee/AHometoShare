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

import transferobjects.Renter;

import static org.junit.Assert.*;

/**
 *
 * @author Christopher Labelle
 */
public class RenterTest {
    
	Renter instance;
	
    public RenterTest() {
    	instance = new Renter(
			1,
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
     * Test of getRenterID method, of class Renter.
     */
    @Test
    public void testGetRenterID() {
        System.out.println("getRenterID");
        int expResult = 1;
        int result = instance.getRenterID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class Renter.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        String expResult = "first@last.com";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassWord method, of class Renter.
     */
    @Test
    public void testGetPassWord() {
        System.out.println("getPassWord");
        String expResult = "password";
        String result = instance.getPassWord();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFirstName method, of class Renter.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        String expResult = "First";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastName method, of class Renter.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        String expResult = "Last";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPhone method, of class Renter.
     */
    @Test
    public void testGetPhone() {
        System.out.println("getPhone");
        String expResult = "555-555-5555";
        String result = instance.getPhone();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGender method, of class Renter.
     */
    @Test
    public void testGetGender() {
        System.out.println("getGender");
        int expResult = 1;
        int result = instance.getGender();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateBirth method, of class Renter.
     */
    @Test
    public void testGetDateBirth() {
        System.out.println("getDateBirth");
        String expResult = "1993";
        String result = instance.getDateBirth();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIsStudent method, of class Renter.
     */
    @Test
    public void testGetIsStudent() {
        System.out.println("getIsStudent");
        Boolean expResult = true;
        Boolean result = instance.getIsStudent();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIsEmployed method, of class Renter.
     */
    @Test
    public void testGetIsEmployed() {
        System.out.println("getIsEmployed");
        Boolean expResult = true;
        Boolean result = instance.getIsEmployed();
        assertEquals(expResult, result);
    }

    /**
     * Test of getIsSmoker method, of class Renter.
     */
    @Test
    public void testGetIsSmoker() {
        System.out.println("getIsSmoker");
        Boolean expResult = false;
        Boolean result = instance.getIsSmoker();
        assertEquals(expResult, result);
    }

    /**
     * Test of getStartDate method, of class Renter.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("getStartDate");
        Date expResult = new java.sql.Date(0);
        Date result = instance.getStartDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEndDate method, of class Renter.
     */
    @Test
    public void testGetEndDate() {
        System.out.println("getEndDate");
        Date expResult = new java.sql.Date(0);
        Date result = instance.getEndDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getAvailability method, of class Renter.
     */
    @Test
    public void testGetAvailability() {
        System.out.println("getAvailability");
        int expResult = 4;
        int result = instance.getAvailability();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLowPrice method, of class Renter.
     */
    @Test
    public void testGetLowPrice() {
        System.out.println("getLowPrice");
        double expResult = 2.0;
        double result = instance.getLowPrice();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getHighPrice method, of class Renter.
     */
    @Test
    public void testGetHighPrice() {
        System.out.println("getHighPrice");
        double expResult = 2.0;
        double result = instance.getHighPrice();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of getReferralSource method, of class Renter.
     */
    @Test
    public void testGetReferralSource() {
        System.out.println("getReferralSource");
        String expResult = "Reddit";
        String result = instance.getReferralSource();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHasCRCheck method, of class Renter.
     */
    @Test
    public void testGetHasCRCheck() {
        System.out.println("getHasCRCheck");
        Boolean expResult = true;
        Boolean result = instance.getHasCRCheck();
        assertEquals(expResult, result);
    }

    /**
     * Test of setRenterId method, of class Renter.
     */
    @Test
    public void testSetRenterId() {
        System.out.println("setRenterId");
        int renterId = 0;
        instance.setRenterId(renterId);
        assertEquals(renterId, instance.getRenterID());
    }

    /**
     * Test of setEmail method, of class Renter.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        instance.setEmail(email);
        assertEquals(email, instance.getEmail());
    }

    /**
     * Test of setPassWord method, of class Renter.
     */
    @Test
    public void testSetPassWord() {
        System.out.println("setPassWord");
        String passWord = "";
        instance.setPassWord(passWord);
        assertEquals(passWord, instance.getPassWord());
    }

    /**
     * Test of setFirstName method, of class Renter.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        instance.setFirstName(firstName);
        assertEquals(firstName, instance.getFirstName());
    }

    /**
     * Test of setLastName method, of class Renter.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        instance.setLastName(lastName);
        assertEquals(lastName, instance.getLastName());
    }

    /**
     * Test of setPhone method, of class Renter.
     */
    @Test
    public void testSetPhone() {
        System.out.println("setPhone");
        String phone = "";
        instance.setPhone(phone);
        assertEquals(phone, instance.getPhone());
    }

    /**
     * Test of setGender method, of class Renter.
     */
    @Test
    public void testSetGender() {
        System.out.println("setGender");
        int gender = 0;
        instance.setGender(gender);
        assertEquals(gender, instance.getGender());
    }

    /**
     * Test of setDOB method, of class Renter.
     */
    @Test
    public void testSetDOB() {
        System.out.println("setDOB");
        String dateBirth = "";
        instance.setDOB(dateBirth);
        assertEquals(dateBirth, instance.getDateBirth());
    }

    /**
     * Test of setIsStudent method, of class Renter.
     */
    @Test
    public void testSetIsStudent() {
        System.out.println("setIsStudent");
        Boolean isStudent = false;
        instance.setIsStudent(isStudent);
        assertEquals(isStudent, instance.getIsStudent());
    }

    /**
     * Test of setIsEmployed method, of class Renter.
     */
    @Test
    public void testSetIsEmployed() {
        System.out.println("setIsEmployed");
        Boolean isEmployed = false;
        instance.setIsEmployed(isEmployed);
        assertEquals(isEmployed, instance.getIsEmployed());
    }

    /**
     * Test of setIsSmoker method, of class Renter.
     */
    @Test
    public void testSetIsSmoker() {
        System.out.println("setIsSmoker");
        Boolean isSmoker = true;
        instance.setIsSmoker(isSmoker);
        assertEquals(isSmoker, instance.getIsSmoker());
    }

    /**
     * Test of setStartDate method, of class Renter.
     */
    @Test
    public void testSetStartDate() {
        System.out.println("setStartDate");
        Date startDate = null;
        instance.setStartDate(startDate);
        assertEquals(startDate, instance.getStartDate());
    }

    /**
     * Test of setEndDate method, of class Renter.
     */
    @Test
    public void testSetEndDate() {
        System.out.println("setEndDate");
        Date endDate = null;
        instance.setEndDate(endDate);
        assertEquals(endDate, instance.getEndDate());
    }

    /**
     * Test of setAvailability method, of class Renter.
     */
    @Test
    public void testSetAvailability() {
        System.out.println("setAvailability");
        int availability = 0;
        instance.setAvailability(availability);
        assertEquals(availability, instance.getAvailability());
    }

    /**
     * Test of setLowPrice method, of class Renter.
     */
    @Test
    public void testSetLowPrice() {
        System.out.println("setLowPrice");
        double lowPrice = 0.0;
        instance.setLowPrice(lowPrice);
        assertEquals(lowPrice, instance.getLowPrice(), 0.0);
    }

    /**
     * Test of setHighPrice method, of class Renter.
     */
    @Test
    public void testSetHighPrice() {
        System.out.println("setHighPrice");
        double highPrice = 0.0;
        instance.setHighPrice(highPrice);
        assertEquals(highPrice, instance.getHighPrice(), 0.0);
    }

    /**
     * Test of setReferralSource method, of class Renter.
     */
    @Test
    public void testSetReferralSource() {
        System.out.println("setReferralSource");
        String referralSource = "";
        instance.setReferralSource(referralSource);
    }

    /**
     * Test of setHasCRCheck method, of class Renter.
     */
    @Test
    public void testSetHasCRCheck() {
        System.out.println("setHasCRCheck");
        Boolean hasCRCheck = false;
        instance.setHasCRCheck(hasCRCheck);
        assertEquals(hasCRCheck, instance.getHasCRCheck());
    }
}
