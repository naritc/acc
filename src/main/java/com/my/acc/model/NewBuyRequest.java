package com.my.acc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class NewBuyRequest {
    private Long partnerId;
    private Integer bookPage;
    private Integer bookNumber;
    private LocalDateTime buyDate;
    private BigDecimal total;
    private BigDecimal vat;
    private BigDecimal net;
    private String imagePath;
    private List<NewBuyDetail> details;
}
