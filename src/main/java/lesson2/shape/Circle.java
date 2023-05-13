package lesson2.shape;

public class Circle extends Figure{
    private final double radius;
    double area() {
        return Math.PI * radius * radius;
    }
    double perimeter() {
        return 2*Math.PI * radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }
}
