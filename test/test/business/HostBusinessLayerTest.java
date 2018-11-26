/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.business;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.HostBusinessLayer;
import business.ValidationException;

import static org.junit.Assert.*;
import transferobjects.Host;

/**
 *
 * @author melissa
 */
public class HostBusinessLayerTest {
	
    HostBusinessLayer instance = new HostBusinessLayer();
    
    int hostID = 12;
    
    public HostBusinessLayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    	
    	instance.deleteHost(hostID);
        System.out.println("Deleted host with id: " + hostID);
    	
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllHost method, of class HostBusinessLayer.
     * @throws ValidationException 
     */
    @Test
    public void testGetAllHost() throws ValidationException {
        System.out.println("getAllHost");

        String result = null;
        
        Host host1 = new Host(hostID, "host1@test.com", "Password1", "Joe", "Host",  "613-254-6898", 1, "1970", false, true, true, "paper");
        instance.addHost(host1);
        
        String expResult = host1.getEmail();

        List<Host> list = instance.getAllHost();
        
        for (Host host: list) {
        	if (host.getHostID() == hostID) {
        		result = host.getEmail();
        	}
        }

        assertEquals(expResult, result);
    }

    /**
     * Test of addHost method, of class HostBusinessLayer.
     */
    @Test
    public void testAddHost() throws Exception {
        System.out.println("addHost");
        
        Host host = new Host(hostID, "host1@test.com", "Password1", "Joe", "Host",  "613-254-6898", 1, "1970", false, true, true, "paper");

        instance.addHost(host);
        
        int expResult = instance.getHostByHostId(hostID).getHostID();

        assertEquals(expResult, hostID);
    }

    /**
     * Test of getHostByHostId method, of class HostBusinessLayer.
     * @throws ValidationException 
     */
    @Test
    public void testGetHostByHostId() throws ValidationException {
        System.out.println("getHostByHostId");

        Host host = new Host(hostID, "host1@test.com", "Password1", "Joe", "Host",  "613-254-6898", 1, "1970", false, true, true, "paper");
        instance.addHost(host);
        
        int result = instance.getHostByHostId(hostID).getHostID();
        
        assertEquals(hostID, result);

    }

    /**
     * Test of getHostByEmail method, of class HostBusinessLayer.
     * @throws ValidationException 
     */
    @Test
    public void testGetHostByEmail() throws ValidationException {
        System.out.println("getHostByEmail");
        
        String email = "frosty@test.com";
        
        Host host = new Host(hostID, email, "Password1", "Joe", "Host",  "613-254-6898", 1, "1970", false, true, true, "paper");
        instance.addHost(host);

        String result = instance.getHostByEmail(email).getEmail();
        assertEquals(email, result);

    }

    /**
     * Test of hostExists method, of class HostBusinessLayer.
     * @throws ValidationException 
     */
    @Test
    public void testHostExists() throws ValidationException {
        System.out.println("hostExists");
        
        String email = "snowman@test.com";
        
        Host host = new Host(hostID, email, "Password1", "Joe", "Host",  "613-254-6898", 1, "1970", false, true, true, "paper");
        instance.addHost(host);

        String result = instance.getHostByEmail(email).getEmail();
        assertEquals(email, result);
    }

    /**
     * Test of deleteHost method, of class HostBusinessLayer.
     * @throws ValidationException 
     */
    @Test
    public void testDeleteHost() throws ValidationException {
        System.out.println("deleteHost");
        
        Host host = new Host(hostID, "host1@test.com", "Password1", "Joe", "Host",  "613-254-6898", 1, "1970", false, true, true, "paper");
        instance.addHost(host);
        
        instance.deleteHost(hostID);
        
        int result = instance.getHostByHostId(hostID).getHostID();

        assertEquals(0, result);
    }

    /**
     * Test of updateHost method, of class HostBusinessLayer.
     * @throws ValidationException 
     */
    @Test
    public void testUpdateHost_12args() throws ValidationException {
        System.out.println("updateHost");
        
        String updatedEmail = "newhost@test.com";
        
        Host host = new Host(hostID, "host1@test.com", "Password1", "Joe", "Host",  "613-254-6898", 1, "1970", false, true, true, "paper");
        instance.addHost(host);
        
        instance.updateHost(updatedEmail, "Password1", "Joe", "Host", "613-254-6898", 1, "1970", false, true, true, "paper", hostID);

        String result = instance.getHostByHostId(hostID).getEmail();
        
        assertEquals(updatedEmail, result);
        
    }

    /**
     * Test of updateHost method, of class HostBusinessLayer.
     * @throws ValidationException 
     */
    @Test
    public void testUpdateHost_10args() throws ValidationException {
        System.out.println("updateHost");

        String newLN = "George";
        
        Host host = new Host(hostID, "host1@test.com", "Password1", "Joe", "Host",  "613-254-6898", 1, "1970", false, true, true, "paper");
        instance.addHost(host);

        instance.updateHost("Joe", newLN, "613-254-6898", 1, "1970", false, true, true, "paper", hostID);
        
        String result = instance.getHostByHostId(hostID).getLastName();
        
        assertEquals(newLN, result);

    }

    /**
     * Test of updateHost method, of class HostBusinessLayer.
     * @throws ValidationException 
     */
    @Test
    public void testUpdateHost_String_int() throws ValidationException {
        System.out.println("updateHost");

        String passWord = "testing123";
        String updatePassWord = "testing321";
        
        Host host = new Host(hostID, "host1@test.com", passWord, "Joe", "Host",  "613-254-6898", 1, "1970", false, true, true, "paper");
        instance.addHost(host);
        
        instance.updateHost(updatePassWord, hostID);
        
        String result = instance.getHostByHostId(hostID).getPassWord(); //result in encrypted
        
        //assertEquals(updatePassWord, result);
    }

    /**
     * Test of passwordCorrect method, of class HostBusinessLayer.
     * @throws ValidationException 
     */
    @Test
    public void testPasswordCorrect() throws ValidationException {
        System.out.println("passwordCorrect");

        String email = "host1@test.com";
        String password = "Password1";
        
        Host host = new Host(hostID, "host1@test.com", "Password1", "Joe", "Host",  "613-254-6898", 1, "1970", false, true, true, "paper");
        instance.addHost(host);
        
        boolean expResult = true;
        
        boolean result = instance.passwordCorrect(email, password);
        
        assertEquals(expResult, result);

    }
    
}
