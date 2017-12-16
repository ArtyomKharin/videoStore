package com.ua.videoStore.repository;

import com.ua.videoStore.model.Catalog;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CatalogRepository extends JpaRepository<Catalog, Integer> {

}
