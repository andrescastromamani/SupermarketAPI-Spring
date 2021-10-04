package com.acm.market.persistence.mapper;

import com.acm.market.domain.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategory", target = "categoryId"),
            @Mapping(source = "description", target = "category"),
            @Mapping(source = "status", target = "active")
    })
    Category toCategory(com.acm.market.persistence.entity.Category category);

    @InheritInverseConfiguration
    @Mapping(target = "productList", ignore = true)
    com.acm.market.persistence.entity.Category toCat(Category category);
}
