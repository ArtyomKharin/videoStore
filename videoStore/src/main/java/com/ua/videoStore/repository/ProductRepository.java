package com.ua.videoStore.repository;

import com.ua.videoStore.model.Category;
import com.ua.videoStore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByCategory(Category category);
}
