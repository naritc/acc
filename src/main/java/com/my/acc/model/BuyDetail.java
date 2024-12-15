package com.my.acc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BuyDetail {
    private Long buyDetailTransactionId;
    private Long buyTransactionId;
    private Long productId;
    private BigDecimal quantity;
    private BigDecimal price;
    private BigDecimal total;
}