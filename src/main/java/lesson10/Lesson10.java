package lesson10;

import java.util.HashSet;
import java.util.Set;

public class Lesson10 {
    public static void main(String[] args) {
        // Set

        // HashSet - основана на хэш-функции O(1) - недостаток - повышенные требования к памяти
        // порядок обхода элементов не гарантируется

        // LinkedHashSet - все то-же что и в HashSet но гарантируется порядок обхода
        // элементы достаются в порядке вставки

        // TreeSet - обеспечивает хранение и обход элементов в порядке сортровки

        // HashSet
        // при использовании кастомных классов с хэшированными контейнерами
        // мы должны подставить в класс свою реализацию функций equals и hashCode
        // 0. мы обязаны переопределить equals(...) и hashCode()
        // 1. на протяжении жизни объекта его hashCode() не должна меняться
        // 2. если объекты эквиваленты, то их hashCode() должны совпадать

        Set<Point> points = new HashSet<>();
        Point p1 = new Point(10, 20);
        points.add(p1);
        System.out.println(points.size()); // 1
        points.add(p1);
        System.out.println(points.size()); // 1
        Point p2 = new Point(10, 20);
        points.add(p2);
        System.out.println(points.size()); // 2
        System.out.println(
                p1.equals(p2)
        );

        System.out.println("===GoodPoint===");
        GoodPoint gp1 = new GoodPoint(10, 20);
        GoodPoint gp2 = new GoodPoint(10, 20);
        Set<GoodPoint> goodPointSet = new HashSet<>();
        goodPointSet.add(gp1);
        goodPointSet.add(gp2);
        System.out.println(goodPointSet.size());

        System.out.println(gp1.hashCode());
        System.out.println(gp2.hashCode());
        System.out.println(gp1.equals(gp2));


        gp2.setX(110);
        System.out.println(goodPointSet.contains(gp2)); // ?

    }
}
