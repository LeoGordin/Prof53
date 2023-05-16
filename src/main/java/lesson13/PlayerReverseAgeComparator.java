package lesson13;

import java.util.Comparator;

public class PlayerReverseAgeComparator implements Comparator<Player> {
    @Override
    public int compare(Player o1, Player o2) {
        // if o1 > o2 return +
        // if o1 < o2 return -
        // if o1 = o2 return 0
        return Integer.compare(o2.getAge(), o1.getAge());
    }
    public static Comparator<Player> ageComparator = (o1, o2) -> Integer.compare(o1.getAge(), o2.getAge());
}
