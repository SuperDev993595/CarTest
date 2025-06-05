package org.formatter;

import org.car.Car;

import java.util.List;

public class JsonFormatter implements OutputFormatter {
    @Override
    public void print(List<Car> cars, String currency) {
        System.out.println("[");
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            String priceStr = (currency != null && car.getPrice(currency) != null) ? String.format("%.2f", car.getPrice(currency)) : "null";
            System.out.printf("  {\"brand\":\"%s\",\"model\":\"%s\",\"type\":\"%s\",\"releaseDate\":\"%s\",\"price_%s\":%s}",
                    car.getBrand() == null ? "" : car.getBrand(),
                    car.getModel() == null ? "" : car.getModel(),
                    car.getType() == null ? "" : car.getType(),
                    car.getReleaseDate() == null ? "" : car.getReleaseDate(),
                    currency == null ? "" : currency,
                    priceStr);
            if (i < cars.size() - 1) System.out.println(",");
            else System.out.println();
        }
        System.out.println("]");
    }
}

