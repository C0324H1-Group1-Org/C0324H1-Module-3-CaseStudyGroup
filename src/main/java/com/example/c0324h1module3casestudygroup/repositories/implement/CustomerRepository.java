package com.example.c0324h1module3casestudygroup.repositories.implement;

import com.example.c0324h1module3casestudygroup.repositories.ICustomerRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRepository implements ICustomerRepository {
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
}
