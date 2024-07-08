package com.example.c0324h1module3casestudygroup.repositories.implement;

import com.example.c0324h1module3casestudygroup.dto.CartDTO;
import com.example.c0324h1module3casestudygroup.models.Customer;
import com.example.c0324h1module3casestudygroup.repositories.BaseRepository;
import com.example.c0324h1module3casestudygroup.repositories.ICustomerRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {

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

    @Override
    public Customer getCustomerById(int customerId) {
        String sql = "select * from customer where customer.id_customer = ?";
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, customerId);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt("id_customer"));
                customer.setName(rs.getString("name_customer"));
                customer.setPhone(rs.getString("phone"));
                customer.setEmail(rs.getString("email"));
                customer.setAddress(rs.getString("address"));
                return customer;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void addToCart(int customerId,int idProduct, int quantity) {
        String sql = "select * from cart where id_customer = ?";
        String sql_cart_item = "select * from cart_item where id_cart=? and id_product=?";
        String sql_increase_quantity = "update cart_item set quantity=? where id_cart=? and id_product=?";
        String sql_new_cart = "insert into cart(id_customer) values (?)";
        String sql_new_cart_item = "insert into cart_item values (?,?,?)";
        int cartId = 0;
        try {
            PreparedStatement preparedStatement = BaseRepository.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1,customerId);
            ResultSet set = preparedStatement.executeQuery();
            if (set.next()){
                cartId = set.getInt("id_cart");
            } else {
                PreparedStatement addNewCart = BaseRepository.getConnection().prepareStatement(sql_new_cart, Statement.RETURN_GENERATED_KEYS);
                addNewCart.setInt(1,customerId);
                ResultSet keyNewCart = addNewCart.getGeneratedKeys();
                if (keyNewCart.next()){
                    cartId = keyNewCart.getInt(1);
                }
            }
            PreparedStatement preparedStatement1 = BaseRepository.getConnection().prepareStatement(sql_cart_item);
            preparedStatement1.setInt(1,cartId);
            preparedStatement1.setInt(2,idProduct);
            ResultSet set1 = preparedStatement1.executeQuery();
            if (set1.next()){
                int oldQuantity = set1.getInt("quantity");
                int newQuantity = oldQuantity + quantity;
                PreparedStatement preparedStatement2 = BaseRepository.getConnection().prepareStatement(sql_increase_quantity);
                preparedStatement2.setInt(1,newQuantity);
                preparedStatement2.setInt(2,cartId);
                preparedStatement2.setInt(3,idProduct);
                preparedStatement2.executeUpdate();
            } else {
                PreparedStatement addNewCartItem = BaseRepository.getConnection().prepareStatement(sql_new_cart_item);
                addNewCartItem.setInt(1,cartId);
                addNewCartItem.setInt(2,idProduct);
                addNewCartItem.setInt(3,quantity);
                addNewCartItem.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
