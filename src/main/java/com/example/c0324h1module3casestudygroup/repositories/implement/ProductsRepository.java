package com.example.c0324h1module3casestudygroup.repositories.implement;

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

    @Override
    public List<ProductDTO> findProductByIdType(int id) {
        List<ProductDTO> productShirtDTOS = new ArrayList<>();
        int idproduct;
        String UrlImage;
        String name;
        long price;
        try {
            PreparedStatement preparedStatement;
            preparedStatement = BaseRepository.getConnection()
                    .prepareStatement("SELECT id_product, url_image, name_product, price FROM type_product as tp right join sub_type_product as stp on tp.id_type_product = stp.id_type_product right join product on stp.id_sub_type_product = product.id_sub_type_product where tp.id_type_product = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                idproduct = resultSet.getInt("id_product");
                UrlImage = resultSet.getString("url_image");
                name = resultSet.getString("name_product");
                price = resultSet.getLong("price");
                ProductDTO productDTO = new ProductDTO(id, UrlImage, name, price);
                productShirtDTOS.add(productDTO);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productShirtDTOS;
    }

    @Override
    public List<ProductDTO> findByName(String name) {
        List<ProductDTO> productDTOS = new ArrayList<>();
        int idProduct;
        String UrlImage;
        String nameProduct;
        long price;
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection()
                    .prepareStatement("SELECT id_product, url_image, name_product, price FROM product where product.name_product like CONCAT('%',?,'%')");
            preparedStatement.setString(1,"%" + name + "%");
            ResultSet resultSet =preparedStatement.executeQuery();
            while (resultSet.next()) {
                idProduct = resultSet.getInt("id_product");
                UrlImage = resultSet.getString("url_image");
                nameProduct = resultSet.getString("name_product");
                price = resultSet.getLong("price");

                ProductDTO productDTO = new ProductDTO(idProduct, UrlImage, nameProduct, price);
                productDTOS.add(productDTO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productDTOS;
    }
}
