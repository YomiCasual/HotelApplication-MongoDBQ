package com.example.Hotel.Application.Hotel;

import com.example.Hotel.Application.Hotel.Address.Address;
import com.example.Hotel.Application.Hotel.Review.Review;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Hotels")
public class Hotel {

    @Id
    private String id;
    private String name;
    private int pricePerNight;
    private List<Review> reviews;
    private Address address;

    public Hotel(String name, int pricePerNight, List<Review> reviews, Address address) {
        this.name = name;
        this.pricePerNight = pricePerNight;
        this.reviews = reviews;
        this.address = address;
    }

    public Hotel() {
        this.reviews = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public Address getAddress() {
        return address;
    }
}
