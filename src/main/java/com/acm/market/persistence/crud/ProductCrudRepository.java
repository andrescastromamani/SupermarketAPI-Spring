package com.acm.market.persistence.crud;

import com.acm.market.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {
    List<Product> findByIdCategoryOrderByNameAsc(int idProduct);

    Optional<List<Product>> findByMountStockLessThanAndStatus(int mountStock, boolean status);
}
