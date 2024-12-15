package com.my.acc.controller;

import com.my.acc.Util.ResponseUtil;
import com.my.acc.model.BaseResponse;
import com.my.acc.model.BuyResponse;
import com.my.acc.model.BuyTranResponse;
import com.my.acc.model.NewBuyRequest;
import com.my.acc.service.BuyService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/buy")
public class BuyController {
    @Autowired
    private BuyService buyService;

    @GetMapping
    public ResponseEntity<BuyResponse> getBuyResponse(@Valid @RequestBody Pageable pageable) {
        log.info("getBuy Request");

        BuyResponse resp = new BuyResponse();
        resp.setBuyTranDetails(buyService.getBuyList(pageable));
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/{buyTransactionId}")
    public ResponseEntity<BuyTranResponse> getBuyDetailResponse(@Valid @PathVariable Long buyTransactionId) {
        log.info("getBuyDetailResponse Request");

        BuyTranResponse resp = buyService.getBuyDetail(buyTransactionId);
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/new")
    public ResponseEntity<BaseResponse> newBuy(@Valid @RequestBody NewBuyRequest req) {
        log.info("newBuy Request");

        buyService.newBuy(req);
        return ResponseUtil.success();
    }
}
