package com.ua.videoStore.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_item", schema = "internetshop", catalog = "")
@IdClass(OrderItemPK.class)
public class OrderItem {
    private int orderItemId;
    private int orderId;
    private int quantity;
    private double price;
    private Order orderByOrderId;

    @Id
    @Column(name = "order_item_id")
    public int getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(int orderItemId) {
        this.orderItemId = orderItemId;
    }

    @Id
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return orderItemId == orderItem.orderItemId &&
                orderId == orderItem.orderId &&
                quantity == orderItem.quantity &&
                Double.compare(orderItem.price, price) == 0;
    }

    @Override
    public int hashCode() {

        return Objects.hash(orderItemId, orderId, quantity, price);
    }

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false, insertable=false, updatable=false)
    public Order getOrderByOrderId() {
        return orderByOrderId;
    }

    public void setOrderByOrderId(Order orderByOrderId) {
        this.orderByOrderId = orderByOrderId;
    }
}
