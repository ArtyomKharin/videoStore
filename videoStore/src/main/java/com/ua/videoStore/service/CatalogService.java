package com.ua.videoStore.service;

import com.ua.videoStore.model.Catalog;

import java.util.List;


public interface CatalogService {

    List<Catalog> findAll();

    Catalog findOne(Integer id);

}
