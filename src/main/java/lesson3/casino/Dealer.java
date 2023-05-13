package lesson3.casino;

import java.util.Random;

public class Dealer {
    private final Random random = new Random();
    public Card getCard()
    {
        int suite = random.nextInt(4); //случайное число от 0 до 3
        int rank = random.nextInt(13); //случайное число от 0 до 12
        return new Card(
                Rank.values()[rank],
                Suite.values()[suite]
        );
    }
}
