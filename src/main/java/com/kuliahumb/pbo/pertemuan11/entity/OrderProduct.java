package com.kuliahumb.pbo.pertemuan11.entity;

public class OrderProduct {

    private Long id;
    private Long orderId;
    private Long productCode;
    private Integer qty;
    private Double priceEach;

    public OrderProduct() {
    }

    public OrderProduct(Long id, Long orderId, Long productCode, Integer qty, Double priceEach) {
        this.id = id;
        this.orderId = orderId;
        this.productCode = productCode;
        this.qty = qty;
        this.priceEach = priceEach;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductCode() {
        return productCode;
    }

    public void setProductCode(Long productCode) {
        this.productCode = productCode;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Double getPriceEach() {
        return priceEach;
    }

    public void setPriceEach(Double priceEach) {
        this.priceEach = priceEach;
    }

}
