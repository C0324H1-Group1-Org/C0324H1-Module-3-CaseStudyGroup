package com.example.c0324h1module3casestudygroup.controllers;

import com.example.c0324h1module3casestudygroup.dto.CartDTO;
import com.example.c0324h1module3casestudygroup.dto.ProductDTO;
import com.example.c0324h1module3casestudygroup.models.Product;
import com.example.c0324h1module3casestudygroup.repositories.IProductsRepository;
import com.example.c0324h1module3casestudygroup.repositories.implement.ProductsRepository;
import com.example.c0324h1module3casestudygroup.services.ICustomerService;
import com.example.c0324h1module3casestudygroup.services.IProductService;
import com.example.c0324h1module3casestudygroup.services.implement.CustomerService;
import com.example.c0324h1module3casestudygroup.services.implement.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "HomeController",value = "/daisy")
public class HomeController extends HttpServlet {
    private static IProductService productService = new ProductService();



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            default:
                List<ProductDTO> productDTOS = productService.findAllProduct();
                req.setAttribute("products", productDTOS);
                req.getRequestDispatcher("/products/home.jsp").forward(req, resp);
                break;
        }
    }
}
