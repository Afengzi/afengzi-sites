package com.afengzi.test;

import org.springframework.util.xml.DomUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: afengzi
 * Date: 15-2-27
 * Time: 下午9:10
 * To change this template use File | Settings | File Templates.
 */
public class XmlParseUtil extends DomUtils {

    private Document document;

    public XmlParseUtil() {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            document = documentBuilder.parse("afengzi-sites-web\\src\\test\\java\\com\\afengzi\\test\\spring-service.xml");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (FileNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (SAXException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    public void parse() {
        NodeList nodeList = document.getElementsByTagName("bean");
        Element element = (Element) nodeList.item(0);
        String beanId = element.getAttribute("id");
        String clazz = element.getAttribute("class");
        List<Element> elements = getChildElements(element);
        for (Element element1 : elements) {
            String name = element1.getAttribute("name");
            String value = element1.getAttribute("value");
            if (element1.hasAttribute("value")) {
                System.out.println("*************value " + value);
            }
        }
    }

    public static void main(String[] args) {
        XmlParseUtil xmlParseUtil = new XmlParseUtil();
        xmlParseUtil.parse();
    }

}
