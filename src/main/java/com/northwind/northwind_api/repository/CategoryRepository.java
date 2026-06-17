package com.northwind.northwind_api.repository;

import com.northwind.northwind_api.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    Optional<Category> findByCategoryID(int categoryID);
    List<Category> findByCategoryNameContainingIgnoreCase(String name);

    @Query("SELECT c FROM Category c")
    List<Category> findAllWithCategory();
}