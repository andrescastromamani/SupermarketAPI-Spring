package com.acm.market.persistence;

import com.acm.market.persistence.crud.ProductCrudRepository;
import com.acm.market.persistence.entity.Product;

import java.util.List;
import java.util.Optional;

public class ProductRepository {
    private ProductCrudRepository productCrudRepository;

    public List<Product> getAll() {
        return (List<Product>) productCrudRepository.findAll();
    }

    public List<Product> getByCategory(int idCategory) {
        return productCrudRepository.findByIdCategoryOrderByNameAsc(idCategory);
    }

    public Optional<List<Product>> getStock(int mount) {
        return productCrudRepository.findByMountStockLessThanAndStatus(mount, true);
    }
}
