package lesson13;

import java.util.*;

public class PlayerTester {
    public static void main(String[] args) {
        List<Player> team = new ArrayList<>(
                Arrays.asList(
                        new Player(14, "Sam", 24),
                        new Player(16, "Alex", 27),
                        new Player(10, "John", 34),
                        new Player(27, "Sam", 19),
                        new Player(12, "Michael", 37)
                )
        );
        System.out.println(team);
        Collections.sort(team);
        System.out.println(team);

        Comparator<Player> reverseAge = new PlayerReverseAgeComparator();
        Collections.sort(team, reverseAge);
        System.out.println(team);

        Comparator<Player> namesComparator = new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        Collections.sort(team, namesComparator);
        System.out.println(team);

        // Interface consisting one method is called "functional interface" and can be replaced with lambda expression

        Comparator<Player> reverseNameComparator = (o1, o2) -> o2.getName().compareTo(o1.getName());

        Collections.sort(
                team,
                namesComparator.thenComparing(reverseAge.reversed()));
        System.out.println(team);


    }

}
