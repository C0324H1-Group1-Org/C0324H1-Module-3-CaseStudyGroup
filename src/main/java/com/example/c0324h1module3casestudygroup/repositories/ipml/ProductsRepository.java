package com.example.c0324h1module3casestudygroup.repositories.ipml;

import com.example.c0324h1module3casestudygroup.dto.ProductDTO;
import com.example.c0324h1module3casestudygroup.repositories.BaseRepository;
import com.example.c0324h1module3casestudygroup.repositories.IProductsRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductsRepository implements IProductsRepository {

    @Override
    public List<ProductDTO> findAllProduct() {
            List<ProductDTO> productDTOS = new ArrayList<>();
            int id;
            String UrlImage;
            String name;
            long price;

        try {
            PreparedStatement preparedStatement;
            preparedStatement = BaseRepository.getConnection().prepareStatement("SELECT id_product, url_image, name_product, price FROM product");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("id_product");
                UrlImage = resultSet.getString("url_image");
                name = resultSet.getString("name_product");
                price = resultSet.getLong("price");

                ProductDTO productDTO = new ProductDTO(id, UrlImage, name, price);
                productDTOS.add(productDTO);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
            return productDTOS;
        }

    }
