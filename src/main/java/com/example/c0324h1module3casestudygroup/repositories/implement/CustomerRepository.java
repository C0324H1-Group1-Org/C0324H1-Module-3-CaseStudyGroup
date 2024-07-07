package com.example.c0324h1module3casestudygroup.repositories.implement;

import com.example.c0324h1module3casestudygroup.dto.CartDTO;
import com.example.c0324h1module3casestudygroup.models.Account;
import com.example.c0324h1module3casestudygroup.models.Customer;
import com.example.c0324h1module3casestudygroup.repositories.ICustomerRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public void register(Customer customer, Account account) {
        String insert_customer_sql = "insert into customer(id_acc, name_customer, phone, email, address) values (?, ?, ?, ?, ?)";
        String insert_account = "insert into account(username, password) values (?, ?)";
        try {
            PreparedStatement accountStatement = BaseRepository.getConnection().prepareStatement(insert_account, PreparedStatement.RETURN_GENERATED_KEYS);
            accountStatement.setString(1, account.getUsername());
            accountStatement.setString(2, account.getPassword());
            accountStatement.executeUpdate();

            ResultSet resultSet = accountStatement.getGeneratedKeys();
            if (resultSet.next()) {
                int accountId = resultSet.getInt(1);
                PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(insert_customer_sql);
                preparedStatement.setInt(1, accountId);
                preparedStatement.setString(2, customer.getName());
                preparedStatement.setString(3, customer.getPhone());
                preparedStatement.setString(4, customer.getEmail());
                preparedStatement.setString(5, customer.getAddress());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<CartDTO> getCart(String username) {
        List<CartDTO> list = new ArrayList<>();
        String sql = "select cart.id_cart,url_image,product.id_product,name_product, price,quantity,(price*quantity) as priceQuantity from account \n" +
                "inner join customer on account.id_acc = customer.id_acc \n" +
                "inner join cart on cart.id_customer = customer.id_customer \n" +
                "inner join cart_item on cart.id_cart = cart_item.id_cart\n" +
                "inner join product on cart_item.id_product = product.id_product\n" +
                "where account.username = ?";
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(sql);
            preparedStatement.setString(1,username);
            ResultSet set = preparedStatement.executeQuery();
            while (set.next()){
                list.add(new CartDTO(set.getInt("id_cart"),set.getString("url_image"),set.getInt("id_product"),set.getString("name_product"),set.getFloat("price"),
                        set.getInt("quantity"),set.getFloat("priceQuantity")
                        ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return list;
    }

    @Override
    public void deleteCartItem(int idCart, int idProduct) {
        String sql = "delete from cart_item where id_cart=? and id_product=?";
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1,idCart);
            preparedStatement.setInt(2,idProduct);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateCartItem(int idCartUpdate, int idProductUpdate, int inputQuantity) {
        String sql = "update cart_item set quantity = ? where id_cart = ? and id_product = ?";
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1,inputQuantity);
            preparedStatement.setInt(2,idCartUpdate);
            preparedStatement.setInt(3,idProductUpdate);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
