package com.ua.videoStore.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ProductFieldPK implements Serializable {
    private int productId;
    private int fieldId;

    @Column(name = "product_id", nullable = false)
    @Id
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Column(name = "field_id", nullable = false)
    @Id
    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductFieldPK that = (ProductFieldPK) o;
        return productId == that.productId &&
                fieldId == that.fieldId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(productId, fieldId);
    }
}
