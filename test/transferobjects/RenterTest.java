/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjects;

import java.sql.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chris
 */
public class RenterTest {
    
    public RenterTest() {
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
        Renter instance = new Renter();
        int expResult = 0;
        int result = instance.getRenterID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmail method, of class Renter.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        Renter instance = new Renter();
        String expResult = "";
        String result = instance.getEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPassWord method, of class Renter.
     */
    @Test
    public void testGetPassWord() {
        System.out.println("getPassWord");
        Renter instance = new Renter();
        String expResult = "";
        String result = instance.getPassWord();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstName method, of class Renter.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        Renter instance = new Renter();
        String expResult = "";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastName method, of class Renter.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        Renter instance = new Renter();
        String expResult = "";
        String result = instance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPhone method, of class Renter.
     */
    @Test
    public void testGetPhone() {
        System.out.println("getPhone");
        Renter instance = new Renter();
        String expResult = "";
        String result = instance.getPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGender method, of class Renter.
     */
    @Test
    public void testGetGender() {
        System.out.println("getGender");
        Renter instance = new Renter();
        int expResult = 0;
        int result = instance.getGender();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateBirth method, of class Renter.
     */
    @Test
    public void testGetDateBirth() {
        System.out.println("getDateBirth");
        Renter instance = new Renter();
        String expResult = "";
        String result = instance.getDateBirth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsStudent method, of class Renter.
     */
    @Test
    public void testGetIsStudent() {
        System.out.println("getIsStudent");
        Renter instance = new Renter();
        Boolean expResult = null;
        Boolean result = instance.getIsStudent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsEmployed method, of class Renter.
     */
    @Test
    public void testGetIsEmployed() {
        System.out.println("getIsEmployed");
        Renter instance = new Renter();
        Boolean expResult = null;
        Boolean result = instance.getIsEmployed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsSmoker method, of class Renter.
     */
    @Test
    public void testGetIsSmoker() {
        System.out.println("getIsSmoker");
        Renter instance = new Renter();
        Boolean expResult = null;
        Boolean result = instance.getIsSmoker();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStartDate method, of class Renter.
     */
    @Test
    public void testGetStartDate() {
        System.out.println("getStartDate");
        Renter instance = new Renter();
        Date expResult = null;
        Date result = instance.getStartDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEndDate method, of class Renter.
     */
    @Test
    public void testGetEndDate() {
        System.out.println("getEndDate");
        Renter instance = new Renter();
        Date expResult = null;
        Date result = instance.getEndDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAvailability method, of class Renter.
     */
    @Test
    public void testGetAvailability() {
        System.out.println("getAvailability");
        Renter instance = new Renter();
        int expResult = 0;
        int result = instance.getAvailability();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLowPrice method, of class Renter.
     */
    @Test
    public void testGetLowPrice() {
        System.out.println("getLowPrice");
        Renter instance = new Renter();
        double expResult = 0.0;
        double result = instance.getLowPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHighPrice method, of class Renter.
     */
    @Test
    public void testGetHighPrice() {
        System.out.println("getHighPrice");
        Renter instance = new Renter();
        double expResult = 0.0;
        double result = instance.getHighPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getReferralSource method, of class Renter.
     */
    @Test
    public void testGetReferralSource() {
        System.out.println("getReferralSource");
        Renter instance = new Renter();
        String expResult = "";
        String result = instance.getReferralSource();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHasCRCheck method, of class Renter.
     */
    @Test
    public void testGetHasCRCheck() {
        System.out.println("getHasCRCheck");
        Renter instance = new Renter();
        Boolean expResult = null;
        Boolean result = instance.getHasCRCheck();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRenterId method, of class Renter.
     */
    @Test
    public void testSetRenterId() {
        System.out.println("setRenterId");
        int renterId = 0;
        Renter instance = new Renter();
        instance.setRenterId(renterId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Renter.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        Renter instance = new Renter();
        instance.setEmail(email);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPassWord method, of class Renter.
     */
    @Test
    public void testSetPassWord() {
        System.out.println("setPassWord");
        String passWord = "";
        Renter instance = new Renter();
        instance.setPassWord(passWord);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFirstName method, of class Renter.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        Renter instance = new Renter();
        instance.setFirstName(firstName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLastName method, of class Renter.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        Renter instance = new Renter();
        instance.setLastName(lastName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPhone method, of class Renter.
     */
    @Test
    public void testSetPhone() {
        System.out.println("setPhone");
        String phone = "";
        Renter instance = new Renter();
        instance.setPhone(phone);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGender method, of class Renter.
     */
    @Test
    public void testSetGender() {
        System.out.println("setGender");
        int gender = 0;
        Renter instance = new Renter();
        instance.setGender(gender);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDOB method, of class Renter.
     */
    @Test
    public void testSetDOB() {
        System.out.println("setDOB");
        String dateBirth = "";
        Renter instance = new Renter();
        instance.setDOB(dateBirth);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsStudent method, of class Renter.
     */
    @Test
    public void testSetIsStudent() {
        System.out.println("setIsStudent");
        Boolean isStudent = null;
        Renter instance = new Renter();
        instance.setIsStudent(isStudent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsEmployed method, of class Renter.
     */
    @Test
    public void testSetIsEmployed() {
        System.out.println("setIsEmployed");
        Boolean isEmployed = null;
        Renter instance = new Renter();
        instance.setIsEmployed(isEmployed);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsSmoker method, of class Renter.
     */
    @Test
    public void testSetIsSmoker() {
        System.out.println("setIsSmoker");
        Boolean isSmoker = null;
        Renter instance = new Renter();
        instance.setIsSmoker(isSmoker);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStartDate method, of class Renter.
     */
    @Test
    public void testSetStartDate() {
        System.out.println("setStartDate");
        Date startDate = null;
        Renter instance = new Renter();
        instance.setStartDate(startDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEndDate method, of class Renter.
     */
    @Test
    public void testSetEndDate() {
        System.out.println("setEndDate");
        Date endDate = null;
        Renter instance = new Renter();
        instance.setEndDate(endDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAvailability method, of class Renter.
     */
    @Test
    public void testSetAvailability() {
        System.out.println("setAvailability");
        int availability = 0;
        Renter instance = new Renter();
        instance.setAvailability(availability);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setLowPrice method, of class Renter.
     */
    @Test
    public void testSetLowPrice() {
        System.out.println("setLowPrice");
        double lowPrice = 0.0;
        Renter instance = new Renter();
        instance.setLowPrice(lowPrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHighPrice method, of class Renter.
     */
    @Test
    public void testSetHighPrice() {
        System.out.println("setHighPrice");
        double highPrice = 0.0;
        Renter instance = new Renter();
        instance.setHighPrice(highPrice);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setReferralSource method, of class Renter.
     */
    @Test
    public void testSetReferralSource() {
        System.out.println("setReferralSource");
        String referralSource = "";
        Renter instance = new Renter();
        instance.setReferralSource(referralSource);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHasCRCheck method, of class Renter.
     */
    @Test
    public void testSetHasCRCheck() {
        System.out.println("setHasCRCheck");
        Boolean hasCRCheck = null;
        Renter instance = new Renter();
        instance.setHasCRCheck(hasCRCheck);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
