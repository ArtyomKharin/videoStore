package com.ua.videoStore.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Catalog {
    private int catalogId;
    private String image;
    private String title;
    private Collection<Category> categoriesByCatalogId;

    @Id
    @Column(name = "catalog_id")
    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catalog catalog = (Catalog) o;
        return catalogId == catalog.catalogId &&
                Objects.equals(image, catalog.image) &&
                Objects.equals(title, catalog.title);
    }

    @Override
    public int hashCode() {

        return Objects.hash(catalogId, image, title);
    }

    @OneToMany(mappedBy = "catalogByCatalogId")
    public Collection<Category> getCategoriesByCatalogId() {
        return categoriesByCatalogId;
    }

    public void setCategoriesByCatalogId(Collection<Category> categoriesByCatalogId) {
        this.categoriesByCatalogId = categoriesByCatalogId;
    }
}
