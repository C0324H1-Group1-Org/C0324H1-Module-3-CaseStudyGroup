package com.example.c0324h1module3casestudygroup.repositories.implement;

import com.example.c0324h1module3casestudygroup.dto.CartDTO;
import com.example.c0324h1module3casestudygroup.dto.OrderDetailDTO;
import com.example.c0324h1module3casestudygroup.dto.ProductDTO;
import com.example.c0324h1module3casestudygroup.repositories.BaseRepository;
import com.example.c0324h1module3casestudygroup.repositories.IOrderRepository;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository implements IOrderRepository {
    @Override
    public int createOreder(int customerId, LocalDate dateOrder, String status) {
        int orderId = 0;
        try {
            String sql = "insert into orders (id_customer, date_order, status) values (?, ?, ?)";
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, customerId);
            preparedStatement.setDate(2, Date.valueOf(dateOrder));
            preparedStatement.setString(3, status);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderId;
    }

    @Override
    public void saveOrderDetail(int orderId, List<CartDTO> products) {
        String sql = "insert into orders_detail (id_order, id_product, quantity) values (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(sql);
            for (CartDTO product : products) {
                preparedStatement.setInt(1, orderId);
                preparedStatement.setInt(2, product.getIdProduct());
                preparedStatement.setInt(3, product.getQuantity());
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<OrderDetailDTO> getOrderDetailsByOrderId(int orderId) {
        List<OrderDetailDTO> orderDetails = new ArrayList<>();
        String sql = "select p.url_image, p.name_product, od.quantity, p.price, o.date_order " +
                "from orders_detail od " +
                "join product p on od.id_product = p.id_product " +
                "JOIN orders o ON od.id_order = o.id_order " +
                "WHERE od.id_order = ?";

        try{
            PreparedStatement stmt = BaseRepository.getConnection().prepareStatement(sql);
            stmt.setInt(1, orderId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String urlImage = rs.getString("url_image");
                String name = rs.getString("name_product");
                int quantity = rs.getInt("quantity");
                long price = rs.getLong("price");
                java.util.Date date = rs.getDate("date_order");

                OrderDetailDTO orderDetail = new OrderDetailDTO(urlImage, name, quantity, price, date);
                orderDetails.add(orderDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderDetails;
    }
}
