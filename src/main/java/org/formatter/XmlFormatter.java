package org.formatter;

import org.car.Car;

import java.util.List;

public class XmlFormatter implements OutputFormatter {
    @Override
    public void print(List<Car> cars, String currency) {
        System.out.println("<cars>");
        for (Car car : cars) {
            String priceStr = (currency != null && car.getPrice(currency) != null) ? String.format("%.2f", car.getPrice(currency)) : "";
            System.out.printf("  <car><brand>%s</brand><model>%s</model><type>%s</type><releaseDate>%s</releaseDate><price currency=\"%s\">%s</price></car>\n",
                    car.getBrand() == null ? "" : car.getBrand(),
                    car.getModel() == null ? "" : car.getModel(),
                    car.getType() == null ? "" : car.getType(),
                    car.getReleaseDate() == null ? "" : car.getReleaseDate(),
                    currency == null ? "" : currency,
                    priceStr);
        }
        System.out.println("</cars>");
    }
}


