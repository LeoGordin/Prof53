package lesson26.create;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class CreateXml {
    public static void main(String[] args) throws ParserConfigurationException, FileNotFoundException, TransformerException {
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.newDocument();
        /*
            <test hello="123>
                <world id="456"/>
            </test>
        */
        Element root = doc.createElement("test");
        root.setAttribute("hello", "123" );
        doc.appendChild(root);

        Element world = doc.createElement("world");
        world.setAttribute("id", "456");
        root.appendChild(world);

        FileOutputStream fos = new FileOutputStream("result.xml");
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(fos);
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.transform(source, result);
    }
}
