/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author chris
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({business.RenterBusinessLayerTest.class, business.PropertyBusinessLayerTest.class, business.ListofValBusinessLayerTest.class, business.PropertyPictureBusinessLayerTest.class, business.PropertyXResourceLayerTest.class, business.ResourceBusinessLayerTest.class, business.HostBusinessLayerTest.class, business.ValidationExceptionTest.class})
public class BusinessSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
