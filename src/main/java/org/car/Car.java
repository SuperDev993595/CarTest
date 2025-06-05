package org.car;

import java.time.LocalDate;
import java.util.Map;

public class Car {
    private final String brand;
    private final String model;
    private final String type;
    private final LocalDate releaseDate;
    private final Map<String, Double> prices; // currency -> price

    public Car(String brand, String model, String type, LocalDate releaseDate, Map<String, Double> prices) {
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.releaseDate = releaseDate;
        this.prices = prices;
    }

    public String getBrand() { return brand; }
    public String getModel() { return model; }
    public String getType() { return type; }
    public LocalDate getReleaseDate() { return releaseDate; }
    public Map<String, Double> getPrices() { return prices; }

    // Helper to get price by currency
    public Double getPrice(String currency) {
        return prices.get(currency);
    }
}

