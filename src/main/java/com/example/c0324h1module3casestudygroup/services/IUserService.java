package com.example.c0324h1module3casestudygroup.services;

import com.example.c0324h1module3casestudygroup.dto.UserDTO;

public interface IUserService {
    boolean isValidUser(String username, String password);

    boolean isUsernameTaken(String username);

    void register(UserDTO userDTO);
}
