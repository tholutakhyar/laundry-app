/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.baka.tx.laundry.app.model;

/**
 *
 * @author tx
 */
public class customer {
    private int id;
    private String nama;
    private String alamat;
    private String kontak;
    
    public customer() {}
    
    public customer(int id, String nama, String alamat, String kontak) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.kontak = kontak;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNama() {
        return this.nama;
    }
    
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public String getAlamat() {
        return this.alamat;
    }
    
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    
    public String getKontak() {
        return this.kontak;
    }
    
    public void setKontak(String kontak) {
        this.kontak = kontak;
    }
    
    public boolean isFilled() {
        return !(this.nama == null || this.alamat == null || this.kontak == null);
    }
}
