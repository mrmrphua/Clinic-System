/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package last;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user8
 */
public class StaffValidateTest {
    
    public StaffValidateTest() {
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
     * Test of CheckName method, of class StaffValidate.
     */
    @Test
    public void testCheckName() throws Exception {
        System.out.println("CheckName");
        StaffValidate instance = new StaffValidate( "Ng Hong Yao","920505017177", "273, jalan utama 17", "0175556993","12","yao.9205@gmail.com");
        String expResult = "Correct";
        String result = instance.CheckName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of CheckIC method, of class StaffValidate.
     */
    @Test
    public void testCheckIC() throws Exception {
        System.out.println("CheckIC");
        StaffValidate instance = new StaffValidate( "Ng Hong Yao","920505017177", "273, jalan utama 17", "0175556993","12","yao.9205@gmail.com");
        String expResult = "Correct";
        String result = instance.CheckIC();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of CheckAddress method, of class StaffValidate.
     */
    @Test
    public void testCheckAddress() throws Exception {
        System.out.println("CheckAddress");
        StaffValidate instance = new StaffValidate( "Ng Hong Yao","920505017177", "273, jalan utama 17", "0175556993","12","yao.9205@gmail.com");
        String expResult = "Correct";
        String result = instance.CheckAddress();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of CheckPhone method, of class StaffValidate.
     */
    @Test
    public void testCheckPhone() throws Exception {
        System.out.println("CheckPhone");
        StaffValidate instance = new StaffValidate( "Ng Hong Yao","920505017177", "273, jalan utama 17", "0175556993","12","yao.9205@gmail.com");
        String expResult = "Correct";
        String result = instance.CheckPhone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of CheckAge method, of class StaffValidate.
     */
    @Test
    public void testCheckAge() throws Exception {
        System.out.println("CheckAge");
        StaffValidate instance = new StaffValidate( "Ng Hong Yao","920505017177", "273, jalan utama 17", "0175556993","12","yao.9205@gmail.com");
        String expResult = "Correct";
        String result = instance.CheckAge();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of CheckEmail method, of class StaffValidate.
     */
    @Test
    public void testCheckEmail() throws Exception {
        System.out.println("CheckEmail");
        StaffValidate instance = new StaffValidate( "Ng Hong Yao","920505017177", "273, jalan utama 17", "0175556993","12","yao.9205@gmail.com");
        String expResult = "Correct";
        String result = instance.CheckEmail();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
