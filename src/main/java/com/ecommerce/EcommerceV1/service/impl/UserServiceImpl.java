package com.ecommerce.EcommerceV1.service.impl;

import com.ecommerce.EcommerceV1.exceptions.RegisterNotFound;
import com.ecommerce.EcommerceV1.persistance.entity.UserEntity;
import com.ecommerce.EcommerceV1.persistance.repository.UserRepository;
import com.ecommerce.EcommerceV1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public List<UserEntity> getAllUsers() {

        List<UserEntity> userList = userRepository.findAll();
        return userList;
    }

    @Override
    public UserEntity getUserById(String idUser) {

        UserEntity userEntity = userRepository.findById(idUser).orElseThrow();

        return userEntity;
    }

    @Override
    public UserEntity createUser(UserEntity userEntity) {

        return userRepository.save(userEntity);
    }

    @Override
    public void disableUser(String idUser) {

        UserEntity user = userRepository.findById(idUser)
                .orElseThrow( () -> new RegisterNotFound("User Not Found with id " +idUser));

        user.setEnabled(false);

        userRepository.save(user);
    }
}
