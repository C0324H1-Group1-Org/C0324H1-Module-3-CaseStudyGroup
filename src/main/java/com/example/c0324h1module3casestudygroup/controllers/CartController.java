package com.example.c0324h1module3casestudygroup.controllers;

import com.example.c0324h1module3casestudygroup.dto.CartDTO;
import com.example.c0324h1module3casestudygroup.services.ICustomerService;
import com.example.c0324h1module3casestudygroup.services.implement.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "cartController", value = "/cart")
public class CartController extends HttpServlet {

    private static ICustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            default:
                HttpSession httpSession = req.getSession(false);
                if (httpSession != null){
                    List<CartDTO> cartDTOS = customerService.getCart((String) httpSession.getAttribute("username"));
                    req.setAttribute("carts",cartDTOS);
                    req.getRequestDispatcher("/products/cart.jsp").forward(req,resp);
                }
                else{
                    resp.sendRedirect("/login?action=login");
                }
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "delete":
                int idCart = Integer.parseInt(req.getParameter("idCart"));
                int idProduct = Integer.parseInt(req.getParameter("idProduct"));
                customerService.deleteCartItem(idCart,idProduct);
                resp.sendRedirect("/cart");
                break;
            case "update":
                int idCartUpdate = Integer.parseInt(req.getParameter("idCart"));
                int idProductUpdate = Integer.parseInt(req.getParameter("idProduct"));
                int inputQuantity = Integer.parseInt(req.getParameter("inputQuantity"));
                customerService.updateCartItem(idCartUpdate,idProductUpdate,inputQuantity);
                resp.sendRedirect("/cart");
                break;
        }
    }
}
