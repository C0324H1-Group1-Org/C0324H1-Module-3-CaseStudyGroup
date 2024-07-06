package com.example.c0324h1module3casestudygroup.repositories;

import com.example.c0324h1module3casestudygroup.models.Account;
import com.example.c0324h1module3casestudygroup.models.Customer;

public interface ICustomerRepository {
    boolean isValidUser(java.lang.String username, java.lang.String password);

    boolean isUsernameTaken(String username);

    void register(Customer customer, Account account);
}
