package com.example.Hotel.Application.Hotel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {
    /*Hotel findById(String id);*/
    List<Hotel> findByPricePerNightLessThan (int price);

    @Query(value="{ 'name' : ?0 }", fields="{ 'pricePerNight' : 1 }")
    Hotel findByName(String name);
}
