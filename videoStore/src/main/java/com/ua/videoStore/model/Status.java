package com.ua.videoStore.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Status {
    private int statusId;
    private String title;
    private Collection<Order> ordersByStatusId;

    @Id
    @Column(name = "status_id")
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return statusId == status.statusId &&
                Objects.equals(title, status.title);
    }

    @Override
    public int hashCode() {

        return Objects.hash(statusId, title);
    }

    @OneToMany(mappedBy = "statusByStatusId")
    public Collection<Order> getOrdersByStatusId() {
        return ordersByStatusId;
    }

    public void setOrdersByStatusId(Collection<Order> ordersByStatusId) {
        this.ordersByStatusId = ordersByStatusId;
    }
}
