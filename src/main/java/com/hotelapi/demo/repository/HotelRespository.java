package com.hotelapi.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotelapi.demo.models.Hotel;

@Repository
public interface HotelRespository extends JpaRepository<Hotel, Integer> {

    //these two are know as derived query which is builtin by repository
    //can be write by findBy, getBy
    //first the entity attribute as it is referring to aother entity then its attribute
    //like Hotel->Address->City()
    List<Hotel> findByAddressCity(String city);
    //Hotel->Address->streetName()
    List<Hotel>  findByAddressStreetName(String location);

    //these are known as @query and also known as JPQL
    @Query("FROM Hotel h INNER JOIN h.menuList mn WHERE mn.menuName=?1")
    List<Hotel> getHotelByMenu(String menuName);

    

    
    
    @Query("FROM Hotel h INNER JOIN h.deliveries d WHERE d.partnerName=?1")
    List<Hotel> getHotelByDeliveryPartnerName(String partnerName);

    @Query("FROM Hotel h INNER JOIN h.address a INNER JOIN h.menuList mn WHERE a.streetName=?1 AND mn.menuName=?2")
    List<Hotel> getHotelByLocationAndMenu(String location, String menu);
}
