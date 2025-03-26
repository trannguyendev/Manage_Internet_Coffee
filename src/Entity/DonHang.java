/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author ADMIN
 */
public class DonHang {
    int tong_tien;
    int id_tk;
    String thoi_gian;
    boolean trang_thai;  

    public DonHang(int tong_tien, int id_tk, String thoi_gian, boolean trang_thai) {
        this.tong_tien = tong_tien;
        this.id_tk = id_tk;
        this.thoi_gian = thoi_gian;
        this.trang_thai = trang_thai;
    }

    public DonHang() {
    }

    public int getTong_tien() {
        return tong_tien;
    }

    public void setTong_tien(int tong_tien) {
        this.tong_tien = tong_tien;
    }

    public int getId_tk() {
        return id_tk;
    }

    public void setId_tk(int id_tk) {
        this.id_tk = id_tk;
    }

    public String getThoi_gian() {
        return thoi_gian;
    }

    public void setThoi_gian(String thoi_gian) {
        this.thoi_gian = thoi_gian;
    }

    public boolean isTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(boolean trang_thai) {
        this.trang_thai = trang_thai;
    }
    
    
}
