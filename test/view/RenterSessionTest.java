/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
public class RenterSessionTest {
    
    public RenterSessionTest() {
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
     * Test of getAttribute method, of class RenterSession.
     */
    @Test
    public void testGetAttribute() {
        System.out.println("getAttribute");
        String key = "";
        RenterSession instance = null;
        Object expResult = null;
        Object result = instance.getAttribute(key);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAttribute method, of class RenterSession.
     */
    @Test
    public void testSetAttribute() {
        System.out.println("setAttribute");
        String key = "";
        Object value = null;
        RenterSession instance = null;
        instance.setAttribute(key, value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeAttribute method, of class RenterSession.
     */
    @Test
    public void testRemoveAttribute() {
        System.out.println("removeAttribute");
        String key = "";
        RenterSession instance = null;
        instance.removeAttribute(key);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of endSession method, of class RenterSession.
     */
    @Test
    public void testEndSession() {
        System.out.println("endSession");
        RenterSession instance = null;
        instance.endSession();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSessionAttributes method, of class RenterSession.
     */
    @Test
    public void testSetSessionAttributes() {
        System.out.println("setSessionAttributes");
        Renter renter = null;
        boolean isLoggedIn = false;
        RenterSession instance = null;
        instance.setSessionAttributes(renter, isLoggedIn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
