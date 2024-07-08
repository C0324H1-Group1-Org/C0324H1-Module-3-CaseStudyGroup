package com.example.c0324h1module3casestudygroup.services;

import com.example.c0324h1module3casestudygroup.dto.ProductDTO;
import com.example.c0324h1module3casestudygroup.models.Product;

import java.util.List;

public interface IProductService {
    List<ProductDTO> findAllProduct();

    List<ProductDTO> findProductByIdType(int id);

    List<ProductDTO> findByName(String name);

    Product getProductById(String id);
}
