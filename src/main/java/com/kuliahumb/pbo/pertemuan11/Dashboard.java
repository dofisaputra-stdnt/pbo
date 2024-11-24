package com.kuliahumb.pbo.pertemuan11;

import com.kuliahumb.pbo.pertemuan11.entity.Order;
import com.kuliahumb.pbo.pertemuan11.entity.OrderProduct;
import com.kuliahumb.pbo.pertemuan11.entity.Product;
import com.kuliahumb.pbo.pertemuan11.entity.User;
import com.kuliahumb.pbo.pertemuan11.service.DataService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class Dashboard extends JFrame {
    private JButton listUserButton;
    private JButton listProductButton;
    private JButton listOrderButton;
    private JButton listProductOrderButton;
    private JTable tableData;
    private JScrollPane tScrollPane;
    private JButton CRUDUserButton;
    private JButton CRUDProductButton;
    private JButton CRUDOrderButton;
    private JButton CRUDOrderProductButton;
    private JPanel mainPanel;

    public Dashboard(User user) {
        setTitle("Dashboard");
        setContentPane(mainPanel);
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        if (!user.getRole().equalsIgnoreCase("admin")) {
            disableCRUDButton();
        }

        listUserButton.addActionListener(e -> refreshTableUser());
        listProductButton.addActionListener(e -> refreshTableProduct());
        listOrderButton.addActionListener(e -> refreshTableOrder());
        listProductOrderButton.addActionListener(e -> refreshTableOrderProduct());
        CRUDUserButton.addActionListener(e -> new CRUDUser(this));
        CRUDProductButton.addActionListener(e -> new CRUDProduct(this));
        CRUDOrderButton.addActionListener(e -> new CRUDOrder(this));
        CRUDOrderProductButton.addActionListener(e -> new CRUDOrderProduct(this));
    }

    private void disableCRUDButton() {
        CRUDUserButton.setEnabled(false);
        CRUDProductButton.setEnabled(false);
        CRUDOrderButton.setEnabled(false);
        CRUDOrderProductButton.setEnabled(false);
    }

    public void refreshTableUser() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID", "Username", "Email", "Role"});
        List<User> users = DataService.getListUser();
        users.forEach(user -> model.addRow(new Object[]{user.getId(), user.getUsername(), user.getEmail(), user.getRole()}));
        tableData.setModel(model);
        tScrollPane.setViewportView(tableData);
    }

    public void refreshTableProduct() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Code", "Product Line ID", "Name", "Scale", "Vendor", "Description", "Qty in Stock", "Buy Price", "MSRP"});
        List<Product> products = DataService.getListProduct();
        products.forEach(product -> model.addRow(new Object[]{product.getCode(), product.getProductLineId(), product.getName(), product.getScale(), product.getVendor(), product.getPdtDescription(), product.getQtyInStock(), product.getBuyPrice(), product.getMSRP()}));
        tableData.setModel(model);
        tScrollPane.setViewportView(tableData);
    }

    public void refreshTableOrder() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID", "Order Date", "Required Date", "Shipped Date", "Status", "Comments"});
        List<Order> orders = DataService.getListOrder();
        orders.forEach(order -> model.addRow(new Object[]{order.getId(), order.getOrderDate(), order.getRequiredDate(), order.getShippedDate(), order.getStatus(), order.getComments()}));
        tableData.setModel(model);
        tScrollPane.setViewportView(tableData);
    }

    public void refreshTableOrderProduct() {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Order ID", "Product Code", "Qty", "Price Each"});
        List<OrderProduct> orderProducts = DataService.getListOrderProduct();
        orderProducts.forEach(orderProduct -> model.addRow(new Object[]{orderProduct.getOrderId(), orderProduct.getProductCode(), orderProduct.getQty(), orderProduct.getPriceEach()}));
        tableData.setModel(model);
        tScrollPane.setViewportView(tableData);
    }

}
