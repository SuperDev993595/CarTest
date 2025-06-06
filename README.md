# CarTest

A Java application for parsing, filtering, sorting, and formatting car data from CSV and XML files.

## Features

- Parse car data from CSV ([doc/CarsBrand.csv](doc/CarsBrand.csv)) and XML ([doc/carsType.xml](doc/carsType.xml)) files
- Filter cars by brand and release date (CSV) or by model and price (XML)
- Sort cars by release date (CSV) or price (XML)
- Output results in table, JSON, or XML format

## Usage

Build the project with Maven:

```sh
mvn package
```

Run the application:

### For CSV files

```sh
java -jar CarTest.jar <csvfile> <brand> <releaseDate> [releaseDate|otherSort] [table|json|xml]
```

Example:

```sh
java -jar CarTest.jar doc/CarsBrand.csv Toyota 01/15/2023 releaseDate table
```

### For XML files

```sh
java -jar CarTest.jar <xmlfile> <model> <currency> <maxPrice> [price|otherSort] [table|json|xml]
```

Example:

```sh
java -jar CarTest.jar doc/carsType.xml RAV4 EUR 24000 price json
```

## File Structure

- `src/main/java/org/main/Main.java` - Main entry point
- `src/main/java/org/car/` - Car model, parsers, filters, and sorters
- `src/main/java/org/formatter/` - Output formatters (table, JSON, XML)
- `doc/` - Example data files

## Requirements

- Java 18+
- Maven

## License

MIT License