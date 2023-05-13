package lesson4.animals;

import java.util.Objects;

public abstract class Animal {
    private final String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void greets();

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal animal)) return false;
        return Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
