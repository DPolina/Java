package com.mycompany.unittesting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SimpleCalculatorTest {

    @Test
    public void twoPlusTwoShouldEqualFour() {
        var calculator = new SimpleCalculator();
        assertEquals(4, calculator.add(2,2));
    }
    
}
