package com.example.myreview.Rating;

import com.example.myreview.User;

import java.util.ArrayList;
import java.util.Map;

public class Item{

    private Integer price, shippingCost, soldOutNumber;
    private String name, brand, location, shop, appearance, functionality;
    private Double averageRating;
//    private Category category;

    private Map<String, ArrayList<String>> attributesMap;
//    private Attributes attributes;
    private Map<User, Double> userRatingMap;
    private Map<User, String> attributeMap, userReviewMap, userSuggestionMap;
    private ArrayList<Integer> appearanceList, functionalityList,colorList;
//    private ArrayList<String> shopList;


//    private Map<Book, String> x;

    public Item(String name, Integer price,  Integer shippingCost, String location, String brand,  String shop, ArrayList<String> appearanceList, ArrayList<String> functionalityList, Double averageRating, Integer soldOutNumber,   ArrayList<Integer> colorList,  Map<User, Double> userRatingMap, Map<User, String> userReviewMap, Map<User, String> userSuggestionMap) {
        this.name = name;
        this.price = price;
        this.shippingCost = shippingCost;
        this.location = location;
        this.brand = brand;
        this.shop = shop;

//        this.appearance = appearance;
//        this.functionality = functionality;
        this.averageRating = averageRating;
        this.soldOutNumber = soldOutNumber;
//        this.attributesMap = attributesMap;
        this.colorList = colorList;


//        this.shopList = shopList;
//        this.attributes = attributes;
        this.userRatingMap = userRatingMap;
        this.userReviewMap = userReviewMap;
        this.userSuggestionMap = userSuggestionMap;
//        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Integer getShippingCost() {
        return shippingCost;
    }

    public Double getAverageRating() {
        return averageRating;
    }

    public Integer getSoldOutNumber() {
        return soldOutNumber;
    }

    public String getBrand() {
        return brand;
    }


    public String getLocation() {
        return location;
    }

//    public String getAppearance() {
//        return appearance;
//    }
//
//    public String getFunctionality() {
//        return functionality;
//    }


    public ArrayList<Integer> getAppearanceList() {
        return appearanceList;
    }

    public ArrayList<Integer> getFunctionalityList() {
        return functionalityList;
    }

    public ArrayList<Integer> getColorList() {
        return colorList;
    }

//    public ArrayList<String> getPriceList() {
//        return priceList;
//    }

//    public ArrayList<String> getShopList() {
//        return shopList;
//    }


    public String getShop() {
        return shop;
    }
}
