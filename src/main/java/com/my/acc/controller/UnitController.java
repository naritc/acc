package com.my.acc.controller;

import com.my.acc.Util.ResponseUtil;
import com.my.acc.model.BaseResponse;
import com.my.acc.model.NewUnit;
import com.my.acc.model.UnitResponse;
import com.my.acc.service.UnitService;
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
@RequestMapping("/unit")
public class UnitController {
    @Autowired
    private UnitService unitService;

    @GetMapping
    public ResponseEntity<UnitResponse> getUnits() {
        log.info("GetUnits Request");
        unitService.getUnitList();
        UnitResponse resp = new UnitResponse();
        resp.setUnitDetails(unitService.getUnitList());
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/new")
    public ResponseEntity<BaseResponse> newUnit(@Valid @RequestBody NewUnit req) {
        log.info("NewUnit Request: {}", req);
        unitService.createUnit(req);
        return ResponseUtil.success();
    }
}
