package com.example.Hotel.Application.Hotel.Review;

public class Review {
    private String username;
    private int rate;
    private boolean approve;

    public Review(String username, int rate, boolean approve) {
        this.username = username;
        this.rate = rate;
        this.approve = approve;
    }

    public String getUsername() {
        return username;
    }

    public int getRate() {
        return rate;
    }

    public boolean isApprove() {
        return approve;
    }
}
