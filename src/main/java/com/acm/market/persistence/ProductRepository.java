package com.acm.market.persistence;

import com.acm.market.persistence.crud.ProductCrudRepository;
import com.acm.market.persistence.entity.Product;

import java.util.List;

public class ProductRepository {
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll() {
        return (List<Product>) productCrudRepository.findAll();
    }

}
