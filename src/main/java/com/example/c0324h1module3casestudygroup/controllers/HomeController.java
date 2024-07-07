package com.example.c0324h1module3casestudygroup.controllers;

import com.example.c0324h1module3casestudygroup.dto.ProductDTO;
import com.example.c0324h1module3casestudygroup.services.IProductService;
import com.example.c0324h1module3casestudygroup.services.implement.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet (name = "HomeController",value = "/daisy")
public class HomeController extends HttpServlet {

    private static IProductService productService = new ProductService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        int id_type_product;
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "shirts":
                id_type_product = 2;
                List<ProductDTO> productShirtDTOS = productService.findProductByIdType(id_type_product);
                req.setAttribute("shirts", productShirtDTOS);
                req.getRequestDispatcher("/products/home.jsp").forward(req, resp);
                break;
            case "pants":
                id_type_product = 1;
                List<ProductDTO> productPantDTOS = productService.findProductByIdType(id_type_product);
                req.setAttribute("shirts", productPantDTOS);
                req.getRequestDispatcher("/products/home.jsp").forward(req, resp);
                break;
            default:
                List<ProductDTO> productDTOS = productService.findAllProduct();
                req.setAttribute("products", productDTOS);
                req.getRequestDispatcher("/products/home.jsp").forward(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String action = req.getParameter("action");
        int id_type_product;

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "shirts":
                id_type_product = 2;
                List<ProductDTO> productShirtDTOS = productService.findProductByIdType(id_type_product);
                req.setAttribute("shirts", productShirtDTOS);
                req.getRequestDispatcher("/products/home.jsp").forward(req, resp);
                resp.sendRedirect(req.getContextPath() + "/daisy");
                break;
            case "pants":
                id_type_product = 1;
                List<ProductDTO> productPantDTOS = productService.findProductByIdType(id_type_product);
                req.setAttribute("shirts", productPantDTOS);
                req.getRequestDispatcher("/products/home.jsp").forward(req, resp);
                resp.sendRedirect(req.getContextPath() + "/daisy");
                break;
            case "search":
                String search = req.getParameter("search");
                List<ProductDTO> productDTOS = productService.findByName(search);
                req.setAttribute("products", productDTOS);
                req.getRequestDispatcher("/products/home.jsp").forward(req, resp);
                break;
            default:
                resp.sendRedirect(req.getContextPath() + "/daisy");
                break;
        }
    }
}

