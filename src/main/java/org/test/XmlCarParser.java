package org.test;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class XmlCarParser implements CarParser {
    @Override
    public List<Car> parse(String filename) throws Exception {
        List<Car> cars = new ArrayList<>();
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(new File(filename));
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("car");
        for (int i = 0; i < nList.getLength(); i++) {
            Element e = (Element) nList.item(i);
            String brand = e.getElementsByTagName("brand").item(0).getTextContent();
            double price = Double.parseDouble(e.getElementsByTagName("price").item(0).getTextContent());
            LocalDate date = LocalDate.parse(e.getElementsByTagName("releaseDate").item(0).getTextContent());
            String type = e.getElementsByTagName("type").item(0).getTextContent();
            String currency = e.getElementsByTagName("currency").item(0).getTextContent();
            cars.add(new Car(brand, price, date, type, currency));
        }
        return cars;
    }
}
