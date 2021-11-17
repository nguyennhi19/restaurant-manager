package com.codegym.controller.api;


import com.codegym.model.Product;
import com.codegym.model.dto.ProductDTO;
import com.codegym.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/product")
public class ProductApi {

    @Autowired
    private IProductService iProductService;

    @GetMapping
    public Iterable<ProductDTO> getList() {

        Iterable<ProductDTO> products = iProductService.findAllPDTO();

        return products;
    }

    @PostMapping("/create")
    public Product create(@RequestBody Product product) {

        Product product1 = iProductService.save(product);

        return product1;
    }

    @GetMapping("/{id}")
    public ProductDTO createId(@PathVariable Long id) {

        ProductDTO product = iProductService.findByIdPDTO(id).get();

        return product;
    }

    @PostMapping("/update")
    public Product update(@RequestBody Product product) {

        Product product1 = iProductService.save(product);

        return product1;
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {

        iProductService.remove(id);

        Optional<Product> product = iProductService.findById(id);

        if (product.isPresent()) {
            return new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }
}
