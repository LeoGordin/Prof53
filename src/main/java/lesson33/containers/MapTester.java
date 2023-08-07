package lesson33.containers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MapTester {
    public static void main(String[] args) throws InterruptedException {
        Map<String, Integer> map = new HashMap<>();

        List<Integer> res = parallelAdd100(map, 100);
        System.out.println(res);
    }
    private static List<Integer> parallelAdd100(Map<String, Integer> map, int times) throws InterruptedException {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < times; i++)
        {
            map.put("test", 0); // инициализация
            ExecutorService service = Executors.newFixedThreadPool(4);
            service.shutdown();
            service.awaitTermination(5, TimeUnit.SECONDS);
            result.add(map.get("test"));
        }
        return result;
    }
}
