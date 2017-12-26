package com.ua.videoStore.controller;

import com.ua.videoStore.model.Catalog;
import com.ua.videoStore.service.CatalogService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/catalog")
public class CatalogController {

    private final CatalogService catalogService;

    @Autowired
    public CatalogController(CatalogService catalogService) {
        this.catalogService = catalogService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Catalog>> getAllCatalog(){
        List<Catalog> catalogs = catalogService.findAll();
        if (catalogs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(catalogs, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Catalog> getCatalogById(@PathVariable Integer id){
        Catalog catalog = catalogService.findOne(id);
        if(catalog == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else{
            return new ResponseEntity<>(catalog, HttpStatus.OK);
        }

    }

}
