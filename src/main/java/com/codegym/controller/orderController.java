package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.service.category.ICategoryService;
import com.codegym.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/order")
public class orderController {
    @Autowired
    private IProductService iProductService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping
    public ModelAndView getList() {
        ModelAndView modelAndView = new ModelAndView();
        Iterable<Category> categories = iCategoryService.findAll();
        modelAndView.addObject("categories", categories);

        Iterable<Product> products = iProductService.findAll();
        modelAndView.setViewName("/user/order");
        modelAndView.addObject("products", products);
        return modelAndView;
    }
}
