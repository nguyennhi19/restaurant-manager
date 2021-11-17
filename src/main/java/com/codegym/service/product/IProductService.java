package com.codegym.service.product;

import com.codegym.model.Product;
import com.codegym.model.dto.ProductDTO;
import com.codegym.service.IGeneralService;

import java.util.List;
import java.util.Optional;

public interface IProductService extends IGeneralService<Product> {
    List<ProductDTO> findAllPDTO();
    Optional<ProductDTO> findByIdPDTO(Long id);
}
