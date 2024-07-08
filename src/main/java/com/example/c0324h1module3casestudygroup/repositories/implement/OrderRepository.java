package com.example.c0324h1module3casestudygroup.repositories.implement;

import com.example.c0324h1module3casestudygroup.dto.*;
import com.example.c0324h1module3casestudygroup.repositories.BaseRepository;
import com.example.c0324h1module3casestudygroup.repositories.IOrderRepository;

import javax.xml.transform.Result;
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
            ResultSet s = preparedStatement.getGeneratedKeys();
            if (s.next()){
                orderId = s.getInt(1);
            }
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
        String sql = "select p.url_image, p.name_product, od.quantity, p.price, o.date_order\n" +
                "from orders_detail od\n" +
                "         join product p on od.id_product = p.id_product\n" +
                "         join orders o on od.id_order = o.id_order\n" +
                "where od.id_order = ?";

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

    @Override
    public List<OrderDTO> getOrderByCustomerId(int customerId) {
        List<OrderDTO> orderDTOList = new ArrayList<>();
        String sql_select_order_by_id_customer = "SELECT id_order,date_order,status FROM daisy.orders where id_customer=? ";
        String sql_select_order_detail_by_id_order = "SELECT url_image,name_product,quantity,price FROM daisy.orders_detail o inner join product p on o.id_product = p.id_product where id_order=?";
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(sql_select_order_by_id_customer);
            preparedStatement.setInt(1,customerId);
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()){
                int orderId = set.getInt("id_order");
                OrderDTO orderDTO = new OrderDTO(orderId,set.getDate("date_order"),set.getString("status"));
                PreparedStatement preparedStatement_sub = BaseRepository.getConnection().prepareStatement(sql_select_order_detail_by_id_order);
                preparedStatement_sub.setInt(1,orderId);
                ResultSet orderDetailSet = preparedStatement_sub.executeQuery();
                List<OrderProductDTO> orderProductDTOS = new ArrayList<>();
                while (orderDetailSet.next()){
                    OrderProductDTO orderProductDTO = new OrderProductDTO(orderDetailSet.getString("url_image"),orderDetailSet.getString("name_product"),orderDetailSet.getInt("quantity"),orderDetailSet.getFloat("price"));
                    orderProductDTOS.add(orderProductDTO);
                }
                orderDTO.setOrderProductDTOS(orderProductDTOS);
                orderDTOList.add(orderDTO);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return orderDTOList;
    }
}
