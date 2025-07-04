package org.main;

import org.car.*;
import org.formatter.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        if (args.length < 3) {
            System.out.println("Usage for CSV: java -jar app.jar <csvfile> <brand> <MM/dd/yyyy or yyyy-MM-dd or yyyy,dd,MM>");
            System.out.println("Usage for XML: java -jar app.jar <xmlfile> <model> <currency> <maxPrice>");
            System.out.println("Add: <sortType> <outputType>");
            System.out.println("Example: java -jar app.jar cars.csv Toyota 01/15/2023 releaseDate table");
            System.out.println("Example: java -jar app.jar cars.xml RAV4 EUR 24000 price json");
            return;
        }

        String inputFile = args[0];
        String fileType = inputFile.substring(inputFile.lastIndexOf('.') + 1);

        List<Car> cars;
        CarParser parser;
        OutputFormatter formatter;
        List<Car> filtered = new ArrayList<>();
        List<Car> sorted = new ArrayList<>();
        String sortType = "releaseDate";
        String outputType = "table";
        String currency = null;

        try {
            if (fileType.equalsIgnoreCase("csv")) {
                parser = new CsvCarParser();
                cars = parser.parse(inputFile);
                String brand = args[1];
                LocalDate releaseDate = null;
                DateTimeFormatter formatter0 = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy,dd,MM");

                try {
                    releaseDate = LocalDate.parse(args[2], formatter1);
                } catch (Exception e) {
                    try {
                        releaseDate = LocalDate.parse(args[2], formatter2);
                    } catch (Exception e1) {
                        releaseDate = LocalDate.parse(args[2], formatter0);
                    }
                }


                filtered = CarFilter.filterByBrandAndReleaseDate(cars, brand, releaseDate);
                if (args.length > 3) sortType = args[3];
                if (args.length > 4) outputType = args[4];
                // Sorting
                if (sortType.equalsIgnoreCase("releaseDate")) {
                    sorted = CarSorter.sortByReleaseDateDesc(filtered);
                } else {
                    sorted = filtered;
                }
                //currency = null; // CSV has no price/currency info
            } else if (fileType.equalsIgnoreCase("xml")) {
                parser = new XmlCarParser();
                cars = parser.parse(inputFile);
                String model = args[1];
                currency = args[2];
                double maxPrice = Double.parseDouble(args[3]);
                filtered = CarFilter.filterByModelAndPrice(cars, model, currency, maxPrice);
                if (args.length > 4) sortType = args[4];
                if (args.length > 5) outputType = args[5];
                // Sorting
                if (sortType.equalsIgnoreCase("price")) {
                    sorted = CarSorter.sortByPriceDesc(filtered, currency);
                } else {
                    sorted = filtered;
                }
            } else {
                System.out.println("Unknown file type.");
                return;
            }

            // Output
            switch (outputType.toLowerCase()) {
                case "table": formatter = new TableFormatter(); break;
                case "json": formatter = new JsonFormatter(); break;
                case "xml": formatter = new XmlFormatter(); break;
                default:
                    System.out.println("Unknown output type.");
                    return;
            }
            formatter.print(sorted, currency);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

