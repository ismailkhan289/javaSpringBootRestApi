package com.hotelapi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelapi.demo.models.Delivery;

@Repository
public interface DeliveryRespository extends JpaRepository<Delivery, Integer> {

    Delivery findByPartnerName(String partnerName);
}
