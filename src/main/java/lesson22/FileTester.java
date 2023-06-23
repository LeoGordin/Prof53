package lesson22;

import java.io.File;
import java.util.Arrays;

public class FileTester {
    public static void main(String[] args) {
        File testFile = new File("test.bin");
        System.out.println(testFile.exists());
        File matchesFile = new File("matches.txt");
        System.out.println("exists: " + matchesFile.exists());
        System.out.println(matchesFile.length());

        File currentDir = new File(".");
        System.out.println("Is directory: " + currentDir.isDirectory());

        String [] list = currentDir.list();
        Arrays.stream(list).forEach(
                f -> {
                    File d = new File(f);
                    if (d.isFile())
                        System.out.println("file: " + f);
                    else
                        System.out.println("dir: " + f);
                }
        );
    }
}
