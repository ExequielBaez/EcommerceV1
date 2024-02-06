package com.ecommerce.EcommerceV1.persistance.entity;

import com.ecommerce.EcommerceV1.enums.UserType;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;

@Entity
@Data
public class UserEntity {
    @Id
    @UuidGenerator
    private String idUser;

    private String username;

    private String firstName;

    private String lastName;

    private String email;

    private String address;

    private String cellphone;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    @CreationTimestamp
    private LocalDateTime dateCreated;

    @UpdateTimestamp
    private LocalDateTime dateUpdated;

    private boolean enabled = true;

}
