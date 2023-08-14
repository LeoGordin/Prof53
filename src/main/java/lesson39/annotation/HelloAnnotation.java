package lesson39.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface HelloAnnotation {
    String value(); // параметры аннотации
    String name(); // параметры аннотации
}
