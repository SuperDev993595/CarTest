package org.test;

import java.util.List;

public class JsonFormatter implements OutputFormatter {
    @Override
    public void print(List<Car> cars) {
        System.out.println("[");
        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            System.out.printf("  {\"brand\":\"%s\",\"price\":%.2f,\"releaseDate\":\"%s\",\"type\":\"%s\",\"currency\":\"%s\"}",
                    car.getBrand(), car.getPrice(), car.getReleaseDate(), car.getType(), car.getCurrency());
            if (i < cars.size() - 1) System.out.println(",");
            else System.out.println();
        }
        System.out.println("]");
    }
}
