package lesson1;

import lesson1.japanese.JapaneseEmployee;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JapaneseSalaryTest {
    @Test
    public void testSalary()
    {
        JapaneseEmployee e = new JapaneseEmployee("Yukio", "Misima",
                50_000, 10);

        assertEquals(
                "Тестируем зарплату",
                50_000 + 10*10_000,
                e.calculateSalary()
        );
    }

    @Test
    public void testIntroduction()
    {
        JapaneseEmployee e1 = new JapaneseEmployee("Yukio", "Misima",
                50_000, 15);

        JapaneseEmployee e2 = new JapaneseEmployee("Takeshi", "Kitano",
                50_000, 5);

        assertEquals("Добрый день Yukio Misima", e1.hello());
        assertEquals("Привет Takeshi", e2.hello());
    }
}
