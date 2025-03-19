package Entity;

import Utils.KetNoiDB;
import java.sql.*;
public class DoAn {
    int id_san_pham;
    String ten_sp;
    int id_danh_muc;
    int gia_sp;

    public DoAn() {
    }

    public DoAn(int id_san_pham, String ten_sp, int id_danh_muc, int gia_sp) {
        this.id_san_pham = id_san_pham;
        this.ten_sp = ten_sp;
        this.id_danh_muc = id_danh_muc;
        this.gia_sp = gia_sp;
    }

    public void setId_san_pham(int id_san_pham) {
        this.id_san_pham = id_san_pham;
    }

    public void setTen_sp(String ten_sp) {
        this.ten_sp = ten_sp;
    }

    public void setId_danh_muc(int id_danh_muc) {
        this.id_danh_muc = id_danh_muc;
    }

    public void setGia_sp(int gia_sp) {
        this.gia_sp = gia_sp;
    }

    public int getId_san_pham() {
        return id_san_pham;
    }

    public String getTen_sp() {
        return ten_sp;
    }

    public int getId_danh_muc() {
        return id_danh_muc;
    }

    public int getGia_sp() {
        return gia_sp;
    }
    
    
}
