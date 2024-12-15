package com.my.acc.service;

import com.my.acc.entity.UnitEntity;
import com.my.acc.mapper.UnitMapper;
import com.my.acc.model.NewUnit;
import com.my.acc.model.UnitDetail;
import com.my.acc.repository.UnitRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
public class UnitService {
    @Autowired
    private UnitRepository unitRepository;

    public List<UnitDetail> getUnitList() {
        log.info("Get unit list");

        List<UnitEntity> enList = unitRepository.findAll();
        return UnitMapper.toDetail(enList);
    }

    @Transactional
    public void createUnit(NewUnit req) {
        log.info("Create unit");

        UnitEntity en = UnitMapper.newEntity(req);
        unitRepository.save(en);
    }
}
