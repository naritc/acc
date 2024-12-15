package com.my.acc.mapper;

import com.my.acc.entity.BuyTransactionEntity;
import com.my.acc.model.BuyTranDetail;
import com.my.acc.model.NewBuyRequest;

import java.util.List;

public class BuyMapper {
    public static BuyTransactionEntity toEntity(NewBuyRequest req) {
        BuyTransactionEntity en = new BuyTransactionEntity();
        en.setBookPage(req.getBookPage());
        en.setBookNumber(req.getBookNumber());
        en.setBuyDate(req.getBuyDate());
        en.setVat(req.getVat());
        return en;
    }

    public static BuyTranDetail toDetail(BuyTransactionEntity en) {
        BuyTranDetail detail = new BuyTranDetail();
        detail.setBuyTransactionId(en.getBuyTransactionId());
        detail.setBookPage(en.getBookPage());
        detail.setBookNumber(en.getBookNumber());
        detail.setBuyDate(en.getBuyDate());
        detail.setNet(en.getNet());
        detail.setVat(en.getVat());
        detail.setTotal(en.getTotal());
        detail.setImagePath(en.getImagePath());
        detail.setIsCancel(en.getIsCancel());
        return detail;
    }

    public static  List<BuyTransactionEntity> toEntity(List<NewBuyRequest> reqList) {
        return reqList.stream().map(BuyMapper::toEntity).toList();
    }

    public static List<BuyTranDetail> toDetail(List<BuyTransactionEntity> enList) {
        return enList.stream().map(BuyMapper::toDetail).toList();
    }
}
