package com.my.acc.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sell_transaction")
public class SellTransactionEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sellTransactionId;
    private Long partnerId;
    private Integer bookPage;
    private Integer bookNumber;
    private LocalDateTime sellDate;
    private BigDecimal total;
    private BigDecimal vat;
    private BigDecimal net;
    private String imagePath;
    private Boolean isCancel;
    private LocalDateTime cancelDate;
}
