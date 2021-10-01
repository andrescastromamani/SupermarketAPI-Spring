package com.acm.market.persistence.crud;

import com.acm.market.persistence.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductCrudRepository extends CrudRepository<Product, Integer> {

}
