package lesson1.geometry;

public class Rectangle {
    // добавьте свойства se и nw - юго восточная точка и северозападная
    private Point se;
    private Point nw;
    // добавьте конструктор

    public Rectangle(Point se, Point nw) {
        this.se = se;
        this.nw = nw;
    }

    // геттеры и сеттеры


    public Point getSe() {
        return se;
    }

    public void setSe(Point se) {
        this.se = se;
    }

    public Point getNw() {
        return nw;
    }

    public void setNw(Point nw) {
        this.nw = nw;
    }

    int area()
    {
        int sizeX = se.getX() - nw.getX();
        int sizeY = se.getY() - nw.getY();
        return Math.abs(sizeY*sizeX);
    }
}
