package org.example.gagrics_admin_app;

import org.json.JSONArray;
import org.json.JSONObject;

public class Order {
    JSONObject paymentInfo;
    String id;
    JSONObject cartProduct;
    JSONObject shippingAddress;
    JSONObject user;
    int totalPrice;
    String status;
    String paidAt;
    String createdAt;
    String deliveredAt;


    public Order() {
        this.paymentInfo = paymentInfo;
        this.id = id;
        this.cartProduct = cartProduct;
        this.shippingAddress = shippingAddress;
        this.user = user;
        this.totalPrice = totalPrice;
        this.status = status;
        this.paidAt = paidAt;
        this.createdAt = createdAt;
        this.deliveredAt = deliveredAt;
    }

    public JSONObject getPaymentInfo() {
        return paymentInfo;
    }

    public void setPaymentInfo(JSONObject paymentInfo) {
        this.paymentInfo = paymentInfo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public JSONObject getCartProduct() {
        return cartProduct;
    }

    public void setCartProduct(JSONObject cartProduct) {
        this.cartProduct = cartProduct;
    }

    public JSONObject getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(JSONObject shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public JSONObject getUser() {
        return user;
    }

    public void setUser(JSONObject user) {
        this.user = user;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPaidAt() {
        return paidAt;
    }

    public void setPaidAt(String paidAt) {
        this.paidAt = paidAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getDeliveredAt() {
        return deliveredAt;
    }

    public void setDeliveredAt(String deliveredAt) {
        this.deliveredAt = deliveredAt;
    }
}
