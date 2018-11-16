/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import transferobjects.Resource;

/**
 *
 * @author chris
 */
public class ResourceBusinessLayerTest {
    
    public ResourceBusinessLayerTest() {
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
     * Test of getAllResource method, of class ResourceBusinessLayer.
     */
    @Test
    public void testGetAllResource() {
        System.out.println("getAllResource");
        ResourceBusinessLayer instance = new ResourceBusinessLayer();
        List<Resource> expResult = null;
        List<Resource> result = instance.getAllResource();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addResource method, of class ResourceBusinessLayer.
     */
    @Test
    public void testAddResource() throws Exception {
        System.out.println("addResource");
        Resource resource = null;
        ResourceBusinessLayer instance = new ResourceBusinessLayer();
        instance.addResource(resource);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRESOURCEByResourceId method, of class ResourceBusinessLayer.
     */
    @Test
    public void testGetRESOURCEByResourceId() {
        System.out.println("getRESOURCEByResourceId");
        int resourceId = 0;
        ResourceBusinessLayer instance = new ResourceBusinessLayer();
        Resource expResult = null;
        Resource result = instance.getRESOURCEByResourceId(resourceId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteResource method, of class ResourceBusinessLayer.
     */
    @Test
    public void testDeleteResource() {
        System.out.println("deleteResource");
        int resourceId = 0;
        ResourceBusinessLayer instance = new ResourceBusinessLayer();
        instance.deleteResource(resourceId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateResource method, of class ResourceBusinessLayer.
     */
    @Test
    public void testUpdateResource() {
        System.out.println("updateResource");
        String type = "";
        int resourceId = 0;
        ResourceBusinessLayer instance = new ResourceBusinessLayer();
        instance.updateResource(type, resourceId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
