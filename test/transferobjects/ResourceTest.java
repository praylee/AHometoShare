/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transferobjects;

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
public class ResourceTest {
    
    public ResourceTest() {
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
     * Test of getResourceID method, of class Resource.
     */
    @Test
    public void testGetResourceID() {
        System.out.println("getResourceID");
        Resource instance = new Resource();
        int expResult = 0;
        int result = instance.getResourceID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class Resource.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Resource instance = new Resource();
        String expResult = "";
        String result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setResourceId method, of class Resource.
     */
    @Test
    public void testSetResourceId() {
        System.out.println("setResourceId");
        int id = 0;
        Resource instance = new Resource();
        instance.setResourceId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setType method, of class Resource.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        String type = "";
        Resource instance = new Resource();
        instance.setType(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
