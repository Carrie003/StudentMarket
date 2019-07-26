package com.example.myreview.Rating;

import java.util.ArrayList;

public class WishList {


    private ArrayList<Apartment> houseOrApartmentList;

    private ArrayList<Book> bookList;

    private ArrayList<Item> itemList;

    public WishList(ArrayList<Apartment> houseOrApartmentList, ArrayList<Book> bookList, ArrayList<Item> itemList ){

        this.houseOrApartmentList = houseOrApartmentList;
        this.bookList = bookList;
        this.itemList = itemList;


    }

    public ArrayList<Apartment> getHouseOrApartmentList() {
        return houseOrApartmentList;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }
}
