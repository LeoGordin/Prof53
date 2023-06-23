package lesson23;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectOutputInputTester {
    public static void main(String[] args) {
    //    write();
        read();
    }
    public static void read()
    {
        try (
                FileInputStream fis = new FileInputStream("dog.bin");
                ObjectInputStream ois = new ObjectInputStream(fis);
                ){
            Object o = ois.readObject();
            if(o instanceof Dog) {

                Dog d = (Dog) o;
            System.out.println(d.name);
        }


    } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
    public static void write()
    {
        Dog dog = new Dog("Sharik", 3);
        try (FileOutputStream fos = new FileOutputStream("dog.bin");
             ObjectOutputStream oos = new ObjectOutputStream(fos);
                ){

            oos.writeObject(dog);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
