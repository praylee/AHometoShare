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
public class PropertyPictureTest {
    
    public PropertyPictureTest() {
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
     * Test of getPictureID method, of class PropertyPicture.
     */
    @Test
    public void testGetPictureID() {
        System.out.println("getPictureID");
        PropertyPicture instance = new PropertyPicture();
        int expResult = 0;
        int result = instance.getPictureID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPropertyID method, of class PropertyPicture.
     */
    @Test
    public void testGetPropertyID() {
        System.out.println("getPropertyID");
        PropertyPicture instance = new PropertyPicture();
        int expResult = 0;
        int result = instance.getPropertyID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPicture method, of class PropertyPicture.
     */
    @Test
    public void testGetPicture() {
        System.out.println("getPicture");
        PropertyPicture instance = new PropertyPicture();
        String expResult = "";
        String result = instance.getPicture();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPictureId method, of class PropertyPicture.
     */
    @Test
    public void testSetPictureId() {
        System.out.println("setPictureId");
        int pictureId = 0;
        PropertyPicture instance = new PropertyPicture();
        instance.setPictureId(pictureId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPropertyId method, of class PropertyPicture.
     */
    @Test
    public void testSetPropertyId() {
        System.out.println("setPropertyId");
        int propertyId = 0;
        PropertyPicture instance = new PropertyPicture();
        instance.setPropertyId(propertyId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPicture method, of class PropertyPicture.
     */
    @Test
    public void testSetPicture() {
        System.out.println("setPicture");
        String picture = "";
        PropertyPicture instance = new PropertyPicture();
        instance.setPicture(picture);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
