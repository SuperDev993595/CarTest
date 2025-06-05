package org.car;

import java.io.File;
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
            String type = getTagValue(e, "type");
            String model = getTagValue(e, "model");

            // Brand is not present in XML, so use model as brand or set to null.
            String brand = null;

            // Prices
            Map<String, Double> prices = new HashMap<>();
            // Main price
            NodeList priceNodes = e.getElementsByTagName("price");
            for (int j = 0; j < priceNodes.getLength(); j++) {
                Element priceElem = (Element) priceNodes.item(j);
                String currency = priceElem.getAttribute("currency");
                Double priceValue = Double.parseDouble(priceElem.getTextContent());
                prices.put(currency, priceValue);
            }
            // Release date not present, set as null
            cars.add(new Car(brand, model, type, null, prices));
        }
        return cars;
    }

    private String getTagValue(Element e, String tag) {
        NodeList nl = e.getElementsByTagName(tag);
        if (nl.getLength() > 0) {
            return nl.item(0).getTextContent();
        }
        return null;
    }
}

