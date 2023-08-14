package lesson39.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionTester {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Sample sample = new Sample();
        // получаем класс объекта
        Class<? extends Sample> clazz = sample.getClass();
        System.out.println("Class name is: " + clazz.getName());
        Constructor<? extends Sample> constructor = clazz.getConstructor();
        System.out.println("Constructor name is: " + constructor.getName());

        System.out.println("Public methods: ");
        Method [] methods = clazz.getMethods();
        for(Method m : methods)
            System.out.println("Method name: " + m.getName());

        // ссылка на метод jump(int) класса Sample
        Method jumpMethod = clazz.getDeclaredMethod("jump", int.class);

        // выполнение метода класса с нужными параметрами через Reflection API
        jumpMethod.invoke(sample, 25);

        // выполните greeting через механизм Reflection
        // получить ссылку на метод
        Method greetingMethod = clazz.getDeclaredMethod("greeting");
        // и выполнить
        greetingMethod.invoke(sample);

        // меняем приватное поле
        Field nameField = clazz.getDeclaredField("name");
        // делаем поле изменяемым
        nameField.setAccessible(true); // private -> "public"
        // меняем значение поля для экземпляра класса
        nameField.set(sample, "Hello 123");
        // проверяем
        greetingMethod.invoke(sample);

        // ссылка на метод
        Method secretMethod = clazz.getDeclaredMethod("secret");
        // делаем публичным
        secretMethod.setAccessible(true);
        // вызываем
        secretMethod.invoke(sample);

    }
}
