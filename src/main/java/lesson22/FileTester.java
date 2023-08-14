package lesson22;

import java.io.File;
import java.util.Arrays;

public class FileTester {
    public static void main(String[] args) {
        File testFile = new File("test.bin");
        System.out.println(testFile.exists());

        File matchesFile = new File("matches.txt");
        System.out.println("exists: " + matchesFile.exists());

        // распечатайте длину этого файла
        System.out.println("length: " + matchesFile.length());

        File currentDir = new File(".");
        System.out.println("is directory " + currentDir.isDirectory());

        String [] files =  currentDir.list();
        // модифицируйте чтобы для директории распечатывалось "dir src"
        Arrays.stream(files)
                .forEach(
                        f -> {
                            File d = new File(f);
                            if(d.isFile())
                                System.out.print("file ");
                            else
                                System.out.print("dir ");
                            System.out.println(f);
                        }
                );



    }
}
