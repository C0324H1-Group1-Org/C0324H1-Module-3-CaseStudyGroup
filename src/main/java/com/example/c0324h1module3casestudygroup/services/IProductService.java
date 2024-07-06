package com.example.c0324h1module3casestudygroup.services;

import com.example.c0324h1module3casestudygroup.dto.ProductDTO;

import java.util.List;

public interface IProductService {
    List<ProductDTO> findAllProduct();
}
