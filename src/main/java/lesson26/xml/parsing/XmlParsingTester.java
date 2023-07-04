package lesson26.xml.parsing;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class XmlParsingTester {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {

        // parse - извечь полезную информацию

        // SAX - потоковая библиотека - быстрая, не строит дерево документа
        // программирование сводится к переопределению ряда колбэков,
        // выполняющихся при нахождении нового элемента, атрибута, тексового значения и тп
        // низкие требования к памяти

        // DOM - Document Object Model - строит в памяти полное дерево документа
        // сильно упрощает навигацию и поиск в документе
        // может использоваться для изменения документа в памяти
        // требует памяти на хранение и на построение дерева

        // XML
        //      xml schema - проверка структуры документа на соответствие схеме
        //      DOM SAX - парсинг
        //      XPath - возможность послать запрос XML документу как будто это база данных
        //          найти третий элемент с определенным значением атрибута
        //      XSLT - трансформации XML документа
        //      JAXB, SimpleXML - с помощью аннотаций полей класса определить как он будет
        //          сериализоваться и десериализоваться в XML

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // DocumentBuilder используется для парсинга и изменения документа
        DocumentBuilder builder = factory.newDocumentBuilder();
        // Document дерево из элементов в памяти
        Document doc = builder.parse(new File("test.xml"));

        Element root = doc.getDocumentElement(); //CATALOG

        NodeList priceNodeList = root.getElementsByTagName("PRICE");

        for (int i = 0; i < priceNodeList.getLength(); i++) {
            Node priceNode = priceNodeList.item(i); // конкретный элемент PRICE
            System.out.println(
                    priceNode.getFirstChild().getTextContent()
            );
        }

        NodeList plantNodelist = root.getElementsByTagName("PLANT");
        int sum = 0;
        for (int i = 0; i < plantNodelist.getLength(); i++) {
            Element plant = (Element) plantNodelist.item(i);
            sum+= Integer.parseInt(plant.getAttribute("plantid"));
        }
        System.out.println(sum);

    }
}

