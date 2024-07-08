package com.example.c0324h1module3casestudygroup.controllers;

import com.example.c0324h1module3casestudygroup.dto.CartDTO;
import com.example.c0324h1module3casestudygroup.dto.OrderDTO;
import com.example.c0324h1module3casestudygroup.dto.OrderDetailDTO;
import com.example.c0324h1module3casestudygroup.dto.ProductDTO;
import com.example.c0324h1module3casestudygroup.models.Customer;
import com.example.c0324h1module3casestudygroup.repositories.BaseRepository;
import com.example.c0324h1module3casestudygroup.services.ICustomerService;
import com.example.c0324h1module3casestudygroup.services.IOrderService;
import com.example.c0324h1module3casestudygroup.services.implement.CustomerService;
import com.example.c0324h1module3casestudygroup.services.implement.OrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrderServlet", value = "/order")
public class OrderController extends HttpServlet {
    ICustomerService customerService = new CustomerService();
    IOrderService orderService = new OrderService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "order":
                viewOrder(request, response);
                break;
            case "done":
                viewThankYou(request, response);
                break;
            case "order_detail":
                viewOrderDetail(request, response);
                break;
            default:
                viewOrder(request, response);
                break;
        }
    }

    private void viewThankYou(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/order/done.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

//    lấy orderId từ session và hiển thị chi tiết đơn hàng
    private void viewOrderDetail(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("customerId") == null) {
            try {
                response.sendRedirect("/daisy");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return;
        }
        int customerId = (int) session.getAttribute("customerId");
//        List<OrderDetailDTO> orderDetails = orderService.getOrderDetailsByOrderId(orderId);
        List<OrderDTO> orderDTOList = orderService.getOrderByCustomerId(customerId);
        request.setAttribute("orderDetails", orderDTOList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/order/order_detail.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void viewOrder(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("customerId") != null) {
            int customerId = (int) session.getAttribute("customerId");
            Customer customer = customerService.getCustomerById(customerId);
            request.setAttribute("customer", customer);
            try {
                request.getRequestDispatcher("/order/order.jsp").forward(request,response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        } else {
            try {
                response.sendRedirect("/login?action=login");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "order":
                OrderCustomer(request, response);
                break;
//            case "order_detail":
//                viewOrderDetail(request, response);
//                break;
        }
    }



    private void OrderCustomer(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("customerId") != null) {
            int customerId = (int) session.getAttribute("customerId");
            String username = (String) session.getAttribute("username");
            List<CartDTO> cartItems = customerService.getCart(username);
            List<CartDTO> products = new ArrayList<>();
            for (CartDTO cartItem : cartItems) {
                products.add(new CartDTO(cartItem.getIdCart(), cartItem.getUrlImage(), cartItem.getIdProduct(), cartItem.getNameProduct(), cartItem.getPrice(), cartItem.getQuantity()));

            }

            if (!products.isEmpty()) {
                String sql = "delete from cart where id_customer=?";
                try {
                    PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(sql);
                    preparedStatement.setInt(1, (Integer) session.getAttribute("customerId"));
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                LocalDate dateOrder = LocalDate.now();
                int orderId = orderService.createOrder(customerId, dateOrder, "pending");
                orderService.saveOrderDetail(orderId, products);
                session.setAttribute("orderId", orderId);
                try {
                    response.sendRedirect("order/done.jsp");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    response.sendRedirect("/cart");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        } else {
            try {
                response.sendRedirect("/login?action=login");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
