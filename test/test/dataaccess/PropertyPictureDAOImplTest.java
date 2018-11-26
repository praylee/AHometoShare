/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dataaccess;

//import java.io.InputStream;
import java.sql.Blob;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dataaccess.PropertyPictureDAO;
import dataaccess.PropertyPictureDAOImpl;

import static org.junit.Assert.*;
import transferobjects.PropertyPicture;

/**
 *
 * @author Christopher Labelle
 */
public class PropertyPictureDAOImplTest {
    
	PropertyPictureDAO instance;
	int pictureId;
	int propertyId;
	
    public PropertyPictureDAOImplTest() {
    	instance = new PropertyPictureDAOImpl();
    	List<PropertyPicture> pics = instance.getAllPictures();
    	pictureId = pics.size() > 0 ? pics.size() + 1 : 1;
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
        List<PropertyPicture> expResult = null;
        List<PropertyPicture> result = instance.getAllPictures();
        assertNotEquals(expResult, result);
    }

    /**
     * Test of addPicture method, of class PropertyPictureDAOImpl.
     */
//    @Test
//    public void testAddPicture() {
//        System.out.println("addPicture");
//        PropertyPicture propertypicture = null;
//        InputStream blob = null;
//        instance.addPicture(propertypicture, blob);
//    }

    /**
     * Test of getAllPicturesByProperty method, of class PropertyPictureDAOImpl.
     */
    @Test
    public void testGetAllPicturesByProperty() {
        System.out.println("getAllPicturesByProperty");
        int propertyId = 4;
        List<PropertyPicture> expResult = null;
        List<PropertyPicture> result = instance.getAllPicturesByProperty(propertyId);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of getAllPicturesById method, of class PropertyPictureDAOImpl.
     */
    @Test
    public void testGetAllPicturesById() {
        System.out.println("getAllPicturesById");
        int pictureId = 4;
        List<Blob> expResult = null;
        List<Blob> result = instance.getAllPicturesById(pictureId);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of getFirstPictureByProperty method, of class PropertyPictureDAOImpl.
     */
    @Test
    public void testGetFirstPictureByProperty() {
        System.out.println("getFirstPictureByProperty");
        int propertyId = 12;
        Blob expResult = null;
        Blob result = instance.getFirstPictureByProperty(propertyId);
        assertNotEquals(expResult, result);
    }

    /**
     * Test of deletePicture method, of class PropertyPictureDAOImpl.
     */
    @Test
    public void testDeletePicture() {
        System.out.println("deletePicture");
        int pictureId = 6;
        instance.deletePicture(pictureId);
    }
    
}
