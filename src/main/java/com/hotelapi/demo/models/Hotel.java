// package com.hotelapi.demo.models;

// import java.util.Set;

// import jakarta.persistence.CascadeType;
// import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.JoinTable;
// import jakarta.persistence.ManyToMany;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.OneToOne;
// import jakarta.persistence.SequenceGenerator;



// @Entity


// public class Hotel {
// 	@Id
// 	@GeneratedValue(generator = "hotel_id", strategy = GenerationType.SEQUENCE)
// 	@SequenceGenerator(name = "hot_id",sequenceName = "hotel_id",initialValue = 1, allocationSize=50  )
// 	private Integer hotelId;

// 	private String hotelName;
  
// 	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)//it is for storing the infor concurrently or synchronization 
// 	@JoinColumn(name="address_id")
// 	private Address address;

// 	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
// 	@JoinColumn(name = "hotel_id")
// 	private Set<Menu> menuList;

// 	@ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
// 	@JoinTable(name = "hotel_delivery", 
// 				joinColumns = @JoinColumn(name="hotel_id"),
// 				inverseJoinColumns = @JoinColumn(name="delivery_id"))
// 	private Set<Delivery> delivery;
	
// 	public Hotel() {
// 	}
// 	public Hotel(String hotelName, Address address, Set<Menu> menuList, Set<Delivery> delivery) {
// 		super();
// 		this.hotelName = hotelName;
// 		this.address = address;
// 		this.menuList = menuList;
// 		this.delivery = delivery;
// 	}
// 	@Override
// 	public String toString() {
// 		return "Hotel [hotelName=" + hotelName + ", address=" + address + ", menuList=" + menuList + ", delivery="
// 				+ delivery + "]";
// 	}
	
	
// }
package com.hotelapi.demo.models;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;



@Entity


public class Hotel {
	@Id
	@GeneratedValue(generator = "hotel_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "hot_id",sequenceName = "hotel_id",initialValue = 1, allocationSize=50  )
	private Integer hotelId;

	private String hotelName;
	
	//address attribute for hotel, one hotel one address
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)//it is for storing the infor concurrently or synchronization 
	@JoinColumn(name="address_id")
	private Address address;

	//menu list attribute in hotel table one hotel many menus
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "hotel_id")
	private Set<Menu> menuList=new HashSet<>();

	//delivery table Attribute in hotel, one hotel many delivery partner, on many to many
	//cascade will be persist and the hotel entity attirbute for delivery(deliveries) will be 
	//mappedby there on at Entity attribute of hotel 
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinTable(name = "hotel_delivery_my", 
				joinColumns = @JoinColumn(name="hotel_id"),
				inverseJoinColumns = @JoinColumn(name="delivery_id"))
	private Set<Delivery> deliveries=new HashSet<>();
	
	public Hotel() {
	}
	public Hotel(String hotelName, Address address, Set<Menu> menuList, Set<Delivery> deliveries) {
		super();
		this.hotelName = hotelName;
		this.address = address;
		this.menuList=menuList;
		this.deliveries=deliveries;
		
	}
	@Override
	public String toString() {
		return "Hotel [hotelName=" + hotelName + ", address=" + address + ", menuList=" + menuList + ", deliveries="
				+ deliveries + "]";
	}
	public Integer getHotelId() {
		return hotelId;
	}
	public void setHotelId(Integer hotelId) {
		this.hotelId = hotelId;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setMenuList(Set<Menu> menuList) {
		this.menuList = menuList;
	}
	public void setDeliveries(Set<Delivery> deliveries) {
		this.deliveries = deliveries;
	}
	public Address getAddress() {
		return address;
	}
	public Set<Menu> getMenuList() {
		return menuList;
	}
	public Set<Delivery> getDeliveries() {
		return deliveries;
	}
	
	
	
}