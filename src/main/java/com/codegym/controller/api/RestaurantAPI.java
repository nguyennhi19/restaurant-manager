package com.codegym.controller.api;

import com.codegym.service.product.IProductService;
import com.codegym.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantAPI {

    @Autowired
    private IProductService iproductService;




}
