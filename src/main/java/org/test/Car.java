package org.test;

import java.time.LocalDate;

public class Car {
    private String brand;
    private double price;
    private LocalDate releaseDate;
    private String type;
    private String currency;

    public Car(String brand, double price, LocalDate releaseDate, String type, String currency) {
        this.brand = brand;
        this.price = price;
        this.releaseDate = releaseDate;
        this.type = type;
        this.currency = currency;
    }

    public String getBrand() { return brand; }
    public double getPrice() { return price; }
    public LocalDate getReleaseDate() { return releaseDate; }
    public String getType() { return type; }
    public String getCurrency() { return currency; }
}
