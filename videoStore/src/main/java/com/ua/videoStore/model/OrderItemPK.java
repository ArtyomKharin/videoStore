package com.ua.videoStore.model;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class OrderItemPK implements Serializable {
    private int orderItemId;
    private int orderId;

    @Column(name = "order_item_id")
    @Id
    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    @Column(name = "order_id")
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
        return orderItemId == that.orderItemId &&
                orderId == that.orderId;
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderItemId, orderId);
    }
}
