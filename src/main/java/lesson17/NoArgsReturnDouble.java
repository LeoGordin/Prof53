package lesson17;

@FunctionalInterface // аннотация означает что этот интерфейс функциональный
public interface NoArgsReturnDouble {
    double function(); // SAM - Single Abstract Method
    default String hello() { return "Hello"; }
    static long getTime() { return System.currentTimeMillis(); }

    // void test(); // не может быть двух абстрактных функций в
    // функциональном интерфейсе
}
