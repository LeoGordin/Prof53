package lesson1.geometry;

public class RectangleTest {
    public static void main(String[] args) {

    Point pointOne = new Point(2,4);
    Point pointTwo = new Point(5, 6);

    Rectangle rectangle = new Rectangle(pointOne, pointTwo);
        System.out.println(rectangle.area());

    }
}
