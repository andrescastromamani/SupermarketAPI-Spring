package com.acm.market.persistence.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "pruchases_products")
public class PurchaseProduct {
    @EmbeddedId
    private PurchaseProductPK id;
    private  Integer mount;
    private Double total;
    private Boolean status;
}
