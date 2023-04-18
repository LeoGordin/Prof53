package lesson3.pizza;

public class Pizza {

    //private static String size;
    private PizzaSize size;
    private int ham;
    private int cheese;
    private int pepperoni;
    private int pineapple;

    public Pizza(PizzaSize size, int ham, int cheese, int pepperoni, int pineapple) {
        this.size = size;
        this.ham = ham;
        this.cheese = cheese;
        this.pepperoni = pepperoni;
        this.pineapple = pineapple;
    }

    public int calculatePrice()
    {
        int price = 0;
        // SMALL 10
        // MIDDLE 12
        // LARGE 14
        switch (size)
        {
            case SMALL:
                price += 10;
                break;
            case MIDDLE:
                price += 12;
                break;
            case LARGE:
                price += 14;
                break;
        }
        // за каждый дополнительный топпинг по 2
        price += (ham + cheese + pepperoni + pineapple) * 2;
        return price;
    }

    public static void main(String[] args) {
        Pizza p1 = new Pizza(PizzaSize.SMALL, 2,2,1,0);
        System.out.println(p1.calculatePrice());
    }


}
