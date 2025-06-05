package org.test;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class CsvCarParser implements CarParser {
    @Override
    public List<Car> parse(String filename) throws Exception {
        List<Car> cars = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine(); // header
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                if (tokens.length < 5) continue;
                String brand = tokens[0].trim();
                double price = Double.parseDouble(tokens[1].trim());
                LocalDate date = LocalDate.parse(tokens[2].trim());
                String type = tokens[3].trim();
                String currency = tokens[4].trim();
                cars.add(new Car(brand, price, date, type, currency));
            }
        }
        return cars;
    }
}
