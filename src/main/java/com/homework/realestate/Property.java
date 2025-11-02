package com.homework.realestate;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Represents a real estate property with its characteristics.
 * This class models a property with attributes such as address, type, price, area, and room count.
 */
public class Property {
    private static final Logger logger = Logger.getLogger(Property.class.getName());
    
    private String id;
    private String address;
    private PropertyType type;
    private BigDecimal price;
    private double area;
    private int bedrooms;
    private int bathrooms;
    private boolean isAvailable;

    /**
     * Default constructor for Property.
     */
    public Property() {
        logger.info("Creating new Property instance with default constructor");
    }

    /**
     * Constructor for Property with all attributes.
     *
     * @param id the unique identifier for the property
     * @param address the address of the property
     * @param type the type of the property (HOUSE, APARTMENT, etc.)
     * @param price the price of the property
     * @param area the area of the property in square units
     * @param bedrooms the number of bedrooms in the property
     * @param bathrooms the number of bathrooms in the property
     * @param isAvailable the availability status of the property
     */
    public Property(String id, String address, PropertyType type, BigDecimal price, 
                   double area, int bedrooms, int bathrooms, boolean isAvailable) {
        logger.info("Creating new Property instance with id: " + id);
        this.id = id;
        this.address = address;
        this.type = type;
        this.price = price;
        this.area = area;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.isAvailable = isAvailable;
    }

    /**
     * Gets the unique identifier of the property.
     *
     * @return the property id
     */
    public String getId() {
        logger.info("Getting property id: " + id);
        return id;
    }

    /**
     * Sets the unique identifier of the property.
     *
     * @param id the property id to set
     */
    public void setId(String id) {
        logger.info("Setting property id to: " + id);
        this.id = id;
    }

    /**
     * Gets the address of the property.
     *
     * @return the property address
     */
    public String getAddress() {
        logger.info("Getting property address: " + (address != null ? address : "null"));
        return address;
    }

    /**
     * Sets the address of the property.
     *
     * @param address the property address to set
     */
    public void setAddress(String address) {
        logger.info("Setting property address to: " + address);
        this.address = address;
    }

    /**
     * Gets the type of the property.
     *
     * @return the property type
     */
    public PropertyType getType() {
        logger.info("Getting property type: " + (type != null ? type : "null"));
        return type;
    }

    /**
     * Sets the type of the property.
     *
     * @param type the property type to set
     */
    public void setType(PropertyType type) {
        logger.info("Setting property type to: " + type);
        this.type = type;
    }

    /**
     * Gets the price of the property.
     *
     * @return the property price
     */
    public BigDecimal getPrice() {
        logger.info("Getting property price: " + (price != null ? price.toString() : "null"));
        return price;
    }

    /**
     * Sets the price of the property.
     *
     * @param price the property price to set
     */
    public void setPrice(BigDecimal price) {
        logger.info("Setting property price to: " + (price != null ? price.toString() : "null"));
        this.price = price;
    }

    /**
     * Gets the area of the property.
     *
     * @return the property area
     */
    public double getArea() {
        logger.info("Getting property area: " + area);
        return area;
    }

    /**
     * Sets the area of the property.
     *
     * @param area the property area to set
     */
    public void setArea(double area) {
        logger.info("Setting property area to: " + area);
        this.area = area;
    }

    /**
     * Gets the number of bedrooms in the property.
     *
     * @return the number of bedrooms
     */
    public int getBedrooms() {
        logger.info("Getting property bedrooms: " + bedrooms);
        return bedrooms;
    }

    /**
     * Sets the number of bedrooms in the property.
     *
     * @param bedrooms the number of bedrooms to set
     */
    public void setBedrooms(int bedrooms) {
        logger.info("Setting property bedrooms to: " + bedrooms);
        this.bedrooms = bedrooms;
    }

    /**
     * Gets the number of bathrooms in the property.
     *
     * @return the number of bathrooms
     */
    public int getBathrooms() {
        logger.info("Getting property bathrooms: " + bathrooms);
        return bathrooms;
    }

    /**
     * Sets the number of bathrooms in the property.
     *
     * @param bathrooms the number of bathrooms to set
     */
    public void setBathrooms(int bathrooms) {
        logger.info("Setting property bathrooms to: " + bathrooms);
        this.bathrooms = bathrooms;
    }

    /**
     * Checks if the property is available.
     *
     * @return true if the property is available, false otherwise
     */
    public boolean isAvailable() {
        logger.info("Checking property availability: " + isAvailable);
        return isAvailable;
    }

    /**
     * Sets the availability status of the property.
     *
     * @param available the availability status to set
     */
    public void setAvailable(boolean available) {
        logger.info("Setting property availability to: " + available);
        isAvailable = available;
    }

    /**
     * Compares this property to another object for equality.
     * Properties are considered equal if they have the same id.
     *
     * @param o the object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        try {
            logger.info("Checking equality with object: " + (o != null ? o.getClass().getName() : "null"));
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Property property = (Property) o;
            boolean result = Objects.equals(id, property.id);
            logger.info("Equality check result: " + result);
            return result;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error during equality check", e);
            return false;
        }
    }

    /**
     * Generates a hash code for this property based on its id.
     *
     * @return the hash code value
     */
    @Override
    public int hashCode() {
        try {
            int hash = Objects.hash(id);
            logger.info("Generated hash code: " + hash);
            return hash;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error during hash code generation", e);
            return 0;
        }
    }

    /**
     * Returns a string representation of the property.
     *
     * @return a string representation of the property
     */
    @Override
    public String toString() {
        try {
            String str = "Property{" +
                    "id='" + id + '\'' +
                    ", address='" + address + '\'' +
                    ", type=" + type +
                    ", price=" + price +
                    ", area=" + area +
                    ", bedrooms=" + bedrooms +
                    ", bathrooms=" + bathrooms +
                    ", isAvailable=" + isAvailable +
                    '}';
            logger.info("Generated string representation");
            return str;
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Error during string representation generation", e);
            return "Property{error}";
        }
    }
}