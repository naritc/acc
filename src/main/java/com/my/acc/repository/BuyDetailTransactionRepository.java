package com.my.acc.repository;

import com.my.acc.entity.BuyDetailTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BuyDetailTransactionRepository extends JpaRepository<BuyDetailTransactionEntity, Long> {
    List<BuyDetailTransactionEntity> findAllByBuyTransactionId(Long buyTransactionId);
}
