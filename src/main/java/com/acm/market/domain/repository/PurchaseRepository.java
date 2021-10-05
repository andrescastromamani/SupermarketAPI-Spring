package com.acm.market.domain.repository;

import com.acm.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();

    Optional<List<Purchase>> getByClient(String ClientId);

    Purchase save(Purchase purchase);
}
