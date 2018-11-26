/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.transferobjects;

import java.sql.Blob;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import transferobjects.PropertyPicture;

import static org.junit.Assert.*;

/**
 *
 * @author Christopher Labelle
 */
public class PropertyPictureTest {
    
	PropertyPicture instance;
	
    public PropertyPictureTest() {
    	instance = new PropertyPicture(1, 1, null);
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
     * Test of setPictureId method, of class PropertyPicture.
     */
    @Test
    public void testSetPictureId() {
        System.out.println("setPictureId");
        int pictureId = 0;
        instance.setPictureId(pictureId);
        assertEquals(pictureId, instance.getPictureID());
    }

    /**
     * Test of setPropertyId method, of class PropertyPicture.
     */
    @Test
    public void testSetPropertyId() {
        System.out.println("setPropertyId");
        int propertyId = 0;
        instance.setPropertyId(propertyId);
        assertEquals(propertyId, instance.getPropertyID());
    }

    /**
     * Test of setPicture method, of class PropertyPicture.
     */
    @Test
    public void testSetPicture() {
        System.out.println("setPicture");
        Blob picture = null;
        instance.setPicture(picture);
        assertEquals(picture, instance.getPicture());
    }
    
}
