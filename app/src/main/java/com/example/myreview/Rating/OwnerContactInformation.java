package com.example.myreview.Rating;

import java.util.Map;

public class OwnerContactInformation {

    private Map<String, String> locationMap, contactMap;
    public OwnerContactInformation(Map<String, String> locationMap, Map<String, String> contactMap){
        this.locationMap = locationMap;
        this.contactMap = contactMap;

    }

}
