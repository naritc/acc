package com.my.acc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetail {
    private Long productId;
    private Long unitId;
    private String unitName;
    private String name;
    private String description;
}
