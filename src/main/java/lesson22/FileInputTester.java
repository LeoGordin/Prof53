package lesson22;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class FileInputTester {
    public static void main(String[] args) {
        try {
            InputStream testFileStream = new FileInputStream("testfile.txt");
            Reader testFileReader = new InputStreamReader(testFileStream);
            int symbol = testFileReader.read();
            while (symbol != -1) {
                System.out.print((char) symbol);
                symbol = testFileReader.read();
            }
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
