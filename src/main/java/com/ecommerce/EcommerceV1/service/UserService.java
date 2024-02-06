package com.ecommerce.EcommerceV1.service;

import com.ecommerce.EcommerceV1.persistance.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getAllUsers();

    UserEntity getUserById(String idUser);

    UserEntity createUser(UserEntity userEntity);

    void disableUser(String idUser);
}
