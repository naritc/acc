package com.my.acc.mapper;

import com.my.acc.entity.ProductEntity;
import com.my.acc.entity.UnitEntity;
import com.my.acc.model.NewProductRequest;
import com.my.acc.model.ProductDetail;

import java.util.List;

public class ProductMapper {
    public static ProductEntity toEntity(NewProductRequest req) {
        ProductEntity en = new ProductEntity();
        en.setUnitId(req.getUnitId());
        en.setName(req.getName());
        en.setDescription(req.getDescription());
        return en;
    }

    public static ProductDetail toDetail(ProductEntity en, List<UnitEntity> unitList) {
        ProductDetail detail = new ProductDetail();
        detail.setProductId(en.getProductId());
        detail.setUnitId(en.getUnitId());
        detail.setName(en.getName());
        detail.setDescription(en.getDescription());
        detail.setUnitName(unitList.stream().filter(unit -> unit.getUnitId().equals(en.getUnitId())).map(UnitEntity::getName).findFirst().orElse(null));

        return detail;
    }

    public static List<ProductDetail> toDetail(List<ProductEntity> enList, List<UnitEntity> unitList) {
        return enList.stream().map(en -> toDetail(en, unitList)).toList();
    }
}
