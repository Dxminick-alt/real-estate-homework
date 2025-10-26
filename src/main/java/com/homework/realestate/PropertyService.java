package com.homework.realestate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PropertyService {
    
    private List<Property> properties;
    
    public PropertyService() {
        this.properties = new ArrayList<>();
    }
    
    public PropertyService(List<Property> properties) {
        this.properties = new ArrayList<>(properties);
    }
    
    public void addProperty(Property property) {
        properties.add(property);
    }
    
    public List<Property> getProperties() {
        return new ArrayList<>(properties);
    }
    
    public List<Property> getAvailableProperties() {
        return properties.stream()
                .filter(Property::isAvailable)
                .collect(Collectors.toList());
    }
    
    public List<Property> getPropertiesByType(PropertyType type) {
        return properties.stream()
                .filter(property -> property.getType() == type)
                .collect(Collectors.toList());
    }
    
    public List<Property> getPropertiesByPriceRange(BigDecimal minPrice, BigDecimal maxPrice) {
        return properties.stream()
                .filter(property -> property.getPrice().compareTo(minPrice) >= 0 && 
                        property.getPrice().compareTo(maxPrice) <= 0)
                .collect(Collectors.toList());
    }
    
    public List<Property> getPropertiesByBedrooms(int bedrooms) {
        return properties.stream()
                .filter(property -> property.getBedrooms() == bedrooms)
                .collect(Collectors.toList());
    }
    
    public BigDecimal getAveragePrice() {
        return properties.stream()
                .collect(Collectors.averagingDouble(p -> p.getPrice().doubleValue()))
                .compareTo(Double.NaN) == 0 ? BigDecimal.ZERO : 
                BigDecimal.valueOf(properties.stream()
                        .collect(Collectors.averagingDouble(p -> p.getPrice().doubleValue())));
    }
    
    public Property findMostExpensiveProperty() {
        return properties.stream()
                .max((p1, p2) -> p1.getPrice().compareTo(p2.getPrice()))
                .orElse(null);
    }
    
    public long countPropertiesByType(PropertyType type) {
        return properties.stream()
                .filter(property -> property.getType() == type)
                .count();
    }
}