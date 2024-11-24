package com.kuliahumb.pbo.pertemuan11;

import com.kuliahumb.pbo.pertemuan11.service.DataService;
import com.kuliahumb.pbo.pertemuan11.util.DialogUtil;

import javax.swing.*;

public class CRUDProduct extends JFrame {

    private JButton newButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton cancelButton;
    private JTextField textCode;
    private JTextField textName;
    private JTextField textScale;
    private JTextField textVendor;
    private JTextField textDescription;
    private JTextField textQty;
    private JTextField textBuyPrice;
    private JTextField textMSRP;
    private JPanel mainPanel;

    public CRUDProduct(Dashboard dashboard) {
        setTitle("CRUD Product");
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

            String name = textName.getText();
            String vendor = textVendor.getText();
            String description = textDescription.getText();
            String scale = textScale.getText();
            String qty = textQty.getText();
            String buyPrice = textBuyPrice.getText();
            String msrp = textMSRP.getText();

            if (name.isEmpty() || vendor.isEmpty() || description.isEmpty() || scale.isEmpty() || qty.isEmpty() || buyPrice.isEmpty() || msrp.isEmpty()) {
                DialogUtil.showError("All fields must be filled!");
                return;
            }

            if (DataService.insertProduct(name, Integer.parseInt(scale), vendor, description, Integer.parseInt(qty), Double.parseDouble(buyPrice), Double.parseDouble(msrp))) {
                DialogUtil.showInfo("Product has been saved!");
                clearForm();
                dashboard.refreshTableProduct();
            } else {
                DialogUtil.showError("Product already exists!");
            }
        });

        updateButton.addActionListener(e -> {
            if (updateButton.getText().equalsIgnoreCase("Update")) {
                clearForm();
                enableForm(true, true);
                return;
            }

            String code = textCode.getText();
            String name = textName.getText();
            String vendor = textVendor.getText();
            String description = textDescription.getText();
            String scale = textScale.getText();
            String qty = textQty.getText();
            String buyPrice = textBuyPrice.getText();
            String msrp = textMSRP.getText();

            if (code.isEmpty() || name.isEmpty() || vendor.isEmpty() || description.isEmpty() || scale.isEmpty() || qty.isEmpty() || buyPrice.isEmpty() || msrp.isEmpty()) {
                DialogUtil.showError("All fields must be filled!");
                return;
            }

            if (DataService.updateProduct(Long.parseLong(code), name, Integer.parseInt(scale), vendor, description, Integer.parseInt(qty), Double.parseDouble(buyPrice), Double.parseDouble(msrp))) {
                DialogUtil.showInfo("Product has been updated!");
                clearForm();
                dashboard.refreshTableProduct();
            } else {
                DialogUtil.showError("Product not found!");
            }
        });

        deleteButton.addActionListener(e -> {
            if (deleteButton.getText().equalsIgnoreCase("Delete")) {
                clearForm();
                enableFormOnlyCode();
                return;
            }

            String code = textCode.getText();
            if (code.isEmpty()) {
                DialogUtil.showError("Code must be filled!");
                return;
            }

            if (DataService.deleteProduct(Long.parseLong(code))) {
                DialogUtil.showInfo("Product has been deleted!");
                clearForm();
                dashboard.refreshTableProduct();
            } else {
                DialogUtil.showError("Product not found!");
            }
        });

        cancelButton.addActionListener(e -> clearForm());
    }

    private void enableForm(boolean status, boolean isUpdate) {
        textCode.setEnabled(status && isUpdate);
        textName.setEnabled(status);
        textVendor.setEnabled(status);
        textDescription.setEnabled(status);
        textScale.setEnabled(status);
        textQty.setEnabled(status);
        textBuyPrice.setEnabled(status);
        textMSRP.setEnabled(status);

        if (status && isUpdate) {
            textCode.requestFocus();
            updateButton.setText("Save");

            newButton.setEnabled(false);
            updateButton.setEnabled(true);
            deleteButton.setEnabled(false);
        } else if (status) {
            textName.requestFocus();
            newButton.setText("Save");

            newButton.setEnabled(true);
            updateButton.setEnabled(false);
            deleteButton.setEnabled(false);
        }
    }

    private void enableFormOnlyCode() {
        enableForm(false, false);
        textCode.setEnabled(true);
        textCode.requestFocus();
        deleteButton.setText("Confirm");

        newButton.setEnabled(false);
        updateButton.setEnabled(false);
        deleteButton.setEnabled(true);
    }

    private void clearForm() {
        textName.setText("");
        textVendor.setText("");
        textDescription.setText("");
        textCode.setText("");
        textScale.setText("");
        textQty.setText("");
        textBuyPrice.setText("");
        textMSRP.setText("");

        newButton.setText("New");
        updateButton.setText("Update");
        deleteButton.setText("Delete");

        newButton.setEnabled(true);
        updateButton.setEnabled(true);
        deleteButton.setEnabled(true);

        enableForm(false, false);
    }

}
