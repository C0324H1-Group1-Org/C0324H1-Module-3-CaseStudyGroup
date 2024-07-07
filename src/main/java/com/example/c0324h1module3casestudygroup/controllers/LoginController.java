package com.example.c0324h1module3casestudygroup.controllers;

import com.example.c0324h1module3casestudygroup.dto.UserDTO;
import com.example.c0324h1module3casestudygroup.services.IUserService;
import com.example.c0324h1module3casestudygroup.services.implement.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet",value = "/login")
public class LoginController extends HttpServlet {
    IUserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action =request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "register":
                showFormRegister(request, response);
                break;
            case "login":
                showFormLogin(request, response);
                break;
            case "logout":
                HttpSession session = request.getSession(false);
                if (session != null) {
                    session.invalidate();
                }
                response.sendRedirect("/daisy");
                break;
            default:
//                showFormLogin(request, response);
        }
    }

    private void showFormRegister(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login/register.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormLogin(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/login/login.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action =request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "login":
                loginCustomer(request, response);
                break;
            case "register":
                registerCustomer(request, response);
                break;
        }
    }

    private void loginCustomer(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean isLogin = userService.isValidUser(username, password);
        if (isLogin) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            try {
                response.sendRedirect("/daisy");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            request.setAttribute("username", username);
            request.setAttribute("message", "Tài khoản, mật khẩu không chính xác");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login/login.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void registerCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserDTO userDTO = new UserDTO(name, phone, email, address, username, password);

        if (userService.isUsernameTaken(username)) {
            request.setAttribute("user", userDTO);
            request.setAttribute("message", "Tài khoản đã tồn tại");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/login/register.jsp");
            try {
                dispatcher.forward(request, response);
            } catch (ServletException | IOException e) {
                throw new RuntimeException(e);
            }
            return;
        }

        userService.register(userDTO);
        try {
            response.sendRedirect("/login?action=login");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
