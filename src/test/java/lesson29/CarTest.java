package lesson29;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class CarTest {
    @Test
    public void propertyTest() {
        Car car = new Car("407", "Peugeot", 14_000);
        assertThat(car, instanceOf(Car.class));
        assertThat(car, hasProperty("price"));
        assertThat(car, hasProperty("model", equalTo("407")));
    }

    @Test
    public void testCars() {
        List<Car> cars = Arrays.asList(
                new Car("407", "Peugeot", 14_000),
                new Car("Celica", "Toyota", 24_000));
        assertThat(cars, hasSize(2));
        assertThat(cars, everyItem(hasProperty("price", greaterThan(10_000.0))));
    }
}
