/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dataaccess;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dataaccess.HostDAO;
import dataaccess.HostDAOImpl;
import transferobjects.Host;

import static org.junit.Assert.*;

/**
 *
 * @author Christopher Labelle
 */
public class HostDAOImplTest {
    
	HostDAO instance;
	Host host;
	int hostId;
	
    public HostDAOImplTest() {
    	instance = new HostDAOImpl();
    	List<Host> hosts = instance.getAllHost();
    	hostId = hosts.size() > 0 ? hosts.size() + 1 : 1;
    	host = new Host(
			hostId,
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
     * Test of getAllHost method, of class HostDAOImpl.
     */
    @Test
    public void testGetAllHost() {
        System.out.println("getAllHost");
        List<Host> expResult = null;
        List<Host> result = instance.getAllHost();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of addHost method, of class HostDAOImpl.
     */
    @Test
    public void testAddHost() {
        System.out.println("addHost");
        instance.addHost(host);
    }

    /**
     * Test of getHostByHostId method, of class HostDAOImpl.
     */
    @Test
    public void testGetHostByHostId() {
        System.out.println("getHostByHostId");
        Host expResult = null;
        Host result = instance.getHostByHostId(hostId);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of getHostByEmail method, of class HostDAOImpl.
     */
    @Test
    public void testGetHostByEmail() {
        System.out.println("getHostByEmail");
        String email = "email";
        Host expResult = null;
        Host result = instance.getHostByEmail(email);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of deleteHost method, of class HostDAOImpl.
     */
    @Test
    public void testDeleteHost() {
        System.out.println("deleteHost");
        int hostId = 0;
        instance.deleteHost(hostId);
    }

    /**
     * Test of updateHost method, of class HostDAOImpl.
     */
    @Test
    public void testUpdateHost_12args() {
        System.out.println("updateHost");
        String email = "";
        String passWord = "";
        String firstName = "";
        String lastName = "";
        String phone = "";
        int gender = 0;
        String dateBirth = "";
        Boolean retired = false;
        Boolean pets = false;
        Boolean smoker = false;
        String referralSource = "";
        int hostId = this.hostId;
        instance.updateHost(email, passWord, firstName, lastName, phone, gender, dateBirth, retired, pets, smoker, referralSource, hostId);
    }

    /**
     * Test of updateHost method, of class HostDAOImpl.
     */
    @Test
    public void testUpdateHost_10args() {
        System.out.println("updateHost");
        String firstName = "";
        String lastName = "";
        String phone = "";
        int gender = 0;
        String dateBirth = "";
        Boolean retired = false;
        Boolean pets = false;
        Boolean smoker = false;
        String referralSource = "";
        int hostId = this.hostId;
        instance.updateHost(firstName, lastName, phone, gender, dateBirth, retired, pets, smoker, referralSource, hostId);
    }

    /**
     * Test of updateHost method, of class HostDAOImpl.
     */
    @Test
    public void testUpdateHost_String_int() {
        System.out.println("updateHost");
        String passWord = "password";
        int hostId = this.hostId;
        instance.updateHost(passWord, hostId);
    }

    /**
     * Test of passwordCorrect method, of class HostDAOImpl.
     */
    @Test
    public void testPasswordCorrect() {
        System.out.println("passwordCorrect");
        String email = "email";
        String password = "password";
        boolean expResult = true;
        boolean result = instance.passwordCorrect(email, password);
        assertEquals(expResult, result);
    }
    
}
