package com.ua.videoStore.service.impl;

import com.ua.videoStore.model.Category;
import com.ua.videoStore.model.Product;
import com.ua.videoStore.repository.CategoryRepository;
import com.ua.videoStore.repository.ProductRepository;
import com.ua.videoStore.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product findOne(Integer id) {
        return productRepository.findOne(id);
    }

    @Override
    public List<Product> findByCategory(Integer categoryId) {
        Category category = categoryRepository.findOne(categoryId);
        if (category == null) {
            return null;
        }
        return productRepository.findByCategory(category);
    }
}
