package com.northwind.northwind_api.service;

import com.northwind.northwind_api.model.Product;
import com.northwind.northwind_api.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(int id) {
        return productRepository.findById(id);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product createProduct(Product product, String productName) {
        return productRepository.save(product);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public List<Product> getProductByCategoryID(int categoryID) {
        return productRepository.findByCategoryID(categoryID);
    }

    public List<Product> findByProductNameContainingIgnoreCase(String productName) {
        return productRepository.findByProductNameContainingIgnoreCase(productName);
    }
}
