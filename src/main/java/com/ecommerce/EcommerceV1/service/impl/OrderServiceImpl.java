package com.ecommerce.EcommerceV1.service.impl;

import com.ecommerce.EcommerceV1.enums.OrderState;
import com.ecommerce.EcommerceV1.persistance.entity.OrderEntity;
import com.ecommerce.EcommerceV1.persistance.entity.UserEntity;
import com.ecommerce.EcommerceV1.persistance.repository.OrderRepository;
import com.ecommerce.EcommerceV1.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<OrderEntity> getAllorders() {
        List<OrderEntity> orderList = orderRepository.findAll();
        return orderList;
    }

    @Override
    public OrderEntity getOrderById(String idOrder) {

        OrderEntity order = orderRepository.findById(idOrder).orElseThrow();
        return order;    }

    @Override
    public OrderEntity save(OrderEntity orderEntity) {

        orderEntity.getOrderProducts().forEach(
              orderProductEntity -> orderProductEntity.setOrderEntity(orderEntity)
        );
        return orderRepository.save(orderEntity);
    }

    @Override
    public List<OrderEntity> findByUserId(String idUser) {

        UserEntity userEntity = new UserEntity();
        userEntity.setIdUser(idUser);

        return orderRepository.findByUserEntity(userEntity);

    }

    @Override
    public void updateStateById(String idOrder, String state) {
        if(state.equals(OrderState.CANCELLED.toString())){
           orderRepository.updateStateById(idOrder, OrderState.CANCELLED.toString());

        }else{
           orderRepository.updateStateById(idOrder, OrderState.CONFIRMED.toString());

        }
    }
}
