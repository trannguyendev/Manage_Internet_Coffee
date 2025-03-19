/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Utils.KetNoiDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Entity.ThongKeDonHang;
/**
 *
 * @author Lenovo
 */
public class ThongKeDonHangDAO {
    public List<ThongKeDonHang> ThongTinThongKeDonHang(){
        List<ThongKeDonHang> ThongKeDonHangLst = new ArrayList<>();
        try (Connection conn = KetNoiDB.getConnect()) {
            String sql = "SELECT sp.id_san_pham, sp.ten_sp, SUM(ctdh.so_luong) AS so_luong_ban, SUM(ctdh.so_luong * ctdh.gia) AS tong_doanh_thu " +
                       "FROM Chi_tiet_don_hang ctdh " +
                       "JOIN San_pham sp ON ctdh.id_san_pham = sp.id_san_pham " +
                       "JOIN Don_hang dh ON ctdh.id_don_hang = dh.id_don_hang " +
                       "WHERE dh.trang_thai = 1 " +
                       "GROUP BY sp.id_san_pham, sp.ten_sp";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id_san_pham = rs.getInt("id_san_pham");
                String ten_sp = rs.getString("ten_sp");
                int so_luong_ban = rs.getInt("so_luong_ban");
                int tong_doanh_thu = rs.getInt("tong_doanh_thu");
                ThongKeDonHang TKDH = new ThongKeDonHang(id_san_pham, ten_sp, so_luong_ban, tong_doanh_thu);
                ThongKeDonHangLst.add(TKDH);
            }
           return ThongKeDonHangLst;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
            return ThongKeDonHangLst;
        }
    }
}
