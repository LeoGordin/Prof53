package lesson11;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTester {
    public static void main(String[] args) {


        // Queue - интерфейс
        // позволяет доавлять элементы в конец и получать их из начала

        Queue<String> bankingQueue = new LinkedList<>();

        bankingQueue.offer("Max Kotkov");
        bankingQueue.offer("Sveta Petrova");
        bankingQueue.offer("Semen Deznev");
        String element = null;
        while ((element = bankingQueue.poll()) != null){
            System.out.println("Element " + element);
        }

        //PriorityQueue
        //Прииоритет определяется на основе Компаратора
        Queue<String> priorityCustomers = new PriorityQueue<>();
        priorityCustomers.add("One");
        priorityCustomers.add("Two");
        priorityCustomers.add("Three");
        priorityCustomers.add("Four");
        priorityCustomers.add("Five");
        priorityCustomers.add("Six");

        while (!priorityCustomers.isEmpty()) {
            String e = priorityCustomers.poll();
            System.out.println("Priority ");
        }


    }

}
