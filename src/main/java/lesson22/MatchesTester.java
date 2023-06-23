package lesson22;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class MatchesTester {
    Calendar calendar = new GregorianCalendar(2022, 9, 21);

    List<Match> matches = new ArrayList<>();

    public static void main(String[] args) {
        // считать из файла matches.txt все результаты
        // создать на базе них экземпляры класса Match
        // и добавить их в список
        List<Match> matches = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(
                    new FileReader("matches.txt")
            );
            String line = bufferedReader.readLine();
            while (line != null)
            {
                String[] t = line.split(", ");
                Match match = new Match(
                        new GregorianCalendar(
                                Integer.parseInt(t[0]),
                                Integer.parseInt(t[1]),
                                Integer.parseInt(t[2])
                        ),
                        t[3],
                        t[4],
                        t[5],
                        t[7],
                        Integer.parseInt(t[6])
                );
                matches.add(match);
                line = bufferedReader.readLine();
            }
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        System.out.println(matches.size());

    }


}
