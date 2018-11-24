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
import transferobjects.PropertyXResource;

/**
 *
 * @author chris
 */
public class PropertyXResourceLayerTest {
    
    public PropertyXResourceLayerTest() {
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
     * Test of getAllPropertyXResource method, of class PropertyXResourceLayer.
     */
    @Test
    public void testGetAllPropertyXResource() {
        System.out.println("getAllPropertyXResource");
        PropertyXResourceLayer instance = new PropertyXResourceLayer();
        List<PropertyXResource> expResult = null;
        List<PropertyXResource> result = instance.getAllPropertyXResource();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPropertyXResource method, of class PropertyXResourceLayer.
     */
    @Test
    public void testAddPropertyXResource() throws Exception {
        System.out.println("addPropertyXResource");
        PropertyXResource propertyxresource = null;
        PropertyXResourceLayer instance = new PropertyXResourceLayer();
        instance.addPropertyXResource(propertyxresource);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResourceByPropertyId method, of class PropertyXResourceLayer.
     */
    @Test
    public void testGetResourceByPropertyId() {
        System.out.println("getResourceByPropertyId");
        int propertyId = 0;
        PropertyXResourceLayer instance = new PropertyXResourceLayer();
        PropertyXResource expResult = null;
        PropertyXResource result = instance.getResourceByPropertyId(propertyId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePropertyXResource method, of class PropertyXResourceLayer.
     */
    @Test
    public void testDeletePropertyXResource() {
        System.out.println("deletePropertyXResource");
        int propertyId = 0;
        PropertyXResourceLayer instance = new PropertyXResourceLayer();
        instance.deletePropertyXResource(propertyId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
