/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.baka.tx.laundry.app.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author tx
 */
public class order {
    private int id;
    private admin admin;
    private customer customer;
    private boolean apakahDiantar;
    private Date tglMulai;
    private Date tglSelesai;
    private int hargaPerKg;
    private int totalBerat;
    private int totalHarga;
    private String jenis;
    private int jumlahYangHarusDibayar;
    private int jumlahDibayar;
    private int jumlahKembalian;
    private String status;
    
    public order() {
        this.id = 0;
        this.apakahDiantar = false;
        this.tglMulai = null;
        this.tglSelesai = null;
        this.hargaPerKg = 0;
        this.totalBerat = 0;
        this.totalHarga = 0;
        this.jenis = null;
        this.jumlahYangHarusDibayar = 0;
        this.jumlahKembalian = -1;
        this.customer = new customer();
        this.status = "antrian";
    }
    
    private int getJenisHarga(String jenis) {
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
                harga = 0;
                break;
        }
        return harga;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public admin admin() {
        return this.admin;
    }
    
    public void setAdmin(admin admin) {
        this.admin = admin;
    }
    
    public customer customer() {
        return this.customer;
    }
    
    public void setCustomer(customer customer) {
        this.customer = customer;
    }
    
    public boolean apakahDiantar() {
        return this.apakahDiantar;
    }
    
    public void setApakahDiantar(boolean val) {
        this.apakahDiantar = val;
    }
    
    public Date getTglMulai() {
        return this.tglMulai;
    }
    
    public String getTglMulaiFormatted() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(this.tglMulai);
    }
    
    public void setTglMulai(Date tgl) {
        this.tglMulai = tgl;
    }
    
    public Date getTglSelesai() {
        return this.tglSelesai;
    }
    
    public String getTglSelesaiFormatted() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(this.tglSelesai);
    }
    
    public void setTglSelesai(Date tgl) {
        this.tglSelesai = tgl;
    }
    
    public String getJenis() {
        return this.jenis;
    }
    
    public void setJenis(String jenis) {
        this.jenis = jenis;
        this.hargaPerKg = this.getJenisHarga(jenis);
        this.calculateTotalHarga();
    }
    
    public int getHargaPerKg() {
        return this.hargaPerKg;
    }
    
    public int getTotalBerat() {
        return totalBerat;
    }

    public void setTotalBerat(int totalBerat) {
        this.totalBerat = totalBerat;
        this.calculateTotalHarga();
    }
    
    private void calculateTotalHarga() {
        this.totalHarga = this.totalBerat * this.hargaPerKg;
        this.calculateJumlahKembalian();
    }

    public int getTotalHarga() {
        return this.totalHarga;
    }

    public int getJumlahYangHarusDibayar() {
        return getTotalHarga();
    }

    public int getJumlahDibayar() {
        return jumlahDibayar;
    }

    public void setJumlahDibayar(int jumlahDibayar) {
        this.jumlahDibayar = jumlahDibayar;
        this.calculateJumlahKembalian();
    }
    
    private void calculateJumlahKembalian() {
        this.jumlahKembalian = this.jumlahDibayar - this.totalHarga;
    }
    
    // Todo check if payment more or equals to total price should pay
    public boolean isKembalianCorrect() {
        return this.jumlahKembalian >= 0;
    }
    
    public int getJumlahKembalian() {
        return this.jumlahKembalian;
    }
    
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
}