package com.example.myreview.Rating;

public class TransactionInformation {
    public boolean onSell, onRent;
    private double sellPrice, rentPrice, shippingCost;
    public TransactionInformation(boolean onSell,  boolean onRent, double sellPrice, double rentPrice, double shippingCost){
        this.onSell = onSell;
        this.onRent = onRent;
        this.sellPrice = sellPrice;
        this.rentPrice = rentPrice;
        this.shippingCost = shippingCost;

    }

    public boolean isOnSell() {
        return onSell;
    }


    public boolean isOnRent() {
        return onRent;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public double getShippingCost() {
        return shippingCost;
    }






}
