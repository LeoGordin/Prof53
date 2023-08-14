package lesson6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HomeWork {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>(Arrays.asList("Dima", "Max", "Alina"));
        System.out.println(l);
        reverse(l);
        System.out.println(l);

        List<String> ll = new ArrayList<>(Arrays.asList("Dima", "Sam", "Dima", "Alina"));
        System.out.println(ll);
        removeDuplicates(ll);
        System.out.println(ll); // Alina, Dima, Sam

    }


    // перерыв до 20:45 по Берлину

    // Напишите функцию, удаляющие дубликаты из передаваемого в нее списка
    public static List<String> removeDuplicates(List<String> l)
    {
        // ["Dima", "Sam", "Dima", "Alina"]
        // [Alina, Dima, Dima, Sam]
        Collections.sort(l); // отсортируем список
        String current = l.get(l.size() - 1);
        for(int i = l.size() - 2; i >= 0; i--)
        {
            if(l.get(i).equals(current))
                l.remove(i);
            else
                current = l.get(i);

        }
        return l;
    }



    // Напишите функцию, меняющую порядок следования элементов
    // передаваемого в нее списка на противоположный
    public static List<String> reverse(List<String> l){
        for(int i = 0; i < l.size() / 2; i++)
        {
            String temp = l.get(i);
            l.set(i, l.get(l.size() - 1 - i));
            l.set(l.size() - 1 - i, temp);
        }

        return l;
    }
}
