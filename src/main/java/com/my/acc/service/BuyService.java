package com.my.acc.service;

import com.my.acc.entity.BuyDetailTransactionEntity;
import com.my.acc.entity.BuyTransactionEntity;
import com.my.acc.mapper.BuyDetailMapper;
import com.my.acc.mapper.BuyMapper;
import com.my.acc.model.BuyDetail;
import com.my.acc.model.BuyTranDetail;
import com.my.acc.model.BuyTranResponse;
import com.my.acc.model.CancelBuyRequest;
import com.my.acc.model.NewBuyRequest;
import com.my.acc.repository.BuyDetailTransactionRepository;
import com.my.acc.repository.BuyTransactionRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Log4j2
@Service
public class BuyService {
    @Autowired
    private BuyTransactionRepository buyTransactionRepository;

    @Autowired
    private BuyDetailTransactionRepository buyDetailTransactionRepository;

    public List<BuyTranDetail> getBuyList(Pageable pageable) {
        log.info("GetBuyList Request");

        Page<BuyTransactionEntity> enPage = buyTransactionRepository.findAllByOrderByBuyDateDesc(pageable);
        return BuyMapper.toDetail(enPage.getContent());
    }

    public List<BuyDetail> getBuyDetailList(Long buyTransactionId) {
        log.info("GetBuyDetailList Request");

        List<BuyDetailTransactionEntity> dtl = buyDetailTransactionRepository.findAllByBuyTransactionId(buyTransactionId);
        return BuyDetailMapper.toDetail(dtl);
    }

    public BuyTranResponse getBuyDetail(Long buyTransactionId) {
        log.info("GetBuyDetail Request");

        BuyTransactionEntity en = buyTransactionRepository.findById(buyTransactionId).orElseThrow();
        List<BuyDetailTransactionEntity> dtl = buyDetailTransactionRepository.findAllByBuyTransactionId(buyTransactionId);

        BuyTranResponse resp = new BuyTranResponse();
        resp.setInfo(BuyMapper.toDetail(en));
        resp.setDetails(BuyDetailMapper.toDetail(dtl));

        return resp;
    }

    @Transactional
    public void newBuy(NewBuyRequest req) {
        log.info("NewBuy Request");

        BuyTransactionEntity en = BuyMapper.toEntity(req);
        buyTransactionRepository.saveAndFlush(en);

        List<BuyDetailTransactionEntity> dtl = BuyDetailMapper.toEntity(req.getDetails(), en.getBuyTransactionId());
        BigDecimal total = BigDecimal.ZERO;
        BigDecimal vat = req.getVat();

        dtl.forEach(d -> {
            total.add(d.getTotal());
        });

        en.setTotal(total);
        en.setVat(vat);
        en.setNet(total.add(vat));

        buyTransactionRepository.save(en);
        buyDetailTransactionRepository.saveAll(dtl);
    }

    @Transactional
    public void cancelBuy(CancelBuyRequest req) {
        log.info("CancelBuy Request");

        BuyTransactionEntity en = buyTransactionRepository.findById(req.getBuyTransactionId()).orElseThrow();
        en.setIsCancel(true);
        en.setCancelDate(req.getCancelDate());
        buyTransactionRepository.save(en);
    }
}
