package com.kuliahumb.pbo.pertemuan11;

import com.kuliahumb.pbo.pertemuan11.util.DBUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Login extends JFrame {

    private JTextField textUsername;
    private JPasswordField textPassword;
    private JButton loginButton;
    private JButton cancelButton;
    private JPanel mainPanel;

    private final Connection connection;

    public Login() throws SQLException {
        connection = DBUtil.getConnection();
        textUsername.requestFocus();

        setContentPane(mainPanel);
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        loginButton.addActionListener(e -> {
            String username = textUsername.getText();
            String password = new String(textPassword.getPassword());

            if (!username.isEmpty() && !password.isEmpty()) {
                try {
                    if (validateLogin(username, password)) {
                        JOptionPane.showMessageDialog(null, "Login Success");
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                        textUsername.requestFocus();
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Username dan Password must be filled");
                textUsername.requestFocus();
            }
        });

        cancelButton.addActionListener(e -> {
            textUsername.setText("");
            textPassword.setText("");
        });
    }

    private boolean validateLogin(String username, String password) throws SQLException {
        Statement statement = connection.createStatement();
        String query = "SELECT * FROM user WHERE username = '" + username + "' AND password = '" + password + "'";
        return statement.executeQuery(query).next();
    }

    public static void main(String[] args) throws SQLException {
        Login login = new Login();
        login.pack();
        login.setVisible(true);
//        login.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

}
