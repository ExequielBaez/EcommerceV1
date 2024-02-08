package com.ecommerce.EcommerceV1.controller;

import com.ecommerce.EcommerceV1.persistance.entity.OrderEntity;
import com.ecommerce.EcommerceV1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/api/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<?> getAllorders(){
       // List<OrderEntity> orderList = orderService.getAllorders();
        return ResponseEntity.status(HttpStatus.OK).body(orderService.getAllorders());
    }

    @GetMapping("/{idOrder}")
    public ResponseEntity<?> getorderById(@PathVariable String idOrder){
        OrderEntity order = orderService.getOrderById(idOrder);
        return ResponseEntity.status(HttpStatus.OK).body(order);

    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderEntity orderEntity){
        OrderEntity order = orderService.save(orderEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(order);
    }

    @PostMapping("/update/state")
    public ResponseEntity<?> updateStateById(@RequestParam String idOrder, @RequestParam String state){
        //orderService.updateStateById(idOrder, state);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
