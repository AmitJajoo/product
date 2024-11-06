package com.amit.product.product.exception;

import com.amit.product.product.enums.ErrorMessgaeEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(ErrorMessgaeEnum errorMessage) {
        super(errorMessage.getMessage());
    }
}