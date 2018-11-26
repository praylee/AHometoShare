/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.dataaccess;

import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dataaccess.DataSource;

import static org.junit.Assert.*;

/**
 *
 * @author Christopher Labelle
 */
public class DataSourceTest {
    
    public DataSourceTest() {
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
     * Test of createConnection method, of class DataSource.
     */
    @Test
    public void testCreateConnection() {
        System.out.println("createConnection");
        DataSource instance = new DataSource();
        Connection expResult = null;
        Connection result = instance.createConnection();
        assertNotEquals(expResult, result);
    }
    
}
