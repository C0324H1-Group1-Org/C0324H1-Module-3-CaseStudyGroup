package com.example.c0324h1module3casestudygroup.repositories;

import com.example.c0324h1module3casestudygroup.dto.UserDTO;

public interface IUserRepository {
    boolean isValidUser(String username, String password);

    boolean isUsernameTaken(String username);

    void register(UserDTO userDTO);

    int getUserIdByUsername(String username);
}
