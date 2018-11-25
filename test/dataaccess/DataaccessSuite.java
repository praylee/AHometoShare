/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataaccess;

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
@Suite.SuiteClasses({dataaccess.PropertyDAOImplTest.class, dataaccess.RenterDAOImplTest.class, dataaccess.PropertyPictureDAOImplTest.class, dataaccess.HostDAOImplTest.class, dataaccess.PropertyPictureDAOTest.class, dataaccess.RenterDAOTest.class, dataaccess.HostDAOTest.class, dataaccess.PropertyDAOTest.class, dataaccess.DataSourceTest.class})
public class DataaccessSuite {

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
