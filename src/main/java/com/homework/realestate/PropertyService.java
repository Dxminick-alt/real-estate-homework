package com.homework.realestate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.stream.Collectors;

/**
 * Service class for managing and analyzing real estate properties.
 * This class provides methods to add, filter, and analyze properties using Java 8 Streams.
 */
public class PropertyService {
    
    private static final Logger logger = Logger.getLogger(PropertyService.class.getName());
    
    private List<Property> properties;
    
    /**
     * Default constructor that initializes an empty property list.
     */
    public PropertyService() {
        logger.info("Creating new PropertyService instance with default constructor");
        this.properties = new ArrayList<>();
    }
    
    /**
     * Constructor that initializes the service with a list of properties.
     *
     * @param properties the initial list of properties
     */
    public PropertyService(List<Property> properties) {
        logger.info("Creating new PropertyService instance with " + (properties != null ? properties.size() : 0) + " properties");
        this.properties = new ArrayList<>(properties);
    }
    
    /**
     * Adds a property to the collection.
     *
     * @param property the property to add
     * @throws IllegalArgumentException if the property is null
     */
    public void addProperty(Property property) {
        try {
            logger.info("Adding property with id: " + (property != null ? property.getId() : "null"));
            if (property == null) {
                logger.log(Level.SEVERE, "Attempted to add null property");
                throw new IllegalArgumentException("Property cannot be null");
            }
            properties.add(property);
            logger.info("Property added successfully");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error adding property", e);
            throw e;
        }
    }
    
    /**
     * Gets a copy of all properties in the collection.
     *
     * @return a new list containing all properties
     */
    public List<Property> getProperties() {
        try {
            logger.info("Getting all properties, count: " + properties.size());
            List<Property> copy = new ArrayList<>(properties);
            logger.info("Properties retrieved successfully");
            return copy;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error getting properties", e);
            throw e;
        }
    }
    
    /**
     * Gets all available properties (properties marked as available).
     *
     * @return a list of available properties
     */
    public List<Property> getAvailableProperties() {
        try {
            logger.info("Filtering available properties");
            List<Property> available = properties.stream()
                    .filter(Property::isAvailable)
                    .collect(Collectors.toList());
            logger.info("Found " + available.size() + " available properties");
            return available;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error filtering available properties", e);
            throw e;
        }
    }
    
    /**
     * Gets all properties of a specific type.
     *
     * @param type the property type to filter by
     * @return a list of properties of the specified type
     * @throws IllegalArgumentException if the type is null
     */
    public List<Property> getPropertiesByType(PropertyType type) {
        try {
            logger.info("Filtering properties by type: " + type);
            if (type == null) {
                logger.log(Level.SEVERE, "Attempted to filter by null property type");
                throw new IllegalArgumentException("Property type cannot be null");
            }
            List<Property> filtered = properties.stream()
                    .filter(property -> property.getType() == type)
                    .collect(Collectors.toList());
            logger.info("Found " + filtered.size() + " properties of type " + type);
            return filtered;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error filtering properties by type", e);
            throw e;
        }
    }
    
    /**
     * Gets all properties within a specific price range.
     *
     * @param minPrice the minimum price (inclusive)
     * @param maxPrice the maximum price (inclusive)
     * @return a list of properties within the specified price range
     * @throws IllegalArgumentException if minPrice or maxPrice is null, or if minPrice > maxPrice
     */
    public List<Property> getPropertiesByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        try {
            logger.info("Filtering properties by price range: " + minPrice + " - " + maxPrice);
            if (minPrice == null || maxPrice == null) {
                logger.log(Level.SEVERE, "Attempted to filter by null price range");
                throw new IllegalArgumentException("Price range values cannot be null");
            }
            if (minPrice.compareTo(maxPrice) > 0) {
                logger.log(Level.SEVERE, "Invalid price range: minPrice > maxPrice");
                throw new IllegalArgumentException("Minimum price cannot be greater than maximum price");
            }
            List<Property> filtered = properties.stream()
                    .filter(property -> property.getPrice().compareTo(minPrice) >= 0 && 
                            property.getPrice().compareTo(maxPrice) <= 0)
                    .collect(Collectors.toList());
            logger.info("Found " + filtered.size() + " properties in price range");
            return filtered;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error filtering properties by price range", e);
            throw e;
        }
    }
    
    /**
     * Gets all properties with a specific number of bedrooms.
     *
     * @param bedrooms the number of bedrooms to filter by
     * @return a list of properties with the specified number of bedrooms
     */
    public List<Property> getPropertiesByBedrooms(int bedrooms) {
        try {
            logger.info("Filtering properties by bedrooms: " + bedrooms);
            List<Property> filtered = properties.stream()
                    .filter(property -> property.getBedrooms() == bedrooms)
                    .collect(Collectors.toList());
            logger.info("Found " + filtered.size() + " properties with " + bedrooms + " bedrooms");
            return filtered;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error filtering properties by bedrooms", e);
            throw e;
        }
    }
    
    /**
     * Calculates the average price of all properties.
     *
     * @return the average price of all properties, or BigDecimal.ZERO if there are no properties
     */
    public BigDecimal getAveragePrice() {
        try {
            logger.info("Calculating average price of " + properties.size() + " properties");
            if (properties.isEmpty()) {
                logger.info("No properties found, returning zero");
                return BigDecimal.ZERO;
            }
            double average = properties.stream()
                    .collect(Collectors.averagingDouble(p -> p.getPrice().doubleValue()));
            BigDecimal result = BigDecimal.valueOf(average);
            logger.info("Average price calculated: " + result);
            return result;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error calculating average price", e);
            throw e;
        }
    }
    
    /**
     * Finds the most expensive property in the collection.
     *
     * @return the most expensive property, or null if there are no properties
     */
    public Property findMostExpensiveProperty() {
        try {
            logger.info("Finding most expensive property among " + properties.size() + " properties");
            if (properties.isEmpty()) {
                logger.info("No properties found, returning null");
                return null;
            }
            Property mostExpensive = properties.stream()
                    .max((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()))
                    .orElse(null);
            logger.info("Most expensive property found with id: " + (mostExpensive != null ? mostExpensive.getId() : "null"));
            return mostExpensive;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error finding most expensive property", e);
            throw e;
        }
    }
    
    /**
     * Counts the number of properties of a specific type.
     *
     * @param type the property type to count
     * @return the count of properties of the specified type
     * @throws IllegalArgumentException if the type is null
     */
    public long countPropertiesByType(PropertyType type) {
        try {
            logger.info("Counting properties of type: " + type);
            if (type == null) {
                logger.log(Level.SEVERE, "Attempted to count properties of null type");
                throw new IllegalArgumentException("Property type cannot be null");
            }
            long count = properties.stream()
                    .filter(property -> property.getType() == type)
                    .count();
            logger.info("Found " + count + " properties of type " + type);
            return count;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error counting properties by type", e);
            throw e;
        }
    }
}