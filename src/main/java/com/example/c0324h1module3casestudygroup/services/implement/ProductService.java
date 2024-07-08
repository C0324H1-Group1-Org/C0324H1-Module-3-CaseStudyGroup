package com.example.c0324h1module3casestudygroup.services.implement;

import com.example.c0324h1module3casestudygroup.dto.ProductDTO;
import com.example.c0324h1module3casestudygroup.models.Product;
import com.example.c0324h1module3casestudygroup.repositories.IProductsRepository;
import com.example.c0324h1module3casestudygroup.repositories.implement.ProductsRepository;
import com.example.c0324h1module3casestudygroup.services.IProductService;

import java.util.List;

public class ProductService implements IProductService {
    private static final IProductsRepository productsRepository = new ProductsRepository();
    @Override
    public List<ProductDTO> findAllProduct() {
        return productsRepository.findAllProduct();
    }

    @Override
    public Product getProductById(String id) {
        return productsRepository.getProductById(id);
    }
}
