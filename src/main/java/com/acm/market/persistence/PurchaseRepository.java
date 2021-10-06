package com.acm.market.persistence;

import com.acm.market.domain.Purchase;
import com.acm.market.persistence.crud.PurchaseCrudRepository;
import com.acm.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PurchaseRepository implements com.acm.market.domain.repository.PurchaseRepository {
    @Autowired
    private PurchaseCrudRepository purchaseCrudRepository;
    //@Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<com.acm.market.persistence.entity.Purchase>) purchaseCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String clientId) {
        return purchaseCrudRepository.findByIdClient(clientId)
                .map(purchases -> mapper.toPurchases(purchases));
    }

    @Override
    public Purchase save(Purchase purchase) {
        com.acm.market.persistence.entity.Purchase pur = mapper.toPur(purchase);
        pur.getPurchaseProductList().forEach(product -> product.setPurchase(pur));
        return mapper.toPurchase(purchaseCrudRepository.save(pur));
    }
}
