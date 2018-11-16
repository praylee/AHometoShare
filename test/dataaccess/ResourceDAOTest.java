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
import transferobjects.Resource;

/**
 *
 * @author chris
 */
public class ResourceDAOTest {
    
    public ResourceDAOTest() {
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
     * Test of getAllResource method, of class ResourceDAO.
     */
    @Test
    public void testGetAllResource() {
        System.out.println("getAllResource");
        ResourceDAO instance = new ResourceDAOImpl();
        List<Resource> expResult = null;
        List<Resource> result = instance.getAllResource();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addResource method, of class ResourceDAO.
     */
    @Test
    public void testAddResource() {
        System.out.println("addResource");
        Resource resource = null;
        ResourceDAO instance = new ResourceDAOImpl();
        instance.addResource(resource);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResourceByResourceId method, of class ResourceDAO.
     */
    @Test
    public void testGetResourceByResourceId() {
        System.out.println("getResourceByResourceId");
        int resourceId = 0;
        ResourceDAO instance = new ResourceDAOImpl();
        Resource expResult = null;
        Resource result = instance.getResourceByResourceId(resourceId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteResource method, of class ResourceDAO.
     */
    @Test
    public void testDeleteResource() {
        System.out.println("deleteResource");
        int resourceId = 0;
        ResourceDAO instance = new ResourceDAOImpl();
        instance.deleteResource(resourceId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateResource method, of class ResourceDAO.
     */
    @Test
    public void testUpdateResource() {
        System.out.println("updateResource");
        String type = "";
        int resourceId = 0;
        ResourceDAO instance = new ResourceDAOImpl();
        instance.updateResource(type, resourceId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class ResourceDAOImpl implements ResourceDAO {

        public List<Resource> getAllResource() {
            return null;
        }

        public void addResource(Resource resource) {
        }

        public Resource getResourceByResourceId(int resourceId) {
            return null;
        }

        public void deleteResource(int resourceId) {
        }

        public void updateResource(String type, int resourceId) {
        }
    }
    
}
