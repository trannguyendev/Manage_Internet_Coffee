/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;
import Utils.KetNoiDB;
import java.sql.*;
/**
 *
 * @author Maximus
 */
public class TaiKhoan {
    private boolean vai_tro;
    private String ten_dang_nhap;
    private String mat_khau;
    private int so_du;
    private String sdt;
    private String email;
    private String ho_ten;

    public TaiKhoan() {
    }

    public TaiKhoan(boolean vai_tro, String ten_dang_nhap, String mat_khau, int so_du, String sdt, String email, String ho_ten) {
        this.vai_tro = vai_tro;
        this.ten_dang_nhap = ten_dang_nhap;
        this.mat_khau = mat_khau;
        this.so_du = so_du;
        this.sdt = sdt;
        this.email = email;
        this.ho_ten = ho_ten;
    }

    public boolean isVai_tro() {
        return vai_tro;
    }

    public void setVai_tro(boolean vai_tro) {
        this.vai_tro = vai_tro;
    }

    public String getTen_dang_nhap() {
        return ten_dang_nhap;
    }

    public void setTen_dang_nhap(String ten_dang_nhap) {
        this.ten_dang_nhap = ten_dang_nhap;
    }

    public String getMat_khau() {
        return mat_khau;
    }

    public void setMat_khau(String mat_khau) {
        this.mat_khau = mat_khau;
    }

    public int getSo_du() {
        return so_du;
    }

    public void setSo_du(int so_du) {
        this.so_du = so_du;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }
    
    
}
