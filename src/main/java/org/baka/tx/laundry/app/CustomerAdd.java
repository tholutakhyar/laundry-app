/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package org.baka.tx.laundry.app;

import java.awt.event.WindowEvent;
import java.util.Date;
import javax.swing.JOptionPane;
import org.baka.tx.laundry.app.lib.database;
import org.baka.tx.laundry.app.model.admin;
import org.baka.tx.laundry.app.model.customer;

/**
 *
 * @author Tholut Akhyar
 */
public class CustomerAdd extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    database db;
    customer customer;
    admin admin;
    
    public CustomerAdd() {
        initComponents();
        this.setLocationRelativeTo(null);
        db = new database();
    }
    
    private void closeThisFrame() {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));;
        this.resetForm();
    }
    
    public void setAdmin(admin admin) {
        this.admin = admin;
    }
    
    public void resetForm() {
        customer = new customer();
        fieldCustomerNama.setText(null);
        fieldCustomerAlamat.setText(null);
        fieldCustomerKontak.setText(null);
    }

    private void doTambahCustomer() {
        if (!customer.isFilled()) {
            JOptionPane.showMessageDialog(this, "Tolong isi Detail Customer", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (this.db.addCustomer(customer) != 0) {
            closeThisFrame();
        } else {
            JOptionPane.showMessageDialog(this, "Maaf Ada sedikit gangguan, Silahkan Ulangi Lagi!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
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
        fieldCustomerNama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fieldCustomerAlamat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        fieldCustomerKontak = new javax.swing.JTextField();
        buttonTambah1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Laundry Sanjaya - Tambah Customer");

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("Tambah Customer");

        buttonTambah.setText("Tambah");
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahActionPerformed(evt);
            }
        });

        fieldCustomerNama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCustomerNamaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldCustomerNamaKeyTyped(evt);
            }
        });

        jLabel3.setText("Nama");

        fieldCustomerAlamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCustomerAlamatKeyReleased(evt);
            }
        });

        jLabel4.setText("Alamat");

        jLabel5.setText("Kontak");

        fieldCustomerKontak.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                fieldCustomerKontakKeyReleased(evt);
            }
        });

        buttonTambah1.setBackground(new java.awt.Color(255, 204, 204));
        buttonTambah1.setText("Batal");
        buttonTambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambah1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonTambah1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(fieldCustomerKontak, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fieldCustomerAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(fieldCustomerNama, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3))
                            .addContainerGap()))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCustomerNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCustomerAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fieldCustomerKontak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonTambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonTambah1)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed
        // TODO add your handling code here:
        doTambahCustomer();
    }//GEN-LAST:event_buttonTambahActionPerformed

    private void buttonTambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambah1ActionPerformed
        // TODO add your handling code here:
        closeThisFrame();
    }//GEN-LAST:event_buttonTambah1ActionPerformed

    private void fieldCustomerNamaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCustomerNamaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_fieldCustomerNamaKeyTyped

    private void fieldCustomerAlamatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCustomerAlamatKeyReleased
        // TODO add your handling code here:
        customer.setAlamat(fieldCustomerAlamat.getText());
    }//GEN-LAST:event_fieldCustomerAlamatKeyReleased

    private void fieldCustomerKontakKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCustomerKontakKeyReleased
        // TODO add your handling code here:
        customer.setKontak(fieldCustomerKontak.getText());
    }//GEN-LAST:event_fieldCustomerKontakKeyReleased

    private void fieldCustomerNamaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fieldCustomerNamaKeyReleased
        // TODO add your handling code here:
        customer.setNama(fieldCustomerNama.getText());
    }//GEN-LAST:event_fieldCustomerNamaKeyReleased

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
            java.util.logging.Logger.getLogger(CustomerAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CustomerAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CustomerAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CustomerAdd.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CustomerAdd().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonTambah;
    private javax.swing.JButton buttonTambah1;
    private javax.swing.JTextField fieldCustomerAlamat;
    private javax.swing.JTextField fieldCustomerKontak;
    private javax.swing.JTextField fieldCustomerNama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
