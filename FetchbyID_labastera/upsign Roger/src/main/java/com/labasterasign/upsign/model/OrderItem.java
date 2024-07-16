package com.labasterasign.upsign.model;

import java.util.Date;

public class OrderItem {
    private String itemName;
    private Double itemPrice;
    private Date orderDate;
    private final Integer orderQuantity;

    public OrderItem(String itemOrder, Integer orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getOrderQuantity() {
        return orderQuantity;
    }
}

