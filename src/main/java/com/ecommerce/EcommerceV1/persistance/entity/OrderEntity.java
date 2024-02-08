package com.ecommerce.EcommerceV1.persistance.entity;

import com.ecommerce.EcommerceV1.enums.OrderState;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;
import org.hibernate.query.sql.internal.ParameterRecognizerImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class OrderEntity {

    @Id
    @UuidGenerator
    private String idOrder;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.PERSIST)
    private List<OrderProductEntity> orderProducts;

    @Enumerated(value = EnumType.STRING)
    private OrderState orderState;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private UserEntity userEntity;

    public OrderEntity() {
        orderProducts = new ArrayList<>();
    }
    public BigDecimal getTotalOrderPrice(){
        return this.orderProducts.stream()
                .map( orderProductEntity -> orderProductEntity.getTotalItem() ).reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
