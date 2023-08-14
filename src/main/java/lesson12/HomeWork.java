package lesson12;

import java.util.*;

public class HomeWork {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>(Arrays.asList(
                1,2,3,1,4,3,2,3
        ));
        removeOddNumberOfElements(l);
        System.out.println(l);

        System.out.println(checkBrackets("{}{}")); // true
        System.out.println(checkBrackets("{()[]}")); // true
        System.out.println(checkBrackets("}{")); // false
        System.out.println(checkBrackets("[[]")); // false
        System.out.println(checkBrackets("{(][)}")); // false
    }

    // Напишите функцию, которая проверит в выражении сбалансированность скобок трех видов
    // Примеры:
    // {}{} -> true
    // {()[]} - > true
    // [} -> false
    // [[] -> false
    // {{{]) -> false
    // {(][)} -> false
    // ({)}() -> false
    public static boolean checkBrackets(String w)
    {
        Stack<Character> chars = new Stack<>();
        for(char c : w.toCharArray())
        {
            try {
                // если символ это открывающая скобка {[( то заносим его в стэк
                if (c == '{' || c == '[' || c == '(')
                    chars.push(c);
                    // если символ это } то нужно убедиться что в вершине стэка {
                    // если символ это ] то нужно убедиться что в вершине стэка [
                    // если символ это ) то нужно убедиться что в вершине стэка (
                else if (
                        (c == '}' && chars.peek() == '{') ||
                                (c == ']' && chars.peek() == '[') ||
                                (c == ')' && chars.peek() == '(')
                ) {
                    chars.pop();
                }
            }
            catch (Exception e)
            {return false;}
        }
        return chars.size() == 0;
    }


    // Напишите функцию которая удалит из списка все числа,
    // встречающиеся там нечетное количество раз
    // Пример: [1,2,3,1,4,3,2,3] -> [1,2,1,2]
    public static void removeOddNumberOfElements(List<Integer> l)
    {
        List<Integer> i = new ArrayList<>(l);
        Collections.sort(i); // 1,1,2,2,3,3,3,4
        int prev = i.get(0);
        int counter = 1; // сколько раз встретилось число
        for(int j = 1; j < i.size(); j++)
        {
            int current = i.get(j);
            if(prev == current)
                counter++;
            else {
                if(counter % 2 == 1)
                    l.removeAll(Arrays.asList(prev));
                counter = 1;
            }
            prev = current;
        }
        if(counter % 2 == 1)
            l.removeAll(Arrays.asList(prev));
    }
}
