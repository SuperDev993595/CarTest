package org.test;

import java.util.List;

public interface CarParser {
    List<Car> parse(String filename) throws Exception;
}

