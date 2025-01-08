package com.mycompany.unittesting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleCalculatorTest {
    
    @Test
    public void TestingAddMethod() {
        assertTrue(SimpleCalculator.add(2,2) == 4); // 2 plus 2 should equal 4 (but 2 times 2 is also 4!)
        assertEquals(10, SimpleCalculator.add(3,7)); // 3 plus 7 should equal 10
    }
    
    @Test
    public void TestingSubtractMethod() {
        assertEquals(7, SimpleCalculator.subtract(10,3)); // 10 minus 3 should equal 7
        assertEquals(1, SimpleCalculator.subtract(99,98)); // 99 minus 98 should equal 1
    }
    
    @Test
    public void TestingMultiplyMethod() {
        int A = 3, B = 7;
        assertEquals(A*B, SimpleCalculator.multiply(A,B)); // 3 times 7 should equal 21
    }
    
    @Test
    public void TestingDivideMethod() {
        int A = 18, B = 3;
        assertEquals(A/B, SimpleCalculator.divide(A,B)); // 18 divided by 3 should equal 6
    }
}
