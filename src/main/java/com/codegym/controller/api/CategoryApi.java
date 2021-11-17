package com.codegym.controller.api;

import com.codegym.model.Category;
import com.codegym.model.Product;
import com.codegym.model.dto.ProductDTO;
import com.codegym.service.category.CategoryService;
import com.codegym.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class CategoryApi {

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping
    public Iterable<Category> getList() {

        Iterable<Category> categories = iCategoryService.findAll();

        return categories;
    }

    @PostMapping("/create")
    public Category create(@RequestBody Category category) {

        Category category1 = iCategoryService.save(category);

        return category1;
    }

    @GetMapping("/{id}")
    public Category createId(@PathVariable Long id) {

        Category category = iCategoryService.findById(id).get();

        return category;
    }

    @PostMapping("/update")
    public Category update(@RequestBody Category category) {

        Category category1 = iCategoryService.save(category);

        return category1;
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id) {

        iCategoryService.remove(id);

        Optional<Category> category = iCategoryService.findById(id);

        if (category.isPresent()) {
            return new ResponseEntity<Boolean>(true, HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<Boolean>(true, HttpStatus.CREATED);
    }

}
