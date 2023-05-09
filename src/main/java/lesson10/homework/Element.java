package lesson10.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Element {
    public String word;
    public List<Integer> positions = new ArrayList<>();

    public Element(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Element element)) return false;
        return Objects.equals(word, element.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }

    @Override
    public String toString() {
        return word + ":" + positions;
    }
}
