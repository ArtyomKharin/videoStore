package com.ua.videoStore.service;

import com.ua.videoStore.model.Product;

import java.util.List;

public interface ProductService {

    Product findOne(Integer id);

    List<Product> findByCategory(Integer categoryId);
}
