package com.hotelapi.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotelapi.demo.exceptions.HotelIdNotFoundException;
import com.hotelapi.demo.exceptions.HotelNotFoundException;
import com.hotelapi.demo.models.Hotel;

@Service

public interface HotelServiceInt {
    //crud interface definition;
    Hotel addHotel(Hotel hotel);
    void updateHotel(Hotel hotel);
    Hotel getHotelById(int hotelId) throws HotelIdNotFoundException;
    void deleteHotelById(int hotelId) throws HotelIdNotFoundException;;

    //searching of hotel interface
    List<Hotel> getHotelsByCity(String city) throws HotelNotFoundException;//for thie we need derived query findBy,getBy
    List<Hotel> getHotelByMenu(String menu) throws HotelNotFoundException;//for this interface we develope @ query which is know 
    
    //@querey known as JPQL in Hotel repository
    List<Hotel> getHotelByDelivery(String partnerName) throws HotelNotFoundException;
    List<Hotel> getHotelByLocation(String location) throws HotelNotFoundException;
    List<Hotel> getHotelByLocationAndMenu(String location, String menu) throws HotelNotFoundException;
}
