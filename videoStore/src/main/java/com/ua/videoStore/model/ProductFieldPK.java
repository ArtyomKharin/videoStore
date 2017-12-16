package com.ua.videoStore.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ProductFieldPK implements Serializable {
    private int productFieldId;
    private int fieldId;

    @Column(name = "product_field_id")
    @Id
    public int getProductFieldId() {
        return productFieldId;
    }

    public void setProductFieldId(int productFieldId) {
        this.productFieldId = productFieldId;
    }

    @Column(name = "field_id")
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
        return productFieldId == that.productFieldId &&
                fieldId == that.fieldId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(productFieldId, fieldId);
    }
}
