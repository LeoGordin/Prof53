package lesson12;

import java.util.*;

// 1 уровень сложности: 1. Напишите функцию которая удалит из списка все числа, встречающиеся там нечетное количество раз
//Пример: [1,2,3,1,4,3,2,3] -> [1,2,1,2]
public class HomeWork {
    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>(Arrays.asList(1,2,3,1,4,3,2,3));
        removeOddNumberOfElements(integerList);
        System.out.println(integerList);

        System.out.println(checkBrackets("{}{}")); // true
        System.out.println(checkBrackets("{()[]}")); // true
        System.out.println(checkBrackets("}{")); // false
        System.out.println(checkBrackets("[[]")); // false
        System.out.println(checkBrackets("{(][)}")); // false

    }
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
            catch (Exception e) {
                return false;
            }
        }
        return chars.size() == 0;
    }

    public static void removeOddNumberOfElements(List<Integer> l) {

        List<Integer> i = new ArrayList<>(l);
        Collections.sort(i);
        int prev = i.get(0);
        int counter = 1;
        for (int j = 1; j < i.size(); j++) {
            int current = i.get(j);
            if (prev == current)
                counter++;
            else {
                if(counter % 2 == 1)
                    l.removeAll(Arrays.asList(prev));
                counter = 1;
            }
            prev = current;
        }
        if (counter % 2 == 1)
            l.removeAll(Arrays.asList(prev));
    }

}
