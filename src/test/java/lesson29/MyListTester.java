package lesson29;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.inOrder;

public class MyListTester {

    static class ListProcessor {
        static void process(List<String> list) {
            list.size();
            list.add("hello");
            list.clear();
        }
    }

    @Test
    public void testInOrder()
    {
        List<String> mockerList = Mockito.mock(MyList.class);
        ListProcessor.process(mockerList);

        // InOrder позволяет проверить порядок вызова методов мока
        InOrder inOrder = inOrder(mockerList);
        inOrder.verify(mockerList).size();
        inOrder.verify(mockerList).add("hello");
        inOrder.verify(mockerList).clear();
    }
}
