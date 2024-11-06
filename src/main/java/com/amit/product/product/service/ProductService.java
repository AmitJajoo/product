package com.amit.product.product.service;

import com.amit.product.product.dto.ProductDTO;
import com.amit.product.product.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(Long id);
    Product createProduct(ProductDTO product);
    Product updateProduct(Long id, ProductDTO product);
    void deleteProduct(Long id);
}
