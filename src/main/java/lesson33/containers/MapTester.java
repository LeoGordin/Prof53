package lesson33.containers;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MapTester {
    public static void main(String[] args) throws InterruptedException {
        // Map<String, Integer> map = new HashMap<>(); // HashMap в многопоточной среде напрямую использовать нельзя!
        // Map<String, Integer> map = new Hashtable<>(); // недостаток - медленная
        // Map<String, Integer> map = new ConcurrentHashMap<>(); // самая быстрая реализация для многопоточной среды
        Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>()); // обертка над непотокобезопасным контейнером

        List<String> names = new Vector<>(); // потокобезопасная реализация списка

        List<Integer> res = parallelAdd100(map, 100);
        System.out.println(res);
    }

    private static List<Integer> parallelAdd100(Map<String, Integer> map, int times) throws InterruptedException {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < times; i++) {
            map.put("test", 0); // инициализация
            ExecutorService service = Executors.newFixedThreadPool(4);
            for (int j = 0; j < 10; j++) {
                service.submit(
                        () -> {
                            for (int k = 0; k < 10; k++) {
                                map.computeIfPresent(
                                        "test",
                                        (key, value) -> value + 1
                                );
                            }
                        }
                );
            }
            service.shutdown();
            service.awaitTermination(5, TimeUnit.SECONDS);
            result.add(map.get("test"));
        }
        return result;
    }
}
