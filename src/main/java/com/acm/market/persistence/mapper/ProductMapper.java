package com.acm.market.persistence.mapper;

import com.acm.market.domain.Category;
import com.acm.market.domain.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "idProduct", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "salePrice", target = "price"),
            @Mapping(source = "mountStock", target = "stock"),
            @Mapping(source = "status", target = "active"),
    })
    Product toProduct(com.acm.market.persistence.entity.Product product);

    List<Product> toProucts(List<com.acm.market.persistence.entity.Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "barCode", ignore = true)
    com.acm.market.persistence.entity.Product toCat(Product product);
}
