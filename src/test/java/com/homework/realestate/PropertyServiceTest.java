package com.homework.realestate;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

public class PropertyServiceTest {
    
    private PropertyService propertyService;
    private Property property1;
    private Property property2;
    private Property property3;
    
    @Before
    public void setUp() {
        propertyService = new PropertyService();
        
        property1 = new Property("1", "123 Main St", PropertyType.HOUSE, 
                new BigDecimal("500000"), 2000, 4, 3, true);
        property2 = new Property("2", "456 Oak Ave", PropertyType.APARTMENT, 
                new BigDecimal("250000"), 1200, 2, 2, true);
        property3 = new Property("3", "789 Pine Rd", PropertyType.CONDO, 
                new BigDecimal("350000"), 1500, 3, 2, false);
                
        propertyService.addProperty(property1);
        propertyService.addProperty(property2);
        propertyService.addProperty(property3);
    }
    
    @Test
    public void testGetAvailableProperties() {
        List<Property> availableProperties = propertyService.getAvailableProperties();
        
        assertThat(availableProperties, hasSize(2));
        assertThat(availableProperties, containsInAnyOrder(property1, property2));
    }
    
    @Test
    public void testGetPropertiesByType() {
        List<Property> houses = propertyService.getPropertiesByType(PropertyType.HOUSE);
        
        assertThat(houses, hasSize(1));
        assertThat(houses.get(0), equalTo(property1));
    }
    
    @Test
    public void testGetPropertiesByPriceRange() {
        List<Property> affordableProperties = propertyService.getPropertiesByPriceRange(
                new BigDecimal("200000"), new BigDecimal("400000"));
        
        assertThat(affordableProperties, hasSize(2));
        assertThat(affordableProperties, containsInAnyOrder(property2, property3));
    }
    
    @Test
    public void testGetPropertiesByBedrooms() {
        List<Property> threeBedroomProperties = propertyService.getPropertiesByBedrooms(3);
        
        assertThat(threeBedroomProperties, hasSize(1));
        assertThat(threeBedroomProperties.get(0), equalTo(property3));
    }
    
    @Test
    public void testGetAveragePrice() {
        BigDecimal averagePrice = propertyService.getAveragePrice();
        BigDecimal expectedAverage = new BigDecimal("366666.67").setScale(2, BigDecimal.ROUND_HALF_UP);
        
        assertThat(averagePrice.setScale(2, BigDecimal.ROUND_HALF_UP), 
                comparesEqualTo(expectedAverage));
    }
    
    @Test
    public void testFindMostExpensiveProperty() {
        Property mostExpensive = propertyService.findMostExpensiveProperty();
        
        assertThat(mostExpensive, equalTo(property1));
        assertThat(mostExpensive.getPrice(), comparesEqualTo(new BigDecimal("500000")));
    }
    
    @Test
    public void testCountPropertiesByType() {
        long houseCount = propertyService.countPropertiesByType(PropertyType.HOUSE);
        long apartmentCount = propertyService.countPropertiesByType(PropertyType.APARTMENT);
        long condoCount = propertyService.countPropertiesByType(PropertyType.CONDO);
        
        assertThat(houseCount, is(1L));
        assertThat(apartmentCount, is(1L));
        assertThat(condoCount, is(1L));
    }
}