package com.ua.videoStore.service.impl;

import com.ua.videoStore.model.Catalog;
import com.ua.videoStore.model.Category;
import com.ua.videoStore.repository.CatalogRepository;
import com.ua.videoStore.repository.CategoryRepository;
import com.ua.videoStore.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CatalogRepository catalogRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository, CatalogRepository catalogRepository) {
        this.categoryRepository = categoryRepository;
        this.catalogRepository = catalogRepository;
    }


    @Override
    public List<Category> findByCatalog(Integer catalogId) {
        Catalog catalog = catalogRepository.findOne(catalogId);
        if(catalog == null) {
            return null;
        }
        return categoryRepository.findByCatalog(catalog);
    }

    @Override
    public Category findOne(Integer id) {
        return categoryRepository.findOne(id);
    }


}
