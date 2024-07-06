package com.example.c0324h1module3casestudygroup.services.implement;

import com.example.c0324h1module3casestudygroup.models.Account;
import com.example.c0324h1module3casestudygroup.models.Customer;
import com.example.c0324h1module3casestudygroup.repositories.ICustomerRepository;
import com.example.c0324h1module3casestudygroup.repositories.implement.CustomerRepository;
import com.example.c0324h1module3casestudygroup.services.ICustomerService;

public class CustomerService implements ICustomerService {
    ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public boolean isValidUser(String username, String password) {
        return customerRepository.isValidUser(username, password);
    }

    @Override
    public boolean isUsernameTaken(String username) {
        return customerRepository.isUsernameTaken(username);
    }

    @Override
    public void register(Customer customer, Account account) {
        customerRepository.register(customer, account);
    }
}
