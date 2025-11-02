package com.homework;

import com.homework.realestate.Property;
import com.homework.realestate.PropertyService;
import com.homework.realestate.PropertyType;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.io.IOException;
import java.io.InputStream;

/**
 * Main application class for the Real Estate Management System.
 * This class demonstrates the functionality of the property management system.
 */
public class App {
    
    private static final Logger logger = Logger.getLogger(App.class.getName());
    
    /**
     * Main method that starts the Real Estate Management System.
     * Initializes the logging system and demonstrates basic functionality.
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        try {
            // Initialize logging
            initializeLogging();
            
            logger.info("Starting Real Estate Management System");
            
            // Create property service
            PropertyService propertyService = new PropertyService();
            
            // Add some sample properties
            addSampleProperties(propertyService);
            
            // Demonstrate functionality
            demonstrateFunctionality(propertyService);
            
            logger.info("Real Estate Management System finished successfully");
        } catch (Exception e) {
            logger.severe("Error in main application: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Initializes the logging system with the configuration from logging.properties.
     */
    private static void initializeLogging() {
        try {
            InputStream configFile = App.class.getClassLoader().getResourceAsStream("logging.properties");
            if (configFile != null) {
                LogManager.getLogManager().readConfiguration(configFile);
                logger.info("Logging initialized successfully");
            } else {
                logger.warning("Logging configuration file not found, using default settings");
            }
        } catch (IOException e) {
            logger.severe("Failed to initialize logging: " + e.getMessage());
        }
    }
    
    /**
     * Adds sample properties to the property service for demonstration.
     *
     * @param propertyService the property service to add properties to
     */
    private static void addSampleProperties(PropertyService propertyService) {
        logger.info("Adding sample properties");
        
        Property property1 = new Property("1", "123 Main St", PropertyType.HOUSE, 
                new BigDecimal("500000"), 2000, 4, 3, true);
        Property property2 = new Property("2", "456 Oak Ave", PropertyType.APARTMENT, 
                new BigDecimal("250000"), 1200, 2, 2, true);
        Property property3 = new Property("3", "789 Pine Rd", PropertyType.CONDO, 
                new BigDecimal("350000"), 1500, 3, 2, false);
                
        propertyService.addProperty(property1);
        propertyService.addProperty(property2);
        propertyService.addProperty(property3);
        
        logger.info("Sample properties added successfully");
    }
    
    /**
     * Demonstrates the functionality of the property service.
     *
     * @param propertyService the property service to demonstrate
     */
    private static void demonstrateFunctionality(PropertyService propertyService) {
        logger.info("Demonstrating property service functionality");
        
        // Get all properties
        List<Property> allProperties = propertyService.getProperties();
        logger.info("Total properties: " + allProperties.size());
        
        // Get available properties
        List<Property> availableProperties = propertyService.getAvailableProperties();
        logger.info("Available properties: " + availableProperties.size());
        
        // Get properties by type
        List<Property> houses = propertyService.getPropertiesByType(PropertyType.HOUSE);
        logger.info("Houses: " + houses.size());
        
        // Get average price
        BigDecimal averagePrice = propertyService.getAveragePrice();
        logger.info("Average price: " + averagePrice);
        
        // Find most expensive property
        Property mostExpensive = propertyService.findMostExpensiveProperty();
        logger.info("Most expensive property ID: " + (mostExpensive != null ? mostExpensive.getId() : "null"));
    }
}