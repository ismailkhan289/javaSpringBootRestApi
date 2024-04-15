package com.hotelapi.demo.service;

import java.util.List;

import com.hotelapi.demo.models.Menu;

public interface MenuServiceInt {

    List<Menu> getMenuByHotel(String hotel);
}
