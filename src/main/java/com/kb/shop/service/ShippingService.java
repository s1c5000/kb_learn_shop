package com.kb.shop.service;

import com.kb.shop.domain.ShippingInfo;
import com.kb.shop.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShippingService {

    @Autowired
    ShippingRepository shippingRepository;

    public ShippingInfo getShippingInfo (Long id) {
        return shippingRepository.selectShippingInfo(id);
    }

    public ShippingInfo setShippingInfo (ShippingInfo shippingInfo){
        shippingRepository.setShippingInfo(shippingInfo);
        return getShippingInfo(shippingInfo.getId());
    }


}
