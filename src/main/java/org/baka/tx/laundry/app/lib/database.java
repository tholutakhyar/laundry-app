/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.baka.tx.laundry.app.lib;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Tholut Akhyar
 */
public class database {
    
    public Connection connect() {
        String userHomeDir = System.getProperty("user.home");
        String dbUrl = "jdbc:sqlite:" + userHomeDir + "/laundryapp.db";
        Connection conn = null;
        
        try {
            conn = DriverManager.getConnection(dbUrl);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return conn;
    }
    
    public void testConnection() {
        try (Connection conn = this.connect()){
            if (conn != null) {
                System.out.println("[DB] Koneksi SQLite berhasil yay!");
                conn.close();
                this.setupTable();
            } else {
                System.out.println("[DB] Konek SQLite gagal! sadkek");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void setupTable() {
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement()){
            String sqlAdmin = "CREATE TABLE IF NOT EXISTS admin " +
                        "(id INT PRIMARY KEY NOT NULL," +
                        "username CHAR(50) NOT NULL, " +
                        "password CHAR(50))"; 
            
            stmt.executeUpdate(sqlAdmin);
            
            String sqlCustomer = "CREATE TABLE IF NOT EXISTS customer " +
                        "(id INT PRIMARY KEY NOT NULL," +
                        "nama CHAR(100) NOT NULL, " +
                        "alamat CHAR(255) NOT NULL, " +
                        "kontak CHAR(255))"; 
            
            stmt.executeUpdate(sqlCustomer);
            
            String sqlOrder = "CREATE TABLE IF NOT EXISTS order " +
                        "(id INT PRIMARY KEY NOT NULL," +
                        "admin_id INT NOT NULL, " +                        
                        "customer_id INT NOT NULL, " +
                        "tgl_mulai INT NOT NULL, " +
                        "tgl_selesai INT NOT NULL, " +
                        "apakah_di_antar INT NOT NULL, " +
                        "jenis INT NOT NULL, " +
                        "status CHAR(50) NOT NULL )"; 
            
            stmt.executeUpdate(sqlOrder);
            
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void query(String sql) {
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)){
            // Todo membuat query code
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}