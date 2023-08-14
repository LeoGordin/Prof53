package lesson29;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class HamcrestIntro {
    @Test
    public void testArray()
    {
        String[] words = {"hello", "world", "equator", "sun"};
        assertThat(words, arrayWithSize(4));
        assertThat(words, hasItemInArray("sun"));
    }

    @Test
    public void listTest()
    {
        List<Integer> list = Arrays.asList(5,2,4);
        assertThat(list, hasSize(3));
        assertThat(list, contains(5,2,4)); // все элементы именно в этом порядке
        assertThat(list, containsInAnyOrder(5,4,2));
        assertThat(list, everyItem(greaterThan(1)));
    }

    @Test
    public void stringListTest()
    {
        List<String> strings = Arrays.asList("Hell", "Hello");

        LambdaMatcher<String> lambdaMatcher = new LambdaMatcher<>(
                "",
                s -> s.length() > 3
        );

        assertThat(
                strings,
                everyItem( // каждый элемент
                        allOf( // должен удовлетворять всем матчерам
                                startsWith("H"),
                                containsString("ll"),
                                new LambdaMatcher<>(s-> s.length() > 3)
                        )
                )
        );
    }
}
