package lesson13;

import java.util.Comparator;

public class PlayerReverseAgeComparator implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        // если o1 > o2 нужно вернуть что-то положительное
        // если o1 == o2 нужно вернуть 0
        // если o1 < o2 нужно вернуть что-то отрицательное
        // напишите компаратор по убыванию возраста
        return Integer.compare(o2.getAge(), o1.getAge());
    }
}
