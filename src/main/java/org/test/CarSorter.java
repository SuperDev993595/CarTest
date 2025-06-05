package org.test;

import java.util.*;
import java.util.stream.Collectors;

public class CarSorter {
    public static List<Car> sortByReleaseYearDesc(List<Car> cars) {
        return cars.stream()
                .sorted(Comparator.comparing(Car::getReleaseDate).reversed())
                .collect(Collectors.toList());
    }

    public static List<Car> sortByPriceDesc(List<Car> cars) {
        return cars.stream()
                .sorted(Comparator.comparing(Car::getPrice).reversed())
                .collect(Collectors.toList());
    }
}

