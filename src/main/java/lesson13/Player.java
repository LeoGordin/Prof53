package lesson13;

import java.util.Comparator;

public class Player implements Comparable<Player> {
    private int rank;
    private String name;
    private int age;

    public Player(int rank, String name, int age) {
        this.rank = rank;
        this.name = name;
        this.age = age;
    }

    public int getRank() {
        return rank;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Player{" +
                "rank=" + rank +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Player o) {
        // напишите сравнение по возрасту
        // если this < o нужно возвратить что-то отрицательное
        // если this == o нужно возвратить 0
        // если this > o нужно возвратить что-то положительное
        // return (getAge() - o.getAge()); // -2млрд - 2млрд
        return Integer.compare(getAge(), o.getAge());
    }

    public static Comparator<Player> ageComparator = (o1, o2) -> Integer.compare(o1.getAge(), o2.getAge());
    // Player.ageComparator

}
