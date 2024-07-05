package com.example.c0324h1module3casestudygroup.services.implement;

import com.example.c0324h1module3casestudygroup.repositories.ICustomerRepository;
import com.example.c0324h1module3casestudygroup.repositories.implement.CustomerRepository;
import com.example.c0324h1module3casestudygroup.services.ICustomerService;

public class CustomerService implements ICustomerService {
    ICustomerRepository customerRepository = new CustomerRepository();

    @Override
    public boolean isValidUser(String username, String password) {
        return customerRepository.isValidUser(username, password);
    }
}
