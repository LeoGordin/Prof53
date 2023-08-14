package lesson39.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@HelloAnnotation(name = "Max", value = "Hello")
public class AnnotationTester {
    public static void main(String[] args) throws NoSuchMethodException, ClassNotFoundException {
//        AnnotationTester tester = new AnnotationTester();
//        Class<? extends AnnotationTester> clazz = tester.getClass();

        Class<?> clazz = Class.forName("lesson39.annotation.AnnotationTester");
        // все аннотации
        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation a : annotations)
            System.out.println("type: " + a.annotationType());

        // получить аннотацию определенного класса
        HelloAnnotation helloAnnotation = clazz.getAnnotation(HelloAnnotation.class);
        System.out.println("value: " + helloAnnotation.value() + ", name: " + helloAnnotation.name());

        // получите метод doSomething по названию из clazz
        Method doSomethingMethod = clazz.getMethod("doSomething");
        // получите из метода аннотацию HelloAnnotation.class
        HelloAnnotation methodAnnotation = doSomethingMethod.getAnnotation(HelloAnnotation.class);
        // распечатайте ее name и value
        System.out.println("value: " + methodAnnotation.value() + ", name: " + methodAnnotation.name());

    }

    @HelloAnnotation(name = "do", value = "something")
    public void doSomething()
    {

    }
}
