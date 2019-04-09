/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package light;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ccoughlin
 */
public class GasussionTest {
    
    public GasussionTest() {
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
     * Test of rowReduction method, of class Gasussion.
     */
    @Test
    public void testRowReduction() {
        System.out.println("rowReduction");
        Gasussion instance = null;
        instance.rowReduction();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResult method, of class Gasussion.
     */
    @Test
    public void testGetResult() {
        System.out.println("getResult");
        Gasussion instance = null;
        int[] expResult = null;
        int[] result = instance.getResult();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
