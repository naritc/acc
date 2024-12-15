package com.my.acc.repository;

import com.my.acc.entity.SellTransactionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SellTransactionRepository extends JpaRepository<SellTransactionEntity, Long> {
    @Query("SELECT s FROM SellTransactionEntity s ORDER BY s.sellDate DESC")
    Page<SellTransactionEntity> findAllByOrderBySellDateDesc(Pageable pageable);
}
