package com.ecommerce.EcommerceV1.controller;

import com.ecommerce.EcommerceV1.exceptions.RegisterNotFound;
import com.ecommerce.EcommerceV1.persistance.entity.UserEntity;
import com.ecommerce.EcommerceV1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v1/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUsers(){

        List<UserEntity> userEntityList = userService.getAllUsers();

        return ResponseEntity.status(HttpStatus.OK).body(userEntityList);
    }

    @GetMapping("{idUser}")
    public ResponseEntity<?> getUserById(@PathVariable String idUser){

        UserEntity userEntity = userService.getUserById(idUser);

        return ResponseEntity.status(HttpStatus.OK).body(userEntity);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserEntity userEntity){

        UserEntity user = userService.createUser(userEntity);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

    @PutMapping("{idUser}")
    public ResponseEntity<?> disableUser(@PathVariable String idUser){

        userService.disableUser(idUser);

        //JSON{"delete" : true}
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
