package lesson32.crossbow;

public class CrossbowTester {

    public static void main(String[] args) {

        Crossbow crossbow = new Crossbow();

        Thread t1 = new Thread(crossbow::fire);
        Thread t2 = new Thread(crossbow::reload);

        t1.start();
        t2.start();
    }
}
