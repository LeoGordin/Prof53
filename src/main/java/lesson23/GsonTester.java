package lesson23;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;

public class GsonTester {
    public static void main(String[] args) {
//        Dog d = new Dog("Polkan", 4);
//        write(d, "dog.json.txt");

        Dog d = read("dog.json.txt");
        System.out.println(d.getName());
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

    public static Dog read(String fileName)
    {
        Gson gson = new Gson();
        Dog dog = null;
        try(
                FileReader fileReader = new FileReader(fileName);
                )
        {
            dog = gson.fromJson(fileReader, Dog.class);
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
        return dog;
    }
}
