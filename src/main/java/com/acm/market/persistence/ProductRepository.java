package com.acm.market.persistence;

import com.acm.market.persistence.crud.ProductCrudRepository;
import com.acm.market.persistence.entity.Product;
import com.acm.market.persistence.mapper.ProductMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements com.acm.market.domain.repository.ProductRepository {
    private ProductCrudRepository productCrudRepository;
    private ProductMapper mapper;

    @Override
    public List<com.acm.market.domain.Product> getAll() {
        List<Product> productList = (List<Product>) productCrudRepository.findAll();
        return mapper.toProucts(productList);
    }

    @Override
    public Optional<List<com.acm.market.domain.Product>> getByCategory(int idCategory) {
        List<Product> products = productCrudRepository.findByIdCategoryOrderByNameAsc(idCategory);
        return Optional.of(mapper.toProucts(products));
    }

    @Override
    public Optional<List<com.acm.market.domain.Product>> getStockProducts(int mount) {
        Optional<List<Product>> products = productCrudRepository.findByMountStockLessThanAndStatus(mount, true);
        return products.map(prods -> mapper.toProucts(prods));
    }

    @Override
    public Optional<com.acm.market.domain.Product> getProduct(int productId) {
        return productCrudRepository.findById(productId).map(product -> mapper.toProduct(product));
    }

    @Override
    public com.acm.market.domain.Product save(com.acm.market.domain.Product product) {
        Product prod = mapper.toProd(product);
        return mapper.toProduct(productCrudRepository.save(prod));
    }

    @Override
    public void delete(int productId) {
        productCrudRepository.deleteById(productId);
    }
}
