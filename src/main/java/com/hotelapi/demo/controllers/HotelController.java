package com.hotelapi.demo.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelapi.demo.models.Hotel;
import com.hotelapi.demo.service.HotelServiceInt;

//this is hotel controller in this controller we start with @restcontroller and @requestMapping
//autowired the instance of our hoterservie interface, then we take all the methods from hoterservice implementation
//for every method it has mapping for storing data postmapping(path), getting a record or all hotels
//getmapping(path), updating we putMapping(path)
//for storing and udpdating we use @RequestBody in the arguments
//and for getting record/s we use @PathVariable
//to handle the data back referencing we use @JsonIgnore @JsonBackReference
//ResponseEntity is used for return repsonse

@RestController
@RequestMapping(path = "/hotels-restapi")
public class HotelController {

    @Autowired
    HotelServiceInt hotelServiceInt;
    //adding a new hotel in database;
    @PostMapping
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel){
        System.out.println("Received request to create hotel: " + hotel);
        Hotel newHotel= hotelServiceInt.addHotel(hotel);
        HttpHeaders header=new HttpHeaders();
        header.add("description", "A New One Hotel is Added");
        return ResponseEntity.ok().headers(header).body(newHotel);
    }
    //updating a record in database;
    @PutMapping
    public ResponseEntity<String> updateHotel(@RequestBody Hotel hotel){
        hotelServiceInt.updateHotel(hotel);

        return ResponseEntity.ok("Updated");
    }
    @GetMapping("/hotels/hotel-by-id/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable int hotelId){
        Hotel hotel = hotelServiceInt.getHotelById(hotelId);
        HttpHeaders header=new HttpHeaders();
        header.add("description", "getting one hotel instance");
        return ResponseEntity.ok().headers(header).body(hotel);
    }
    @DeleteMapping("/hotels/hotel-by-id/{hotelId}")
    public ResponseEntity<Void> deleteHotel(@PathVariable int hotelId){
        // System.out.println(hotelId);
        // Hotel getHotel=hotelServiceInt.getHotelById(hotelId);
        hotelServiceInt.deleteHotelById(hotelId);
        return ResponseEntity.ok().build();
       
        // return myHotelid; 
    }

    //searching of hotel interface
    //for thie we need derived query findBy,getBy
    @GetMapping("/hotels/hotels-by-city/{cityName}")
    public ResponseEntity<List<Hotel>> getHotelsByCity(@PathVariable String cityName){
        List<Hotel> hotelList=hotelServiceInt.getHotelsByCity(cityName);
        return ResponseEntity.ok().body(hotelList);
    }

    //for this interface we develope @ query which is know
    @GetMapping("/hotels/hotels-by-menu/{menu}") 
    public ResponseEntity<List<Hotel>> getHotelByMenu(@PathVariable String menu){
        List<Hotel> hotelList=hotelServiceInt.getHotelByMenu(menu);
        return ResponseEntity.ok().body(hotelList);
    }
    
    //@querey known as JPQL in Hotel repository
    @GetMapping("/hotels/hotels-by-delivery/{partnerName}") 
    public ResponseEntity<List<Hotel>> getHotelByDelivery(@PathVariable String partnerName){
        List<Hotel> hotelList=hotelServiceInt.getHotelByDelivery(partnerName);
        return ResponseEntity.ok().body(hotelList);
    }
    @GetMapping("/hotels/hotels-by-location/{location}")
    public ResponseEntity<List<Hotel>> getHotelByLocation(@PathVariable String location){
        List<Hotel> hotelList=hotelServiceInt.getHotelByLocation(location);
        return ResponseEntity.ok().body(hotelList);
    }
    @GetMapping("/hotels/hotels-by-location/{location}/menu/{menu}")

    public ResponseEntity<List<Hotel>> getHotelByLocationAndMenu(@PathVariable String location, 
            @PathVariable String menu){
        List<Hotel> hotelList=hotelServiceInt.getHotelByLocationAndMenu(location, menu);
        return ResponseEntity.ok().body(hotelList);
    }

}
