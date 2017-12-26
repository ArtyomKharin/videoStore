package com.ua.videoStore.model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Product {
    private int productId;
    private String title;
    private String image;
    private double currentPrice;
    @JsonIdentityReference(alwaysAsId = true)
    private Collection<OrderItem> orderItems;
    private Category category;
    @JsonIdentityReference(alwaysAsId = true)
    private Collection<ProductField> productFields;

    @Id
    @Column(name = "product_id", nullable = false)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "title", nullable = false, length = 45)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "image", nullable = false, length = 60)
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "current_price", nullable = false, precision = 0)
    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId &&
                Double.compare(product.currentPrice, currentPrice) == 0 &&
                Objects.equals(title, product.title) &&
                Objects.equals(image, product.image);
    }

    @Override
    public int hashCode() {

        return Objects.hash(productId, title, image, currentPrice);
    }

    @OneToMany(mappedBy = "product")
    public Collection<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Collection<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", insertable = false, updatable = false)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @OneToMany(mappedBy = "product")
    public Collection<ProductField> getProductFields() {
        return productFields;
    }

    public void setProductFields(Collection<ProductField> productFields) {
        this.productFields = productFields;
    }
}
