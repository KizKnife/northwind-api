package com.northwind.northwind_api.controller;

import com.northwind.northwind_api.model.Product;
import com.northwind.northwind_api.repository.ProductRepository;
import com.northwind.northwind_api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")

public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        return productService.getProductById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("category/{categoryID}")
    public List<Product> getProductByCategoryID(@PathVariable int categoryID) {
        return productService.getProductByCategoryID(categoryID);
    }

    @GetMapping("search/{productName}")
    public List<Product> findByProductNameContainingIgnoreCase(@PathVariable String productName) {
        return productService.findByProductNameContainingIgnoreCase(productName);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
