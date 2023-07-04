package lesson24;

import java.io.BufferedReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.stream.Collectors;

public class StringReaders {
    public static void main(String[] args) {
        String data = "hello\n" +
                "i love you\n" +
                "don't you tell me your name?";
        System.out.println(data);

        StringReader sr = new StringReader(data);
        BufferedReader br = new BufferedReader(sr);
        System.out.println(br.lines()
                .map(String::toUpperCase).collect(Collectors.toSet())
        );

        StringWriter sw = new StringWriter();
        sw.append("hello\n");
        sw.append("it's a new line \n");
        sw.flush();
        System.out.println(sw.toString());
    }
}
