package org.formatter;

import org.car.Car;

import java.util.List;

public interface OutputFormatter {
    void print(List<Car> cars, String currency);
}

