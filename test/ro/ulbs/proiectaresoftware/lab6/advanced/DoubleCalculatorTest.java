package ro.ulbs.proiectaresoftware.lab6.advanced;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoubleCalculatorTest {
    private DoubleCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new DoubleCalculator();
    }

    @Test
    public void testAddPositive() {
        calculator.clear();
        calculator.add(10.5);
        double result = (Double) calculator.add(4.5).result();
        Assertions.assertEquals(15.0, result);
    }

    @Test
    public void testAddNegatives() {
        calculator.clear();
        calculator.add(-10.5);
        double result = (Double) calculator.add(-4.5).result();
        Assertions.assertEquals(-15.0, result);
    }

    @Test
    public void testSubtractPositives() {
        calculator.clear();
        calculator.add(20.5);
        double result = (Double) calculator.subtract(5.0).result();
        Assertions.assertEquals(15.5, result);
    }

    @Test
    public void testSubtractNegatives() {
        calculator.clear();
        calculator.add(-10.0);
        double result = (Double) calculator.subtract(-5.0).result();
        Assertions.assertEquals(-5.0, result);
    }

    @Test
    public void testMultiplyPositives() {
        calculator.clear();
        calculator.add(5.0);
        double result = (Double) calculator.multiply(2.5).result();
        Assertions.assertEquals(12.5, result);
    }

    @Test
    public void testMultiplyNegatives() {
        calculator.clear();
        calculator.add(-5.0);
        double result = (Double) calculator.multiply(-2.0).result();
        Assertions.assertEquals(10.0,result);
    }

    @Test
    public void testMultiplyBy0(){
        calculator.clear();
        calculator.add(100.5);
        double result = (Double) calculator.multiply(0.0).result();
        Assertions.assertEquals(0.0, result);
    }

    @Test
    public void testDividePositives() {
        calculator.clear();
        calculator.add(20.0);
        double result = (Double) calculator.divide(4.0).result();
        Assertions.assertEquals(5.0, result);
    }

    @Test
    public void testDivideNegatives() {
        calculator.clear();
        calculator.add(-20.0);
        double result = (Double) calculator.divide(-4.0).result();
        Assertions.assertEquals(5.0, result);
    }

    @Test
    public void testDivideBy0(){
        calculator.clear();
        calculator.add(10.0);
        double result = (Double) calculator.divide(0.0).result();
        Assertions.assertTrue(Double.isInfinite(result));
    }
}
