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
public class PartnerDetail {
    private Long partnerId;
    private String taxId;
    private String name;
    private String address;
    private String address2;
    private Boolean isHeadOffice;
    private String branchName;
    private String mobileNo;
    private String mobileNo2;
    private String email;
    private String email2;
    private String contactPerson;
    private String description;
}
