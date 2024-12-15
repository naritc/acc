package com.my.acc.service;

import com.my.acc.entity.ProductEntity;
import com.my.acc.entity.UnitEntity;
import com.my.acc.mapper.ProductMapper;
import com.my.acc.model.NewProductRequest;
import com.my.acc.model.ProductDetail;
import com.my.acc.repository.ProductRepository;
import com.my.acc.repository.UnitRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j2
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UnitRepository unitRepository;

    public List<ProductDetail> getProductList() {
        log.info("GetProductList Request");

        List<UnitEntity> unitList = unitRepository.findAll();

        List<ProductEntity> enList = productRepository.findAll();

        return ProductMapper.toDetail(enList, unitList);
    }

    @Transactional
    public void newProduct(NewProductRequest req) {
        log.info("NewProduct Request");

        ProductEntity en = ProductMapper.toEntity(req);
        productRepository.save(en);
    }
}
