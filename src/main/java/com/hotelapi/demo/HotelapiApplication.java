package com.hotelapi.demo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hotelapi.demo.models.Address;
import com.hotelapi.demo.models.Delivery;
import com.hotelapi.demo.models.Hotel;
import com.hotelapi.demo.models.Menu;
import com.hotelapi.demo.service.DeliveryInt;
import com.hotelapi.demo.service.HotelServiceInt;
import com.hotelapi.demo.service.MenuServiceInt;

@SpringBootApplication

public class HotelapiApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(HotelapiApplication.class, args);
	}

	@Autowired
	HotelServiceInt hotelService;
	@Autowired
	DeliveryInt deliveryInt;
	@Autowired
	MenuServiceInt menuService;
	@Override
	public void run(String... args) throws Exception {
		
		// Address address=new Address("ingloStra","essen",22331,"BRW");
		// Menu menu1=new Menu("NIhari",23);
		// Menu menu2=new Menu("PoriNaan",3);
		// Set<Menu> menuList=new HashSet<>(Arrays.asList(menu1,menu2));
		// Delivery del1=deliveryInt.getDeliveryByPartnerName("Uber");		
		// Set<Delivery> deliList=new HashSet<>(Arrays.asList(del1));
		// Hotel hotel=new Hotel("Alfajar", address, menuList, deliList);
		// hotelService.addHotel(hotel);
		
					//select h.hotel_name,d.partner_name from hotel h left join hotel_delivery_my hd 
					//on hd.hotel_id=h.hotel_id left join delivery d on d.delivery_id=hd.delivery_id;
		// Hotel hotel=hotelService.getHotelById(202);
		// hotel.getAddress().setStreetName("MarktStraSe");
		// hotelService.updateHotel(hotel);
		// 		System.out.println(hotel);
		

				//these where implementation for derived queries in the repository
		// hotelService.getHotelByCity("berlin")
		// .stream()
		// .forEach((h)->System.out.println(h.getHotelName()+"  "+h.getAddress().getStreetName()));
		// System.out.println();

		// hotelService.getHotelByLocation("ing")
		// .stream()
		// .forEach((h)->System.out.println(h.getHotelName()+" "+h.getMenuList()));
		// System.out.println();

				//These are two methods program with @query knwon as JPQL in the repository Hotel

				//select h.hotel_name, m.menu_name
				//from hotel h
				//inner join menu m on m.hote_id=h.hote_id
				//where m.menu_name="sandwich";
		// hotelService.getHotelByMenu("sandwich")
		// .stream()
		// .forEach((h)->System.out.println(h.getHotelName()+" "+h.getAddress().getStreetName()));
		// System.out.println();

				//select h.hotel_name, d.partner_name 
				//from hotel h
				//inner join hotel_delivery_my hd on hd.hotel_id=h.hotel_id
				//left join delivery d on d.delivery_id=hd.delivery_id
				//where d.partner_name="TCS";
		// hotelService.getHotelByDelivery("TCS")
		// .stream()
		// .forEach((h)->System.out.println(h.getHotelName()+" "+h.getAddress().getCity()));

				//select h.hotel_name, a.address 
				//from hotel h
				//inner join menu m on m.hotel_id=h.hotel_id
				//inner join address a on a.address_id=h.hotel_id
				//where a.street_name="innstraSe" and m.menu_name="desinaan";
		// hotelService.getHotelByLocationAndMenu("innstraSe", "desinaan") 
		// .stream()
		// .forEach((h)->System.out.println(h.getHotelName()+" "+h.getAddress().getCity()));

		menuService.getMenuByHotel("kubi")
			.forEach((m)->System.out.println(m.getMenuName()+" "+m.getPrice()));

		

	}

	

}
