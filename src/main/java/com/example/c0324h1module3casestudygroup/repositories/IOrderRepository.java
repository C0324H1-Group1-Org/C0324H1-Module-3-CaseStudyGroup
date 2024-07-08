package com.example.c0324h1module3casestudygroup.repositories;

import com.example.c0324h1module3casestudygroup.dto.CartDTO;
import com.example.c0324h1module3casestudygroup.dto.OrderDetailDTO;

import java.time.LocalDate;
import java.util.List;

public interface IOrderRepository {
    int createOreder(int customerId, LocalDate dateOrder, String status);

    void saveOrderDetail(int orderId, List<CartDTO> products);

    List<OrderDetailDTO> getOrderDetailsByOrderId(int orderId);
}
