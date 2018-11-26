/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.transferobjects;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Christopher Labelle
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({test.transferobjects.PropertyTest.class, test.transferobjects.RenterTest.class, test.transferobjects.HostTest.class, test.transferobjects.PropertyPictureTest.class})
public class TransferobjectsSuite {

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
