package com.hotelapi.demo.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
    @JsonIgnore 
    private Set<Hotel> hotelList = new HashSet<>();
    
    public Delivery() {
    }

    public Delivery(String partnerName, double charges) {
        this.partnerName = partnerName;
        this.charges = charges;
    }
    
    public String getPartnerName() {
		return partnerName;
	}

	public void setPartnerName(String partnerName) {
		this.partnerName = partnerName;
	}

	public double getCharges() {
		return charges;
	}

	public void setCharges(double charges) {
		this.charges = charges;
	}

	public Set<Hotel> getHotelList() {
		return hotelList;
	}

	public void setHotelList(Set<Hotel> hotelList) {
		this.hotelList = hotelList;
	}

	

    @Override
    public String toString() {
        return "Delivery [deliveryId=" + deliveryId + ", partnerName=" + partnerName + ", charges=" + charges
                + ", hotelList=" + hotelList + "]";
    }

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    
}
