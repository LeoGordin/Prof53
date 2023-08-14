package lesson28;

import lesson2.crossword.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ProducerConsumer {
    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<>(Arrays.asList(3.15, 3));
        numberList.add(16);
        addNumber(numberList); // ok так как Number является суперклассом для Integer

        List<Object> objectList = new ArrayList<>();
        addNumber(objectList); // ok так как Object является суперклассом для Integer

        List<Integer> integerList = new ArrayList<>(Arrays.asList(1,2,3));
        printListOfNumbers(integerList);
    }

    // Consumer
    // контракт - не записываем в numberList ничего
    // а только считываем то что там есть как Number
    public static void printListOfNumbers(List<? extends Number>  numberList)
    {
        // numberList.add(1); нарушение контракта
        numberList.forEach(
                n -> System.out.println("number is: " + n)
        );
    }



    // Producer
    // мы обязуемся ничего не пытаться считывать Integer из integerList
    // а обязуемся только записывать в него Integer
    public static void addNumber(List<? super Integer> integerList)
    {
        // Integer i = integerList.get(0); // в списке могут быть Number, Object etc
        integerList.add(
                new Random().nextInt()
        );
    }
}
