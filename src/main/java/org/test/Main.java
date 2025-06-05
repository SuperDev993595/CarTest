package org.test;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        if (args.length < 5) {
            System.out.println("Usage: java -jar app.jar <inputfile> <csv|xml> <filterType> <sortType> <outputType> [filterValue1] [filterValue2]");
            System.out.println("Example: java -jar app.jar cars.csv csv brand_price releaseYear table Toyota 30000");
            return;
        }
        String inputFile = args[0];
        String fileType = args[1];
        String filterType = args[2];
        String sortType = args[3];
        String outputType = args[4];

        CarParser parser = fileType.equalsIgnoreCase("csv") ? new CsvCarParser() : new XmlCarParser();
        List<Car> cars;
        try {
            cars = parser.parse(inputFile);
        } catch (Exception e) {
            System.out.println("Error parsing file: " + e.getMessage());
            return;
        }

        // Filtering
        if (filterType.equalsIgnoreCase("brand_price")) {
            if (args.length < 7) {
                System.out.println("brand_price filter requires brand and maxPrice arguments.");
                return;
            }
            String brand = args[5];
            double maxPrice = Double.parseDouble(args[6]);
            cars = CarFilter.filterByBrandAndPrice(cars, brand, maxPrice);
        } else if (filterType.equalsIgnoreCase("brand_releaseDate")) {
            if (args.length < 7) {
                System.out.println("brand_releaseDate filter requires brand and releaseDate arguments.");
                return;
            }
            String brand = args[5];
            LocalDate date = LocalDate.parse(args[6]);
            cars = CarFilter.filterByBrandAndReleaseDate(cars, brand, date);
        }

        // Sorting
        if (sortType.equalsIgnoreCase("releaseYear")) {
            cars = CarSorter.sortByReleaseYearDesc(cars);
        } else if (sortType.equalsIgnoreCase("price")) {
            cars = CarSorter.sortByPriceDesc(cars);
        }

        // Output
        OutputFormatter formatter;
        switch (outputType.toLowerCase()) {
            case "table": formatter = new TableFormatter(); break;
            case "json": formatter = new JsonFormatter(); break;
            case "xml": formatter = new XmlFormatter(); break;
            default:
                System.out.println("Unknown output type.");
                return;
        }
        formatter.print(cars);
    }
}
