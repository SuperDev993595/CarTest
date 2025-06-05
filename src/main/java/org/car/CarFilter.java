package org.car;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class CarFilter {
    // For CSV: filter by brand and release date
    public static List<Car> filterByBrandAndReleaseDate(List<Car> cars, String brand, LocalDate releaseDate) {
        return cars.stream()
                .filter(car -> brand == null || (car.getBrand() != null && car.getBrand().equalsIgnoreCase(brand)))
                .filter(car -> releaseDate == null || (car.getReleaseDate() != null && car.getReleaseDate().equals(releaseDate)))
                .collect(Collectors.toList());
    }

    // For XML: filter by model and price in a given currency
    public static List<Car> filterByModelAndPrice(List<Car> cars, String model, String currency, double maxPrice) {
        return cars.stream()
                .filter(car -> model == null || (car.getModel() != null && car.getModel().equalsIgnoreCase(model)))
                .filter(car -> car.getPrice(currency) != null && car.getPrice(currency) <= maxPrice)
                .collect(Collectors.toList());
    }
}


