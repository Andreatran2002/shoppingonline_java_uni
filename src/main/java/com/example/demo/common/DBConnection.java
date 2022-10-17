package com.example.demo.common;

import com.example.demo.model.Category;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
    private final String serverName = "localhost";
    private final String dbName = "ShopOnline";
    private final String portNumber = "1433";
    private final String instance = "";
    private final String userID = "sa";
    private final String password = "123Phuongvy";
    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" +
                portNumber + "\\" + instance + ";databaseName=" + dbName;
        if (instance == null || instance.trim().isEmpty())
            url = "jdbc:sqlserver://"+serverName+":"+portNumber
                    +";databaseName="+dbName+";encrypt=true;trustServerCertificate=true;";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }

    public static void main(String[] args) {
        try {
            System.out.println(new DBConnection().getConnection());
            String sql = "SELECT * FROM category WHERE categoryId = ? ";

            try {

                PreparedStatement ps = new DBConnection().getConnection().prepareStatement(sql);
                ps.setInt(1, 3);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    Category category = new Category();
                    category.setCateid(rs.getInt("categoryId"));
                    category.setCatename(rs.getString("categoryName"));
                    category.setStatus(rs.getInt("status"));
                    category.setIcon(rs.getString("images"));
                    System.out.println(category);
                }} catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
