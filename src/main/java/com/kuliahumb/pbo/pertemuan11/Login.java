package com.kuliahumb.pbo.pertemuan11;

import com.kuliahumb.pbo.pertemuan11.entity.User;
import com.kuliahumb.pbo.pertemuan11.util.DBUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;

public class Login extends JFrame {
    private JPanel mainPanel;
    private JTextField txUsername;
    private JPasswordField txPassword;
    private JButton loginButton;
    private JButton cancelButton;

    public Login() {
        setTitle("Login");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        txUsername.requestFocus();
        loginButton.addActionListener(e -> {
            String username = txUsername.getText();
            String password = new String(txPassword.getPassword());

            User user = validateLogin(username, password);
            if (user != null) {
                new Dashboard(user);
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> System.exit(0));
    }

    private User validateLogin(String username, String password) {
        try (Connection connection = DBUtil.getConnection()) {
            String query = "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
            ResultSet resultSet = connection.createStatement().executeQuery(query);

            if (resultSet.next()) {
                return new User(
                        resultSet.getLong("id"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getString("role")
                );
            } else {
                return null;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        new Login();
    }

}
