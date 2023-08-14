package lesson1.geometry;

public class GeometryTester {
    public static void main(String[] args) {
        Point p1 = new Point(10, 5);
        Point p2 = new Point(1, 12);

        Rectangle r = new Rectangle(p1, p2);

        System.out.println(r.area());

    }
}
