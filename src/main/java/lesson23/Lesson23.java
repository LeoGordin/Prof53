package lesson23;

import java.io.BufferedReader;
import java.io.FileReader;

public class Lesson23 {
    public static void main(String[] args) {
        // считать и просуммировать все числа из файлика digits.txt
        // try-with-resource
        try (
                // инициализация потоков ввода-вывода в
                // try-with-resource блоке
                // автоматически приводит к выполнению для них
                // метода close() при любом варианте развития событий -
                // try, catch ...
                FileReader fileReader = new FileReader("digits.txt");
                BufferedReader bufferedReader = new BufferedReader(fileReader);
        )
        {
            System.out.println(
                    bufferedReader.lines()
                            .map(Integer::parseInt)
                            .reduce(0, Integer::sum)
            );
            // важно закрывать потоки ввода-вывода, так это
            // ресурс который выделяется процессу операционной системой
            // и количество возможных одновременно открытых потоков
            // ввода-вывода ограничено
            // bufferedReader.close(); // закрываем поток ввода-вывода после использования
            // fileReader.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        finally {
            // блок выполняется в любом случае -
            // и после try блока
            // и после catch блока
        }
    }
}
