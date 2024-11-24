package com.kuliahumb.pbo.pertemuan11;

import com.kuliahumb.pbo.pertemuan11.service.DataService;
import com.kuliahumb.pbo.pertemuan11.util.DialogUtil;

import javax.swing.*;

public class CRUDOrderProduct extends JFrame {

    private JPanel mainPanel;
    private JTextField textPriceEach;
    private JTextField textId;
    private JTextField textOrderId;
    private JTextField textProductCode;
    private JTextField textQty;
    private JButton newButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton cancelButton;

    public CRUDOrderProduct(Dashboard dashboard) {
        setTitle("CRUD Order Product");
        this.setContentPane(mainPanel);
        this.pack();
        this.setVisible(true);
        clearForm();

        newButton.addActionListener(e -> {
            if (newButton.getText().equalsIgnoreCase("New")) {
                clearForm();
                enableForm(true, false);
                return;
            }

            String orderId = textOrderId.getText();
            String productCode = textProductCode.getText();
            String qty = textQty.getText();
            String priceEach = textPriceEach.getText();

            if (orderId.isEmpty() || productCode.isEmpty() || qty.isEmpty() || priceEach.isEmpty()) {
                DialogUtil.showError("All fields must be filled!");
                return;
            }

            if (DataService.insertOrderProduct(Long.parseLong(orderId), Long.parseLong(productCode), Integer.parseInt(qty), Double.parseDouble(priceEach))) {
                DialogUtil.showInfo("Order Product has been saved!");
                clearForm();
                dashboard.refreshTableOrderProduct();
            } else {
                DialogUtil.showError("Order Product already exists!");
            }
        });

        updateButton.addActionListener(e -> {
            if (updateButton.getText().equalsIgnoreCase("Update")) {
                enableForm(true, true);
                return;
            }

            String id = textId.getText();
            String orderId = textOrderId.getText();
            String productCode = textProductCode.getText();
            String qty = textQty.getText();
            String priceEach = textPriceEach.getText();

            if (id.isEmpty() || orderId.isEmpty() || productCode.isEmpty() || qty.isEmpty() || priceEach.isEmpty()) {
                DialogUtil.showError("All fields must be filled!");
                return;
            }

            if (DataService.updateOrderProduct(Long.parseLong(id), Long.parseLong(orderId), Long.parseLong(productCode), Integer.parseInt(qty), Double.parseDouble(priceEach))) {
                DialogUtil.showInfo("Order Product has been updated!");
                clearForm();
                dashboard.refreshTableOrderProduct();
            } else {
                DialogUtil.showError("Order Product not found!");
            }
        });

        deleteButton.addActionListener(e -> {
            if (deleteButton.getText().equalsIgnoreCase("Delete")) {
                enableFormOnlyId();
                return;
            }

            String id = textId.getText();
            if (id.isEmpty()) {
                DialogUtil.showError("ID must be filled!");
                return;
            }

            if (DataService.deleteOrderProduct(Long.parseLong(id))) {
                DialogUtil.showInfo("Order Product has been deleted!");
                clearForm();
                dashboard.refreshTableOrderProduct();
            } else {
                DialogUtil.showError("Order Product not found!");
            }
        });

        cancelButton.addActionListener(e -> clearForm());
    }

    private void enableForm(boolean status, boolean isUpdate) {
        textId.setEnabled(status && isUpdate);
        textOrderId.setEnabled(status);
        textProductCode.setEnabled(status);
        textQty.setEnabled(status);
        textPriceEach.setEnabled(status);

        if (status && isUpdate) {
            textId.requestFocus();
            updateButton.setText("Save");

            newButton.setEnabled(false);
            updateButton.setEnabled(true);
            deleteButton.setEnabled(false);
        } else if (status) {
            textOrderId.requestFocus();
            newButton.setText("Save");

            newButton.setEnabled(true);
            updateButton.setEnabled(false);
            deleteButton.setEnabled(false);
        }
    }

    private void enableFormOnlyId() {
        enableForm(false, false);
        textId.setEnabled(true);
        textId.requestFocus();
        deleteButton.setText("Confirm");

        newButton.setEnabled(false);
        updateButton.setEnabled(false);
        deleteButton.setEnabled(true);
    }

    private void clearForm() {
        textPriceEach.setText("");
        textId.setText("");
        textOrderId.setText("");
        textProductCode.setText("");
        textQty.setText("");

        newButton.setText("New");
        updateButton.setText("Update");
        deleteButton.setText("Delete");

        newButton.setEnabled(true);
        updateButton.setEnabled(true);
        deleteButton.setEnabled(true);

        enableForm(false, false);
    }

}
