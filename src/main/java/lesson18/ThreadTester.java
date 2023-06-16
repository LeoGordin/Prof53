package lesson18;

public class ThreadTester {
    public static void main(String[] args) {
// Thread - поток выполнения, "нить" - одновременно выполняющиеся функции
        // класс в яве
        // Runnable интерфейс в яве - работа, которая может быть выполнена в отдельном
        // потоке выполнения
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hello from thread!");
            }
        };

        Thread t = new Thread(r); // создание нового потока на базе работы из Runnable

        t.start(); // / запуск нового потока выполнения
    }
}
