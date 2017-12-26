package com.ua.videoStore.controller;

import com.ua.videoStore.model.Category;
import com.ua.videoStore.service.CategoryService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("catalog/{id}/categories")
    public ResponseEntity<List<Category>> getAllCategoriesByCatalog(@PathVariable Integer id){
        List<Category> categories = categoryService.findByCatalog(id);
        if(categories == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @RequestMapping("category/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Integer id){
        Category category = categoryService.findOne(id);
        if(category == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }
}
