package com.my.acc.controller;

import com.my.acc.Util.ResponseUtil;
import com.my.acc.model.BaseResponse;
import com.my.acc.model.NewSellRequest;
import com.my.acc.model.SellResponse;
import com.my.acc.model.SellTranResponse;
import com.my.acc.service.SellService;
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
@RequestMapping("/sell")
public class SellController {
    @Autowired
    private SellService sellService;

    @GetMapping
    public ResponseEntity<SellResponse> getSellResponse(@Valid @RequestBody Pageable pageable) {
        log.info("getSell Request");

        SellResponse resp = new SellResponse();
        resp.setSellTranDetails(sellService.getSellList(pageable));
        return ResponseEntity.ok(resp);
    }

    @GetMapping("/{sellTransactionId}")
    public ResponseEntity<SellTranResponse> getSellDetailResponse(@Valid @PathVariable Long sellTransactionId) {
        log.info("getSellDetailResponse Request");

        SellTranResponse resp = sellService.getSellDetail(sellTransactionId);
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/new")
    public ResponseEntity<BaseResponse> newSell(@Valid @RequestBody NewSellRequest req) {
        log.info("newSell Request");

        sellService.newSell(req);
        return ResponseUtil.success();
    }
}
