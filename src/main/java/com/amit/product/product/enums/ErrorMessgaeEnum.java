package com.amit.product.product.enums;

import lombok.Getter;

@Getter
public enum ErrorMessgaeEnum {
    PRODUCT_NOT_FOUND("Product not found");

    private final String message;

    ErrorMessgaeEnum(String message) {
        this.message = message;
    }

}
