package com.example.c0324h1module3casestudygroup.services.implement;

import com.example.c0324h1module3casestudygroup.dto.UserDTO;
import com.example.c0324h1module3casestudygroup.repositories.IUserRepository;
import com.example.c0324h1module3casestudygroup.repositories.implement.UserRepository;
import com.example.c0324h1module3casestudygroup.services.IUserService;

public class UserService implements IUserService {
    IUserRepository userRepository = new UserRepository();
    @Override
    public boolean isValidUser(String username, String password) {
        return userRepository.isValidUser(username, password);
    }

    @Override
    public boolean isUsernameTaken(String username) {
        return userRepository.isUsernameTaken(username);
    }

    @Override
    public void register(UserDTO userDTO) {
        userRepository.register(userDTO);
    }

    @Override
    public int getUserIdByUsername(String username) {
        return userRepository.getUserIdByUsername(username);
    }
}
