package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private IProductService iProductService;

    @GetMapping
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView();

        Iterable<Product> products = iProductService.findAll();
        modelAndView.setViewName("/user/home");
        modelAndView.addObject("products", products);
        return modelAndView;
    }
}
