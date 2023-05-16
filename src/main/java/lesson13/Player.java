package lesson13;

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
        return Integer.compare(getAge(), o.getAge());
    }
}
