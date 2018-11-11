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
public class PropertyXResourceTest {
    
    public PropertyXResourceTest() {
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
     * Test of getPropertyID method, of class PropertyXResource.
     */
    @Test
    public void testGetPropertyID() {
        System.out.println("getPropertyID");
        PropertyXResource instance = new PropertyXResource();
        int expResult = 0;
        int result = instance.getPropertyID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResourceID method, of class PropertyXResource.
     */
    @Test
    public void testGetResourceID() {
        System.out.println("getResourceID");
        PropertyXResource instance = new PropertyXResource();
        int expResult = 0;
        int result = instance.getResourceID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPropertyId method, of class PropertyXResource.
     */
    @Test
    public void testSetPropertyId() {
        System.out.println("setPropertyId");
        int propertyId = 0;
        PropertyXResource instance = new PropertyXResource();
        instance.setPropertyId(propertyId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setResourceId method, of class PropertyXResource.
     */
    @Test
    public void testSetResourceId() {
        System.out.println("setResourceId");
        int resourceId = 0;
        PropertyXResource instance = new PropertyXResource();
        instance.setResourceId(resourceId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
