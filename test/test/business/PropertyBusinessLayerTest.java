/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.business;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import business.HostBusinessLayer;
import business.PropertyBusinessLayer;
import business.ValidationException;

import static org.junit.Assert.*;

import transferobjects.Host;
import transferobjects.Property;

/**
 *
 * @author melissa
 */
public class PropertyBusinessLayerTest {
	
	int hostID = 10;
    int propID = 10;
    
    PropertyBusinessLayer pInstance = new PropertyBusinessLayer();
    HostBusinessLayer hInstance = new HostBusinessLayer();
    
    public PropertyBusinessLayerTest() {
        
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {       
        pInstance.deleteProperty(propID);
        System.out.println("Deleted property with id: " + propID);
        hInstance.deleteHost(hostID);
        System.out.println("Deleted host with id: " + hostID);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllProperty method, of class PropertyBusinessLayer.
     * @throws ValidationException 
     */
    @Test
    public void testGetAllProperty() throws ValidationException {
        System.out.println("getAllProperty");
        
        String address = "13 Cranberry Court";
        String result = null;

        
        Host host = new Host(hostID, "host1@test.com", "Password1", "Joe", "Host",  "613-254-6898", 1, "1970", false, true, true, "paper");
        hInstance.addHost(host);

        
        Date sd = java.sql.Date.valueOf("2019-01-01");
        Date ed = java.sql.Date.valueOf("2020-01-01");
        
        
        Property property = new Property (propID, hostID, address, "Ottawa", "K2K 2N5", "Ontario", "Canada", 2, true, true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,500,sd,ed,"clean bathroom",1);
        pInstance.addProperty(property);
        
        
        List<Property> list = pInstance.getAllProperty();
        
        for (Property item: list) {
        	if (item.getpropertyID() == propID) {
        		result = item.getAddress();
        	}
        }
        
        assertEquals(address, result);

    }

    /**
     * Test of addProperty method, of class PropertyBusinessLayer.
     * @throws ValidationException 
     */
    @Test
    public void testAddProperty() throws ValidationException {
        System.out.println("addProperty");

        Host host = new Host(hostID, "host1@test.com", "Password1", "Joe", "Host",  "613-254-6898", 1, "1970", false, true, true, "paper");
        hInstance.addHost(host);

        
        Date sd = java.sql.Date.valueOf("2019-01-01");
        Date ed = java.sql.Date.valueOf("2020-01-01");
        
        
        Property property = new Property (propID, hostID, "13 Cranberry Court", "Ottawa", "K2K 2N5", "Ontario", "Canada", 2, true, true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,500,sd,ed,"clean bathroom",1);
        pInstance.addProperty(property);
        
        int result = pInstance.getPropertyById(propID).getpropertyID();
        
        assertEquals(propID, result);
        
    }


    /**
     * Test of getPropertyByHostId method, of class PropertyBusinessLayer.
     * @throws ValidationException 
     */
    @Test
    public void testGetPropertyByHostId() throws ValidationException {
        System.out.println("getPropertyByHostId");
        
        int result = 0;

        Host host = new Host(hostID, "host1@test.com", "Password1", "Joe", "Host",  "613-254-6898", 1, "1970", false, true, true, "paper");
        hInstance.addHost(host);

        
        Date sd = java.sql.Date.valueOf("2019-01-01");
        Date ed = java.sql.Date.valueOf("2020-01-01");
        
        
        Property property = new Property (propID, hostID, "13 Cranberry Court", "Ottawa", "K2K 2N5", "Ontario", "Canada", 2, true, true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,500,sd,ed,"clean bathroom",1);
        pInstance.addProperty(property);
        
        List<Property> list = pInstance.getPropertyByHostId(hostID); 
        
        for (Property item: list) {
        	if (item.getpropertyID() == propID) {
        		result = item.getpropertyID();
        	}
        }
        
        assertEquals(propID, result);
    }

    /**
     * Test of deleteProperty method, of class PropertyBusinessLayer.
     * @throws ValidationException 
     */
    @Test
    public void testDeleteProperty() throws ValidationException {
        System.out.println("deleteProperty");
        
        Host host = new Host(hostID, "host1@test.com", "Password1", "Joe", "Host",  "613-254-6898", 1, "1970", false, true, true, "paper");
        hInstance.addHost(host);

        
        Date sd = java.sql.Date.valueOf("2019-01-01");
        Date ed = java.sql.Date.valueOf("2020-01-01");
        
        
        Property property = new Property (propID, hostID, "13 Cranberry Court", "Ottawa", "K2K 2N5", "Ontario", "Canada", 2, true, true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,500,sd,ed,"clean bathroom",1);
        pInstance.addProperty(property);
        
        pInstance.deleteProperty(propID);
        
        int result = pInstance.getPropertyById(propID).getpropertyID();
        
        assertEquals(0, result);

    }

    /**
     * Test of updateProperty method, of class PropertyBusinessLayer.
     * @throws ValidationException 
     */
    @Test
    public void testUpdateProperty() throws ValidationException {
        System.out.println("updateProperty");
        
        String updatedAddress = "13 Blackberry Court";

        
        Host host = new Host(hostID, "host1@test.com", "Password1", "Joe", "Host",  "613-254-6898", 1, "1970", false, true, true, "paper");
        hInstance.addHost(host);

        
        Date sd = java.sql.Date.valueOf("2019-01-01");
        Date ed = java.sql.Date.valueOf("2020-01-01");
        
        
        Property property = new Property (propID, hostID, "13 Cranberry Court", "Ottawa", "K2K 2N5", "Ontario", "Canada", 2, true, true,true,true,true,true,true,true,true,true,true,true,true,true,true,true,500,sd,ed,"clean bathroom",1);
        pInstance.addProperty(property);
        
        pInstance.updateProperty(hostID, updatedAddress, "Ottawa", "K2K 2N5", "Ontario", "Canada", 2, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, 500, sd, ed, "clean bathroom", 1, propID);
        
        String result = pInstance.getPropertyById(propID).getAddress();
        
        assertEquals(updatedAddress, result);
    }
    
}
