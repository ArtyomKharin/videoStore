package com.ua.videoStore.service;

import com.ua.videoStore.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> findByCatalog(Integer catalogId);

    Category findOne(Integer id);

}
