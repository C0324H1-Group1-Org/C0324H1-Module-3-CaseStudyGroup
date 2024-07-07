package com.example.c0324h1module3casestudygroup.services.implement;

import com.example.c0324h1module3casestudygroup.dto.CartDTO;
import com.example.c0324h1module3casestudygroup.repositories.ICustomerRepository;
import com.example.c0324h1module3casestudygroup.repositories.implement.CustomerRepository;
import com.example.c0324h1module3casestudygroup.services.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public List<CartDTO> getCart(String username) {
        return customerRepository.getCart(username);
    }

    @Override
    public void deleteCartItem(int idCart, int idProduct) {
        customerRepository.deleteCartItem(idCart,idProduct);
    }

    @Override
    public void updateCartItem(int idCartUpdate, int idProductUpdate, int inputQuantity) {
        customerRepository.updateCartItem(idCartUpdate,idProductUpdate,inputQuantity);
    }


}
