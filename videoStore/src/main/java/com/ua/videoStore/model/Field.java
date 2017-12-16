package com.ua.videoStore.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Field {
    private int fieldId;
    private String name;
    private Collection<ProductField> productFieldsByFieldId;

    @Id
    @Column(name = "field_id")
    public int getFieldId() {
        return fieldId;
    }

    public void setFieldId(int fieldId) {
        this.fieldId = fieldId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Field field = (Field) o;
        return fieldId == field.fieldId &&
                Objects.equals(name, field.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fieldId, name);
    }

    @OneToMany(mappedBy = "fieldByFieldId")
    public Collection<ProductField> getProductFieldsByFieldId() {
        return productFieldsByFieldId;
    }

    public void setProductFieldsByFieldId(Collection<ProductField> productFieldsByFieldId) {
        this.productFieldsByFieldId = productFieldsByFieldId;
    }
}
