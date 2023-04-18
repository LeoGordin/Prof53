package lesson1.geometry;

public class Rectangle{
    // добавьте свойства se и nw - юго восточная точка и северозападная
    Point se;
    Point nw;

    public Rectangle(Point se, Point nw) {
        this.se = se;
        this.nw = nw;
    }

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

    double area()
    {
        int sideOne = getSe().getX() - getNw().getY();
        int sideTwo = getNw().getY() - getSe().getY();
        return Math.abs(sideOne * sideTwo);
    }
}