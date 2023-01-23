/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.baka.tx.laundry.app;

import javax.swing.JTabbedPane;
import org.baka.tx.laundry.app.lib.database;
import org.baka.tx.laundry.app.model.admin;

/**
 *
 * @author tx
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    OrderAdd od;
    database db = null;
    admin admin;
    public Dashboard() {
        initComponents();
        this.setLocationRelativeTo(null);
        od = new OrderAdd();
        od.setAlwaysOnTop(true);
        od.setLocationRelativeTo(null);
        db = new database();
    }
    
    private void refreshOrderTable() {
        
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
        jTable1 = new javax.swing.JTable();
        cbOrderStatus = new javax.swing.JComboBox<>();
        jTextField1 = new javax.swing.JTextField();
        Order_ButtonTambah = new javax.swing.JButton();
        TabCustomer = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Laundry Sanjaya - Dashboard");

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("Dashboard");

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "OrderID", "Nama Customer", "Jenis", "Tgl Mulai", "Tgl Selesai", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        cbOrderStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semua", "Proses", "Diantar", "Selesai" }));

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
                .addComponent(jTextField1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Order_ButtonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        TabOrderLayout.setVerticalGroup(
            TabOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TabOrderLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(TabOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbOrderStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Order_ButtonTambah))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        MainTab.addTab("Order", TabOrder);

        javax.swing.GroupLayout TabCustomerLayout = new javax.swing.GroupLayout(TabCustomer);
        TabCustomer.setLayout(TabCustomerLayout);
        TabCustomerLayout.setHorizontalGroup(
            TabCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 566, Short.MAX_VALUE)
        );
        TabCustomerLayout.setVerticalGroup(
            TabCustomerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 252, Short.MAX_VALUE)
        );

        MainTab.addTab("Customer", TabCustomer);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MainTab, javax.swing.GroupLayout.PREFERRED_SIZE, 566, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(MainTab, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Order_ButtonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Order_ButtonTambahActionPerformed
        // TODO add your handling code here:
        od.setAdmin(admin);
        od.resetForm();
        od.setVisible(true);
    }//GEN-LAST:event_Order_ButtonTambahActionPerformed

    private void MainTabStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_MainTabStateChanged
        // TODO add your handling code here:
        JTabbedPane sourceTabbedPane = (JTabbedPane) evt.getSource();
        int indexTab = sourceTabbedPane.getSelectedIndex();
        String nameTab = sourceTabbedPane.getTitleAt(indexTab);
        //System.out.println("Tab Changed: " + nameTab);
        
        if (nameTab.equals("Order")) {
            this.refreshOrderTable();
        }
    }//GEN-LAST:event_MainTabStateChanged

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
