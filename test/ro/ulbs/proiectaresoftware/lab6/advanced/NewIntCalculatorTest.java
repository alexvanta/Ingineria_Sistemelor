package ro.ulbs.proiectaresoftware.lab6.advanced;
import org.junit.jupiter.api.*;
public class NewIntCalculatorTest {
    private NewIntCalculator calculator;

    @BeforeEach
    public void setUp() {
        calculator = new NewIntCalculator();
    }

    @Test
    public void testAddPositive() {
        calculator.clear();
        calculator.add(10);
        int result = (Integer) calculator.add(5).result();
        Assertions.assertEquals(15, result);
    }

    @Test
    public void testAddNegatives(){
        calculator.clear();
        calculator.add(-10);
        int result = (Integer) calculator.add(-5).result();
        Assertions.assertEquals(-15, result);
    }

    @Test
    public void testSubstractPositives() {
        calculator.clear();
        calculator.add(20);
        int result = (Integer) calculator.subtract(5).result();
        Assertions.assertEquals(15, result);
    }

    @Test
    public void testSubstractNegatives(){
        calculator.clear();
        calculator.add(-10);
        int result = (Integer) calculator.subtract(-5).result();
        Assertions.assertEquals(-5, result);
    }

    @Test
    public void testMultiplyPositives() {
        calculator.clear();
        calculator.add(5);
        int result = (Integer) calculator.multiply(4).result();
        Assertions.assertEquals(20, result);
    }

    @Test
    public void testMultiplyNegatives() {
        calculator.clear();
        calculator.add(-5);
        int result = (Integer) calculator.multiply(-4).result();
        Assertions.assertEquals(20, result);
    }

    @Test
    public void testMultiplyBy0() {
        calculator.clear();
        calculator.add(100);
        int result = (Integer) calculator.multiply(0).result();
        Assertions.assertEquals(0,result);
    }

    @Test
    public void testDividePositives() {
        calculator.clear();
        calculator.add(20);
        int result = (Integer) calculator.divide(4).result();
        Assertions.assertEquals(5, result);
    }

    @Test
    public void testDivideNegatives() {
        calculator.clear();
        calculator.add(-20);
        int result = (Integer) calculator.divide(-4).result();
        Assertions.assertEquals(5, result);
    }

    @Test
    public void testDivideBy0() {
        calculator.clear();
        calculator.add(10);
        Exception exception = Assertions.assertThrows(ArithmeticException.class, () -> {
            calculator.divide(0);
        });
        Assertions.assertNotNull(exception);
    }
}


