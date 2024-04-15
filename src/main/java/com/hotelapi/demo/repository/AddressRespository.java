package com.hotelapi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelapi.demo.models.Address;

@Repository
public interface AddressRespository extends JpaRepository<Address, Integer> {

}
