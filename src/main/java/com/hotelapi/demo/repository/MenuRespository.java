package com.hotelapi.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.hotelapi.demo.models.Menu;

@Repository
public interface MenuRespository extends JpaRepository<Menu, Integer> {

    //derived Query 
    List<Menu> findByHotelHotelName(String hotel);

    //@query Notations
    @Query("FROM Menu m INNER JOIN m.hotel h WHERE h.hotelName=?1")
    List<Menu> findByHotel(String hotel);

    //SQL Query Notation 
    @Query(value = "select * from menu m inner join hotel h on m.hotel_id=h.hotel_id where h.hotel_name=?1",nativeQuery = true)
    List<Menu> findByHotelSQLQuery(String hotel);


}
