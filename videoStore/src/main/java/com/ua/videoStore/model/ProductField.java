package com.ua.videoStore.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_field", schema = "internetshop", catalog = "")
@IdClass(ProductFieldPK.class)
public class ProductField {
    private int productFieldId;
    private int fieldId;
    private String value;
    private Field fieldByFieldId;

    @Id
    @Column(name = "product_field_id")
    public int getProductFieldId() {
        return productFieldId;
    }

    public void setProductFieldId(int productFieldId) {
        this.productFieldId = productFieldId;
    }

    @Id
    @Column(name = "field_id")
    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    @Basic
    @Column(name = "value")
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
        return productFieldId == that.productFieldId &&
                fieldId == that.fieldId &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(productFieldId, fieldId, value);
    }

    @ManyToOne
    @JoinColumn(name = "field_id", referencedColumnName = "field_id", nullable = false, insertable=false, updatable=false)
    public Field getFieldByFieldId() {
        return fieldByFieldId;
    }

    public void setFieldByFieldId(Field fieldByFieldId) {
        this.fieldByFieldId = fieldByFieldId;
    }
}
