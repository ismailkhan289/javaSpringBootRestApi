package com.hotelapi.demo.exceptions;

public class HotelNotFoundException extends RuntimeException {

    private static final long serialVersionUID=1L;

    public HotelNotFoundException(){
        super();

    }
    public HotelNotFoundException(String message){
        super(message);
    }

 
    
    
}
