package com.example.myreview.Rating;

import java.util.Comparator;

public class Apartment {
//    private String description;
//    private double price, rent, size, peopleNum, floorNum;
//    private boolean onSell, onRentOut;

    private HouseGeneralInformation generalInformation;
    private HouseOrApartmentDescription description;
    private Location location;

    private TransactionInformation transactionInformation;
    private OwnerContactInformation contactInformation;
    private Rating rating;

    private Data source;

    public Apartment(HouseGeneralInformation generalInformation, Location location, TransactionInformation transactionInformation, HouseOrApartmentDescription description, OwnerContactInformation contactInformation, Rating rating) {
        this.generalInformation = generalInformation;
        this.description = description;
        this.location = location;
        this.transactionInformation = transactionInformation;
        this.contactInformation = contactInformation;
        this.rating = rating;


    }

    public HouseGeneralInformation getGeneralInformation() {
        return generalInformation;
    }


    public Location getLocation() {
        return location;
    }

    public TransactionInformation getTransactionInformation() {
        return transactionInformation;
    }

    public HouseOrApartmentDescription getDescription() {
        return description;
    }


    public OwnerContactInformation getContactInformation() {
        return contactInformation;
    }

    public Rating getRating() {
        return rating;
    }

    public  Comparator<Apartment> distanceComparator = new Comparator<Apartment>() {
        @Override
        public int compare(Apartment e1, Apartment e2) {
            return calculateDistance(e1).compareTo(calculateDistance(e2));
        }
    };



    public  Comparator<Apartment> likesComparator = new Comparator<Apartment>() {
        @Override
        public int compare(Apartment e1, Apartment e2) {
            return e1.getRating().getLike().compareTo(e2.getRating().getLike());
        }
    };

    public  Comparator<Apartment> priceComparator = new Comparator<Apartment>() {
        @Override
        public int compare(Apartment e1, Apartment e2) {

            return  (calculateTotalPrice(e1).compareTo(calculateTotalPrice(e2)));
        }
    };
    public Comparator<Apartment> sizeComparator = new Comparator<Apartment>() {
        @Override
        public int compare(Apartment e1, Apartment e2) {

            return  (e1.getGeneralInformation().getSize().compareTo(e2.getGeneralInformation().getSize()));
        }
    };

    public Comparator<Apartment> peopleNumComparator = new Comparator<Apartment>() {
        @Override
        public int compare(Apartment e1, Apartment e2) {

            return  (e1.getGeneralInformation().getPeopleNum().compareTo(e2.getGeneralInformation().getPeopleNum()));
        }
    };


    public  Double calculateDistance(Apartment estate){
        double latitudeDistance  = source.getCurrentLatLng().latitude- estate.getLocation().getLatLng().latitude;
        double longitudeDistance =source.getCurrentLatLng().longitude - estate.getLocation().getLatLng().longitude;
        double distance = Math.sqrt(latitudeDistance*latitudeDistance+longitudeDistance*longitudeDistance);
        return  distance;
    }

    public Double calculateTotalPrice(Apartment estate){
        double totalPrice;
        if(estate.getTransactionInformation().isOnSell()){
            totalPrice = estate.getTransactionInformation().getSellPrice()+ estate.getTransactionInformation().getShippingCost();
        }

        else
            totalPrice = estate.getTransactionInformation().getRentPrice()+ estate.getTransactionInformation().getShippingCost();

        return  totalPrice;
    }


}