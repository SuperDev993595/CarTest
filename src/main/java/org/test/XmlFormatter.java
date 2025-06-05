package org.test;

import java.util.List;

public class XmlFormatter implements OutputFormatter {
    @Override
    public void print(List<Car> cars) {
        System.out.println("<cars>");
        for (Car car : cars) {
            System.out.printf("  <car><brand>%s</brand><price>%.2f</price><releaseDate>%s</releaseDate><type>%s</type><currency>%s</currency></car>\n",
                    car.getBrand(), car.getPrice(), car.getReleaseDate(), car.getType(), car.getCurrency());
        }
        System.out.println("</cars>");
    }
}

