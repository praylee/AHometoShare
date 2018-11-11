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
import transferobjects.PropertyXResource;

/**
 *
 * @author chris
 */
public class PropertyXResourceDAOTest {
    
    public PropertyXResourceDAOTest() {
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
     * Test of getAllPropertyXResource method, of class PropertyXResourceDAO.
     */
    @Test
    public void testGetAllPropertyXResource() {
        System.out.println("getAllPropertyXResource");
        PropertyXResourceDAO instance = new PropertyXResourceDAOImpl();
        List<PropertyXResource> expResult = null;
        List<PropertyXResource> result = instance.getAllPropertyXResource();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPropertyXResource method, of class PropertyXResourceDAO.
     */
    @Test
    public void testAddPropertyXResource() {
        System.out.println("addPropertyXResource");
        PropertyXResource PR = null;
        PropertyXResourceDAO instance = new PropertyXResourceDAOImpl();
        instance.addPropertyXResource(PR);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResourceByPropertyId method, of class PropertyXResourceDAO.
     */
    @Test
    public void testGetResourceByPropertyId() {
        System.out.println("getResourceByPropertyId");
        int id = 0;
        PropertyXResourceDAO instance = new PropertyXResourceDAOImpl();
        PropertyXResource expResult = null;
        PropertyXResource result = instance.getResourceByPropertyId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePropertyXResource method, of class PropertyXResourceDAO.
     */
    @Test
    public void testDeletePropertyXResource() {
        System.out.println("deletePropertyXResource");
        int id = 0;
        PropertyXResourceDAO instance = new PropertyXResourceDAOImpl();
        instance.deletePropertyXResource(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class PropertyXResourceDAOImpl implements PropertyXResourceDAO {

        public List<PropertyXResource> getAllPropertyXResource() {
            return null;
        }

        public void addPropertyXResource(PropertyXResource PR) {
        }

        public PropertyXResource getResourceByPropertyId(int id) {
            return null;
        }

        public void deletePropertyXResource(int id) {
        }
    }
    
}
