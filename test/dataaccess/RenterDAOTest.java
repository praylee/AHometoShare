/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

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
public class RenterDAOTest {
    
    public RenterDAOTest() {
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
     * Test of getAllRenter method, of class RenterDAO.
     */
    @Test
    public void testGetAllRenter() {
        System.out.println("getAllRenter");
        RenterDAO instance = new RenterDAOImpl();
        List<Renter> expResult = null;
        List<Renter> result = instance.getAllRenter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addRenter method, of class RenterDAO.
     */
    @Test
    public void testAddRenter() {
        System.out.println("addRenter");
        Renter renter = null;
        RenterDAO instance = new RenterDAOImpl();
        instance.addRenter(renter);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRenterByRenterId method, of class RenterDAO.
     */
    @Test
    public void testGetRenterByRenterId() {
        System.out.println("getRenterByRenterId");
        int renterId = 0;
        RenterDAO instance = new RenterDAOImpl();
        Renter expResult = null;
        Renter result = instance.getRenterByRenterId(renterId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    /**
     * Test of deleteRenter method, of class RenterDAO.
     */
    @Test
    public void testDeleteRenter() {
        System.out.println("deleteRenter");
        int renterId = 0;
        RenterDAO instance = new RenterDAOImpl();
        instance.deleteRenter(renterId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRenter method, of class RenterDAO.
     */
    @Test
    public void testUpdateRenter_18args() {
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
        RenterDAO instance = new RenterDAOImpl();
        instance.updateRenter(email, passWord, firstName, lastName, phone, gender, dateBirth, isStudent, isEmployed, isSmoker, startDate, endDate, availability, lowPrice, highPrice, referralSource, hasCRCheck, renterId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }


    /**
     * Test of updateRenter method, of class RenterDAO.
     */
    @Test
    public void testUpdateRenter_9args() {
        System.out.println("updateRenter");
        String firstName = "";
        String lastName = "";
        String phone = "";
        int gender = 0;
        String dateBirth = "";
        Boolean isStudent = null;
        Boolean isEmployed = null;
        Boolean isSmoker = null;
        int renterId = 0;
        RenterDAO instance = new RenterDAOImpl();
        instance.updateRenter(firstName, lastName, phone, gender, dateBirth, isStudent, isEmployed, isSmoker, renterId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRenter method, of class RenterDAO.
     */
    @Test
    public void testUpdateRenter_String_int() {
        System.out.println("updateRenter");
        String passWord = "";
        int renterId = 0;
        RenterDAO instance = new RenterDAOImpl();
        instance.updateRenter(passWord, renterId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRenterByEmail method, of class RenterDAO.
     */
    @Test
    public void testGetRenterByEmail() {
        System.out.println("getRenterByEmail");
        String email = "";
        RenterDAO instance = new RenterDAOImpl();
        Renter expResult = null;
        Renter result = instance.getRenterByEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of passwordCorrect method, of class RenterDAO.
     */
    @Test
    public void testPasswordCorrect() {
        System.out.println("passwordCorrect");
        String email = "";
        String password = "";
        RenterDAO instance = new RenterDAOImpl();
        boolean expResult = false;
        boolean result = instance.passwordCorrect(email, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class RenterDAOImpl implements RenterDAO {

        public List<Renter> getAllRenter() {
            return null;
        }

        public void addRenter(Renter renter) {
        }

        public Renter getRenterByRenterId(int renterId) {
            return null;
        }

        public Renter getRenterByRenterUname(String username) {
            return null;
        }

        public void deleteRenter(int renterId) {
        }

        public void updateRenter(String email, String passWord, String firstName, String lastName, String phone, int gender, String dateBirth, Boolean isStudent, Boolean isEmployed, Boolean isSmoker, Date startDate, Date endDate, int availability, double lowPrice, double highPrice, String referralSource, Boolean hasCRCheck, int renterId) {
        }

        public void updateRenter(Date startDate, Date endDate, double lowPrice, double highPrice, int renterId) {
        }

        public void updateRenter(String firstName, String lastName, String phone, int gender, String dateBirth, Boolean isStudent, Boolean isEmployed, Boolean isSmoker, int renterId) {
        }

        public void updateRenter(String passWord, int renterId) {
        }

        public Renter getRenterByEmail(String email) {
            return null;
        }

        public boolean passwordCorrect(String email, String password) {
            return false;
        }
    }
    
}
