package lesson3.fruits;

public enum Fruits {
    APPLE(52),
    ORANGE(47),
    BANANA(89),
    GRAPES(67),
    KIWI(61);

    private int calories;

    Fruits(int calories) {
        this.calories = calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getCalories() {
        return calories;
    }

    public static void main(String[] args) {
        Fruits a = APPLE;
        a.setCalories(1);
        System.out.println(a.getCalories());
    }
}
