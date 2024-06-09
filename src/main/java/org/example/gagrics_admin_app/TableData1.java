package org.example.gagrics_admin_app;

public class TableData1 {
    String orderId;
    String orderStatus;
    int qty;
    int total;
    String orderDate;
    String sellerEmail;
    String buyerEmail;

    public TableData1() {
        this.orderId = orderId;
        this.orderStatus = orderStatus;
        this.qty = qty;
        this.total = total;
        this.orderDate = orderDate;
        this.sellerEmail = sellerEmail;
        this.buyerEmail = buyerEmail;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getSellerEmail() {
        return sellerEmail;
    }

    public void setSellerEmail(String sellerEmail) {
        this.sellerEmail = sellerEmail;
    }

    public String getBuyerEmail() {
        return buyerEmail;
    }

    public void setBuyerEmail(String buyerEmail) {
        this.buyerEmail = buyerEmail;
    }
}
