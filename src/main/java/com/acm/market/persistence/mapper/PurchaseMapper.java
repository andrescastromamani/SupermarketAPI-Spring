package com.acm.market.persistence.mapper;

import com.acm.market.domain.Purchase;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {
    @Mappings({
            @Mapping(source = "idPurchase", target = "purchaseId"),
            @Mapping(source = "idClient", target = "clientId"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "paymentMethod", target = "paymentMethod"),
            @Mapping(source = "comment", target = "comment"),
            @Mapping(source = "status", target = "state"),
            @Mapping(source = "purchaseProductList", target = "items"),
    })
    Purchase toPurchase(com.acm.market.persistence.entity.Purchase purchase);

    List<Purchase> toPurchases(List<com.acm.market.persistence.entity.Purchase> purchases);

    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    com.acm.market.persistence.entity.Purchase toPur(Purchase purchase);
}
