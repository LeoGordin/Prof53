package lesson11;

import java.util.*;

public class StackTester {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        List<String> names = new ArrayList<>(
                Arrays.asList("Max", "Lena", "Alex", "Katerina", "Valeria")
        );

        List<String> reversedNames = new ArrayList<>();
        for (String s: names)
            stack.push(s);
        while (!stack.isEmpty()){
            String n = stack.pop();
            reversedNames.add(n);
        }

        //  с помощью стэка реверсируйте список имен в список reversedNames
        // LIFO контейнер - последний пришел, первым вышел Last in, first out
        // T push(T) - добавляет элемент на вершину стэка
        // T pop() - снимает верхний элемент из стэка и возвращает его
        // T peek() - возвращает верхний элемент из стэка, но не удаляет его
        // boolean isEmpty() - есть ли еще элемент на вершине стэка

        for (String n : names)
            stack.push(n);

        while (!stack.empty())
        {
            String n = stack.pop();
            reversedNames.add(n);
        }

        System.out.println(names);
        System.out.println(reversedNames);

    }
}
