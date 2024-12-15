package com.my.acc.mapper;

import com.my.acc.entity.SellDetailTransactionEntity;
import com.my.acc.model.NewSellDetail;
import com.my.acc.model.SellDetail;

import java.util.List;

public class SellDetailMapper {
    public static SellDetailTransactionEntity toEntity(NewSellDetail req, Long tranId) {
        SellDetailTransactionEntity en = new SellDetailTransactionEntity();
        en.setSellTransactionId(tranId);
        en.setProductId(req.getProductId());
        en.setQuantity(req.getQuantity());
        en.setPrice(req.getPrice());
        en.setTotal(req.getQuantity().multiply(req.getPrice()));
        return en;
    }

    public static SellDetail toDetail(SellDetailTransactionEntity en) {
        SellDetail detail = new SellDetail();
        detail.setSellDetailTransactionId(en.getSellDetailTransactionId());
        detail.setSellTransactionId(en.getSellTransactionId());
        detail.setProductId(en.getProductId());
        detail.setQuantity(en.getQuantity());
        detail.setPrice(en.getPrice());
        detail.setTotal(en.getTotal());
        return detail;
    }

    public static List<SellDetailTransactionEntity> toEntity(List<NewSellDetail> req, Long tranId) {
        return req.stream().map(detail -> toEntity(detail, tranId)).toList();
    }

    public static List<SellDetail> toDetail(List<SellDetailTransactionEntity> enList) {
        return enList.stream().map(SellDetailMapper::toDetail).toList();
    }
}
