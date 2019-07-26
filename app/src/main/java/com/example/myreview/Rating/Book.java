package com.example.myreview.Rating;

import java.util.ArrayList;
import java.util.Comparator;

public class Book {

    private BookGeneralInformation generalInformation;
    private TransactionInformation priceInformation;
    private BookDescription description;
    private String title, author, ISBN, publisher, publicationDate,  itemDescription, contentDescription, date;
//    private boolean onSell, onRentOut;
    private ArrayList<String> contentFeatureList;
    private Location location;
    private Rating rating;
    public static final Data source = new Data();
//
//    public Book(String title, String author, String location, String ISBN, String publisher, String publicationDate, String itemDescription, String contentDescription, String date, boolean onSell, boolean onRentOut, ArrayList<String> featureList){
//        this.title = title;
//        this.author = author;
//        this.location = location;
//        this.ISBN = ISBN;
//        this.publisher = publisher;
//        this.publicationDate = publicationDate;
//        this.itemDescription  = itemDescription;
//        this.contentDescription = contentDescription;
//        this.date =date;
//        this.onSell = onSell;
//        this.onRentOut = onRentOut;
//        this.featureList = featureList;
//    }

    public Book(BookGeneralInformation generalInformation, TransactionInformation transactionInformation, BookDescription description, Location location, Rating rating, String date ){

        this.generalInformation = generalInformation;
        this.priceInformation = transactionInformation;
        this.description = description;
//        this.onSell = onSell;
//        this.onRentOut = onRentOut;

        this.date = date;
        this.location = location;
        this.rating =rating;

    }


    public BookGeneralInformation getGeneralInformation() {
        return generalInformation;
    }

    public TransactionInformation getTransactionInformation() {
        return priceInformation;
    }

    public Location getLocation() {
        return location;
    }

    public BookDescription getDescription() {
        return description;
    }

    public Rating getRating() {
        return rating;
    }


    public  Comparator<Book> distanceComparator = new Comparator<Book>() {
        @Override
        public int compare(Book b1, Book b2) {
            return calculateDistance(b1).compareTo(calculateDistance(b2));
        }
    };



    public  Comparator<Book> likesComparator = new Comparator<Book>() {
        @Override
        public int compare(Book b1, Book b2) {
            return b1.getRating().getLike().compareTo(b2.getRating().getLike());
        }
    };

    public  Comparator<Book> priceComparator = new Comparator<Book>() {
        @Override
        public int compare(Book b1, Book b2) {

            return  (calculateTotalPrice(b1).compareTo(calculateTotalPrice(b2)));
        }
    };




    public  Double calculateDistance(Book book){
        double latitudeDistance  = source.getCurrentLatLng().latitude- book.getLocation().getLatLng().latitude;
        double longitudeDistance =source.getCurrentLatLng().longitude - book.getLocation().getLatLng().longitude;
        double distance = Math.sqrt(latitudeDistance*latitudeDistance+longitudeDistance*longitudeDistance);
        return  distance;
    }

    public Double calculateTotalPrice(Book book){
        double totalPrice;
        if(book.getTransactionInformation().isOnSell()){
            totalPrice = book.getTransactionInformation().getSellPrice()+ book.getTransactionInformation().getShippingCost();
        }

        else
            totalPrice = book.getTransactionInformation().getRentPrice()+ book.getTransactionInformation().getShippingCost();

        return  totalPrice;
    }

//    public Comparator<Book> getDistanceComparator() {
//        return distanceComparator;
//    }
//
//    public Comparator<Book> getLikesComparator() {
//        return likesComparator;
//    }
//
//    public Comparator<Book> getPriceComparator() {
//        return priceComparator;
//    }
}

