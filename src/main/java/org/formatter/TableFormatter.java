package org.formatter;

import org.car.Car;

import java.util.List;

public class TableFormatter implements OutputFormatter {
    @Override
    public void print(List<Car> cars, String currency) {
        System.out.printf("%-10s %-10s %-10s %-12s %-10s\n", "Brand", "Model", "Type", "ReleaseDate", "Price (" + (currency != null ? currency : "") + ")");
        for (Car car : cars) {
            String priceStr = (currency != null && car.getPrice(currency) != null) ? String.format("%.2f", car.getPrice(currency)) : "-";
            System.out.printf("%-10s %-10s %-10s %-12s %-10s\n",
                    car.getBrand() == null ? "-" : car.getBrand(),
                    car.getModel() == null ? "-" : car.getModel(),
                    car.getType() == null ? "-" : car.getType(),
                    car.getReleaseDate() == null ? "-" : car.getReleaseDate(),
                    priceStr);
        }
    }
}


