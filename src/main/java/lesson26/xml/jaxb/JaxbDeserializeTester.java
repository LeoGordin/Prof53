package lesson26.xml.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.File;

public class JaxbDeserializeTester {
    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Catalog.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Catalog catalog = (Catalog) unmarshaller.unmarshal(new File("test.xml"));
        System.out.println(catalog);
        System.out.println(
                catalog.getPlants().stream()
                        .map(Plant::getPlantid)
                        .mapToInt(Integer::parseInt)
                        .sum()
        );

    }
}
