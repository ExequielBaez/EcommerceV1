package com.ecommerce.EcommerceV1.persistance.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity
@Data
public class ProductEntity {

    @Id
    @UuidGenerator
    private String idProduct;

    private String nameProduct;

    private String code;

    private String description;

    private String urlImage;

    private BigDecimal price;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime dateUpdated;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "idCategory")
    private CategoryEntity categoryEntity;

    private boolean enabled = true;




}
