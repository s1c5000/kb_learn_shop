package com.kb.shop.controller;

import com.kb.shop.domain.ShippingInfo;
import com.kb.shop.repository.ShippingRepository;
import com.kb.shop.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/shipping")
public class ShippingController {

    // 배송 정보를 생성하는 POST 호출을 생성합니다. (path : /shipping)
    // 배송 Status를 변경하는 PUT 호출을 생성합니다. (path : /shipping)
    // 배송 정보를 확인하는 GET 호출을 생성합니다.  (path : /shipping)

    @Autowired
    private ShippingService shippingService;

    @GetMapping("/shiiping/{id}")
    public ResponseEntity<ShippingInfo> getShippingInfo(@PathVariable Long id){
        ShippingInfo shippingInfo = new ShippingInfo();
        shippingInfo = shippingService.getShippingInfo(id);

        if (shippingInfo != null){
            return new ResponseEntity<>(shippingInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/")
    public ResponseEntity<ShippingInfo> setShiipingInfo(@RequestBody ShippingInfo shippingInfo){
        ShippingInfo newShippingInfo = new ShippingInfo();
        newShippingInfo = shippingService.setShippingInfo(shippingInfo);
        if (newShippingInfo != null){
            return new ResponseEntity<>(newShippingInfo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



//    @PostMapping("/shipping")
//    public ResponseEntity<ShippingInfo> setShippingInfo(@RequestParam ShippingInfo shippingInfo) {
//        Optional<ShippingInfo> newShippingInfo = Optional.of(new ShippingInfo());
//        newShippingInfo = shippingService.setShippingInfo(shippingInfo);
//        if (newShippingInfo != null){
//            return new ResponseEntity<>(newShippingInfo, HttpStatus.OK);
//        }
////        Optional<ShippingInfo> newShippingInfo = ShippingService.setShippingInfo(shippingInfo);
//
//
//    }

}
