package lesson6.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HomeWork {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>(Arrays.asList("Dima", "Max", "Alina"));
        reverse(l);
        System.out.println(l);

        List<String> ll = new ArrayList<>(Arrays.asList("Dima", "Sam", "Dima", "Alina"));
        System.out.println(ll);
        removeDuplicates(ll);
        System.out.println(ll);

    }

    public static List<String> reverse(List<String> l){
        for(int i = 0; i < l.size() / 2; i++)
        {
            String temp = l.get(i);
            l.set(i, l.get(l.size() - 1 - i));
            l.set(l.size() - 1 - i, temp);
        }

        return l;
    }

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
}
