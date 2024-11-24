package com.kuliahumb.pbo.pertemuan11;

import com.kuliahumb.pbo.pertemuan11.util.DBUtil;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;

public class CRUDUser extends JFrame {

    private JButton newButton;
    private JButton updateButton;
    private JButton cancelButton;
    private JTextField textUsername;
    private JPasswordField textPassword;
    private JPasswordField textRetypePassword;
    private JTextField textEmail;
    private JComboBox comboRole;
    private JTextField textUserId;
    private JPanel mainPanel;

    private final Connection connection;

    public CRUDUser() {
        connection = DBUtil.getConnection();
        disableForm();

        setContentPane(mainPanel);
        setTitle("CRUD User");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        newButton.addActionListener(e -> {
            clearForm();
            enableForm(false);
            textUsername.requestFocus();

            try {
                insertUser();
                JOptionPane.showMessageDialog(null, "User has been added");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        updateButton.addActionListener(e -> {
            clearForm();
            enableForm(true);
            textUserId.requestFocus();
        });

        cancelButton.addActionListener(e -> {
            clearForm();
            disableForm();
        });
    }

    private void disableForm() {
        textUserId.setEnabled(false);
        textUsername.setEnabled(false);
        textPassword.setEnabled(false);
        textRetypePassword.setEnabled(false);
        textEmail.setEnabled(false);
        comboRole.setEnabled(false);
    }

    private void enableForm(boolean isUpdate) {
        textUserId.setEnabled(isUpdate);
        textUsername.setEnabled(true);
        textPassword.setEnabled(true);
        textRetypePassword.setEnabled(true);
        textEmail.setEnabled(true);
        comboRole.setEnabled(true);
    }

    private void clearForm() {
        textUserId.setText("");
        textUsername.setText("");
        textPassword.setText("");
        textRetypePassword.setText("");
        textEmail.setText("");
        comboRole.setSelectedIndex(0);
    }

    private void insertUser() throws SQLException {
        String username = textUsername.getText();
        String password = new String(textPassword.getPassword());
        String email = textEmail.getText();
        String role = Objects.requireNonNull(comboRole.getSelectedItem()).toString();

        if (username.isEmpty() || password.isEmpty() || email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Username, Password, and Email must be filled");
            return;
        }

        Statement statement = connection.createStatement();
        String query = "INSERT INTO user (username, password, email, role) VALUES ('" + username + "', '" + password + "', '" + email + "', '" + role + "')";
        statement.executeUpdate(query);
    }

    public static void main(String[] args) {
        CRUDUser frame = new CRUDUser();
        frame.pack();
        frame.setVisible(true);
    }

}
