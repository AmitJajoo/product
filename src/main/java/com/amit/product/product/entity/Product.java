package com.amit.product.product.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Product name cannot be null")
    @Size(min = 3, message = "Product name should have at least 3 characters")
    private String name;

    private String description;

    @NotNull(message = "Product price cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Product price must be greater than 0")
    private Double price;
}
