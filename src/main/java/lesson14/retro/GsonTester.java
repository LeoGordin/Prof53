package lesson14.retro;

import com.google.gson.Gson;
import lesson14.Student;

public class GsonTester {
    public static void main(String[] args) {
        Gson gson = new Gson();

        Student max = new Student("Max Kotkov", 5, "A-123");

        String result = gson.toJson(max); // сериализация в json
        System.out.println(result);

        String zina = "{\"name\":\"Zina Pavlova\",\"year\":1,\"group\":\"B-55\"}";

        Student zi = gson.fromJson(zina, Student.class); // десеарилизация из json
        System.out.println(zi.getName());
    }
}
