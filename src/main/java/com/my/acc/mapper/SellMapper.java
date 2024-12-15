package com.my.acc.mapper;

import com.my.acc.entity.SellTransactionEntity;
import com.my.acc.model.SellTranDetail;
import com.my.acc.model.NewSellRequest;

import java.util.List;

public class SellMapper {
    public static SellTransactionEntity toEntity(NewSellRequest req) {
        SellTransactionEntity en = new SellTransactionEntity();
        en.setBookPage(req.getBookPage());
        en.setBookNumber(req.getBookNumber());
        en.setSellDate(req.getSellDate());
        en.setVat(req.getVat());
        return en;
    }

    public static SellTranDetail toDetail(SellTransactionEntity en) {
        SellTranDetail detail = new SellTranDetail();
        detail.setSellTransactionId(en.getSellTransactionId());
        detail.setBookPage(en.getBookPage());
        detail.setBookNumber(en.getBookNumber());
        detail.setSellDate(en.getSellDate());
        detail.setNet(en.getNet());
        detail.setVat(en.getVat());
        detail.setTotal(en.getTotal());
        detail.setImagePath(en.getImagePath());
        detail.setIsCancel(en.getIsCancel());
        return detail;
    }

    public static  List<SellTransactionEntity> toEntity(List<NewSellRequest> reqList) {
        return reqList.stream().map(SellMapper::toEntity).toList();
    }

    public static List<SellTranDetail> toDetail(List<SellTransactionEntity> enList) {
        return enList.stream().map(SellMapper::toDetail).toList();
    }
}
