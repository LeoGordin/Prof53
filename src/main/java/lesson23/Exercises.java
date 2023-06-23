package lesson23;

import java.io.BufferedReader;
import java.io.FileReader;

public class Exercises {
    public static void main(String[] args) {
        try (
                FileReader fileReader = new FileReader("testfile.txt");
                BufferedReader br = new BufferedReader(fileReader)
                ){
            

        } catch (Exception e) {
            System.err.println(e);
        }
    }
}
