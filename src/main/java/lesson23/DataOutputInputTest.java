package lesson23;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataOutputInputTest {
    public static void main(String[] args) {
//        write();
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

    public static void read() {
        try (
                FileInputStream fis = new FileInputStream("data.bin");
                DataInputStream dis = new DataInputStream(fis)
                ){
            System.out.println(dis.readDouble());
            System.out.println(dis.readBoolean());
            System.out.println(dis.readInt());
            System.out.println(dis.readUTF());

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
