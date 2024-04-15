package com.hotelapi.demo.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_id")
    @SequenceGenerator(name = "add_id",sequenceName = "address_id",initialValue = 1, allocationSize=50 )
    private Integer addressId;
    private String streetName;
    private String city;
    private long zipcode;
    private String state;

    public Address() {
    }

    public Address(String streetName, String city, long zipcode, String state) {
        this.streetName = streetName;
        this.city = city;
        this.zipcode = zipcode;
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address [streetName=" + streetName + ", city=" + city + ", zipcode=" + zipcode + ", state=" + state
                + "]";
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getZipcode() {
        return zipcode;
    }

    public void setZipcode(long zipcode) {
        this.zipcode = zipcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
  
}
