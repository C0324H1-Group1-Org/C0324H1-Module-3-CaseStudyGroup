package com.example.c0324h1module3casestudygroup.services;

import com.example.c0324h1module3casestudygroup.dto.ProductDTO;
import com.example.c0324h1module3casestudygroup.models.Product;

import java.util.List;

public interface IProductService {
    List<ProductDTO> findAllProduct();

    Product getProductById(String id);
}
