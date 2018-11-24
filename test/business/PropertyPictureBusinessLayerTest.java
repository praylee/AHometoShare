/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.InputStream;
import java.sql.Blob;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import transferobjects.PropertyPicture;

/**
 *
 * @author chris
 */
public class PropertyPictureBusinessLayerTest {
    
    public PropertyPictureBusinessLayerTest() {
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
     * Test of getAllPictures method, of class PropertyPictureBusinessLayer.
     */
    @Test
    public void testGetAllPictures() {
        System.out.println("getAllPictures");
        PropertyPictureBusinessLayer instance = new PropertyPictureBusinessLayer();
        List<PropertyPicture> expResult = null;
        List<PropertyPicture> result = instance.getAllPictures();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPicture method, of class PropertyPictureBusinessLayer.
     */
    @Test
    public void testAddPicture() throws Exception {
        System.out.println("addPicture");
        PropertyPicture propertypicture = null;
        InputStream blob = null;
        PropertyPictureBusinessLayer instance = new PropertyPictureBusinessLayer();
        instance.addPicture(propertypicture, blob);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPictureById method, of class PropertyPictureBusinessLayer.
     */
    @Test
    public void testGetPictureById() {
        System.out.println("getPictureById");
        int pictureId = 0;
        PropertyPictureBusinessLayer instance = new PropertyPictureBusinessLayer();
        PropertyPicture expResult = null;
        PropertyPicture result = instance.getPictureById(pictureId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePicture method, of class PropertyPictureBusinessLayer.
     */
    @Test
    public void testDeletePicture() {
        System.out.println("deletePicture");
        int pictureId = 0;
        PropertyPictureBusinessLayer instance = new PropertyPictureBusinessLayer();
        instance.deletePicture(pictureId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstPictureByProperty method, of class PropertyPictureBusinessLayer.
     */
    @Test
    public void testGetFirstPictureByProperty() {
        System.out.println("getFirstPictureByProperty");
        int propertyId = 0;
        PropertyPictureBusinessLayer instance = new PropertyPictureBusinessLayer();
        Blob expResult = null;
        Blob result = instance.getFirstPictureByProperty(propertyId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
