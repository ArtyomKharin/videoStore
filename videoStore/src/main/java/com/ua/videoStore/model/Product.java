package com.ua.videoStore.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Product {
    private int productId;
    private String title;
    private String image;
    private double currentPrice;
    private Integer categoryId;
    private Category categoryByCategoryId;

    @Id
    @Column(name = "product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
    @Column(name = "current_price")
    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Basic
    @Column(name = "category_id")
    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId &&
                Double.compare(product.currentPrice, currentPrice) == 0 &&
                Objects.equals(title, product.title) &&
                Objects.equals(image, product.image) &&
                Objects.equals(categoryId, product.categoryId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(productId, title, image, currentPrice, categoryId);
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", insertable=false, updatable=false)
    public Category getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(Category categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }
}
