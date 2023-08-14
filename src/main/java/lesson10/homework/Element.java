package lesson10.homework;

import java.util.ArrayList;
import java.util.List;

public class Element {
    public String word;
    public List<Integer> positions = new ArrayList<>();

    public Element(String word) {
        this.word = word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Element element = (Element) o;

        return word.equals(element.word);
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }

    @Override
    public String toString() {
        return word + ":" + positions;
    }
}
