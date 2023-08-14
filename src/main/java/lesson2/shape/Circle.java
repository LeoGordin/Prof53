package lesson2.shape;

public class Circle extends Figure{
    private double radii;

    public Circle(double radii) {
        this.radii = radii;
    }

    @Override
    double area() {
        return Math.PI * radii * radii;
    }

    @Override
    double perimeter() {
        return 2*Math.PI * radii;
    }
}
