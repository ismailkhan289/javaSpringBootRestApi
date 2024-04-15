package com.hotelapi.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelapi.demo.models.Delivery;
import com.hotelapi.demo.repository.DeliveryRespository;

@Service
public class DeliveryImpl implements DeliveryInt{

    @Autowired
    DeliveryRespository deliveryRespository;
    @Override
    public void updateDelivery(Delivery delivery) {
            deliveryRespository.save(delivery);
    }

    @Override
    public void deleteDeliveryByInt(int deliveryId) {
            deliveryRespository.deleteById(deliveryId);
    }

    @Override
    public Delivery getDeliveryById(int deliveryId) {
            return deliveryRespository.findById(deliveryId).get();
        
    }

    @Override
    public Delivery getDeliveryByPartnerName(String partnerName) {
        
        return deliveryRespository.findByPartnerName(partnerName);
    }

}
