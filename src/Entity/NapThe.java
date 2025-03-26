/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author cunhp
 */
public class NapThe {
    int id_nap;
    int menhGia;
    int id_tk;
    boolean trangThai;

    public NapThe() {
    }

    public NapThe(int id_nap, int menhGia, int id_tk, boolean trangThai) {
        this.id_nap = id_nap;
        this.menhGia = menhGia;
        this.id_tk = id_tk;
        this.trangThai = trangThai;
    }

    public int getId_nap() {
        return id_nap;
    }

    public void setId_nap(int id_nap) {
        this.id_nap = id_nap;
    }

    public int getMenhGia() {
        return menhGia;
    }

    public void setMenhGia(int menhGia) {
        this.menhGia = menhGia;
    }

    public int getId_tk() {
        return id_tk;
    }

    public void setId_tk(int id_tk) {
        this.id_tk = id_tk;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }
    
    
}
