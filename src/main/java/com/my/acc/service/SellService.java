package com.my.acc.service;

import com.my.acc.entity.BuyDetailTransactionEntity;
import com.my.acc.entity.BuyTransactionEntity;
import com.my.acc.entity.SellDetailTransactionEntity;
import com.my.acc.entity.SellTransactionEntity;
import com.my.acc.mapper.BuyDetailMapper;
import com.my.acc.mapper.BuyMapper;
import com.my.acc.mapper.SellDetailMapper;
import com.my.acc.mapper.SellMapper;
import com.my.acc.model.BuyTranResponse;
import com.my.acc.model.CancelBuyRequest;
import com.my.acc.model.CancelSellRequest;
import com.my.acc.model.NewBuyRequest;
import com.my.acc.model.NewSellRequest;
import com.my.acc.model.SellDetail;
import com.my.acc.model.SellTranDetail;
import com.my.acc.model.SellTranResponse;
import com.my.acc.repository.SellDetailTransactionRepository;
import com.my.acc.repository.SellTransactionRepository;
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
public class SellService {
    @Autowired
    private SellTransactionRepository sellTransactionRepository;

    @Autowired
    private SellDetailTransactionRepository sellDetailTransactionRepository;

    public List<SellTranDetail> getSellList(Pageable pageable) {
        log.info("GetSellList Request");

        Page<SellTransactionEntity> enPage = sellTransactionRepository.findAllByOrderBySellDateDesc(pageable);
        return SellMapper.toDetail(enPage.getContent());
    }

    public List<SellDetail> getSellDetailList(Long sellTransactionId) {
        log.info("GetSellDetailList Request");

        List<SellDetailTransactionEntity> dtl = sellDetailTransactionRepository.findAllBySellTransactionId(sellTransactionId);
        return SellDetailMapper.toDetail(dtl);
    }

    public SellTranResponse getSellDetail(Long sellTransactionId) {
        log.info("GetSellDetail Request");

        SellTransactionEntity en = sellTransactionRepository.findById(sellTransactionId).orElseThrow();
        List<SellDetailTransactionEntity> dtl = sellDetailTransactionRepository.findAllBySellTransactionId(sellTransactionId);

        SellTranResponse resp = new SellTranResponse();
        resp.setInfo(SellMapper.toDetail(en));
        resp.setDetails(SellDetailMapper.toDetail(dtl));

        return resp;
    }

    @Transactional
    public void newSell(NewSellRequest req) {
        log.info("NewSell Request");

        SellTransactionEntity en = SellMapper.toEntity(req);
        sellTransactionRepository.saveAndFlush(en);

        List<SellDetailTransactionEntity> dtl = SellDetailMapper.toEntity(req.getDetails(), en.getSellTransactionId());
        BigDecimal total = BigDecimal.ZERO;
        BigDecimal vat = req.getVat();

        dtl.forEach(d -> {
            total.add(d.getTotal());
        });

        en.setTotal(total);
        en.setVat(vat);
        en.setNet(total.add(vat));

        sellTransactionRepository.save(en);
        sellDetailTransactionRepository.saveAll(dtl);
    }

    @Transactional
    public void cancelSell(CancelSellRequest req) {
        log.info("CancelSell Request");

        SellTransactionEntity en = sellTransactionRepository.findById(req.getSellTransactionId()).orElseThrow();
        en.setIsCancel(true);
        en.setCancelDate(req.getCancelDate());
        sellTransactionRepository.save(en);
    }
}
