package com.example.Tarea;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testAddition() {
        assertEquals(5, Calculator.calculate(2, 3, '+'));
    }

    @Test
    void testSubtraction() {
        assertEquals(4, Calculator.calculate(9, 5, '-'));
    }

    @Test
    void testMultiplication() {
        assertEquals(20, Calculator.calculate(4, 5, '*'));
    }

    @Test
    void testDivision() {
        assertEquals(5, Calculator.calculate(20, 4, '/'));
    }

    @Test
    void testDivisionByZero() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.calculate(10, 0, '/');
        });
        assertTrue(exception.getMessage().contains("No se puede dividir por cero"));
    }

    @Test
    void testInvalidOperator() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Calculator.calculate(10, 5, '%');
        });
        assertTrue(exception.getMessage().contains("Operador no válido"));
    }
}