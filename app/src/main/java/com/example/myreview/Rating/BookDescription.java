package com.example.myreview.Rating;

import java.util.ArrayList;

public class BookDescription {

    private String itemDescription, contentDescription;
    private ArrayList<String> contentFeatureList;

    public BookDescription(String itemDescription, String contentIntroduction, ArrayList<String> contentFeatureList){
        this.itemDescription = itemDescription;
        this.contentDescription = contentIntroduction;
        this.contentFeatureList = contentFeatureList;
    }
}