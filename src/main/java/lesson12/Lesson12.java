package lesson12;

import lesson3.casino.Dealer;

import java.util.*;

public class Lesson12 {
    public static void main(String[] args) {
        // нужно смоделировать автобус, люди входят через переднюю дверь а
        // выходят через заднюю - Queue

        // emergency room в скорой помощи - PriorityQueue

        // библиотека - ящик для приема прочитанных книг - Stack


        Set<String> s1 = new HashSet<>(Arrays.asList("One", "Two", "Three"));
        Set<String> s2 = new HashSet<>(Arrays.asList("One", "Two", "Three"));
        Set<String> s3 = new HashSet<>(Arrays.asList("Four", "Two", "Three"));

        System.out.println(setsCompare(s1, s2)); // true
        System.out.println(setsCompare(s1, s3)); // false
        System.out.println(setsCompare(s1, null)); // false
        System.out.println(setsCompare(null, null)); // false


        // напишите функцию которая удалит из Set<Integer> все отрицательные элементы
        Set<Integer> numbers = new HashSet<>(Arrays.asList(1,-2, 3, -5, 8, 10, -12));
        System.out.println("before: " + numbers);
        removeNegative(numbers);
        System.out.println("after: " + numbers);


        // напишите функцию которая тестирует строку на предмет того
        // является ли она палиндромом
        // алла
        // а роза упала на лапу азора
        // aла
        System.out.println(checkPalindrome("алла")); // true
        System.out.println(checkPalindrome("а роза упала на лапу азора")); // true
        System.out.println(checkPalindrome("разговор")); // false



        // напишите функцию которая принимает на вход список из целых чисел и
        // еще целое число
        // функция должна возвратить true если среди целых в списке есть пара
        // произведение которой даёт указанное число
        // [1 2 5 12 4 7], 60 -> true
        // [1 2 4 5 7 12 100], 60 -> true
        List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 5, 12, 4, 7));
        System.out.println(checkProduct(nums, 60)); // true
        System.out.println(checkProduct(nums, 3)); // false


        // reverse-polish calculator * / + -
        // (3 + 4 - 2 ) *6 = 30
        // 3 4 + 2 - 6 * = 30
        //     7 2 - 6 * = 30
        //         5 6 * = 30

        System.out.println(reversePolishCalculator("3 4 + 2 - 6 *")); // 30


        // очередь
        // [10, 20, 30, 40, 50, 60, 70], 5 ->
        // [50, 40, 30, 20, 10, 60, 70]


        // [60, 70] очередь
        // [50, 40, 30, 20, 10] стэк

        // [60 70 50 40 30 20 10] очередь
        // https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html

        Queue<Integer> q = new LinkedList<>(Arrays.asList(10, 20, 30, 40, 50, 60, 70));
        System.out.println("queue before: " + q);
        partiallyReverseQueue(q, 5);
        System.out.println("queue after: " + q);

        // напишите функцию которая ищет в списке самую длинную последовательность четных чисел
        // [1,2,5,6,8,7,4] -> [6,8]
        System.out.println(longestEvenSequence(Arrays.asList(1,2,5,6,8,7,4))); // 6 8


        System.out.println(longestEvenSequence(Arrays.asList(1,2,5,6,8,7,4, 12, 2, 8))); // 4 12 2 8
    }

    public static List<Integer> longestEvenSequence(List<Integer> l)
    {
        // наидлиннейшая последовательность четных найденная ранее
        List<Integer> result = new ArrayList<>();

        // текущая последовательность четных
        List<Integer> r = new ArrayList<>();

        for(Integer i : l)
        {
            // проверим на четность
            if(i % 2 == 0)
            {
                r.add(i); // добавим к текущей последовательности
            }
            else {
                // если длина текущей последовательности больше найденной ранее
                if(r.size() > result.size())
                { // копируем данные из текущей в результат
                    result.clear();
                    result.addAll(r);
                }
                r.clear();
            }
        }
        if(r.size() > result.size())
            return r;
        return result;
    }


    public static void partiallyReverseQueue(Queue<Integer> q, int number)
    {
        Stack<Integer> s = new Stack<>();
        int queueSize = q.size();
        for(int i = 0; i < number; i++)
            s.push(q.poll());
        for(int i = 0; i < number; i++)
            q.add(s.pop());
        for(int i = 0; i < queueSize - number; i++)
            q.add(q.poll());
    }

    public static int reversePolishCalculator(String s)
    {
        int res = 0;
        Queue<String> t = new LinkedList<>(Arrays.asList(s.split(" ")));
        int op1 = 0;
        if(t.size() > 0)
            op1 = Integer.parseInt(t.poll());
        while (t.size() >= 2)
        {
            int op2 = Integer.parseInt(t.poll());
            String operation = t.poll();
            if(operation.equals("*"))
                res = op1 * op2;
            else if (operation.equals("/"))
                res = op1 / op2;
            else if (operation.equals("+"))
                res = op1 + op2;
            else
                res = op1 - op2;
            op1 = res;
        }
        return res;
    }


    // перерыв до 20:40
    public static boolean checkProduct(List<Integer> ints, int value)
    {
        Collections.sort(ints);

        Deque<Integer> i = new LinkedList<>(ints);
        int f = i.removeFirst();
        int l = i.removeLast();
        while (i.size() > 0)
        {
            int s = f*l;
            if(s == value)
                return true;
            if(s < value)
                f = i.removeFirst();
            else
                l = i.removeLast();
        }
        return false;
    }

    public static boolean checkPalindrome(String s)
    {
        s = s.replaceAll(" ", "");
        Deque<Character> chars = new LinkedList<>();

        for(int i = 0; i < s.length(); i++)
        {
            chars.add(s.charAt(i));
        }

        while (chars.size() > 1) {
            Character f = chars.removeFirst(); // возвращает первый элемент и удаляет его
            Character l =  chars.removeLast(); // возвращает последний элемент и удаляет его
            if (!f.equals(l))
                return false;
        }
        return true;
    }

    public static void removeNegative(Set<Integer> s)
    {
        if(s == null)
            return;
        Iterator<Integer> numbersIterator = s.iterator();
        while (numbersIterator.hasNext())
        {
            int i = numbersIterator.next();
            if(i < 0)
                numbersIterator.remove();
        }
    }


    // напишите функцию для сравнения двух сетов - что элементы совпадают
    public static boolean setsCompare(Set<String> s1, Set<String> s2)
    {
        if (s1 == null || s2 == null)
            return false;
        if(s1.size() != s2.size())
            return false;
        // 1. перебор элементов из одного и проверка что этот элемент присутствует во втором
//        for(String s: s1)
//            if(!s2.contains(s))
//                return false;
//
//        return true;

        // 2. вычесть один set из другого
        Set<String> temp = new HashSet<>(s1);
        temp.removeAll(s2);

        return temp.size() == 0;
    }

}
