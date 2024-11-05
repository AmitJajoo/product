package com.amit.product.product.controller;


import com.amit.product.product.dto.JsonResponse;
import com.amit.product.product.entity.Product;
import com.amit.product.product.service.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductServiceImpl productServiceImpl;

    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    @GetMapping
    public ResponseEntity<JsonResponse<List<Product>>> getAllProducts() {
        List<Product> products = productServiceImpl.getAllProducts();
        JsonResponse<List<Product>> response = new JsonResponse<>(products, "Products retrieved successfully",true, HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JsonResponse<Product>> getProductById(@PathVariable Long id) {
        Product product = productServiceImpl.getProductById(id);
        JsonResponse<Product> response = new JsonResponse<>(product, "Product retrieved successfully",true,  HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<JsonResponse<Product>> createProduct(@Valid @RequestBody Product product) {
        Product createdProduct = productServiceImpl.createProduct(product);
        JsonResponse<Product> response = new JsonResponse<>(createdProduct, "Product created successfully", true, HttpStatus.CREATED.value());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JsonResponse<Product>> updateProduct(@PathVariable Long id, @Valid @RequestBody Product product) {
        Product updatedProduct = productServiceImpl.updateProduct(id, product);
        JsonResponse<Product> response = new JsonResponse<>(product, "Product updated successfully",true,  HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JsonResponse<Void>> deleteProduct(@PathVariable Long id) {
        productServiceImpl.deleteProduct(id);
        JsonResponse<Void> response = new JsonResponse<>(null, "Product deleted successfully", true, HttpStatus.NO_CONTENT.value());
        return new ResponseEntity<>(response,HttpStatus.NO_CONTENT);
    }

}