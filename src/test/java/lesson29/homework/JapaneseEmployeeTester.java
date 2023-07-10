package lesson29.homework;
import lesson1.japanese.JapaneseEmployee;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class JapaneseEmployeeTester {

    @Test
    public void testCalculateSalary() {
        JapaneseEmployee mitsuo = new JapaneseEmployee("Mitsuo", "Baso", 120_000, 4);
        JapaneseEmployee akira = new JapaneseEmployee("Akira", "Kurosawa", 100_000, 12);

        double mitsuoSalary = mitsuo.calculateSalary();
        double akiraSalary = akira.calculateSalary();

        assertEquals(160_000, mitsuoSalary, 0.001);
        assertEquals(220_000, akiraSalary, 0.001);
    }

    @Test
    public void testHello() {
        JapaneseEmployee mitsuo = new JapaneseEmployee("Mitsuo", "Baso", 120_000, 4);
        JapaneseEmployee akira = new JapaneseEmployee("Akira", "Kurosawa", 100_000, 12);

        String mitsuoGreeting = mitsuo.hello();
        String akiraGreeting = akira.hello();

        assertEquals("Hello Mitsuo", mitsuoGreeting);
        assertEquals("Good afternoon, Akira Kurosawa", akiraGreeting);
    }
}
