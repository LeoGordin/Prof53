package lesson29;

public class Car {
    private String model;
    private String maker;
    private double price;

    public Car(String model, String maker, double price) {
        this.model = model;
        this.maker = maker;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public String getMaker() {
        return maker;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", maker='" + maker + '\'' +
                ", price=" + price +
                '}';
    }
}
