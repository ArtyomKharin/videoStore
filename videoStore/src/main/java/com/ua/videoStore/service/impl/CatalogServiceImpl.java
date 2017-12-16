package com.ua.videoStore.service.impl;

import com.ua.videoStore.model.Catalog;
import com.ua.videoStore.repository.CatalogRepository;
import com.ua.videoStore.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    private final CatalogRepository catalogRepository;

    @Autowired
    public CatalogServiceImpl(CatalogRepository catalogRepository) {
        this.catalogRepository = catalogRepository;
    }

    @Override
    public List<Catalog> findAll() {
        return catalogRepository.findAll();
    }

    @Override
    public Catalog findOne(Integer id) {
        return catalogRepository.findOne(id);
    }
}
