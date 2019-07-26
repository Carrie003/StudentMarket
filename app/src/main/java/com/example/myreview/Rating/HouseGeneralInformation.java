package com.example.myreview.Rating;

public class HouseGeneralInformation {

    private int peopleNum, floorNum;
    private double size;
    private boolean hasGarage;


    public HouseGeneralInformation(double size,int peopleNum, int floorNum,  boolean hasGarage) {
        this.size = size;
        this.peopleNum = peopleNum;
        this.floorNum = floorNum;
        this.hasGarage = hasGarage;


    }


    public Double getSize() {
        return size;
    }

    public Integer getPeopleNum() {
        return peopleNum;
    }

    public int getFloorNum() {
        return floorNum;
    }

    public boolean hasGarage() {
        return hasGarage;
    }
}
