package com.kuliahumb.pbo.pertemuan11.service;

import com.kuliahumb.pbo.pertemuan11.entity.Order;
import com.kuliahumb.pbo.pertemuan11.entity.OrderProduct;
import com.kuliahumb.pbo.pertemuan11.entity.Product;
import com.kuliahumb.pbo.pertemuan11.entity.User;
import com.kuliahumb.pbo.pertemuan11.util.DBUtil;
import com.kuliahumb.pbo.pertemuan11.util.DialogUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DataService {

    public static List<User> getListUser() {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "SELECT * FROM user";
            ResultSet resultSet = connection.createStatement().executeQuery(query);

            List<User> users = new ArrayList<>();
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getLong("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getString("role")
                ));
            }
            return users;
        } catch (Exception e) {
            DialogUtil.showError(e.getMessage());
            return new ArrayList<>();
        }
    }

    public static List<Product> getListProduct() {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "SELECT * FROM product";
            ResultSet resultSet = connection.createStatement().executeQuery(query);

            List<Product> products = new ArrayList<>();
            while (resultSet.next()) {
                products.add(new Product(
                        resultSet.getLong("code"),
                        resultSet.getLong("productLineId"),
                        resultSet.getString("name"),
                        resultSet.getInt("scale"),
                        resultSet.getString("vendor"),
                        resultSet.getString("pdtDescription"),
                        resultSet.getInt("qtyInStock"),
                        resultSet.getDouble("buyPrice"),
                        resultSet.getDouble("MSRP")
                ));
            }
            return products;
        } catch (Exception e) {
            DialogUtil.showError(e.getMessage());
            return new ArrayList<>();
        }
    }

    public static List<Order> getListOrder() {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "SELECT * FROM `order`";
            ResultSet resultSet = connection.createStatement().executeQuery(query);

            List<Order> orders = new ArrayList<>();
            while (resultSet.next()) {
                orders.add(new Order(
                        resultSet.getLong("id"),
                        resultSet.getLong("customerId"),
                        resultSet.getTimestamp("orderDate"),
                        resultSet.getTimestamp("requiredDate"),
                        resultSet.getTimestamp("shippedDate"),
                        resultSet.getString("status"),
                        resultSet.getString("comments")
                ));
            }
            return orders;
        } catch (Exception e) {
            DialogUtil.showError(e.getMessage());
            return new ArrayList<>();
        }
    }

    public static List<OrderProduct> getListOrderProduct() {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "SELECT * FROM order_product";
            ResultSet resultSet = connection.createStatement().executeQuery(query);

            List<OrderProduct> orderProducts = new ArrayList<>();
            while (resultSet.next()) {
                orderProducts.add(new OrderProduct(
                        resultSet.getLong("id"),
                        resultSet.getLong("orderId"),
                        resultSet.getLong("productCode"),
                        resultSet.getInt("qty"),
                        resultSet.getDouble("priceEach")
                ));
            }
            return orderProducts;
        } catch (Exception e) {
            DialogUtil.showError(e.getMessage());
            return new ArrayList<>();
        }
    }

    public static boolean insertUser(String username, String password, String email, String role) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "INSERT INTO user (username, password, email, role) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, email);
            stmt.setString(4, role);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            DialogUtil.showError(e.getMessage());
            return false;
        }
    }

    public static boolean updateUser(long id, String username, String password, String email, String role) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "UPDATE user SET username = ?, password = ?, email = ?, role = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, email);
            stmt.setString(4, role);
            stmt.setLong(5, id);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            DialogUtil.showError(e.getMessage());
            return false;
        }
    }

    public static boolean insertProduct(String name, int scale, String vendor, String pdtDescription, int qtyInStock, double buyPrice, double MSRP) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "INSERT INTO product (productLineId, name, scale, vendor, pdtDescription, qtyInStock, buyPrice, MSRP) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, 1);
            stmt.setString(2, name);
            stmt.setInt(3, scale);
            stmt.setString(4, vendor);
            stmt.setString(5, pdtDescription);
            stmt.setInt(6, qtyInStock);
            stmt.setDouble(7, buyPrice);
            stmt.setDouble(8, MSRP);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            DialogUtil.showError(e.getMessage());
            return false;
        }
    }

    public static boolean updateProduct(long code, String name, int scale, String vendor, String pdtDescription, int qtyInStock, double buyPrice, double MSRP) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "UPDATE product SET name = ?, scale = ?, vendor = ?, pdtDescription = ?, qtyInStock = ?, buyPrice = ?, MSRP = ? WHERE code = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setInt(2, scale);
            stmt.setString(3, vendor);
            stmt.setString(4, pdtDescription);
            stmt.setInt(5, qtyInStock);
            stmt.setDouble(6, buyPrice);
            stmt.setDouble(7, MSRP);
            stmt.setLong(8, code);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            DialogUtil.showError(e.getMessage());
            return false;
        }
    }

    public static boolean insertOrder(Timestamp orderDate, Timestamp requiredDate, Timestamp shippedDate, String status, String comments) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "INSERT INTO `order` (customerId, orderDate, requiredDate, shippedDate, status, comments) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, 1);
            stmt.setTimestamp(2, orderDate);
            stmt.setTimestamp(3, requiredDate);
            stmt.setTimestamp(4, shippedDate);
            stmt.setString(5, status);
            stmt.setString(6, comments);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            DialogUtil.showError(e.getMessage());
            return false;
        }
    }

    public static boolean updateOrder(long id, Timestamp orderDate, Timestamp requiredDate, Timestamp shippedDate, String status, String comments) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "UPDATE `order` SET orderDate = ?, requiredDate = ?, shippedDate = ?, status = ?, comments = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setTimestamp(1, orderDate);
            stmt.setTimestamp(2, requiredDate);
            stmt.setTimestamp(3, shippedDate);
            stmt.setString(4, status);
            stmt.setString(5, comments);
            stmt.setLong(6, id);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            DialogUtil.showError(e.getMessage());
            return false;
        }
    }

    public static boolean insertOrderProduct(long orderId, long productCode, int qty, double priceEach) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "INSERT INTO order_product (orderId, productCode, qty, priceEach) VALUES ( ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, orderId);
            stmt.setLong(2, productCode);
            stmt.setInt(3, qty);
            stmt.setDouble(4, priceEach);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            DialogUtil.showError(e.getMessage());
            return false;
        }
    }

    public static boolean updateOrderProduct(long id, long orderId, long productCode, int qty, double priceEach) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "UPDATE order_product SET orderId = ?, productCode = ?, qty = ?, priceEach = ? WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, orderId);
            stmt.setLong(2, productCode);
            stmt.setInt(3, qty);
            stmt.setDouble(4, priceEach);
            stmt.setLong(5, id);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            DialogUtil.showError(e.getMessage());
            return false;
        }
    }

    public static boolean deleteUser(long id) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "DELETE FROM user WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            DialogUtil.showError(e.getMessage());
            return false;
        }
    }

    public static boolean deleteProduct(long code) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "DELETE FROM product WHERE code = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, code);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            DialogUtil.showError(e.getMessage());
            return false;
        }
    }

    public static boolean deleteOrder(long id) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "DELETE FROM `order` WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            DialogUtil.showError(e.getMessage());
            return false;
        }
    }

    public static boolean deleteOrderProduct(long id) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "DELETE FROM order_product WHERE id = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setLong(1, id);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            DialogUtil.showError(e.getMessage());
            return false;
        }
    }

}
