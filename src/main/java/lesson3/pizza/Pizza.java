package lesson3.pizza;

// классы
// крокодил данди
// CrocodileDandy

// свойство или функция
// calculateSalary

// константы
// PI

public class Pizza {
    // private String size;
    private PizzaSize size;
    private int ham;
    private int cheese;
    private int peperoni;
    private int pineapple;

    public Pizza(PizzaSize size, int ham, int cheese, int peperoni, int pineapple) {
        this.size = size;
        this.ham = ham;
        this.cheese = cheese;
        this.peperoni = peperoni;
        this.pineapple = pineapple;
    }

    public int calculatePrice()
    {

        int price = 0;
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
        price += (ham + cheese + peperoni + pineapple) * 2;
        return price;
    }


    public static void main(String[] args) {
        Pizza p1 = new Pizza(PizzaSize.SMALL, 1, 0, 1, 3);
        System.out.println(p1.calculatePrice());
    }
}
