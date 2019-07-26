package com.example.myreview.Rating;

import androidx.annotation.NonNull;

import com.example.myreview.User;

import java.util.ArrayList;

public class Objs {
    private User user;
    private Apartment estate;
    private Book book;
    private Item item;

    public Objs(User user, Apartment estate, Book book, Item item){
        this.user = user;
        this.estate= estate;
        this.book = book;
        this.item = item;

    }

    public User getUser() {
        return user;
    }

    public Apartment getEstate() {
        return estate;
    }

    public Book getBook() {
        return book;
    }

    public Item getItem() {
        return item;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setEstate(Apartment estate) {
        this.estate = estate;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
