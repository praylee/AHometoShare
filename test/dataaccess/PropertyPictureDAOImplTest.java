/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

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
public class PropertyPictureDAOImplTest {
    
    public PropertyPictureDAOImplTest() {
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
     * Test of getAllPictures method, of class PropertyPictureDAOImpl.
     */
    @Test
    public void testGetAllPictures() {
        System.out.println("getAllPictures");
        PropertyPictureDAOImpl instance = new PropertyPictureDAOImpl();
        List<PropertyPicture> expResult = null;
        List<PropertyPicture> result = instance.getAllPictures();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPicture method, of class PropertyPictureDAOImpl.
     */
    @Test
    public void testAddPicture() {
        System.out.println("addPicture");
        PropertyPicture propertypicture = null;
        InputStream blob = null;
        PropertyPictureDAOImpl instance = new PropertyPictureDAOImpl();
        instance.addPicture(propertypicture, blob);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllPicturesByProperty method, of class PropertyPictureDAOImpl.
     */
    @Test
    public void testGetAllPicturesByProperty() {
        System.out.println("getAllPicturesByProperty");
        int propertyId = 0;
        PropertyPictureDAOImpl instance = new PropertyPictureDAOImpl();
        List<PropertyPicture> expResult = null;
        List<PropertyPicture> result = instance.getAllPicturesByProperty(propertyId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAllPicturesById method, of class PropertyPictureDAOImpl.
     */
    @Test
    public void testGetAllPicturesById() {
        System.out.println("getAllPicturesById");
        int pictureId = 0;
        PropertyPictureDAOImpl instance = new PropertyPictureDAOImpl();
        List<Blob> expResult = null;
        List<Blob> result = instance.getAllPicturesById(pictureId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstPictureByProperty method, of class PropertyPictureDAOImpl.
     */
    @Test
    public void testGetFirstPictureByProperty() {
        System.out.println("getFirstPictureByProperty");
        int propertyId = 0;
        PropertyPictureDAOImpl instance = new PropertyPictureDAOImpl();
        Blob expResult = null;
        Blob result = instance.getFirstPictureByProperty(propertyId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePicture method, of class PropertyPictureDAOImpl.
     */
    @Test
    public void testDeletePicture() {
        System.out.println("deletePicture");
        int pictureId = 0;
        PropertyPictureDAOImpl instance = new PropertyPictureDAOImpl();
        instance.deletePicture(pictureId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
