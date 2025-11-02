# Real Estate Homework Project

This is a Java homework project for a real estate application that demonstrates the use of Java 8 Streams, Collections, and Logging.

## Project Structure

The project contains the following classes:

1. `Property` - Represents a real estate property with attributes like id, address, type, price, area, bedrooms, bathrooms, and availability status.
2. `PropertyType` - An enum representing different types of properties (APARTMENT, HOUSE, CONDO, TOWNHOUSE).
3. `PropertyService` - A service class that manages a collection of properties and provides methods to filter, search, and analyze property data using Java 8 Streams.
4. `App` - The main application class that demonstrates the functionality.

## Features

- Add properties to the collection
- Filter properties by availability status
- Filter properties by type
- Filter properties by price range
- Filter properties by number of bedrooms
- Calculate average property price
- Find the most expensive property
- Count properties by type
- Comprehensive logging to console and file (realEstateApp.log)
- Full JavaDoc documentation for all classes and methods

## Tests

The project includes comprehensive JUnit tests for all methods in the PropertyService class, including:
- Positive test cases for all functionality
- Negative test cases for error conditions
- Edge case handling

## Technologies Used

- Java 11+
- Maven
- JUnit 4
- Hamcrest Matchers
- Java Util Logging (java.util.logging)

## Logging

The application uses Java Util Logging for comprehensive logging:
- INFO level logging for all method calls
- SEVERE level logging for caught exceptions
- Logs are written to both console and file (realEstateApp.log)
- Custom logging configuration in src/main/resources/logging.properties

## How to Run Tests

```bash
mvn test
```

## How to Run the Application

```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.homework.App"
```

Or to run with custom logging configuration:

```bash
mvn exec:java -Dexec.mainClass="com.homework.App" -Djava.util.logging.config.file=src/main/resources/logging.properties
```