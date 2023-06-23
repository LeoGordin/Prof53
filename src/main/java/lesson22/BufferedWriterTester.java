package lesson22;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Scanner;

public class BufferedWriterTester {
    public static void main(String[] args) {
        // с помощью Scanner считывайте строки с консоли пока не считаете строку "stop"
        // считанные строки сохраняйте в файл с названием result.txt

        Scanner scanner = new Scanner(System.in);
        try {
            Writer writer = new FileWriter("test-output.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            String line = scanner.nextLine();
            while (!line.equals("stop")) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                bufferedWriter.flush();
                line = scanner.nextLine();
            }

//            bufferedWriter.write("hello");
//            bufferedWriter.newLine();
//            bufferedWriter.write("it's a good day");
//            bufferedWriter.flush(); // вызывает сброс буферов в поток
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
