package lesson10.homework;

import java.util.LinkedHashSet;
import java.util.Set;

public class Concordance {
    public static void main(String[] args) {
        String sentence = "один раз это один раз";
        System.out.println(concordance(sentence));
    }

    // поиск элемента в списке
    // если не нашли, возвращаем null
    public static Element findElement(Set<Element> elements, Element e)
    {
        for(Element element : elements)
        {
            if(element.equals(e)){
                return element;
            }
        }
        return null;
    }

    public static Set<Element> concordance(String s)
    {
        Set<Element> r = new LinkedHashSet<>();

        String [] words = s.split(" ");
        for(int i = 0; i < words.length; i++)
        {
            String word = words[i];
            Element e = new Element(word);
            Element existingElement = findElement(r, e);
            if(existingElement != null)
                existingElement.positions.add(i);
            else {
                e.positions.add(i);
                r.add(e);
            }
        }

        return r;
    }

}
