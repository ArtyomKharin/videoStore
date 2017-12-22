package com.ua.videoStore.repository;

import com.ua.videoStore.model.Catalog;
import com.ua.videoStore.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
    List<Category> findByCatalog(Catalog catalog);
}
