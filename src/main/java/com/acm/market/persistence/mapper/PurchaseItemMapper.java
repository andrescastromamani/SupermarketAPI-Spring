package com.acm.market.persistence.mapper;

import com.acm.market.domain.PurchaseItem;
import com.acm.market.persistence.entity.PurchaseProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
            @Mapping(source = "id.idProduct", target = "productId"),
            @Mapping(source = "mount", target = "quantity"),
            @Mapping(source = "total", target = "total"),//if var isEqual is not necesary
            @Mapping(source = "status", target = "active"),
    })
    PurchaseItem toPurchaseItem(PurchaseProduct product);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "purchase", ignore = true),
            @Mapping(target = "id.idPurchase", ignore = true),
    })
    PurchaseProduct toPurchaseProduct(PurchaseItem purchaseItem);
}
