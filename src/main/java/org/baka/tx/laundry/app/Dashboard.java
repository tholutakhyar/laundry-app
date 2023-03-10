/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.baka.tx.laundry.app;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.PatternSyntaxException;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.baka.tx.laundry.app.lib.database;
import org.baka.tx.laundry.app.model.admin;
import org.baka.tx.laundry.app.model.order;

/**
 *
 * @author tx
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    database db = null;
    admin admin;
    private DefaultTableModel orderModel;
    final TableRowSorter<TableModel> orderSorter;
    
    private DefaultTableModel customerModel;
    final TableRowSorter<TableModel> customerSorter;
    private String orderShow = "Semua";

    public Dashboard() {
        initComponents();
        this.setLocationRelativeTo(null);
        db = new database();

        this.orderModel = new DefaultTableModel();
        this.orderTable.setModel(this.orderModel);
        
        this.orderModel.addColumn("Order ID");
        this.orderModel.addColumn("Customer");
        this.orderModel.addColumn("Jenis");
        this.orderModel.addColumn("Tgl Mulai");
        this.orderModel.addColumn("Tgl Selesai");
        this.orderModel.addColumn("Status");
        
        orderSorter = new TableRowSorter<TableModel>(orderModel);
        orderTable.setRowSorter(orderSorter);
        
        
        this.customerModel = new DefaultTableModel();
        this.customerTable.setModel(this.customerModel);
        
        this.customerModel.addColumn("Id");
        this.customerModel.addColumn("Nama");
        this.customerModel.addColumn("Alamat");
        this.customerModel.addColumn("Kontak");

        customerSorter = new TableRowSorter<TableModel>(customerModel);
        customerTable.setRowSorter(customerSorter);

        this.refreshOrderTable();
        this.refreshCustomerTable();
        this.refreshBeranda();
    }

    private void refreshOrderTable() {
        String status = "";
        
        if (this.orderShow != "Semua") {
            status = String.format("WHERE `order`.status = '%s'", this.orderShow.toLowerCase());
        }
        
        String sql = String.format("SELECT `order`.id, apakah_di_antar, status, tgl_mulai, tgl_selesai, jenis, customer.nama as customer_nama FROM `order` LEFT JOIN customer ON customer.id = customer_id %s ORDER BY `order`.id DESC", status);

        while (this.orderModel.getRowCount() > 0) {
            this.orderModel.removeRow(0);
        }
        try (Connection conn = db.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                this.orderModel.addRow(new Object[]{rs.getInt("id"), rs.getString("customer_nama"), rs.getString("jenis"), rs.getString("tgl_mulai"), rs.getString("tgl_selesai"), rs.getString("status")});
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    
    private void refreshCustomerTable() {
        String sql = String.format("SELECT * FROM customer ORDER BY id DESC");
        while (this.customerModel.getRowCount() > 0) {
            this.customerModel.removeRow(0);
        }
        try (Connection conn = db.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {

            while (rs.next()) {
                this.customerModel.addRow(new Object[]{rs.getInt("id"), rs.getString("nama"), rs.getString("alamat"), rs.getString("kontak")});
            }

            stmt.close();
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    
    private void refreshBeranda() {
        if (this.db != null) {
            LabelHIDalamPengiriman.setText(String.valueOf(this.db.getCountOrderOnDeliveryToday()));
            LabelHIDalamProses.setText(String.valueOf(this.db.getCountOrderProcessToday()));
            LabelHIOrderSelesai.setText(String.valueOf(this.db.getCountOrderFinishedToday()));

            LabelBIOrderSelesai.setText(String.valueOf(this.db.getCountOrderFinishedThisMonth()));
        }
    }

    public void setAdmin(admin admin) {
        this.admin = admin;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        MainTab = new javax.swing.JTabbedPane();
        TabBeranda = new javax.swing.JPanel();
        LabelSelamatDatang = new javax.swing.JLabel();
        Label1 = new javax.swing.JLabel();
        Label2 = new javax.swing.JLabel();
        Label3 = new javax.swing.JLabel();
        LabelHIDalamProses = new javax.swing.JLabel();
        Label5 = new javax.swing.JLabel();
        LabelHIDalamPengiriman = new javax.swing.JLabel();
        LabelHIOrderSelesai = new javax.swing.JLabel();
        Label8 = new javax.swing.JLabel();
        Label9 = new javax.swing.JLabel();
        Label10 = new javax.swing.JLabel();
        LabelBIOrderSelesai = new javax.swing.JLabel();
        TabOrder = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderTable = new javax.swing.JTable();
        cbOrderStatus = new javax.swing.JComboBox<>();
        fieldCariOrderTable = new javax.swing.JTextField();
        Order_ButtonTambah = new javax.swing.JButton();
        TabCustomer = new javax.swing.JPanel();
        fieldCariCustomerTable = new javax.swing.JTextField();
        Customer_ButtonTambah = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        customerTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Laundry Sanjaya - Dashboard");

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("Dashboard");
        jLabel1.setDisabledIcon(null);

        MainTab.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                MainTabStateChanged(evt);
            }
        });

        LabelSelamatDatang.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        LabelSelamatDatang.setText("Selamat Datang, Admin!");

        Label1.setFont(new java.awt.Font("sansserif", 3, 14)); // NOI18N
        Label1.setText("Laundry Statik");

        Label2.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        Label2.setText("Hari Ini");

        Label3.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        Label3.setText("Dalam Proses");

        LabelHIDalamProses.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        LabelHIDalamProses.setText("0");

        Label5.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        Label5.setText("Dalam Pengiriman");

        LabelHIDalamPengiriman.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        LabelHIDalamPengiriman.setText("0");

        LabelHIOrderSelesai.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        LabelHIOrderSelesai.setText("0");

        Label8.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        Label8.setText("Order Selesai");

        Label9.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        Label9.setText("Bulan Ini");

        Label10.setFont(new java.awt.Font("sansserif", 3, 12)); // NOI18N
        Label10.setText("Order Selesai");

        LabelBIOrderSelesai.setFont(new java.awt.Font("sansserif", 0, 12)); // NOI18N
        LabelBIOrderSelesai.setText("0");

        javax.swing.GroupLayout TabBerandaLayout = new javax.swing.GroupLayout(TabBeranda);
        TabBeranda.setLayout(TabBerandaLayout);
        TabBerandaLayout.setHorizontalGroup(
            TabBerandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabBerandaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(TabBerandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(LabelSelamatDatang)
                    .addComponent(Label1)
                    .addComponent(Label2)
                    .addGroup(TabBerandaLayout.createSequentialGroup()
                        .addGroup(TabBerandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Label3)
                            .addComponent(LabelHIDalamProses))
                        .addGap(60, 60, 60)
                        .addGroup(TabBerandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Label5)
                            .addComponent(LabelHIDalamPengiriman))
                        .addGap(59, 59, 59)
                        .addGroup(TabBerandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelHIOrderSelesai)
                            .addComponent(Label8)))
                    .addComponent(Label9)
                    .addComponent(Label10)
                    .addComponent(LabelBIOrderSelesai))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        TabBerandaLayout.setVerticalGroup(
            TabBerandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TabBerandaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LabelSelamatDatang)
                .addGap(18, 18, 18)
                .addComponent(Label1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(TabBerandaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(TabBerandaLayout.createSequentialGroup()
                        .addComponent(Label3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelHIDalamProses))
                    .addGroup(TabBerandaLayout.createSequentialGroup()
                        .addComponent(Label5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelHIDalamPengiriman))
                    .addGroup(TabBerandaLayout.createSequentialGroup()
                        .addComponent(Label8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(LabelHIOrderSelesai)))
                .addGap(18, 18, 18)
                .addComponent(Label9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LabelBIOrderSelesai)
                .addContainerGap(56, Short.MAX_VALUE))
        );

        MainTab.addTab("Beranda", TabBeranda);

        orderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OrderID", "Nama Customer", "Jenis", "Tgl Mulai", "Tgl Selesai", "Status"
            }
        ));
        orderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                orderTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(orderTable);

        cbOrderStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua", "Antri", "Proses", "Diantar", "Selesai" }));
        cbOrderStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbOrderStatusItemStateChanged(evt);
            }
        });

        fieldCariOrderTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCariOrderTableKeyReleased(evt);
            }
        });

        Order_ButtonTambah.setText("Tambah");
        Order_ButtonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Order_ButtonTambahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TabOrderLayout = new javax.swing.GroupLayout(TabOrder);
        TabOrder.setLayout(TabOrderLayout);
        TabOrderLayout.setHorizontalGroup(
            TabOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
            .addGroup(TabOrderLayout.createSequentialGroup()
                .addComponent(cbOrderStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCariOrderTable)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Order_ButtonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        TabOrderLayout.setVerticalGroup(
            TabOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabOrderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(TabOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbOrderStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCariOrderTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Order_ButtonTambah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        MainTab.addTab("Order", TabOrder);

        fieldCariCustomerTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCariCustomerTableKeyReleased(evt);
            }
        });

        Customer_ButtonTambah.setText("Tambah");
        Customer_ButtonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Customer_ButtonTambahActionPerformed(evt);
            }
        });

        customerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OrderID", "Nama Customer", "Jenis", "Tgl Mulai", "Tgl Selesai", "Status"
            }
        ));
        customerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                customerTableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(customerTable);

        javax.swing.GroupLayout TabCustomerLayout = new javax.swing.GroupLayout(TabCustomer);
        TabCustomer.setLayout(TabCustomerLayout);
        TabCustomerLayout.setHorizontalGroup(
            TabCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
            .addGroup(TabCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(TabCustomerLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(TabCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                        .addGroup(TabCustomerLayout.createSequentialGroup()
                            .addComponent(fieldCariCustomerTable)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Customer_ButtonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap()))
        );
        TabCustomerLayout.setVerticalGroup(
            TabCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 252, Short.MAX_VALUE)
            .addGroup(TabCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(TabCustomerLayout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addGroup(TabCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fieldCariCustomerTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Customer_ButtonTambah))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(9, 9, 9)))
        );

        MainTab.addTab("Customer", TabCustomer);

        jLabel2.setText("Project UAS - Tholut Akhyar - 21201040");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(MainTab, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MainTab, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Order_ButtonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Order_ButtonTambahActionPerformed
        // TODO add your handling code here:
        OrderAdd od = new OrderAdd();
        od.setAlwaysOnTop(true);
        od.setLocationRelativeTo(null);
        od.setAdmin(admin);
        od.resetForm();
        od.setVisible(true);
        od.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                refreshOrderTable();
            }
        });
    }//GEN-LAST:event_Order_ButtonTambahActionPerformed

    private void MainTabStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_MainTabStateChanged
        // TODO add your handling code here:
        JTabbedPane sourceTabbedPane = (JTabbedPane) evt.getSource();
        int indexTab = sourceTabbedPane.getSelectedIndex();
        String nameTab = sourceTabbedPane.getTitleAt(indexTab);
        //System.out.println("Tab Changed: " + nameTab);

        if (nameTab.equals("Order")) {
            this.refreshOrderTable();
        } else if (nameTab.equals("Customer")) {
            this.refreshCustomerTable();
        } else if (nameTab.equals("Beranda")) {
            this.refreshBeranda();
        } 
    }//GEN-LAST:event_MainTabStateChanged

    private void fieldCariOrderTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCariOrderTableKeyReleased
        // TODO add your handling code here:
        String text = fieldCariOrderTable.getText();
        if (text.length() == 0) {
            orderSorter.setRowFilter(null);
        } else {
            try {
                orderSorter.setRowFilter(RowFilter.regexFilter(text));
            } catch (PatternSyntaxException pse) {
                System.out.println("Bad regex pattern");
            }
        }
    }//GEN-LAST:event_fieldCariOrderTableKeyReleased

    private void fieldCariCustomerTableKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCariCustomerTableKeyReleased
        // TODO add your handling code here:
        String text = fieldCariCustomerTable.getText();
        if (text.length() == 0) {
            customerSorter.setRowFilter(null);
        } else {
            try {
                customerSorter.setRowFilter(RowFilter.regexFilter(text));
            } catch (PatternSyntaxException pse) {
                System.out.println("Bad regex pattern");
            }
        }
    }//GEN-LAST:event_fieldCariCustomerTableKeyReleased

    private void Customer_ButtonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Customer_ButtonTambahActionPerformed
        // TODO add your handling code here:
        CustomerAdd ca = new CustomerAdd();
        ca.setAlwaysOnTop(true);
        ca.setLocationRelativeTo(null);
        ca.setAdmin(admin);
        ca.resetForm();
        ca.setVisible(true);
        ca.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                refreshCustomerTable();
            }
        });
    }//GEN-LAST:event_Customer_ButtonTambahActionPerformed

    private void cbOrderStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbOrderStatusItemStateChanged
        // TODO add your handling code here:
        this.orderShow = cbOrderStatus.getSelectedItem().toString();
        this.refreshOrderTable();
    }//GEN-LAST:event_cbOrderStatusItemStateChanged

    private void customerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_customerTableMouseClicked
        // TODO add your handling code here:
        int row[] = customerTable.getSelectedRows();
        if (row.length > 0) {
            String id = String.valueOf(customerTable.getValueAt(row[0], 0));
            String nama = String.valueOf(customerTable.getValueAt(row[0], 1));
            String alamat = String.valueOf(customerTable.getValueAt(row[0], 2));
            String kontak = String.valueOf(customerTable.getValueAt(row[0], 3));
            
            CustomerEdit ce = new CustomerEdit();
            ce.setAlwaysOnTop(true);
            ce.setLocationRelativeTo(null);
            ce.setAdmin(admin);
            ce.setForm(id, nama, alamat, kontak);
            ce.setVisible(true);
            ce.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    refreshCustomerTable();
                }
            });
        }
    }//GEN-LAST:event_customerTableMouseClicked

    private void orderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_orderTableMouseClicked
        // TODO add your handling code here:
        int row[] = orderTable.getSelectedRows();
        if (row.length > 0) {
            String id = String.valueOf(orderTable.getValueAt(row[0], 0));
            order order = this.db.getOrder(id);
            OrderAction oa = new OrderAction();
            oa.setAlwaysOnTop(true);
            oa.setLocationRelativeTo(null);
            oa.setAdmin(admin);
            oa.setForm(order);
            oa.setVisible(true);
            oa.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    refreshOrderTable();
                }
            });
        }
    }//GEN-LAST:event_orderTableMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Customer_ButtonTambah;
    private javax.swing.JLabel Label1;
    private javax.swing.JLabel Label10;
    private javax.swing.JLabel Label2;
    private javax.swing.JLabel Label3;
    private javax.swing.JLabel Label5;
    private javax.swing.JLabel Label8;
    private javax.swing.JLabel Label9;
    private javax.swing.JLabel LabelBIOrderSelesai;
    private javax.swing.JLabel LabelHIDalamPengiriman;
    private javax.swing.JLabel LabelHIDalamProses;
    private javax.swing.JLabel LabelHIOrderSelesai;
    private javax.swing.JLabel LabelSelamatDatang;
    private javax.swing.JTabbedPane MainTab;
    private javax.swing.JButton Order_ButtonTambah;
    private javax.swing.JPanel TabBeranda;
    private javax.swing.JPanel TabCustomer;
    private javax.swing.JPanel TabOrder;
    private javax.swing.JComboBox<String> cbOrderStatus;
    private javax.swing.JTable customerTable;
    private javax.swing.JTextField fieldCariCustomerTable;
    private javax.swing.JTextField fieldCariOrderTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable orderTable;
    // End of variables declaration//GEN-END:variables
}
