package lesson11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StackTester {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        List<String> names = new ArrayList<>(
                Arrays.asList("Max", "Lena", "Alex", "Katerina", "Valeria")
        );

        List<String> reversedNames = new ArrayList<>();
        //  с помощью стэка реверсируйте список имен в список reversedNames
        // LIFO контейнер - последний пришел, первым вышел Last in, first out
        // T push(T) - добавляет элемент на вершину стэка
        // T pop() - снимает верхний элемент из стэка и возвращает его
        // T peek() - возвращает верхний элемент из стэка, но не удаляет его
        // boolean isEmpty() - есть ли еще элемент на вершине стэка

        for (String n : names)
        {
            stack.push(n);
            System.out.println(stack);
        }


        while (!stack.empty())
        {
            String n = stack.pop();
            reversedNames.add(n);
        }

        System.out.println(names);
        System.out.println(reversedNames);



    }
}
