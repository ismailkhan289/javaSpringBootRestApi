package com.hotelapi.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelapi.demo.exceptions.HotelIdNotFoundException;
import com.hotelapi.demo.exceptions.HotelNotFoundException;
import com.hotelapi.demo.models.Hotel;
import com.hotelapi.demo.repository.HotelRespository;

import jakarta.transaction.Transactional;
import java.util.Optional;

import javax.swing.text.html.Option;

@Service
public class HotelServiceIntImpl implements HotelServiceInt {

    HotelRespository hotelRespository;
    
    @Autowired
    public HotelServiceIntImpl(HotelRespository hotelRespository) {
        this.hotelRespository = hotelRespository;
    }

    //ADD a new Hotel
    @Override
    public Hotel addHotel(Hotel hotel) {
        return hotelRespository.save(hotel);
    }

    //Update an existing Hotel
    @Override
    @Transactional
    public void updateHotel(Hotel hotel) {
        hotelRespository.save(hotel);

    }

    //Get an Hotel By its ID
    @Override
    public Hotel getHotelById(int hotelId) {
        return hotelRespository
                .findById(hotelId)
                .orElseThrow(()->new HotelIdNotFoundException("Hotel with this Id not Found"));

    }

    //Delete Hotel by it ID
    @Override
    @Transactional
    public void deleteHotelById(int hotelId) {
       if(hotelId<=0){
        throw new RuntimeException("The is hotel id invalid or not found");
       }
        hotelRespository.deleteById(hotelId);
    }

    @Override
    public List<Hotel> getHotelsByCity(String city) {
        List<Hotel> hotelList= hotelRespository.findByAddressCity(city);
        if(hotelList.isEmpty()){
            throw new HotelNotFoundException("Hotel with city Name is Not exist");
        }
        return hotelList;
    }

    @Override
    public List<Hotel> getHotelByLocation(String location) {
        List<Hotel> hotelsList=hotelRespository.findByAddressStreetName(location);
        if(hotelsList.isEmpty()){
            throw new HotelNotFoundException("Hotel with this street/ location is not exist.");
        }
        return hotelsList;
    }

    @Override
    public List<Hotel> getHotelByMenu(String menu) {
        List<Hotel> hotelsList=hotelRespository.getHotelByMenu(menu);
        if(hotelsList.isEmpty()){
            throw new HotelNotFoundException("Hotel with menu is not exist.");
        }
        return hotelsList;
    }

    @Override
    public List<Hotel> getHotelByDelivery(String partnerName) {
        List<Hotel> hotelsList=hotelRespository.getHotelByDeliveryPartnerName(partnerName);
        if(hotelsList.isEmpty()){
            throw new HotelNotFoundException("Hotel with this delivery partner is not available.");
        }
        return hotelsList;
    }

    @Override
    public List<Hotel> getHotelByLocationAndMenu(String location, String menu) {
        List<Hotel> hotelsList=hotelRespository.getHotelByLocationAndMenu(location,menu);
        if(hotelsList.isEmpty()){
            throw new HotelNotFoundException("Hotel with this location and menu is not exist.");
        }
        return hotelsList;
        
    }

}
