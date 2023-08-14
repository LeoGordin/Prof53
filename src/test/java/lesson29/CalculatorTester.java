package lesson29;

import lesson2.crossword.C;
import org.junit.*;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class CalculatorTester {

    @Test
    public void testMultiplication() {
        System.out.println("testMultiplication");
        Calculator calculator = new Calculator();
        assertEquals(
                "Testing multiply of 2 and 3 equals 6",
                6.0,
                calculator.multiply(2.0, 3.0),
                0.001
        );
    }

    @Test
    public void testDivision()
    {
        System.out.println("testDivision");
        Calculator calculator = new Calculator();
        assertEquals(
                "Testing division of 10 and 2 equals 5",
                5.0,
                calculator.divide(10.0, 2.0),
                0.001
        );
    }

    @Before // выполняется перед каждым тестов в классе
    public void init()
    {

        System.out.println("init");
    }

    @After // выполняется после каждого теста
    public void tearDown()
    {
        System.out.println("tearDown");
    }

    @BeforeClass // выполняется однократно в самом начале
    public static void beforeAll()
    {
        System.out.println("beforeAll");
    }

    @AfterClass // выполняется однократно в самом конце
    public static void afterAll()
    {
        System.out.println("afterAll");
    }

    // протестим что деление на 0 вызывает нужное исключение
    // с правильным сообщением

    // специальное поле для перехвата исключений
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void divisionByZeroTest()
    {
        System.out.println("divisionByZeroTest");
        exception.expect(ArithmeticException.class);
        exception.expectMessage("Division by zero");
        Calculator calculator = new Calculator();
        calculator.divide(10, 0);
    }
}
