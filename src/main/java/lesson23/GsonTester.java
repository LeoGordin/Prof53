package lesson23;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class GsonTester {
    public static void main(String[] args) {
        Dog d = new Dog("Polkan", 4);
//        write(d, "dog.json.txt");
        read();
    }

    public static void write(Object o, String fileName)
    {
        Gson gson = new Gson();

        try (
                FileWriter fileWriter = new FileWriter(fileName);
        )
        {
            gson.toJson(o, fileWriter);
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }

    public static Dog read() {

        Gson gson = new Gson();
//        gson.fromJson(reader, Dog.class);

        Dog dog = null;
        try (
                FileReader reader = new FileReader("dog.json.txt");
                BufferedReader breader = new BufferedReader(reader);
        ) {
            dog = gson.fromJson(reader, Dog.class);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        return dog;
    }
}
