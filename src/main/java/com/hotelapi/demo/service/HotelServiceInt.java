package com.hotelapi.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotelapi.demo.models.Hotel;

@Service

public interface HotelServiceInt {
    //crud interface definition;
    Hotel addHotel(Hotel hotel);
    void updateHotel(Hotel hotel);
    Hotel getHotelById(int hotelId);
    void deleteHotelById(int hotelId);

    //searching of hotel interface
    List<Hotel> getHotelsByCity(String city);//for thie we need derived query findBy,getBy
    List<Hotel> getHotelByMenu(String menu);//for this interface we develope @ query which is know 
    
    //@querey known as JPQL in Hotel repository
    List<Hotel> getHotelByDelivery(String partnerName);
    List<Hotel> getHotelByLocation(String location);
    List<Hotel> getHotelByLocationAndMenu(String location, String menu);
}
