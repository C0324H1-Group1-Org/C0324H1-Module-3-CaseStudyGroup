package com.example.c0324h1module3casestudygroup.controllers;

//import com.example.c0324h1module3casestudygroup.dto.CartDTO;
import com.example.c0324h1module3casestudygroup.dto.ProductDTO;
import com.example.c0324h1module3casestudygroup.services.IProductService;
//import com.example.c0324h1module3casestudygroup.repositories.IProductsRepository;
//import com.example.c0324h1module3casestudygroup.repositories.implement.ProductsRepository;
//import com.example.c0324h1module3casestudygroup.services.ICustomerService;
//import com.example.c0324h1module3casestudygroup.services.IProductService;
//import com.example.c0324h1module3casestudygroup.services.implement.CustomerService;
import com.example.c0324h1module3casestudygroup.services.implement.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet (name = "HomeController",value = "/daisy")
public class HomeController extends HttpServlet {
//<<<<<<< HEAD

    private static IProductService productService = new ProductService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pageId = 1;
        String page = req.getParameter("page");
        if (page != null){
            pageId = Integer.parseInt(page);
        }
        String action = req.getParameter("action");
        int id_type_product;
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "shirts":
                id_type_product = 1;
                List<ProductDTO> productShirtDTOS = productService.findProductByIdType(id_type_product);
                req.setAttribute("products", productShirtDTOS);
                req.getRequestDispatcher("/products/home.jsp").forward(req, resp);
                break;
            case "pants":
                id_type_product = 2;
                List<ProductDTO> productPantDTOS = productService.findProductByIdType(id_type_product);
                req.setAttribute("products", productPantDTOS);
                req.getRequestDispatcher("/products/home.jsp").forward(req, resp);
                break;
            case "logo":
            default:
                List<ProductDTO> productDTOS1 = productService.findAllProduct();
                req.setAttribute("products", productDTOS1);
                req.getRequestDispatcher("/products/home.jsp").forward(req, resp);
                break;
        }
    }
        @Override
        protected void doPost (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("utf-8");
            String action = req.getParameter("action");
            int id_type_product;

            if (action == null) {
                action = "";
            }
            switch (action) {
                case "shirts":
                    id_type_product = 1;
                    List<ProductDTO> productShirtDTOS = productService.findProductByIdType(id_type_product);
                    req.setAttribute("products", productShirtDTOS);
                    req.getRequestDispatcher("/products/home.jsp").forward(req, resp);
                    break;
                case "pants":
                    id_type_product = 2;
                    List<ProductDTO> productPantDTOS = productService.findProductByIdType(id_type_product);
                    req.setAttribute("products", productPantDTOS);
                    req.getRequestDispatcher("/products/home.jsp").forward(req, resp);

                    break;
                case "search":
                    String search = req.getParameter("search");
                    if (search == null || search.trim().isEmpty()){
                        List<ProductDTO> productDTOS1 = productService.findAllProduct();
                        req.setAttribute("products", productDTOS1);
                        req.getRequestDispatcher("/products/home.jsp").forward(req, resp);
                    } else {
                        List<ProductDTO> productDTOS = productService.findByName(search.trim());
                        if (productDTOS==null || productDTOS.isEmpty()) {
                            List<ProductDTO> productDTOS1 = productService.findAllProduct();
                            req.setAttribute("products", productDTOS1);
                            req.getRequestDispatcher("/products/home.jsp").forward(req, resp);
                        } else {
                            req.setAttribute("products", productDTOS);
                            req.getRequestDispatcher("/products/home.jsp").forward(req, resp);
                        }
                    }
                    break;
                case "logo":
                default:
                    resp.sendRedirect(req.getContextPath() + "/daisy");
                    break;
            }
        }
    }

