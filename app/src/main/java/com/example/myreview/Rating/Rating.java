package com.example.myreview.Rating;

import com.example.myreview.User;

public class Rating {

    private User user;
    private int rating, like;

//    private int price;
    public Rating(User user, int ratingNum, int like){
        this.user = user;
        this.rating =ratingNum;
        this.like = like;
    }

    public User getUser() {
        return user;
    }

    public int getRating() {
        return rating;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
