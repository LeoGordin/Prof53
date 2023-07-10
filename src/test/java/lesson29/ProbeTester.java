package lesson29;

import lesson29.Probe;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProbeTester {

    @Test
    public void allPositive()
    {
        assertTrue(
                "for elements {1,2,3,4} - true",
                Probe.isOnlyPositive(new int[]{1,2,3,4})
        );

        assertFalse(
                "for elements {1,2,3,0} - false",
                Probe.isOnlyPositive(new int[]{1,2,3,0})
        );
    }

    // напишите тест для максимума
    @Test
    public void testMaximum()
    {
        assertEquals(
                "max of {1,2,3,4} == 4",
                4,
                Probe.maxOfArray(new int[]{1,2,3,4})
        );

        assertEquals(
                "max of {} == 0",
                0,
                Probe.maxOfArray(new int[]{})
        );
    }
}
