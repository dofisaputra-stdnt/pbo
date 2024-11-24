package com.kuliahumb.pbo.pertemuan10;

import java.sql.*;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/toko";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "secret";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM produk";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Nama: " + rs.getString("nama"));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC tidak ditemukan!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Gagal terhubung ke database!");
            e.printStackTrace();
        }

    }

}
