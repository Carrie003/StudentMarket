package com.example.myreview.Rating;

import java.util.Map;

public class HouseOrApartmentDescription {
    private Map<String, Integer> roomMap, surroundingMap;
    private String description;

    public HouseOrApartmentDescription(Map<String, Integer> roomMap, Map<String, Integer> surroundingMap, String description){
        this.roomMap = roomMap;
        this.surroundingMap = surroundingMap;
        this.description = description;
    }
}
