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
    String ten_may;
    int id_khu_vuc;

    public MayTinh() {
    }

    public MayTinh(String ten_may, int id_khu_vuc) {
        this.ten_may = ten_may;
        this.id_khu_vuc = id_khu_vuc;
    }

    public String getTen_may() {
        return ten_may;
    }

    public void setTen_may(String ten_may) {
        this.ten_may = ten_may;
    }

    public int getId_khu_vuc() {
        return id_khu_vuc;
    }

    public void setId_khu_vuc(int id_khu_vuc) {
        this.id_khu_vuc = id_khu_vuc;
    }
}
