package com.hotelapi.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelapi.demo.models.Menu;
import com.hotelapi.demo.repository.MenuRespository;

@Service
public class MenuServiceImpl implements MenuServiceInt {

    @Autowired
    MenuRespository menuRespository;

    @Override
    public List<Menu> getMenuByHotel(String hotel) {
        // return menuRespository.findByHotelHotelName(hotel);
        // return menuRespository.findByHotel(hotel);
        return menuRespository.findByHotelHotelName(hotel);
    }

}
