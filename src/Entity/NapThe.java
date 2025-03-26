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
    int menhGia;
    int id_tk;
    boolean trangThai;

    public NapThe() {
    }

    public NapThe(int menhGia, int id_tk, boolean trangThai) {
        this.menhGia = menhGia;
        this.id_tk = id_tk;
        this.trangThai = trangThai;
    }

    public void setId_tk(int id_tk) {
        this.id_tk = id_tk;
    }

    public void setMenhGia(int menhGia) {
        this.menhGia = menhGia;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public int getId_tk() {
        return id_tk;
    }

    public int getMenhGia() {
        return menhGia;
    }

    public boolean isTrangThai() {
        return trangThai;
    }
    
}
