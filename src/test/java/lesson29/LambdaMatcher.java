package lesson29;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

import java.util.function.Predicate;

public class LambdaMatcher <T> extends BaseMatcher<T> {


    // описание того, что матчер делает для анализа ошибочного вывода
    private String description;

    // лямбда которая и будет выполняться для тестируемого элемента
    private Predicate<T> predicate;

    public LambdaMatcher(String description, Predicate<T> predicate) {
        this.description = description;
        this.predicate = predicate;
    }

    public LambdaMatcher(Predicate<T> predicate) {
        this.predicate = predicate;
    }

    // проверка элемента на соответствие предикату
    @Override
    public boolean matches(Object o) {
        return predicate.test((T) o );
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(this.description);
    }
}
