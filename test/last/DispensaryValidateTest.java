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
public class DispensaryValidateTest {
    
    public DispensaryValidateTest() {
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
     * Test of CheckQuantity method, of class DispensaryValidate.
     */
    @Test
    public void testCheckQuantity() throws Exception {
        System.out.println("CheckQuantity");
        DispensaryValidate instance = new DispensaryValidate("Arllera","100","100");
        String expResult = "Correct";
        String result = instance.CheckQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of CheckUnitPrice method, of class DispensaryValidate.
     */
    @Test
    public void testCheckUnitPrice() throws Exception {
        System.out.println("CheckUnitPrice");
        DispensaryValidate instance = new DispensaryValidate("Arllera","100","100");
        String expResult = "Correct";
        String result = instance.CheckUnitPrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of CheckName method, of class DispensaryValidate.
     */
    @Test
    public void testCheckName() throws Exception {
        System.out.println("CheckName");
        DispensaryValidate instance = new DispensaryValidate("Arllera","100","100");
        String expResult = "Correct";
        String result = instance.CheckName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
