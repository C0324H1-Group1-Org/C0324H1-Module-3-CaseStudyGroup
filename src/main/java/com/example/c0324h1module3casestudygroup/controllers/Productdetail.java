package com.example.c0324h1module3casestudygroup.controllers;

import com.example.c0324h1module3casestudygroup.models.Product;
import com.example.c0324h1module3casestudygroup.services.ICustomerService;
import com.example.c0324h1module3casestudygroup.services.IProductService;
import com.example.c0324h1module3casestudygroup.services.implement.CustomerService;
import com.example.c0324h1module3casestudygroup.services.implement.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name="ProducDetail", value = "/productdetail")
public class Productdetail extends HttpServlet {
    private static IProductService productService = new ProductService();
    private static ICustomerService customerService = new CustomerService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        String id = req.getParameter("pid");
        Product p = productService.getProductById(id);
        req.setAttribute("detail",p);
        req.getRequestDispatcher("/products/productdetail.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession(false);
        if (httpSession.getAttribute("customerId") == null){
            resp.sendRedirect("/login?action=login");
        } else {
            int idProduct = Integer.parseInt(req.getParameter("idProduct"));
            int quantity = Integer.parseInt(req.getParameter("quantity"));
            int customerId = (int) req.getSession().getAttribute("customerId");
            httpSession.setAttribute("addToCartMessage","Thêm "+quantity+" sản phẩm vào giỏ hàng thành công");
            customerService.addToCart(customerId,idProduct,quantity);
            resp.sendRedirect(req.getContextPath() + "/productdetail?pid="+idProduct);
        }

    }
}
