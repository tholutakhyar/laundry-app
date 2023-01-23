/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.baka.tx.laundry.app;

import javax.swing.JOptionPane;
import org.baka.tx.laundry.app.lib.database;

/**
 *
 * @author Tholut Akhyar
 */
public class OrderAdd extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    database db;
    
    public OrderAdd() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.showPerKgPrice();
    }
    
    public void resetForm() {
        fieldCustomerId.setText(null);
        fieldCustomerNama.setText(null);
        fieldCustomerAlamat.setText(null);
        fieldCustomerKontak.setText(null);
        fieldHargaPerKg.setText("0");
        fieldTotalBerat.setText("0");
        fieldCustomerPay.setText("0");
        fieldHargaPay.setText("0");
        fieldCustomerPayChange.setText("0");
        this.showPerKgPrice();
    }
    
    private void showPerKgPrice() {
        String orderJenisCucian = cbJenisCucian.getSelectedItem().toString();
        fieldHargaPerKg.setText(String.valueOf(this.getHarga(orderJenisCucian)));
    }
    
    private void calculateOrder() {
        this.showPerKgPrice();
        int orderTotalBerat = 0;
        int customerPay = 0;
        int hargaOrder = 0;
        
        try {
            hargaOrder = Integer.parseInt(fieldHargaPerKg.getText());
            orderTotalBerat = Integer.parseInt(fieldTotalBerat.getText());
            customerPay = Integer.parseInt(fieldCustomerPay.getText());
        } catch (NumberFormatException e) {}
        
        int hargaTotal = orderTotalBerat * hargaOrder;
        int payCharge = customerPay - hargaTotal;
        fieldHargaPay.setText(String.valueOf(hargaTotal));
        fieldCustomerPayChange.setText(String.valueOf(payCharge));
        fieldHargaPerKg.setText(String.valueOf(hargaOrder));
    }
    
    private int getHarga(String jenis) {
        int harga = 0;
        switch (jenis) {
            case "Cuci Biasa":
                harga = 1500;
                break;
            case "Cuci + Strika":
                harga = 3000;
                break;
            case "Cuci Kilat":
                harga = 5000;
                break;
            case "Cuci Boneka":
                harga = 3000;
                break;
            case "Cuci Selimut":
                harga = 2500;
                break;
            case "Cuci Mobil":
                harga = 4000;
                break;
            default:
                break;
        }
        return harga;
    }
    
    private void doTambahOrder() {
        String customerID = fieldCustomerId.getText();
        String customerNama = fieldCustomerNama.getText();
        String customerAlamat = fieldCustomerAlamat.getText();
        String customerKontak = fieldCustomerKontak.getText();
        
        String orderMulai = dateMulai.getDateFormatString();
        String orderSelesai = dateSelesai.getDateFormatString();
        String orderJenisCucian = cbJenisCucian.getSelectedItem().toString();
        boolean orderDiantar = cbDiantar.isSelected();
        int orderTotalKg = 0;
        int orderCustomerPay = 0;
        int orderTotalHarga = 0;
        
        try {
            orderTotalKg = Integer.parseInt(fieldTotalBerat.getText());
            orderCustomerPay = Integer.parseInt(fieldCustomerPay.getText());
            orderTotalHarga = Integer.parseInt(fieldHargaPay.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Tolong isi field dengan angka!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (orderMulai.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tolong isi Tgl Mulai!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (orderSelesai.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tolong isi Tgl Selesai!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (customerNama.isEmpty() || customerAlamat.isEmpty()|| customerKontak.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tolong isi Detail Customer", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        
        if (orderTotalKg <= 0) {
            JOptionPane.showMessageDialog(this, "Tolong isi Total Kilo Dengan Benar", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (orderTotalHarga > orderCustomerPay) {
            JOptionPane.showMessageDialog(this, "Maaf Uang pembayaran Kurang!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        this.setVisible(false);
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
        buttonTambah = new javax.swing.JButton();
        fieldCustomerId = new javax.swing.JTextField();
        fieldCustomerNama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fieldCustomerAlamat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fieldCustomerKontak = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        fieldTotalBerat = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        dateSelesai = new com.toedter.calendar.JDateChooser();
        dateMulai = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        cbJenisCucian = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbDiantar = new javax.swing.JCheckBox();
        fieldHargaPay = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        fieldCustomerPay = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        fieldCustomerPayChange = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        buttonTambah1 = new javax.swing.JButton();
        fieldHargaPerKg = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("Tambah Order");

        buttonTambah.setText("Tambah");
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahActionPerformed(evt);
            }
        });

        fieldCustomerId.setEditable(false);
        fieldCustomerId.setForeground(new java.awt.Color(153, 153, 153));

        jLabel2.setText("Customer Id");

        jLabel3.setText("Nama");

        jLabel4.setText("Alamat");

        jLabel5.setText("Kontak");

        jButton2.setText("Pilih");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setText("Tgl Mulai");

        fieldTotalBerat.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                fieldTotalBeratInputMethodTextChanged(evt);
            }
        });
        fieldTotalBerat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldTotalBeratKeyReleased(evt);
            }
        });

        jLabel7.setText("Total Berat (Kg)");

        jLabel8.setText("Tgl Selesai");

        cbJenisCucian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cuci Biasa", "Cuci + Strika", "Cuci Kilat", "Cuci Boneka", "Cuci Selimut", "Cuci Mobil" }));
        cbJenisCucian.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbJenisCucianItemStateChanged(evt);
            }
        });

        jLabel9.setText("Jenis");

        cbDiantar.setText("Diantar?");

        fieldHargaPay.setEditable(false);
        fieldHargaPay.setForeground(new java.awt.Color(153, 153, 153));

        jLabel10.setText("Harga Yang Harus Dibayar");

        fieldCustomerPay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCustomerPayKeyReleased(evt);
            }
        });

        jLabel11.setText("Customer Membayar Sejumlah");

        fieldCustomerPayChange.setEditable(false);
        fieldCustomerPayChange.setForeground(new java.awt.Color(153, 153, 153));

        jLabel12.setText("Kembalian Untuk Customer");

        buttonTambah1.setBackground(new java.awt.Color(255, 204, 204));
        buttonTambah1.setText("Batal");
        buttonTambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambah1ActionPerformed(evt);
            }
        });

        fieldHargaPerKg.setEditable(false);
        fieldHargaPerKg.setForeground(new java.awt.Color(153, 153, 153));

        jLabel13.setText("Harga Per Kg");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonTambah1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(fieldHargaPay, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldCustomerAlamat, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldCustomerKontak, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(fieldCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                            .addComponent(fieldCustomerNama, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(fieldCustomerPay, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(fieldTotalBerat)
                            .addComponent(dateSelesai, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                            .addComponent(dateMulai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbJenisCucian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbDiantar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel9)
                            .addComponent(fieldCustomerPayChange)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(fieldHargaPerKg))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(fieldCustomerId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton2)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dateMulai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel3))
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(fieldCustomerNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldCustomerAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbJenisCucian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbDiantar))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldCustomerKontak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(fieldTotalBerat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldHargaPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldHargaPerKg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldCustomerPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fieldCustomerPayChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(buttonTambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonTambah1)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed
        // TODO add your handling code here:
        doTambahOrder();
    }//GEN-LAST:event_buttonTambahActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void fieldTotalBeratInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_fieldTotalBeratInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldTotalBeratInputMethodTextChanged

    private void buttonTambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambah1ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        this.resetForm();
    }//GEN-LAST:event_buttonTambah1ActionPerformed

    private void fieldTotalBeratKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldTotalBeratKeyReleased
        // TODO add your handling code here:
        this.calculateOrder();
    }//GEN-LAST:event_fieldTotalBeratKeyReleased

    private void fieldCustomerPayKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCustomerPayKeyReleased
        // TODO add your handling code here:
        this.calculateOrder();
    }//GEN-LAST:event_fieldCustomerPayKeyReleased

    private void cbJenisCucianItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbJenisCucianItemStateChanged
        // TODO add your handling code here:
        this.calculateOrder();
    }//GEN-LAST:event_cbJenisCucianItemStateChanged

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
            java.util.logging.Logger.getLogger(OrderAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OrderAdd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonTambah;
    private javax.swing.JButton buttonTambah1;
    private javax.swing.JCheckBox cbDiantar;
    private javax.swing.JComboBox<String> cbJenisCucian;
    private com.toedter.calendar.JDateChooser dateMulai;
    private com.toedter.calendar.JDateChooser dateSelesai;
    private javax.swing.JTextField fieldCustomerAlamat;
    private javax.swing.JTextField fieldCustomerId;
    private javax.swing.JTextField fieldCustomerKontak;
    private javax.swing.JTextField fieldCustomerNama;
    private javax.swing.JTextField fieldCustomerPay;
    private javax.swing.JTextField fieldCustomerPayChange;
    private javax.swing.JTextField fieldHargaPay;
    private javax.swing.JTextField fieldHargaPerKg;
    private javax.swing.JTextField fieldTotalBerat;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
}
