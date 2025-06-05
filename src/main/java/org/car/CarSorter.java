package org.car;

import java.util.*;
import java.util.stream.Collectors;

public class CarSorter {
    // For CSV: sort by release date
    public static List<Car> sortByReleaseDateDesc(List<Car> cars) {
        return cars.stream()
                .sorted(Comparator.comparing(Car::getReleaseDate, Comparator.nullsLast(Comparator.reverseOrder())))
                .collect(Collectors.toList());
    }

    // For XML: sort by price in a given currency
    public static List<Car> sortByPriceDesc(List<Car> cars, String currency) {
        return cars.stream()
                .sorted(Comparator.comparing((Car car) -> car.getPrice(currency), Comparator.nullsLast(Comparator.reverseOrder())))
                .collect(Collectors.toList());
    }
}


