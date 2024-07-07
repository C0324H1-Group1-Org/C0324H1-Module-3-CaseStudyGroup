package com.example.c0324h1module3casestudygroup.services.implement;

import com.example.c0324h1module3casestudygroup.dto.CartDTO;
import com.example.c0324h1module3casestudygroup.dto.OrderDetailDTO;
import com.example.c0324h1module3casestudygroup.repositories.IOrderRepository;
import com.example.c0324h1module3casestudygroup.repositories.implement.OrderRepository;
import com.example.c0324h1module3casestudygroup.services.IOrderService;

import java.time.LocalDate;
import java.util.List;

public class OrderService implements IOrderService {
    IOrderRepository orderRepository = new OrderRepository();
    @Override
    public int createOrder(int customerId, LocalDate dateOrder, String status) {
        return orderRepository.createOreder(customerId, dateOrder, status);
    }

    @Override
    public void saveOrderDetail(int orderId, List<CartDTO> products) {
        orderRepository.saveOrderDetail(orderId, products);
    }

    @Override
    public List<OrderDetailDTO> getOrderDetailsByOrderId(int orderId) {
        return orderRepository.getOrderDetailsByOrderId(orderId);
    }
}
