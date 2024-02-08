package com.ecommerce.EcommerceV1.persistance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;

@Entity
@Data
public class OrderProductEntity {
    @Id
    @UuidGenerator
    private String idOrderProduct;
    private BigDecimal quantity;
    private BigDecimal price;
    private String idProduct;

    @ManyToOne
    @JoinColumn(name = "idOrder")
    private OrderEntity orderEntity;
    public BigDecimal getTotalItem(){

        return this.price.multiply(quantity);

    }
}
