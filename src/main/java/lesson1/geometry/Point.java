package lesson1.geometry;

public class Point {
    // добавьте точки x и y в виде свойств
    private int x;
    private int y;
    // конструктор

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // геттеры и сеттеры

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
