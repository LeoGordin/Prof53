package lesson24;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Dir {
    public static void main(String[] args) throws IOException {
        File file = new File(".");
        String absolutePath = file.getAbsolutePath();
        printDirectory(0, absolutePath);

    }

    public static void printDirectory(int level, String path) throws IOException {
        File file = new File(path);
        File [] files = file.listFiles(); // All files in current dir
        if (files != null) {
            Arrays.sort(files);
            for (File f : files) {
                System.out.print(!f.isDirectory() ? "-" : "d");

                System.out.print(f.canRead() ? "r" : "-");
                System.out.print(f.canWrite() ? "w" : "-");
                System.out.print(f.canExecute() ? "x" : "-");



                Path p = Paths.get(f.getAbsolutePath());
                FileOwnerAttributeView foav = Files.getFileAttributeView(
                        p,
                        FileOwnerAttributeView.class
                );

                System.out.printf("\t%8d\t%12s", f.length(), foav.getOwner().getName());


                IntStream.rangeClosed(0, level).forEach(
                        i -> System.out.print("\t")
                );
                System.out.println(f.getName());
                if(f.isDirectory())
                    printDirectory(level + 1, f.getAbsolutePath());



                System.out.printf("\t%8d\t%12d", f.length(), foav.getOwner().getName());



                IntStream.rangeClosed(0, level).forEach(
                        i -> System.out.println("\t")
                );
                System.out.println(f.getName());
                if (f.isDirectory()) {
                    printDirectory(level + 1, f.getAbsolutePath());
                }
            }
        }
    }
}
