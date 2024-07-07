package com.example.c0324h1module3casestudygroup.services;

import com.example.c0324h1module3casestudygroup.dto.CartDTO;

import java.util.List;

public interface ICustomerService {

    List<CartDTO> getCart(String username);

    void deleteCartItem(int idCart, int idProduct);


    void updateCartItem(int idCartUpdate, int idProductUpdate, int inputQuantity);
}
