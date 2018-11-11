/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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
@Suite.SuiteClasses({view.HostSessionTest.class, view.ProfileRenterEditViewTest.class, view.RegisterRenterViewTest.class, view.LogoutRedirectTest.class, view.RegisterConfirmViewTest.class, view.RenterProfileSearchTest.class, view.ProfileHostViewTest.class, view.RegisterHostViewTest.class, view.RenterProfileSearchDetailsTest.class, view.RoomPostingViewTest.class, view.SignUpViewTest.class, view.hostAccountViewTest.class, view.RenterSessionTest.class, view.HomeViewTest.class, view.ProfileRenterViewTest.class, view.LogInViewTest.class})
public class ViewSuite {

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
