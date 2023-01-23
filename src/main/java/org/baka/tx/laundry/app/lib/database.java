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
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.baka.tx.laundry.app.model.admin;
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
                    + "harga_dibayar INT NOT NULL, "
                    + "harga_perkg INT NOT NULL, "
                    + "total_berat INT NOT NULL, "
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
    
    public customer getCustomer(String id) {
        String sql = String.format("SELECT * FROM customer WHERE id = %d ", Integer.parseInt(id));
        customer customer = new customer();
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {
            if (rs.next()) {
                customer.setId(rs.getInt("id"));
                customer.setNama(rs.getString("nama"));
                customer.setAlamat(rs.getString("alamat"));
                customer.setKontak(rs.getString("kontak"));
            }
            
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return customer;
        } finally {
            return customer;
        }
    }
    
    public int getCountOrderProcessToday() {
        String sql = "SELECT COUNT(id) as jumlah FROM `order` WHERE `status` = 'proses'";
        int count = 0;
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {
            if (rs.next()) {
                count = rs.getInt("jumlah");
            }
            
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        } finally {
            return count;
        }
    }
    
    public int getCountOrderOnDeliveryToday() {
        String sql = "SELECT COUNT(id) as jumlah FROM `order` WHERE `status` = 'diantar'";
        int count = 0;
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {
            if (rs.next()) {
                count = rs.getInt("jumlah");
            }
            
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        } finally {
            return count;
        }
    }
    
    public int getCountOrderFinishedToday() {
        String today = new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString() + " 00:00:00";
        String sql = String.format("SELECT COUNT(id) as jumlah FROM `order` WHERE `status` = 'selesai' AND updated_at >= '%s'", today);
        int count = 0;
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {
            if (rs.next()) {
                count = rs.getInt("jumlah");
            }
            
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        } finally {
            return count;
        }
    }
    
    public int getCountOrderFinishedThisMonth() {
        // Should Query this month, Fix this later
        String sql = "SELECT COUNT(id) as jumlah FROM `order` WHERE `status` = 'selesai'";
        int count = 0;
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {
            if (rs.next()) {
                count = rs.getInt("jumlah");
            }
            
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return 0;
        } finally {
            return count;
        }
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
    
    public boolean deleteCustomer(String id) {
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement()) {
            String sqlCustomer = String.format("DELETE FROM `customer` WHERE ", id);
            
            stmt.executeUpdate(sqlCustomer);

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            return true;
        }
    }
    
    public boolean updateCustomer(customer customer) {
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement()) {
            String sqlCustomer = String.format("UPDATE `customer` SET updated_at = CURRENT_TIMESTAMP, nama = '%s', alamat = '%s', kontak = '%s' WHERE id = %d", customer.getNama(), customer.getAlamat(), customer.getKontak(), customer.getId());
            
            stmt.executeUpdate(sqlCustomer);
            
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            return true;
        }
    }
    
    public order getOrder(String id) {
        String sql = String.format(""
                + "SELECT " +
                "`order`.*, " +
                "customer.id as customerId, " +
                "customer.nama as customerNama, " +
                "customer.alamat as customerAlamat, " +
                "customer.kontak as customerKontak, " +
                "admin.id as adminId, " +
                "admin.username as adminUsername " +
                "FROM `order` " +
                "INNER JOIN customer ON customer.id = `order`.customer_id " +
                "INNER JOIN admin ON admin.id = `order`.admin_id " +
                "WHERE `order`.id = %d ", Integer.parseInt(id));
        
        order order = new order();
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {
            if (rs.next()) {
                customer customer = new customer();
                customer.setId(rs.getInt("customerId"));
                customer.setNama(rs.getString("customerNama"));
                customer.setAlamat(rs.getString("customerAlamat"));
                customer.setKontak(rs.getString("customerKontak"));
                order.setCustomer(customer);
                
                admin adminx = new admin(rs.getInt("adminId"), rs.getString("adminUsername"), "");
                order.setAdmin(adminx);
                
                order.setId(rs.getInt("id"));
                order.setJenis(rs.getString("jenis"));
                order.setApakahDiantar(rs.getBoolean("apakah_di_antar"));
                order.setTglMulai(Timestamp.valueOf(rs.getString("tgl_mulai")));
                order.setTglSelesai(Timestamp.valueOf(rs.getString("tgl_selesai")));
                order.setStatus(rs.getString("status"));
                order.setTotalBerat(Integer.parseInt(rs.getString("total_berat")));
                order.setJumlahDibayar(Integer.parseInt(rs.getString("harga_dibayar")));
            }
            
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return order;
        } finally {
            return order;
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
            
            String values = String.format("(%d, %d, '%s', '%s', %b, '%s', '%s', %d, %d, %d, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)",
                    order.admin().getId(),
                    order.customer().getId(),
                    order.getTglMulaiFormatted(),
                    order.getTglSelesaiFormatted(),
                    order.apakahDiantar(),
                    order.getJenis(),
                    order.getStatus(),
                    order.getJumlahDibayar(),
                    order.getHargaPerKg(),
                    order.getTotalBerat()
                    );
            
            
            String sql = "INSERT INTO `order`"
                    + "(admin_id, customer_id, tgl_mulai, tgl_selesai, apakah_di_antar, jenis, status, harga_dibayar, harga_perkg, total_berat, created_at, updated_at)"
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
    
    public boolean updateStatusOrder(String id, String status) {
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement()) {
            String sql = String.format("UPDATE `order` SET updated_at = CURRENT_TIMESTAMP, status = '%s' WHERE id = %s AND status != 'selesai'", status, id);
            
            if ("selesai".equals(status)) sql = String.format("UPDATE `order` SET updated_at = CURRENT_TIMESTAMP, tgl_selesai = CURRENT_TIMESTAMP, status = '%s' WHERE id = %s", status, id);
            
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
