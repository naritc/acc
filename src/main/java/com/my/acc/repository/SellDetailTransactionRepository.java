package com.my.acc.repository;

import com.my.acc.entity.BuyDetailTransactionEntity;
import com.my.acc.entity.SellDetailTransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellDetailTransactionRepository extends JpaRepository<SellDetailTransactionEntity, Long> {
    List<SellDetailTransactionEntity> findAllBySellTransactionId(Long sellTransactionId);
}
