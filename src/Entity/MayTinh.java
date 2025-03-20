/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Kien
 */
public class MayTinh {
    int id_may;
    String ten_may;

    public MayTinh() {
    }

    public MayTinh(int id_may, String ten_may) {
        this.id_may = id_may;
        this.ten_may = ten_may;
    }

    public int getId_may() {
        return id_may;
    }

    public void setId_may(int id_may) {
        this.id_may = id_may;
    }

    public String getTen_may() {
        return ten_may;
    }

    public void setTen_may(String ten_may) {
        this.ten_may = ten_may;
    }

    
}
