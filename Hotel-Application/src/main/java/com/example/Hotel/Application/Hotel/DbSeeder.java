package com.example.Hotel.Application.Hotel;

import com.example.Hotel.Application.Hotel.Address.Address;
import com.example.Hotel.Application.Hotel.Hotel;
import com.example.Hotel.Application.Hotel.HotelRepository;
import com.example.Hotel.Application.Hotel.Review.Review;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@Component
public class DbSeeder implements CommandLineRunner {

//    @Autowired
    private HotelRepository hotelRepository;

    public DbSeeder(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Hotel mariam = new Hotel(
                "Mariam",
                130,
                Arrays.asList(
                        new Review("abiodun", 7, true),
                        new Review("Kunle", 4, false)
                ),
                new Address("Nigeria", "Ibadan")

        );
        Hotel sevenGardens = new Hotel(
                "Seven Gardens",
                120,
                Arrays.asList(
                        new Review("Mary", 7, true)
                ),
                new Address("Nigeria", "Lagos")

        );
        Hotel dRock = new Hotel(
                "D Rock",
                190,
                Arrays.asList(
                        new Review("Mary", 7, true),
                        new Review("Bolajoko", 4, false)
                ),
                new Address("Ethopia", "Augu")

        );
        
        this.hotelRepository.deleteAll();
        List<Hotel> hotels =  Arrays.asList(sevenGardens, dRock, mariam);

        this.hotelRepository.save(sevenGardens);
        this.hotelRepository.save(dRock);
        this.hotelRepository.save(mariam);
        System.out.println(hotels);

    }

}
