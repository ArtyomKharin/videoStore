package com.ua.videoStore.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Category {
    private int categoryId;
    private String title;
    private String image;
    private int catalogId;
    private Catalog catalogByCatalogId;
    private Collection<Product> productsByCategoryId;

    @Id
    @Column(name = "category_id")
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
    @Column(name = "catalog_id")
    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return categoryId == category.categoryId &&
                catalogId == category.catalogId &&
                Objects.equals(title, category.title) &&
                Objects.equals(image, category.image);
    }

    @Override
    public int hashCode() {

        return Objects.hash(categoryId, title, image, catalogId);
    }

    @ManyToOne
    @JoinColumn(name = "catalog_id", referencedColumnName = "catalog_id", nullable = false, insertable=false, updatable=false)
    public Catalog getCatalogByCatalogId() {
        return catalogByCatalogId;
    }

    public void setCatalogByCatalogId(Catalog catalogByCatalogId) {
        this.catalogByCatalogId = catalogByCatalogId;
    }

    @OneToMany(mappedBy = "categoryByCategoryId")
    public Collection<Product> getProductsByCategoryId() {
        return productsByCategoryId;
    }

    public void setProductsByCategoryId(Collection<Product> productsByCategoryId) {
        this.productsByCategoryId = productsByCategoryId;
    }
}
