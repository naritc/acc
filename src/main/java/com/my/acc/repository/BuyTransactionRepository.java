package com.my.acc.repository;

import com.my.acc.entity.BuyTransactionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyTransactionRepository extends JpaRepository<BuyTransactionEntity, Long> {
    @Query("SELECT b FROM BuyTransactionEntity b ORDER BY b.buyDate DESC")
    Page<BuyTransactionEntity> findAllByOrderByBuyDateDesc(Pageable pageable);
}
