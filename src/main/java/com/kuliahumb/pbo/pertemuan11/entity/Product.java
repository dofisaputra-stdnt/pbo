package com.kuliahumb.pbo.pertemuan11.entity;

public class Product {

    private Long code;
    private Long productLineId;
    private String name;
    private Integer scale;
    private String vendor;
    private String pdtDescription;
    private Integer qtyInStock;
    private Double buyPrice;
    private Double MSRP;

    public Product() {
    }

    public Product(Long code, Long productLineId, String name, Integer scale, String vendor, String pdtDescription, Integer qtyInStock, Double buyPrice, Double MSRP) {
        this.code = code;
        this.productLineId = productLineId;
        this.name = name;
        this.scale = scale;
        this.vendor = vendor;
        this.pdtDescription = pdtDescription;
        this.qtyInStock = qtyInStock;
        this.buyPrice = buyPrice;
        this.MSRP = MSRP;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public Long getProductLineId() {
        return productLineId;
    }

    public void setProductLineId(Long productLineId) {
        this.productLineId = productLineId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getPdtDescription() {
        return pdtDescription;
    }

    public void setPdtDescription(String pdtDescription) {
        this.pdtDescription = pdtDescription;
    }

    public Integer getQtyInStock() {
        return qtyInStock;
    }

    public void setQtyInStock(Integer qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    public Double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public Double getMSRP() {
        return MSRP;
    }

    public void setMSRP(Double MSRP) {
        this.MSRP = MSRP;
    }

}
