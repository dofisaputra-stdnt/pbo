package com.kuliahumb.pbo.pertemuan11;

import com.kuliahumb.pbo.pertemuan11.service.DataService;
import com.kuliahumb.pbo.pertemuan11.util.DialogUtil;

import javax.swing.*;
import java.util.Objects;

public class CRUDUser extends JFrame {

    private JButton newButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton cancelButton;
    private JTextField textUsername;
    private JPasswordField textPassword;
    private JPasswordField textRetypePassword;
    private JTextField textEmail;
    private JComboBox comboRole;
    private JTextField textUserId;
    private JPanel mainPanel;

    public CRUDUser(Dashboard dashboard) {
        setTitle("CRUD User");
        setContentPane(mainPanel);
        pack();
        setVisible(true);
        clearForm();

        newButton.addActionListener(e -> {
            if (newButton.getText().equalsIgnoreCase("New")) {
                clearForm();
                enableForm(true, false);
                return;
            }

            String username = textUsername.getText();
            String password = new String(textPassword.getPassword());
            String retypePassword = new String(textRetypePassword.getPassword());
            String email = textEmail.getText();
            String role = Objects.requireNonNull(comboRole.getSelectedItem()).toString();

            if (username.isEmpty() || password.isEmpty() || retypePassword.isEmpty() || email.isEmpty() || role.isEmpty()) {
                DialogUtil.showError("All fields must be filled!");
                return;
            }

            if (!password.equals(retypePassword)) {
                DialogUtil.showError("Password and Retype Password must be the same!");
                return;
            }

            if (DataService.insertUser(username, password, email, role)) {
                DialogUtil.showInfo("User has been saved!");
                clearForm();
                dashboard.refreshTableUser();
            } else {
                DialogUtil.showError("Username already exists!");
            }
        });

        updateButton.addActionListener(e -> {
            if (updateButton.getText().equalsIgnoreCase("Update")) {
                clearForm();
                enableForm(true, true);
                return;
            }

            long userId = Long.parseLong(textUserId.getText());
            String username = textUsername.getText();
            String password = new String(textPassword.getPassword());
            String retypePassword = new String(textRetypePassword.getPassword());
            String email = textEmail.getText();
            String role = Objects.requireNonNull(comboRole.getSelectedItem()).toString();

            if (username.isEmpty() || password.isEmpty() || retypePassword.isEmpty() || email.isEmpty() || role.isEmpty()) {
                DialogUtil.showError("All fields must be filled!");
                return;
            }

            if (!password.equals(retypePassword)) {
                DialogUtil.showError("Password and Retype Password must be the same!");
                return;
            }

            if (DataService.updateUser(userId, username, password, email, role)) {
                DialogUtil.showInfo("User has been updated!");
                clearForm();
                dashboard.refreshTableUser();
            } else {
                DialogUtil.showError("User not found!");
            }
        });

        deleteButton.addActionListener(e -> {
            if (deleteButton.getText().equalsIgnoreCase("Delete")) {
                clearForm();
                enableFormOnlyUserId();
                return;
            }

            String userId = textUserId.getText();
            if (userId.isEmpty()) {
                DialogUtil.showError("User ID must be filled!");
                return;
            }

            if (DataService.deleteUser(Long.parseLong(userId))) {
                DialogUtil.showInfo("User has been deleted!");
                clearForm();
                dashboard.refreshTableUser();
            } else {
                DialogUtil.showError("User not found!");
            }
        });

        cancelButton.addActionListener(e -> clearForm());
    }

    private void enableForm(boolean status, boolean isUpdate) {
        textUserId.setEnabled(status && isUpdate);
        textUsername.setEnabled(status);
        textPassword.setEnabled(status);
        textRetypePassword.setEnabled(status);
        textEmail.setEnabled(status);
        comboRole.setEnabled(status);

        if (status && isUpdate) {
            textUserId.requestFocus();
            updateButton.setText("Save");

            newButton.setEnabled(false);
            updateButton.setEnabled(true);
            deleteButton.setEnabled(false);
        } else if (status) {
            textUsername.requestFocus();
            newButton.setText("Save");

            newButton.setEnabled(true);
            updateButton.setEnabled(false);
            deleteButton.setEnabled(false);
        }
    }

    private void enableFormOnlyUserId() {
        enableForm(false, false);
        textUserId.setEnabled(true);
        textUserId.requestFocus();
        deleteButton.setText("Confirm");

        newButton.setEnabled(false);
        updateButton.setEnabled(false);
        deleteButton.setEnabled(true);
    }

    private void clearForm() {
        textUserId.setText("");
        textUsername.setText("");
        textPassword.setText("");
        textRetypePassword.setText("");
        textEmail.setText("");
        comboRole.setSelectedIndex(0);

        newButton.setText("New");
        updateButton.setText("Update");
        deleteButton.setText("Delete");

        newButton.setEnabled(true);
        updateButton.setEnabled(true);
        deleteButton.setEnabled(true);

        enableForm(false, false);
    }

}
