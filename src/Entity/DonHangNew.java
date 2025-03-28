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

    public DonHangNew() {
    }

    public DonHangNew(int id_don_hang, int id_tk, String thoi_gian) {
        this.id_don_hang = id_don_hang;
        this.id_tk = id_tk;
        this.thoi_gian = thoi_gian;
    }

    public int getId_don_hang() {
        return id_don_hang;
    }

    public void setId_don_hang(int id_don_hang) {
        this.id_don_hang = id_don_hang;
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
