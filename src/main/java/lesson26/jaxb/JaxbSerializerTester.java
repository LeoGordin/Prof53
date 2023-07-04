package lesson26.jaxb;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class JaxbSerializerTester {
    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Catalog.class);
        Plant p = new Plant();
        p.setAvailability("AVAILABLE");
        p.setBotanical("TROPICAL");
        p.setLight("SHADOW");
        p.setPlantid("999");
        p.setZone("INDUSTRIAL");
        p.setCommon("RARE");

        Catalog c = new Catalog();
        c.setName("private");
        c.setSize("small");
        c.setPlants(new ArrayList<>(Arrays.asList(p)));
        Marshaller marshaller = context.createMarshaller();// сериализатор
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(c, new File("catalog.xml"));
    }
}
