package com.hotelapi.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Hotel addHotel(Hotel hotel) {
        return hotelRespository.save(hotel);
    }

    @Override
    @Transactional
    public void updateHotel(Hotel hotel) {
        hotelRespository.save(hotel);

    }

    @Override
    public Hotel getHotelById(int hotelId) {
        return hotelRespository.findById(hotelId).get();

    }

    @Override
    @Transactional
    public void deleteHotelById(int hotelId) {
       hotelRespository.deleteById(hotelId);
    }

    @Override
    public List<Hotel> getHotelsByCity(String city) {
        return hotelRespository.findByAddressCity(city);
    }

    @Override
    public List<Hotel> getHotelByLocation(String location) {
        return hotelRespository.findByAddressStreetName(location);
    }

    @Override
    public List<Hotel> getHotelByMenu(String menu) {
        return hotelRespository.getHotelByMenu(menu);
    }

    @Override
    public List<Hotel> getHotelByDelivery(String partnerName) {
        return hotelRespository.getHotelByDeliveryPartnerName(partnerName);
    }

    @Override
    public List<Hotel> getHotelByLocationAndMenu(String location, String menu) {
        return hotelRespository.getHotelByLocationAndMenu(location, menu);
        
    }

}
