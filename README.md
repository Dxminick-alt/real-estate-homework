# Real Estate Homework Project

This is a Java homework project for a real estate application that demonstrates the use of Java 8 Streams and Collections.

## Project Structure

The project contains the following classes:

1. `Property` - Represents a real estate property with attributes like id, address, type, price, area, bedrooms, bathrooms, and availability status.
2. `PropertyType` - An enum representing different types of properties (APARTMENT, HOUSE, CONDO, TOWNHOUSE).
3. `PropertyService` - A service class that manages a collection of properties and provides methods to filter, search, and analyze property data using Java 8 Streams.

## Features

- Add properties to the collection
- Filter properties by availability status
- Filter properties by type
- Filter properties by price range
- Filter properties by number of bedrooms
- Calculate average property price
- Find the most expensive property
- Count properties by type

## Tests

The project includes comprehensive JUnit tests for all methods in the PropertyService class.

## Technologies Used

- Java 8+
- Maven
- JUnit 4
- Hamcrest Matchers

## How to Run Tests

```bash
mvn test
```