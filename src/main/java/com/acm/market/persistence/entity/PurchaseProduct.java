package com.acm.market.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "pruchases_products")
public class PurchaseProduct {
    @EmbeddedId
    private PurchaseProductPK id;
    private Integer mount;
    private Double total;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = "id_product", insertable = false, updatable = false)
    private Product product;

    @ManyToOne
    @MapsId("idPurchase")
    @JoinColumn(name = "id_purchase", insertable = false, updatable = false)
    private Purchase purchase;

    public PurchaseProductPK getId() {
        return id;
    }

    public void setId(PurchaseProductPK id) {
        this.id = id;
    }

    public Integer getMount() {
        return mount;
    }

    public void setMount(Integer mount) {
        this.mount = mount;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Purchase getPurchase() {
        return purchase;
    }

    public void setPurchase(Purchase purchase) {
        this.purchase = purchase;
    }
}
