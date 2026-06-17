package com.northwind.northwind_api.repository;

import com.northwind.northwind_api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByProductID(int productID);
    List<Product> findByProductNameContainingIgnoreCase(String productName);
    List<Product> findBySupplierID(int supplierID);
    List<Product> findByCategoryID(int categoryID);
    List<Product> findBySupplierIDAndCategoryID(int supplierID, int categoryID);
    List<Product> findByCategoryIDAndSupplierID(int categoryID, int supplierID);

    @Query("SELECT p " +
            "FROM Product p " +
            "LEFT JOIN FETCH p.category")
    List<Product> findAllWithCategory();
}