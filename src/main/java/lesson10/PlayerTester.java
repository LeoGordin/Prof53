package lesson10;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class PlayerTester {
    public static void main(String[] args) {
        // 1 создайте класс Player с полями int id и String name
        // 2 сгенерируйте конструктор со всеми полями и геттеры
        // 3 сгенерируйте hashCode и equals только для поля id

        // 4 создайте HashSet<Player>
        // 5 добавьте туда трех игроков
            // 11 Mike
            // 12 Misha
            // 11 Galina
        // 6 распечатайте размер HashSet
        Set<Player> players = new HashSet<>();
        players.add( new Player(11, "Mike"));
        players.add( new Player(12, "Misha"));
        players.add( new Player(11, "Galina"));
        System.out.println(players.size());
        System.out.println(players);
        // 7 создать toString и распечатать набор игроков

        // 8 распечатать всех игроков через итератор
        Iterator<Player> playerIterator = players.iterator();
        while (playerIterator.hasNext())
            System.out.println(playerIterator.next());

        // 9 распечатайте всех игроков через for each
        for (Player p : players)
        {
            System.out.println("for each " + p);
        }

        String [] names = {"Masha", "Galina"};
        for(String s : names)
        {
            //
        }

        players.add(new Player(15, "Alexander"));
        players.add(new Player(1, "Natasha"));
        players.add(new Player(25, "Alexander"));

        // 10 удалите всех игроков с именем Alexander
        // распечайте Set чтобы убедиться что они удалились
        // наивный подход вызывает ConcurrentModificationException
//        for (Player p : players)
//        {
//            if(p.getName().equals("Alexander"))
//                players.remove(p);
//        }

        Iterator<Player> toRemove = players.iterator();
        while (toRemove.hasNext())
        {
            Player p = toRemove.next();
            if(p.getName().equals("Alexander"))
                toRemove.remove();
        }
        System.out.println(players);



    }
}
