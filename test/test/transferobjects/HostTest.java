/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.transferobjects;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import transferobjects.Host;

import static org.junit.Assert.*;

/**
 *
 * @author Christopher Labelle
 */
public class HostTest {
    
	Host instance;
	
    public HostTest() {
    	instance = new Host(
			1,
			"email",
			"password",
			"first",
			"last",
			"phone",
			1,
			"year",
			true,
			true,
			true,
			"source"
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
     * Test of getHostID method, of class Host.
     */
    @Test
    public void testGetHostID() {
        System.out.println("getHostID");
        int expResult = 1;
        int result = instance.getHostID();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEmail method, of class Host.
     */
    @Test
    public void testGetEmail() {
        System.out.println("getEmail");
        String expResult = "email";
        String result = instance.getEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassWord method, of class Host.
     */
    @Test
    public void testGetPassWord() {
        System.out.println("getPassWord");
        String expResult = "password";
        String result = instance.getPassWord();
        assertEquals(expResult, result);
    }

    /**
     * Test of getFirstName method, of class Host.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        String expResult = "first";
        String result = instance.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastName method, of class Host.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        String expResult = "last";
        String result = instance.getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPhone method, of class Host.
     */
    @Test
    public void testGetPhone() {
        System.out.println("getPhone");
        String expResult = "phone";
        String result = instance.getPhone();
        assertEquals(expResult, result);
    }

    /**
     * Test of getGender method, of class Host.
     */
    @Test
    public void testGetGender() {
        System.out.println("getGender");
        int expResult = 1;
        int result = instance.getGender();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateBirth method, of class Host.
     */
    @Test
    public void testGetDateBirth() {
        System.out.println("getDateBirth");
        String expResult = "year";
        String result = instance.getDateBirth();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRetired method, of class Host.
     */
    @Test
    public void testGetRetired() {
        System.out.println("getRetired");
        Boolean expResult = true;
        Boolean result = instance.getRetired();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPets method, of class Host.
     */
    @Test
    public void testGetPets() {
        System.out.println("getPets");
        Boolean expResult = true;
        Boolean result = instance.getPets();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSmoker method, of class Host.
     */
    @Test
    public void testGetSmoker() {
        System.out.println("getSmoker");
        Boolean expResult = true;
        Boolean result = instance.getSmoker();
        assertEquals(expResult, result);
    }

    /**
     * Test of getReferralSource method, of class Host.
     */
    @Test
    public void testGetReferralSource() {
        System.out.println("getReferralSource");
        String expResult = "source";
        String result = instance.getReferralSource();
        assertEquals(expResult, result);
    }

    /**
     * Test of setHostId method, of class Host.
     */
    @Test
    public void testSetHostId() {
        System.out.println("setHostId");
        int hostId = 0;
        instance.setHostId(hostId);
        assertEquals(hostId, instance.getHostID());
    }

    /**
     * Test of setEmail method, of class Host.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        String email = "";
        instance.setEmail(email);
        assertEquals(email, instance.getEmail());
    }

    /**
     * Test of setPassWord method, of class Host.
     */
    @Test
    public void testSetPassWord() {
        System.out.println("setPassWord");
        String passWord = "";
        instance.setPassWord(passWord);
        assertEquals(passWord, instance.getPassWord());
    }

    /**
     * Test of setFirstName method, of class Host.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String firstName = "";
        instance.setFirstName(firstName);
        assertEquals(firstName, instance.getFirstName());
    }

    /**
     * Test of setLastName method, of class Host.
     */
    @Test
    public void testSetLastName() {
        System.out.println("setLastName");
        String lastName = "";
        instance.setLastName(lastName);
        assertEquals(lastName, instance.getLastName());
    }

    /**
     * Test of setPhone method, of class Host.
     */
    @Test
    public void testSetPhone() {
        System.out.println("setPhone");
        String phone = "";
        instance.setPhone(phone);
        assertEquals(phone, instance.getPhone());
    }

    /**
     * Test of setGender method, of class Host.
     */
    @Test
    public void testSetGender() {
        System.out.println("setGender");
        int gender = 0;
        instance.setGender(gender);
        assertEquals(gender, instance.getGender());
    }

    /**
     * Test of setDOB method, of class Host.
     */
    @Test
    public void testSetDOB() {
        System.out.println("setDOB");
        String dateBirth = "";
        instance.setDOB(dateBirth);
        assertEquals(dateBirth, instance.getDateBirth());
    }

    /**
     * Test of setRetired method, of class Host.
     */
    @Test
    public void testSetRetired() {
        System.out.println("setRetired");
        Boolean retired = null;
        instance.setRetired(retired);
        assertEquals(retired, instance.getRetired());
    }

    /**
     * Test of setPets method, of class Host.
     */
    @Test
    public void testSetPets() {
        System.out.println("setPets");
        Boolean pets = null;
        instance.setPets(pets);
        assertEquals(pets, instance.getPets());
    }

    /**
     * Test of setSmoker method, of class Host.
     */
    @Test
    public void testSetSmoker() {
        System.out.println("setSmoker");
        Boolean smoker = null;
        instance.setSmoker(smoker);
        assertEquals(smoker, instance.getSmoker());
    }

    /**
     * Test of setReferralSource method, of class Host.
     */
    @Test
    public void testSetReferralSource() {
        System.out.println("setReferralSource");
        String referralSource = "";
        instance.setReferralSource(referralSource);
        assertEquals(referralSource, instance.getReferralSource());
    }
    
}
