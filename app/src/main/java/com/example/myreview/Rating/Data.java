package com.example.myreview.Rating;

import com.example.myreview.User;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Data {


    private com.example.myreview.User user;
    private ArrayList allAppearanceList, allFunctionalityList;
//    private ArrayList<Book> bookShelf;
    private int[] appearanceColors, functionalityColors;
    private boolean pinItemImage, pinBookImage, pinApartmentImage;
    private LatLng currentLatLng;

    private Map<String, int[]> featureColorMap;
    private Map<User, WishList> userWishMap;




    private Map<User, ArrayList<Book>> bookShelf, bookForSale, bookForRent;
    private Map<User, ArrayList<Apartment>> landExplorer, estateForSale, estateForRent;
    private Map<User, ArrayList<Item>> shoppingCart, itemForSale;
    private Map<User, ArrayList<User>> followings, followers;
//    private

//    private Map<User,>
//    private Map<User, ArrayList<Objs>> landExplorer, bookShelf, shoppingCart,  wishList,  userFollowingsMap, userFollowerMap, userMarketMap, userTransactionMap;
//
//    //    private Map<User, ArrayList<User>> userFollowingsMap;
//    private Map<User, ArrayList<User>> userFollowerMap;
//    private Map<User, ArrayList<?>> userMarketMap;
//    private Map<User, ArrayList<?>> userTransactionMap;


//    private Map<String, int[]> appearanceColorMap;
//    public Map<String, int[]> getAppearanceColorMap(){
//        appearanceColorMap = new HashMap<>();
//        return appearanceColorMap;
//
//
//    }

    public void Data(){
        featureColorMap  = new HashMap<String, int[]>() {{

//            put("appearance", );
//            put("functionality", "value2");
        }};


        bookShelf = new HashMap<>();
        bookForSale = new HashMap<>();
        bookForRent = new HashMap<>();
        landExplorer = new HashMap<>();
        estateForSale = new HashMap<>();
        estateForRent = new HashMap<>();
        shoppingCart = new HashMap<>();
        itemForSale = new HashMap<>();
        followings = new HashMap<>();
        followers = new HashMap<>();

//        currentLatLng

//        userFollowingsMap = new HashMap<>();
//        userFollowerMap = new HashMap<>();


    }

    public Map<String, int[]> getFeatureColorMap() {
        return featureColorMap;
    }

    public ArrayList getAllAppearanceList() {
        return allAppearanceList;
    }

    public ArrayList getAllFunctionalityList() {
        return allFunctionalityList;
    }

    public int[] getAppearanceColors() {
        return appearanceColors;
    }

    public int[] getFunctionalityColors() {
        return functionalityColors;
    }





    public void setPinItemImage(boolean pinItemImage) {
        this.pinItemImage = pinItemImage;
    }
    public void setPinApartmentImage(boolean pinApartmentImage) {
        this.pinApartmentImage = pinApartmentImage;
    }
    public void setPinBookImage(boolean pinBookImage) {
        this.pinBookImage = pinBookImage;
    }

    public boolean isPinItemImage() {
        return pinItemImage;
    }

    public boolean isPinBookImage() {
        return pinBookImage;
    }

    public boolean isPinApartmentImage() {
        return pinApartmentImage;
    }



    public com.example.myreview.User getUser() {
        return user;
    }

    public void setUser(com.example.myreview.User user) {
        this.user = user;
    }
//    public ArrayList<Book> getBookShelf() {
////        return bookShelf;
////    }


    public Map<com.example.myreview.User, WishList> getUserWishMap() {
        return userWishMap;
    }


    public void setUserWishMap(Map<com.example.myreview.User, WishList> userNameWishMap) {
        this.userWishMap = userNameWishMap;
    }


    public LatLng getCurrentLatLng() {
        return currentLatLng;
    }

    public Map<User, ArrayList<Book>> getBookShelf() {
        return bookShelf;
    }

    public Map<User, ArrayList<Book>> getBookForSale() {
        return bookForSale;
    }

    public Map<User, ArrayList<Book>> getBookForRent() {
        return bookForRent;
    }

    public Map<User, ArrayList<Apartment>> getLandExplorer() {
        return landExplorer;
    }

    public Map<User, ArrayList<Apartment>> getEstateForRent() {
        return estateForRent;
    }

    public Map<User, ArrayList<Apartment>> getEstateForSale() {
        return estateForSale;
    }

    public Map<User, ArrayList<User>> getFollowings() {
        return followings;
    }

    public Map<User, ArrayList<User>> getFollowers() {
        return followers;
    }

    //    public Map<User, ArrayList<Objs>> getLandExplorer() {
//        return landExplorer;
//    }
//
//    public Map<User, ArrayList<Objs>> getBookShelf() {
//        return bookShelf;
//    }
//
//    public Map<User, ArrayList<Objs>> getShoppingCart() {
//        return shoppingCart;
//    }
//
//    public Map<User, ArrayList<Objs>> getWishList() {
//        return wishList;
//    }
//
//    public Map<User, ArrayList<Objs>> getUserFollowingsMap() {
//        return userFollowingsMap;
//    }
//    public Map<User, ArrayList<Objs>> getUserFollowerMap() {
//        return userFollowerMap;
//    }
//
//    public Map<User, ArrayList<Objs>> getUserMarketMap() {
//        return userMarketMap;
//    }
//
//    public Map<User, ArrayList<Objs>> getUserTransactionMap() {
//        return userTransactionMap;
//    }



}



