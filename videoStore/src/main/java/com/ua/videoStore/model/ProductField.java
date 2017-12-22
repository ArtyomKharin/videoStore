package com.ua.videoStore.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_field", schema = "internetshop", catalog = "")
@IdClass(ProductFieldPK.class)
public class ProductField {
    private int productId;
    private int fieldId;
    private String value;
    private Product product;
    private Field field;

    @Id
    @Column(name = "product_id", nullable = false)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Id
    @Column(name = "field_id", nullable = false)
    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    @Basic
    @Column(name = "value", nullable = true, length = 45)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductField that = (ProductField) o;
        return productId == that.productId &&
                fieldId == that.fieldId &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(productId, fieldId, value);
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false, insertable = false, updatable = false)
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @ManyToOne
    @JoinColumn(name = "field_id", referencedColumnName = "field_id", nullable = false, insertable = false, updatable = false)
    public Field getField() {
        return field;
    }

    public void setField(Field field) {
        this.field = field;
    }
}
