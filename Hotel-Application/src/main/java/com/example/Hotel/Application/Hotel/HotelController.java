package com.example.Hotel.Application.Hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@RestController
@RequestMapping("/hotel")
public class HotelController {


    private final MongoTemplate mongoTemplate;



    @Autowired
    public HotelController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }




    @GetMapping
    public List<Hotel> getHotels() throws Exception {
        try{
           List<Hotel> hotels = mongoTemplate.findAll(Hotel.class);
           return hotels;
        }catch (Exception e)  {
            throw new Exception(e);
        }

    }

    @PutMapping
    public String createHotel(@RequestBody Hotel hotel) throws Exception {
        try{
            mongoTemplate.insert(hotel);
        }
        catch (Exception e) {
            throw new Exception(e);
        }
        return "Hotel Created";
    }


    @PostMapping("/update/{id}")
    public String updateHotel(@PathVariable String id, @RequestBody Hotel hotel) throws Exception {
        Hotel myhotel = mongoTemplate.findById(id, Hotel.class);
       try{
          mongoTemplate.update(Hotel.class)
                  .matching(query(where("id").is(id)))
                  .replaceWith(hotel)
                  .findAndReplace();
       }
       catch (Exception e) {
           throw new Exception(e);
       }
        return "Hotel Updated";
    }


    @DeleteMapping("/delete/{id}")
    public String deleteHotel(@PathVariable("id") String id) throws Exception {
        try {
            Hotel hotel = mongoTemplate.findById(id, Hotel.class);
            mongoTemplate.remove(hotel, "Hotels");
        }catch (Exception e) {
            throw new Exception(e);
        }
        return "Hotel Deleted";
    }

    //Get by Id
    @GetMapping("/{id}")
    public List getById(@PathVariable("id") String id) {
        Hotel hotel = mongoTemplate.findById(id, Hotel.class);
        return Arrays.asList(hotel);
    }

    //Get by Price
    @GetMapping("price/{price}")
    public List<Hotel> getByPrice(@PathVariable("price") String price) {
        return mongoTemplate.query(Hotel.class)
                .matching(query(where("address.city").is(price)))
                .all();
    }


}
