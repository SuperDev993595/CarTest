package org.car;

import java.util.List;

public interface CarParser {
    List<Car> parse(String filename) throws Exception;
}

