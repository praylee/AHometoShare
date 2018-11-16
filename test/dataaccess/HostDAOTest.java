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
public class HostDAOTest {
    
    public HostDAOTest() {
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
     * Test of getAllHost method, of class HostDAO.
     */
    @Test
    public void testGetAllHost() {
        System.out.println("getAllHost");
        HostDAO instance = new HostDAOImpl();
        List<Host> expResult = null;
        List<Host> result = instance.getAllHost();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addHost method, of class HostDAO.
     */
    @Test
    public void testAddHost() {
        System.out.println("addHost");
        Host host = null;
        HostDAO instance = new HostDAOImpl();
        instance.addHost(host);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHostByHostId method, of class HostDAO.
     */
    @Test
    public void testGetHostByHostId() {
        System.out.println("getHostByHostId");
        int hostId = 0;
        HostDAO instance = new HostDAOImpl();
        Host expResult = null;
        Host result = instance.getHostByHostId(hostId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHostByEmail method, of class HostDAO.
     */
    @Test
    public void testGetHostByEmail() {
        System.out.println("getHostByEmail");
        String email = "";
        HostDAO instance = new HostDAOImpl();
        Host expResult = null;
        Host result = instance.getHostByEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteHost method, of class HostDAO.
     */
    @Test
    public void testDeleteHost() {
        System.out.println("deleteHost");
        int hostId = 0;
        HostDAO instance = new HostDAOImpl();
        instance.deleteHost(hostId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateHost method, of class HostDAO.
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
        HostDAO instance = new HostDAOImpl();
        instance.updateHost(email, passWord, firstName, lastName, phone, gender, dateBirth, retired, pets, smoker, referralSource, hostId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateHost method, of class HostDAO.
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
        HostDAO instance = new HostDAOImpl();
        instance.updateHost(firstName, lastName, phone, gender, dateBirth, retired, pets, smoker, referralSource, hostId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateHost method, of class HostDAO.
     */
    @Test
    public void testUpdateHost_String_int() {
        System.out.println("updateHost");
        String passWord = "";
        int hostId = 0;
        HostDAO instance = new HostDAOImpl();
        instance.updateHost(passWord, hostId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of passwordCorrect method, of class HostDAO.
     */
    @Test
    public void testPasswordCorrect() {
        System.out.println("passwordCorrect");
        String email = "";
        String password = "";
        HostDAO instance = new HostDAOImpl();
        boolean expResult = false;
        boolean result = instance.passwordCorrect(email, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class HostDAOImpl implements HostDAO {

        public List<Host> getAllHost() {
            return null;
        }

        public void addHost(Host host) {
        }

        public Host getHostByHostId(int hostId) {
            return null;
        }

        public Host getHostByEmail(String email) {
            return null;
        }

        public void deleteHost(int hostId) {
        }

        public void updateHost(String email, String passWord, String firstName, String lastName, String phone, int gender, String dateBirth, Boolean retired, Boolean pets, Boolean smoker, String referralSource, int hostId) {
        }

        public void updateHost(String firstName, String lastName, String phone, int gender, String dateBirth, Boolean retired, Boolean pets, Boolean smoker, String referralSource, int hostId) {
        }

        public void updateHost(String passWord, int hostId) {
        }

        public boolean passwordCorrect(String email, String password) {
            return false;
        }
    }
    
}
