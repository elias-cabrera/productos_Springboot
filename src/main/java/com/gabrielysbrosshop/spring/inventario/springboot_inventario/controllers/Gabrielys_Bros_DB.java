package com.gabrielysbrosshop.spring.inventario.springboot_inventario.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

public class Gabrielys_Bros_DB {
    // JDBC URL, username and password of MySQL server
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String USER = "root";
    private static final String PASSWORD = "1ng3n13r0El1@$"; // replace with your MySQL root password

    public static void main(String[] args) {
        // Create a connection to the MySQL server
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement()) {
            PreparedStatement pstmt = null;
            // Connection established
            System.out.println("Connected to MySQL server successfully...");

            // Insert records into the database
            String sql = "INSERT INTO Gabrielys_Bros.Productos (producto_nombre, descripcion, precio, cantidad_en_stock,categoria, creado_a_las,usuario_id) values (?,?,?,?,?,?,?)";
            // Create PreparedStatement object
            pstmt = connection.prepareStatement(sql);

            // Set parameters for the PreparedStatement
            pstmt.setString(1, "Batman");
            pstmt.setString(2, "");
            pstmt.setDouble(3, 150.00);
            pstmt.setInt(4, 1);
            pstmt.setString(5, "Pelcuhes");
            pstmt.setTimestamp(6, new java.sql.Timestamp(System.currentTimeMillis()));
            pstmt.setInt(7, 2);

            // Execute the statement
            int rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int guardarProductos(Productos productos) {
        int rowsAffected = 0;
        // Create a connection to the MySQL server
        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
                Statement statement = connection.createStatement()) {
            PreparedStatement pstmt = null;
            // Connection established
            System.out.println("Connected to MySQL server successfully...");

            // Insert records into the database
            String sql = "INSERT INTO Gabrielys_Bros.Productos (producto_nombre, descripcion, precio, cantidad_en_stock,categoria, creado_a_las,usuario_id) values (?,?,?,?,?,?,?)";
            // Create PreparedStatement object
            pstmt = connection.prepareStatement(sql);

            // Set parameters for the PreparedStatement
            pstmt.setString(1, productos.getNombre());
            pstmt.setString(2, productos.getDescripcion());
            pstmt.setDouble(3, productos.getPrecio());
            pstmt.setInt(4, productos.getCantidadEnStock());
            pstmt.setString(5, productos.getCategoria());
            pstmt.setTimestamp(6, new java.sql.Timestamp(System.currentTimeMillis()));
            pstmt.setInt(7, 2);

            // Execute the statement
            rowsAffected = pstmt.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted successfully.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowsAffected;
    }
}