package lesson2.shape;

public class Triangle extends Figure {

    // стороны
    private int x;
    private int y;
    private int z;

    public Triangle(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    double area() {
        double p = perimeter()/2.0;
        return Math.sqrt(p*(p-x)*(p-y)*(p-z));
    }

    @Override
    double perimeter() {
        return (x+y+z);
    }
}
