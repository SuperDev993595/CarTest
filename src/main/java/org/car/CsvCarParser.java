package org.car;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class CsvCarParser implements CarParser {
    @Override
    public List<Car> parse(String filename) throws Exception {
        List<Car> cars = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    // filter line
                    if (line.startsWith("\"")) line = line.substring(1);
                    if (line.endsWith("\"")) line = line.substring(0, line.length() - 1);

                    String[] tokens = line.split(",");
                    if (tokens.length < 2) continue;
                    String brand = tokens[0].trim();
                    LocalDate releaseDate = LocalDate.parse(tokens[1].trim(), formatter);
                    // No model/type/prices in CSV, set as null/default
                    cars.add(new Car(brand, null, null, releaseDate, new HashMap<>()));
                } catch (Exception e) {
                    System.out.println("parsing error : " + e.getMessage());
                }
            }
        }
        return cars;
    }
}
