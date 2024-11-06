package com.amit.product.product.controller;


import com.amit.product.product.dto.JsonResponse;
import com.amit.product.product.dto.ProductDTO;
import com.amit.product.product.entity.Product;
import com.amit.product.product.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public ResponseEntity<JsonResponse<List<Product>>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        JsonResponse<List<Product>> response = new JsonResponse<>(products, "Products retrieved successfully",true, HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JsonResponse<Product>> getProductById(@PathVariable Long id) {
        Product product = productService.getProductById(id);
        JsonResponse<Product> response = new JsonResponse<>(product, "Product retrieved successfully",true,  HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<JsonResponse<Product>> createProduct(@Valid @RequestBody ProductDTO product) {
        Product createdProduct = productService.createProduct(product);
        JsonResponse<Product> response = new JsonResponse<>(createdProduct, "Product created successfully", true, HttpStatus.CREATED.value());
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JsonResponse<Product>> updateProduct(@PathVariable Long id, @Valid @RequestBody ProductDTO product) {
        Product updatedProduct = productService.updateProduct(id, product);
        JsonResponse<Product> response = new JsonResponse<>(updatedProduct, "Product updated successfully",true,  HttpStatus.OK.value());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JsonResponse<Void>> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        JsonResponse<Void> response = new JsonResponse<>(null, "Product deleted successfully", true, HttpStatus.NO_CONTENT.value());
        return new ResponseEntity<>(response,HttpStatus.NO_CONTENT);
    }

}
