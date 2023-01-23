/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.baka.tx.laundry.app.model;

/**
 *
 * @author tx
 */
public class admin {
    private int id;
    private String username;
    private String password;
    
    public admin() {}
    
    public admin(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    
    public int getId() {
        return this.id;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public boolean isPasswordCorrect(String password) {
        if (password == this.password) return true;
        return false;
    }
}
