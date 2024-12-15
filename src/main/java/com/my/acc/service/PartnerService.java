package com.my.acc.service;

import com.my.acc.entity.PartnerEntity;
import com.my.acc.mapper.PartnerMapper;
import com.my.acc.model.NewPartnerRequest;
import com.my.acc.model.PartnerDetail;
import com.my.acc.repository.PartnerRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
public class PartnerService {
    @Autowired
    private PartnerRepository partnerRepository;

    public List<PartnerDetail> getPartnerList() {
        log.info("Get Partner List");
        List<PartnerEntity> en = partnerRepository.findAll();
        return PartnerMapper.toDetail(en);
    }

    @Transactional
    public void newPartner(NewPartnerRequest req) {
        log.info("New Partner");

        PartnerEntity en = PartnerMapper.newEntity(req);
        partnerRepository.save(en);
    }


}