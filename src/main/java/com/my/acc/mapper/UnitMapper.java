package com.my.acc.mapper;

import com.my.acc.entity.UnitEntity;
import com.my.acc.model.NewUnit;
import com.my.acc.model.UnitDetail;

import java.util.List;

public class UnitMapper {
    public static UnitEntity newEntity(NewUnit req) {
        UnitEntity en = new UnitEntity();
        en.setName(req.getName());
        en.setDescription(req.getDescription());
        return en;
    }

    public static UnitDetail toDetail(UnitEntity en) {
        UnitDetail dt = new UnitDetail();
        dt.setUnitId(en.getUnitId());
        dt.setName(en.getName());
        dt.setDescription(en.getDescription());
        return dt;
    }
    public static List<UnitDetail> toDetail(List<UnitEntity> en) {
        return en.stream().map(UnitMapper::toDetail).toList();
    }
}
