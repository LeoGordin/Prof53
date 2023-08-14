package lesson28.exception;

import java.io.*;

public class TryWithResourceTester {
    public static void main(String[] args) {
//        FileInputStream fis = new FileInputStream("digits.txt");
//        Reader reader = new InputStreamReader(fis);
//        BufferedReader br = new BufferedReader(reader);
//        FileInputStream fis = null;
//        Reader reader = null;
//        BufferedReader br = null;
        try (
                // try-with-resource позволяет создавать что-то что
                // имплементит AutoClosable и это что-то
                // будет автоматически закрыто при выходе из try-catch
                // они закрываются в порядке обратном объявлению
                        FileInputStream fis = new FileInputStream("digits.txt");
                        Reader reader = new InputStreamReader(fis);
                        BufferedReader br = new BufferedReader(reader);
                ) {
//            fis = new FileInputStream("digits.txt");
//            reader = new InputStreamReader(fis);
//            br = new BufferedReader(reader);
            System.out.println(
                    br.lines().mapToInt(Integer::parseInt).sum()
            );
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
