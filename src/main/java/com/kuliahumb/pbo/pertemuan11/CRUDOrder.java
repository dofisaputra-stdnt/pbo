package com.kuliahumb.pbo.pertemuan11;

import com.github.lgooddatepicker.components.DateTimePicker;
import com.kuliahumb.pbo.pertemuan11.service.DataService;
import com.kuliahumb.pbo.pertemuan11.util.DialogUtil;

import javax.swing.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class CRUDOrder extends JFrame {
    private JPanel mainPanel;
    private JTextField textStatus;
    private JTextField textId;
    private JTextField textComment;
    private JButton newButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton cancelButton;
    private DateTimePicker pickerOrderDate;
    private DateTimePicker pickerRequiredDate;
    private DateTimePicker pickerShippedDate;

    public CRUDOrder(Dashboard dashboard) {
        setTitle("CRUD Order");
        setContentPane(mainPanel);
        pack();
        setVisible(true);
        clearForm();

        newButton.addActionListener(e -> {
            if (newButton.getText().equalsIgnoreCase("New")) {
                clearForm();
                enableForm(true, false);

                LocalDateTime now = LocalDateTime.now();
                pickerOrderDate.setDateTimePermissive(now);
                pickerRequiredDate.setDateTimePermissive(now);
                pickerShippedDate.setDateTimePermissive(now);
                return;
            }

            String status = textStatus.getText();
            String comment = textComment.getText();
            LocalDateTime orderDate = pickerOrderDate.getDateTimePermissive();
            LocalDateTime requiredDate = pickerRequiredDate.getDateTimePermissive();
            LocalDateTime shippedDate = pickerShippedDate.getDateTimePermissive();

            if (status.isEmpty() || comment.isEmpty() || orderDate == null || requiredDate == null || shippedDate == null) {
                DialogUtil.showError("All fields must be filled!");
                return;
            }

            if (DataService.insertOrder(Timestamp.valueOf(orderDate), Timestamp.valueOf(requiredDate), Timestamp.valueOf(shippedDate), status, comment)) {
                DialogUtil.showInfo("Order has been saved!");
                clearForm();
                dashboard.refreshTableOrder();
            } else {
                DialogUtil.showError("Order already exists!");
            }
        });

        updateButton.addActionListener(e -> {
            if (updateButton.getText().equalsIgnoreCase("Update")) {
                clearForm();
                enableForm(true, true);

                LocalDateTime now = LocalDateTime.now();
                pickerOrderDate.setDateTimePermissive(now);
                pickerRequiredDate.setDateTimePermissive(now);
                pickerShippedDate.setDateTimePermissive(now);
                return;
            }

            String id = textId.getText();
            String status = textStatus.getText();
            String comment = textComment.getText();
            LocalDateTime orderDate = pickerOrderDate.getDateTimePermissive();
            LocalDateTime requiredDate = pickerRequiredDate.getDateTimePermissive();
            LocalDateTime shippedDate = pickerShippedDate.getDateTimePermissive();

            if (id.isEmpty() || status.isEmpty() || comment.isEmpty() || orderDate == null || requiredDate == null || shippedDate == null) {
                DialogUtil.showError("All fields must be filled!");
                return;
            }

            if (DataService.updateOrder(Integer.parseInt(id), Timestamp.valueOf(orderDate), Timestamp.valueOf(requiredDate), Timestamp.valueOf(shippedDate), status, comment)) {
                DialogUtil.showInfo("Order has been updated!");
                clearForm();
                dashboard.refreshTableOrder();
            } else {
                DialogUtil.showError("Order not found!");
            }
        });

        deleteButton.addActionListener(e -> {
            if (deleteButton.getText().equalsIgnoreCase("Delete")) {
                enableFormOnlyOrderId();
                return;
            }

            String id = textId.getText();
            if (id.isEmpty()) {
                DialogUtil.showError("Order ID must be filled!");
                return;
            }
            if (DataService.deleteOrder(Integer.parseInt(id))) {
                DialogUtil.showInfo("Order has been deleted!");
                clearForm();
                dashboard.refreshTableOrder();
            } else {
                DialogUtil.showError("Order not found!");
            }
        });

        cancelButton.addActionListener(e -> clearForm());
    }

    private void enableForm(boolean status, boolean isUpdate) {
        textId.setEnabled(status && isUpdate);
        textStatus.setEnabled(status);
        textComment.setEnabled(status);
        pickerOrderDate.setEnabled(status);
        pickerRequiredDate.setEnabled(status);
        pickerShippedDate.setEnabled(status);

        if (status && isUpdate) {
            textId.requestFocus();
            updateButton.setText("Save");

            newButton.setEnabled(false);
            updateButton.setEnabled(true);
            deleteButton.setEnabled(false);
        } else if (status) {
            newButton.setText("Save");

            newButton.setEnabled(true);
            updateButton.setEnabled(false);
            deleteButton.setEnabled(false);
        }
    }

    private void enableFormOnlyOrderId() {
        enableForm(false, false);
        textId.setEnabled(true);
        textId.requestFocus();
        deleteButton.setText("Confirm");

        newButton.setEnabled(false);
        updateButton.setEnabled(false);
        deleteButton.setEnabled(true);
    }

    private void clearForm() {
        textId.setText("");
        textStatus.setText("");
        textComment.setText("");
        pickerOrderDate.clear();
        pickerRequiredDate.clear();
        pickerShippedDate.clear();

        newButton.setText("New");
        updateButton.setText("Update");
        deleteButton.setText("Delete");

        newButton.setEnabled(true);
        updateButton.setEnabled(true);
        deleteButton.setEnabled(true);

        enableForm(false, false);
    }

}
