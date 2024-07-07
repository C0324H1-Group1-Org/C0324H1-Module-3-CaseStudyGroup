package com.example.c0324h1module3casestudygroup.controllers;

import com.example.c0324h1module3casestudygroup.models.Product;
import com.example.c0324h1module3casestudygroup.services.IProductService;
import com.example.c0324h1module3casestudygroup.services.implement.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name="ProducDetail", value = "/productdetail")
public class Productdetail extends HttpServlet {
    private static IProductService productService = new ProductService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String id = req.getParameter("pid");
        Product p = productService.getProductById(id);
        req.setAttribute("detail",p);
        req.getRequestDispatcher("productdetail.jsp").forward(req,resp);
    }
}
