package com.hotelapi.demo.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "delivery_id")
    @SequenceGenerator(name = "del_id",sequenceName = "delivery_id", initialValue = 1, allocationSize=50 )
    private Integer deliveryId;
    private String partnerName;
    private double charges;
    
    //Referencing hotel table
    @ManyToMany(mappedBy = "deliveries",cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
    private Set<Hotel> hotelList = new HashSet<>();
    
    public Delivery() {
    }

    public Delivery(String partnerName, double charges) {
        this.partnerName = partnerName;
        this.charges = charges;
    }
    @Override
    public String toString() {
        return "Delivery [partnerName=" + partnerName + ", charges=" + charges + "]";
    }

    
}
