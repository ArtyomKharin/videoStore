package com.ua.videoStore.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class OrderItemPK implements Serializable {
    private int productId;
    private int orderId;

    @Column(name = "product_id", nullable = false)
    @Id
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Column(name = "order_id", nullable = false)
    @Id
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItemPK that = (OrderItemPK) o;
        return productId == that.productId &&
                orderId == that.orderId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(productId, orderId);
    }
}
