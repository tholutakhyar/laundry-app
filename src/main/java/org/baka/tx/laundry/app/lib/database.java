/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.baka.tx.laundry.app.lib;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.baka.tx.laundry.app.model.customer;
import org.baka.tx.laundry.app.model.order;

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
        try (Connection conn = this.connect()) {
            if (conn != null) {
                System.out.println("[DB] Koneksi SQLite berhasil yay!");
                this.setupTable();
                conn.close();
            } else {
                System.out.println("[DB] Konek SQLite gagal! sadkek");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void setupTable() {
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement()) {
            String sqlAdmin = "BEGIN TRANSACTION;"
                    + "CREATE TABLE IF NOT EXISTS `admin` "
                    + "(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,"
                    + "username CHAR(50) NOT NULL, "
                    + "password CHAR(50) NOT NULL, "
                    + "created_at DATETIME NOT NULL, "
                    + "updated_at DATETIME NOT NULL);"
                    + "CREATE UNIQUE INDEX admin_username ON admin(username);"
                    + "INSERT INTO admin"
                    + "(username, password, created_at, updated_at)"
                    + "VALUES"
                    + "('admin', 'ok', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);"
                    + "COMMIT;";

            stmt.executeUpdate(sqlAdmin);

            String sqlCustomer = "CREATE TABLE IF NOT EXISTS `customer` "
                    + "(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,"
                    + "nama CHAR(100) NOT NULL, "
                    + "alamat CHAR(255) NOT NULL, "
                    + "kontak CHAR(255) NOT NULL, "
                    + "created_at DATETIME NOT NULL, "
                    + "updated_at DATETIME NOT NULL)";

            stmt.executeUpdate(sqlCustomer);

            String sqlOrder = "CREATE TABLE IF NOT EXISTS `order` "
                    + "(id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, "
                    + "admin_id INT NOT NULL, "
                    + "customer_id INT NOT NULL, "
                    + "tgl_mulai DATETIME NOT NULL, "
                    + "tgl_selesai DATETIME NOT NULL, "
                    + "apakah_di_antar BOOLEAN NOT NULL DEFAULT FALSE, "
                    + "jenis CHAR(50) NOT NULL, "
                    + "status CHAR(50) NOT NULL, "
                    + "harga_total INT NOT NULL, "
                    + "harga_dibayar INT NOT NULL, "
                    + "created_at DATETIME NOT NULL, "
                    + "updated_at DATETIME NOT NULL)";

            stmt.executeUpdate(sqlOrder);

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ResultSet query(String sql) {
        ResultSet rs = null;
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement();) {
            rs = stmt.executeQuery(sql);
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return rs;
        }
    }

    public boolean isLoginInfoCorrect(String username, String password) {
        String sql = String.format("SELECT username, password FROM admin WHERE username = '%s' AND password = '%s' ", username, password);
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {
            conn.close();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
    
    public int addCustomer(customer customer) {
        int id = 0;
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement()) {
            String values = String.format("('%s', '%s', '%s', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)", customer.getNama(), customer.getAlamat(), customer.getKontak());
            String sqlCustomer = "INSERT INTO customer"
                    + "(nama, alamat, kontak, created_at, updated_at)"
                    + "VALUES"
                    + values;
            
            stmt.executeUpdate(sqlCustomer);
            
            ResultSet generatedKeys = stmt.executeQuery("SELECT last_insert_rowid()");
            if (generatedKeys.next()) {
                id = generatedKeys.getInt(1);
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            return id;
        }
    }

    public boolean addOrder(order order) {
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement()) {
            if (order.customer().getId() == 0) {
                System.out.println("create customer");
                int customerId = this.addCustomer(order.customer());
                
                if (customerId == 0) {
                    System.out.println("create customer failed sadkek");
                    return false;
                }
                
                order.customer().setId(customerId);
            }
            
            String values = String.format("(%d, %d, '%s', '%s', %b, '%s', '%s', %d, %d, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)",
                    order.admin().getId(),
                    order.customer().getId(),
                    order.getTglMulaiFormatted(),
                    order.getTglSelesaiFormatted(),
                    order.apakahDiantar(),
                    order.getJenis(),
                    order.getStatus(),
                    order.getTotalHarga(),
                    order.getJumlahDibayar()
                    );
            
            
            String sql = "INSERT INTO `order`"
                    + "(admin_id, customer_id, tgl_mulai, tgl_selesai, apakah_di_antar, jenis, status, harga_total, harga_dibayar, created_at, updated_at)"
                    + "VALUES"
                    + values;
            
            stmt.executeUpdate(sql);

            stmt.close();
            conn.close();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            return true;
        }
    }
}
