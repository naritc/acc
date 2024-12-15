package com.my.acc.controller;

import com.my.acc.Util.ResponseUtil;
import com.my.acc.model.BaseResponse;
import com.my.acc.model.NewProductRequest;
import com.my.acc.model.ProductResponse;
import com.my.acc.service.ProductService;
import jakarta.validation.Valid;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Log4j2
@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<ProductResponse> getProduct() {
        log.info("GetProduct Request");
        ProductResponse resp = new ProductResponse();
        resp.setProductDetails(productService.getProductList());
        return ResponseEntity.ok(resp);
    }

    @PostMapping("/new")
    public ResponseEntity<BaseResponse> newProduct(@Valid @RequestBody NewProductRequest req) {
        log.info("newProduct Request: {}", req);
        productService.newProduct(req);
        return ResponseUtil.success();
    }
}
