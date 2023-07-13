package lesson29;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

import java.util.function.Predicate;

public class LambdaMatcher <T> extends BaseMatcher<T> {
    @Override
    public boolean matches(Object o) {
        return predicate.test((T) o);
    }

    @Override
    public void describeTo(Description description) {
        description.appendText(this.description);
    }

    // описание того, что матчер делает для анализа ошибочного вывода
    private String description;

    public LambdaMatcher(String description, Predicate<T> predicate) {
        this.description = description;
        this.predicate = predicate;
    }

    // лямбда которая и будет выполняться для тестируемого элемента
    private Predicate<T> predicate;
}
