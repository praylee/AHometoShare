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
public class PropertyPictureDAOTest {
    
    public PropertyPictureDAOTest() {
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
     * Test of getAllPictures method, of class PropertyPictureDAO.
     */
    @Test
    public void testGetAllPictures() {
        System.out.println("getAllPictures");
        PropertyPictureDAO instance = new PropertyPictureDAOImpl();
        List<PropertyPicture> expResult = null;
        List<PropertyPicture> result = instance.getAllPictures();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addPicture method, of class PropertyPictureDAO.
     */
    @Test
    public void testAddPicture() {
        System.out.println("addPicture");
        PropertyPicture propertypicture = null;
        InputStream blob = null;
        PropertyPictureDAO instance = new PropertyPictureDAOImpl();
        instance.addPicture(propertypicture, blob);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPictureById method, of class PropertyPictureDAO.
     */
    @Test
    public void testGetPictureById() {
        System.out.println("getPictureById");
        int pictureId = 0;
        PropertyPictureDAO instance = new PropertyPictureDAOImpl();
        PropertyPicture expResult = null;
        PropertyPicture result = instance.getPictureById(pictureId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deletePicture method, of class PropertyPictureDAO.
     */
    @Test
    public void testDeletePicture() {
        System.out.println("deletePicture");
        int pictureId = 0;
        PropertyPictureDAO instance = new PropertyPictureDAOImpl();
        instance.deletePicture(pictureId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstPictureByProperty method, of class PropertyPictureDAO.
     */
    @Test
    public void testGetFirstPictureByProperty() {
        System.out.println("getFirstPictureByProperty");
        int propertyId = 0;
        PropertyPictureDAO instance = new PropertyPictureDAOImpl();
        Blob expResult = null;
        Blob result = instance.getFirstPictureByProperty(propertyId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class PropertyPictureDAOImpl implements PropertyPictureDAO {

        public List<PropertyPicture> getAllPictures() {
            return null;
        }

        public void addPicture(PropertyPicture propertypicture, InputStream blob) {
        }

        public PropertyPicture getPictureById(int pictureId) {
            return null;
        }

        public void deletePicture(int pictureId) {
        }

        public Blob getFirstPictureByProperty(int propertyId) {
            return null;
        }
    }
    
}
