package com.example.myreview.Rating;

public class SellOrRentOut {

    private boolean onSell, onRentOut;
    public SellOrRentOut(boolean onSell, boolean onRentOut){
        this.onSell = onSell;
        this.onRentOut = onRentOut;
    }


    public boolean isOnSell() {
        return onSell;
    }

    public boolean isOnRentOut() {
        return onRentOut;
    }
}
