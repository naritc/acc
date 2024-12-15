package com.my.acc.mapper;

import com.my.acc.entity.BuyDetailTransactionEntity;
import com.my.acc.model.BuyDetail;
import com.my.acc.model.NewBuyDetail;

import java.util.List;

public class BuyDetailMapper {
    public static BuyDetailTransactionEntity toEntity(NewBuyDetail req, Long tranId) {
        BuyDetailTransactionEntity en = new BuyDetailTransactionEntity();
        en.setBuyTransactionId(tranId);
        en.setProductId(req.getProductId());
        en.setQuantity(req.getQuantity());
        en.setPrice(req.getPrice());
        en.setTotal(req.getQuantity().multiply(req.getPrice()));
        return en;
    }

    public static BuyDetail toDetail(BuyDetailTransactionEntity en) {
        BuyDetail detail = new BuyDetail();
        detail.setBuyDetailTransactionId(en.getBuyDetailTransactionId());
        detail.setBuyTransactionId(en.getBuyTransactionId());
        detail.setProductId(en.getProductId());
        detail.setQuantity(en.getQuantity());
        detail.setPrice(en.getPrice());
        detail.setTotal(en.getTotal());
        return detail;
    }

    public static List<BuyDetailTransactionEntity> toEntity(List<NewBuyDetail> req, Long tranId) {
        return req.stream().map(detail -> toEntity(detail, tranId)).toList();
    }

    public static List<BuyDetail> toDetail(List<BuyDetailTransactionEntity> enList) {
        return enList.stream().map(BuyDetailMapper::toDetail).toList();
    }
}
