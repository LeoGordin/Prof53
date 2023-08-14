package lesson23;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataOutputInputTest {
    public static void main(String[] args) {
        // write();
        read();
    }
    // будет что-то записывать в файл
    public static void write()
    {
        // создадим файл data.bin
        // и последовательно сохраним туда какие-нибудь значения
        try(
                FileOutputStream fos = new FileOutputStream("data.bin");
                DataOutputStream dos = new DataOutputStream(fos);
                )
        {
            dos.writeDouble(3.14);
            dos.writeBoolean(true);
            dos.writeInt(123);
            dos.writeUTF("hello, world!");
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }

    // что-то считывать из файла
    public static void read()
    {
        // считаем сохраненные ранее данные из data.bin
        try (FileInputStream fis = new FileInputStream("data.bin");
                DataInputStream dis = new DataInputStream(fis);) {
            double pi = dis.readDouble();
            boolean t = dis.readBoolean();
            int i = dis.readInt();
            String hello = dis.readUTF();
            System.out.println(pi + " " + t + " " + i + " " + hello);
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }
}
