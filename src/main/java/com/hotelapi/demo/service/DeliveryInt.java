package com.hotelapi.demo.service;

import com.hotelapi.demo.models.Delivery;

public interface DeliveryInt {

    void updateDelivery(Delivery delivery);
    void deleteDeliveryByInt(int deliveryId);
    Delivery getDeliveryById(int deliveryId);
    Delivery getDeliveryByPartnerName(String partnerName);
}
