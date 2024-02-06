package com.ecommerce.EcommerceV1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RegisterNotFound extends RuntimeException{

    public RegisterNotFound(String message){
        super(message);
    }
}
