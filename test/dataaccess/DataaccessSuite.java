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
@Suite.SuiteClasses({dataaccess.PropertyXResourceDAOTest.class, dataaccess.ResourceDAOImplTest.class, dataaccess.DataSourceTest.class, dataaccess.PropertyXResourceDAOImplTest.class, dataaccess.RenterDAOImplTest.class, dataaccess.HostDAOImplTest.class, dataaccess.PropertyDAOTest.class, dataaccess.PropertyDAOImplTest.class, dataaccess.RenterDAOTest.class, dataaccess.PropertyPictureDAOTest.class, dataaccess.ResourceDAOTest.class, dataaccess.HostDAOTest.class, dataaccess.PropertyPictureDAOImplTest.class})
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
