package org.test;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class CarFilter {
    public static List<Car> filterByBrandAndPrice(List<Car> cars, String brand, double maxPrice) {
        return cars.stream()
                .filter(car -> car.getBrand().equalsIgnoreCase(brand) && car.getPrice() <= maxPrice)
                .collect(Collectors.toList());
    }

    public static List<Car> filterByBrandAndReleaseDate(List<Car> cars, String brand, LocalDate releaseDate) {
        return cars.stream()
                .filter(car -> car.getBrand().equalsIgnoreCase(brand) && car.getReleaseDate().equals(releaseDate))
                .collect(Collectors.toList());
    }
}

