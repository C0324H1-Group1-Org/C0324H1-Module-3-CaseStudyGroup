package com.example.c0324h1module3casestudygroup.repositories.implement;

import com.example.c0324h1module3casestudygroup.dto.UserDTO;
import com.example.c0324h1module3casestudygroup.repositories.BaseRepository;
import com.example.c0324h1module3casestudygroup.repositories.IUserRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRepository implements IUserRepository {
    @Override
    public boolean isValidUser(String username, String password) {
        String check_acc_sql = "select * from customer join account on customer.id_acc = account.id_acc where username = ? and password = ?";
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(check_acc_sql);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public boolean isUsernameTaken(String username) {
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement("select count(*) from account where username = ?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    @Override
    public void register(UserDTO userDTO) {
        String insert_customer_sql = "insert into customer(id_acc, name_customer, phone, email, address) values (?, ?, ?, ?, ?)";
        String insert_account = "insert into account(username, password) values (?, ?)";
        try {
            PreparedStatement accountStatement = BaseRepository.getConnection().prepareStatement(insert_account, PreparedStatement.RETURN_GENERATED_KEYS);
            accountStatement.setString(1, userDTO.getUsername());
            accountStatement.setString(2, userDTO.getPassword());
            accountStatement.executeUpdate();

            ResultSet resultSet = accountStatement.getGeneratedKeys();
            if (resultSet.next()) {
                int accountId = resultSet.getInt(1);
                PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(insert_customer_sql);
                preparedStatement.setInt(1, accountId);
                preparedStatement.setString(2, userDTO.getName());
                preparedStatement.setString(3, userDTO.getPhone());
                preparedStatement.setString(4, userDTO.getEmail());
                preparedStatement.setString(5, userDTO.getAddress());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getUserIdByUsername(String username) {
        try {
            String sql = "select customer.id_customer from customer join account on customer.id_acc = account.id_acc where account.username = ?";
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_customer");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }
}
