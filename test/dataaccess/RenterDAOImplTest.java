/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

import java.sql.Date;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import transferobjects.Renter;

/**
 *
 * @author 29751
 */
public class RenterDAOImplTest {
    
    public RenterDAOImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

      /**
     * Test of addRenter method, of class RenterDAOImpl.
     */
    @Test
    public void testAddRenter() {
        System.out.println("addRenter");       
        Renter renter = new Renter(1,"chrislabelle@gmail.com", "password","Chris","Chris","5555555555",1,"1999",false,false,false,new java.sql.Date(System.currentTimeMillis()),new java.sql.Date(System.currentTimeMillis()),4,2,2,"newspaper",true);
        RenterDAOImpl instance = new RenterDAOImpl();
        instance.addRenter(renter);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
    
    /**
     * Test of getAllRenter method, of class RenterDAOImpl.
     */
 /*   @Test
    public void testGetAllRenter() {
        System.out.println("getAllRenter");
        RenterDAOImpl instance = new RenterDAOImpl();
        List<Renter> expResult = null;
        List<Renter> result = instance.getAllRenter();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

  
    /**
     * Test of getRenterByRenterId method, of class RenterDAOImpl.
     */
/*    @Test
    public void testGetRenterByRenterId() {
        System.out.println("getRenterByRenterId");
        int renterId = 0;
        RenterDAOImpl instance = new RenterDAOImpl();
        Renter expResult = null;
        Renter result = instance.getRenterByRenterId(renterId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRenterByRenterUname method, of class RenterDAOImpl.
     */
/*    @Test
    public void testGetRenterByRenterUname() {
        System.out.println("getRenterByRenterUname");
        String username = "";
        RenterDAOImpl instance = new RenterDAOImpl();
        Renter expResult = null;
        Renter result = instance.getRenterByRenterUname(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteRenter method, of class RenterDAOImpl.
     */
/*    @Test
    public void testDeleteRenter() {
        System.out.println("deleteRenter");
        int renterId = 0;
        RenterDAOImpl instance = new RenterDAOImpl();
        instance.deleteRenter(renterId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateRenter method, of class RenterDAOImpl.
     */
/*    @Test
    public void testUpdateRenter() {
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
        RenterDAOImpl instance = new RenterDAOImpl();
        instance.updateRenter(email, passWord, firstName, lastName, phone, gender, dateBirth, isStudent, isEmployed, isSmoker, startDate, endDate, availability, lowPrice, highPrice, referralSource, hasCRCheck, renterId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRenterByEmail method, of class RenterDAOImpl.
     */
/*    @Test
    public void testGetRenterByEmail() {
        System.out.println("getRenterByEmail");
        String email = "";
        RenterDAOImpl instance = new RenterDAOImpl();
        Renter expResult = null;
        Renter result = instance.getRenterByEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of passwordCorrect method, of class RenterDAOImpl.
     */
/*    @Test
    public void testPasswordCorrect() {
        System.out.println("passwordCorrect");
        String email = "";
        String password = "";
        RenterDAOImpl instance = new RenterDAOImpl();
        boolean expResult = false;
        boolean result = instance.passwordCorrect(email, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
}
