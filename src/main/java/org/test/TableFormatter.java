package org.test;

import java.util.List;

public class TableFormatter implements OutputFormatter {
    @Override
    public void print(List<Car> cars) {
        System.out.printf("%-10s %-10s %-12s %-10s %-8s\n", "Brand", "Price", "ReleaseDate", "Type", "Currency");
        for (Car car : cars) {
            System.out.printf("%-10s %-10.2f %-12s %-10s %-8s\n",
                    car.getBrand(), car.getPrice(), car.getReleaseDate(), car.getType(), car.getCurrency());
        }
    }
}

