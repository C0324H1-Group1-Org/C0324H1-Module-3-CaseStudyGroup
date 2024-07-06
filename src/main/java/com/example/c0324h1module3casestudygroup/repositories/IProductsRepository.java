package com.example.c0324h1module3casestudygroup.repositories;

import com.example.c0324h1module3casestudygroup.dto.ProductDTO;

import java.util.List;

public interface IProductsRepository {
    List<ProductDTO> findAllProduct();
}
