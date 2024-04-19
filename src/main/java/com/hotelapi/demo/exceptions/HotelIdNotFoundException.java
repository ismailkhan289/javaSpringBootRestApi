package com.hotelapi.demo.exceptions;

public class HotelIdNotFoundException extends RuntimeException {

    private static final long serialVersionUID=1L;

    public HotelIdNotFoundException(){
        super();

    }
    public HotelIdNotFoundException(String message){
        super(message);
    }

 
    
    
}
