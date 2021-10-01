package com.acm.market.domain.repository;

import com.acm.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();

    Optional<List<Product>> getByCategory(int categoryId);

    Optional<List<Product>> getStockProducts(int mount);

    Optional<Product> getProduct(int productId);

    Product save(Product product);

    void delete(int productId);

}
