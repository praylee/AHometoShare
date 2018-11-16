/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import transferobjects.Host;

/**
 *
 * @author chris
 */
public class HostDAOImplTest {
    
    public HostDAOImplTest() {
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
        HostDAOImpl instance = new HostDAOImpl();
        List<Host> expResult = null;
        List<Host> result = instance.getAllHost();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addHost method, of class HostDAOImpl.
     */
    @Test
    public void testAddHost() {
        System.out.println("addHost");
        Host host = null;
        HostDAOImpl instance = new HostDAOImpl();
        instance.addHost(host);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHostByHostId method, of class HostDAOImpl.
     */
    @Test
    public void testGetHostByHostId() {
        System.out.println("getHostByHostId");
        int hostId = 0;
        HostDAOImpl instance = new HostDAOImpl();
        Host expResult = null;
        Host result = instance.getHostByHostId(hostId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHostByEmail method, of class HostDAOImpl.
     */
    @Test
    public void testGetHostByEmail() {
        System.out.println("getHostByEmail");
        String email = "";
        HostDAOImpl instance = new HostDAOImpl();
        Host expResult = null;
        Host result = instance.getHostByEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteHost method, of class HostDAOImpl.
     */
    @Test
    public void testDeleteHost() {
        System.out.println("deleteHost");
        int hostId = 0;
        HostDAOImpl instance = new HostDAOImpl();
        instance.deleteHost(hostId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        Boolean retired = null;
        Boolean pets = null;
        Boolean smoker = null;
        String referralSource = "";
        int hostId = 0;
        HostDAOImpl instance = new HostDAOImpl();
        instance.updateHost(email, passWord, firstName, lastName, phone, gender, dateBirth, retired, pets, smoker, referralSource, hostId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
        Boolean retired = null;
        Boolean pets = null;
        Boolean smoker = null;
        String referralSource = "";
        int hostId = 0;
        HostDAOImpl instance = new HostDAOImpl();
        instance.updateHost(firstName, lastName, phone, gender, dateBirth, retired, pets, smoker, referralSource, hostId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateHost method, of class HostDAOImpl.
     */
    @Test
    public void testUpdateHost_String_int() {
        System.out.println("updateHost");
        String passWord = "";
        int hostId = 0;
        HostDAOImpl instance = new HostDAOImpl();
        instance.updateHost(passWord, hostId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of passwordCorrect method, of class HostDAOImpl.
     */
    @Test
    public void testPasswordCorrect() {
        System.out.println("passwordCorrect");
        String email = "";
        String password = "";
        HostDAOImpl instance = new HostDAOImpl();
        boolean expResult = false;
        boolean result = instance.passwordCorrect(email, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
