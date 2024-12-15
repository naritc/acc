package com.my.acc.mapper;

import com.my.acc.entity.PartnerEntity;
import com.my.acc.entity.UnitEntity;
import com.my.acc.model.NewPartnerRequest;
import com.my.acc.model.NewUnit;
import com.my.acc.model.PartnerDetail;
import com.my.acc.model.UnitDetail;

import java.util.List;

public class PartnerMapper {
    public static PartnerEntity newEntity(NewPartnerRequest req) {
        PartnerEntity en = new PartnerEntity();
        en.setTaxId(req.getTaxId());
        en.setName(req.getName());
        en.setAddress(req.getAddress());
        en.setAddress2(req.getAddress2());
        en.setIsHeadOffice(req.getIsHeadOffice());
        en.setBranchName(req.getBranchName());
        en.setMobileNo(req.getMobileNo());
        en.setMobileNo2(req.getMobileNo2());
        en.setEmail(req.getEmail());
        en.setEmail2(req.getEmail2());
        en.setContactPerson(req.getContactPerson());
        en.setDescription(req.getDescription());
        return en;
    }

    public static PartnerDetail toDetail(PartnerEntity en) {
        PartnerDetail dt = new PartnerDetail();
        dt.setTaxId(en.getTaxId());
        dt.setName(en.getName());
        dt.setAddress(en.getAddress());
        dt.setAddress2(en.getAddress2());
        dt.setIsHeadOffice(en.getIsHeadOffice());
        dt.setBranchName(en.getBranchName());
        dt.setMobileNo(en.getMobileNo());
        dt.setMobileNo2(en.getMobileNo2());
        dt.setEmail(en.getEmail());
        dt.setEmail2(en.getEmail2());
        dt.setContactPerson(en.getContactPerson());
        dt.setDescription(en.getDescription());
        return dt;
    }
    public static List<PartnerDetail> toDetail(List<PartnerEntity> en) {
        return en.stream().map(PartnerMapper::toDetail).toList();
    }
}
