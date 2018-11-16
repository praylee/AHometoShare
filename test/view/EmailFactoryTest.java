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
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author chris
 */
public class EmailFactoryTest {
    
    public EmailFactoryTest() {
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
     * Test of sendConfirmationEmail method, of class EmailFactory.
     */
    @Test
    public void testSendConfirmationEmail() {
        System.out.println("sendConfirmationEmail");
        String sendToEmail = "";
        String name = "";
        EmailFactory.sendConfirmationEmail(sendToEmail, name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of sendPasswordResetEmail method, of class EmailFactory.
     */
    @Test
    public void testSendPasswordResetEmail() {
        System.out.println("sendPasswordResetEmail");
        String sendToEmail = "";
        String name = "";
        String newPassword = "";
        EmailFactory.sendPasswordResetEmail(sendToEmail, name, newPassword);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
