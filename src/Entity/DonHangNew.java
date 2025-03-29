/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author Lenovo
 */
public class DonHangNew {
    int id_don_hang;
    int id_tk;
    String thoi_gian;
    boolean trang_thai;
    public DonHangNew() {
    }

    public DonHangNew(int id_don_hang, int id_tk, String thoi_gian, boolean trang_thai) {
        this.id_don_hang = id_don_hang;
        this.id_tk = id_tk;
        this.thoi_gian = thoi_gian;
        this.trang_thai = trang_thai;
    }

    public int getId_don_hang() {
        return id_don_hang;
    }

    public void setId_don_hang(int id_don_hang) {
        this.id_don_hang = id_don_hang;
    }

    public boolean isTrang_thai() {
        return trang_thai;
    }

    public void setTrang_thai(boolean trang_thai) {
        this.trang_thai = trang_thai;
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
    
}
