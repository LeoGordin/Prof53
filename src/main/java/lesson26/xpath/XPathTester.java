package lesson26.xpath;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.File;
import java.io.IOException;

public class XPathTester {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, XPathExpressionException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File("test.xml"));
        Element root = doc.getDocumentElement(); // CATALOG
        // XPath это механизм отправки запросов в XML документ
        XPath xpath = XPathFactory.newInstance().newXPath();
        /*
            /CATALOG
            //LIGHT - все элементы LIGHT
            /CATALOG/PLANT - все элементы PLANT дочерние для CATALOG
            //MOVIE/ACTOR - все элементы ACTOR дочерние для MOVIE в любом месте документа
            //PLANT[@plantid='456']/PRICE
         */
        XPathExpression expression = xpath.compile("//PLANT[@plantid='456']/PRICE");
        NodeList price = (NodeList) expression.evaluate(doc, XPathConstants.NODESET);
        for(int i = 0; i < price.getLength(); i++)
        {
            System.out.println(
                    "price " + price.item(i).getFirstChild().getTextContent()
            );
        }
    }
}
