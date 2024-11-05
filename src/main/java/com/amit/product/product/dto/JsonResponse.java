package com.amit.product.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResponse<T> {
    private T data;
    private String message;
    private boolean success;
    private int status;
}

