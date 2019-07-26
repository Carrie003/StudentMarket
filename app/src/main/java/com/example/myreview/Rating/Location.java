package com.example.myreview.Rating;

import com.google.android.gms.maps.model.LatLng;

public class Location {

    private String country, stateOrProvince, county, city, street, postalCode, fullLocation;
    private LatLng latLng;
    public Location( String street, String city, String county, String stateOrProvince, String country, String postalCode, String fullLocation,LatLng latLng){

        this.country = country;
        this.stateOrProvince = stateOrProvince;
        this.country = county;
        this.city = city;
        this.street = street;
        this.postalCode = postalCode;
        this.fullLocation = fullLocation;
        this.latLng = latLng;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getCounty() {
        return county;
    }

    public String getStateOrProvince() {
        return stateOrProvince;
    }

    public String getCountry() {
        return country;
    }

    public String getPostalCode() {
        return postalCode;
    }


    public LatLng getLatLng() {
        return latLng;
    }


}

