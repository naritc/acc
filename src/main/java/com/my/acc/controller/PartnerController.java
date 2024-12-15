package com.my.acc.controller;

import com.my.acc.Util.ResponseUtil;
import com.my.acc.model.BaseResponse;
import com.my.acc.model.NewPartnerRequest;
import com.my.acc.model.PartnerResponse;
import com.my.acc.service.PartnerService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/partner")
public class PartnerController {
    @Autowired
    private PartnerService partnerService;

    @GetMapping
    public ResponseEntity<PartnerResponse> getPartners() {
        log.info("getPartners Request");

        PartnerResponse resp = new PartnerResponse();
        resp.setPartnerDetails(partnerService.getPartnerList());
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/new")
    public ResponseEntity<BaseResponse> newPartner(@Valid @RequestBody NewPartnerRequest req) {
        log.info("newPartner Request");

        partnerService.newPartner(req);
        return ResponseUtil.success();
    }
}
