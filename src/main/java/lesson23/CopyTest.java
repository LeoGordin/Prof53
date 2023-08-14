package lesson23;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class CopyTest {
    public static void main(String[] args) {
        // цель - скопировать любой файл в какой-то другой
        try(
                FileInputStream fis = new FileInputStream("digits.txt");
                FileOutputStream fos = new FileOutputStream("copy-of-digits.txt")
                )
        {
            byte [] buffer = new byte[10]; // буфер куда будем читать данные из файла
            int numberOfBytes = 0;
            while ( (numberOfBytes = fis.read(buffer)) > 0  )
            {
                fos.write(buffer, 0, numberOfBytes);
            }
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}
