package com.example.c0324h1module3casestudygroup.services;

import com.example.c0324h1module3casestudygroup.models.Account;
import com.example.c0324h1module3casestudygroup.models.Customer;

public interface ICustomerService {
    boolean isValidUser(String username, String password);

    boolean isUsernameTaken(String username);

    void register(Customer customer, Account account);
}
