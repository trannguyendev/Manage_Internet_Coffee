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

    public List<ThongKeDonHang> ThongTinThongKeDonHang() {
        List<ThongKeDonHang> ThongKeDonHangLst = new ArrayList<>();
        try (Connection conn = KetNoiDB.getConnect()) {
            String sql = "SELECT sp.id_san_pham, sp.ten_sp, SUM(ctdh.so_luong) AS so_luong_ban, SUM(ctdh.so_luong * ctdh.gia) AS tong_doanh_thu "
                    + "FROM Chi_tiet_don_hang ctdh "
                    + "JOIN San_pham sp ON ctdh.id_san_pham = sp.id_san_pham "
                    + "JOIN Don_hang dh ON ctdh.id_don_hang = dh.id_don_hang "
                    + "GROUP BY sp.id_san_pham, sp.ten_sp";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
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

    public List<ThongKeDonHang> ThongTinThongKeDonHangTheoNam(int thoigian) {
        List<ThongKeDonHang> ThongKeDonHangLst = new ArrayList<>();
        try (Connection conn = KetNoiDB.getConnect()) {
            String sql = "SELECT sp.id_san_pham, sp.ten_sp, \n"
                    + "       SUM(ctdh.so_luong) AS so_luong_ban, \n"
                    + "       SUM(ctdh.so_luong * ctdh.gia) AS tong_doanh_thu\n"
                    + "FROM Chi_tiet_don_hang ctdh\n"
                    + "JOIN San_pham sp ON ctdh.id_san_pham = sp.id_san_pham\n"
                    + "JOIN Don_hang dh ON ctdh.id_don_hang = dh.id_don_hang\n"
                    + "WHERE YEAR(dh.thoi_gian) = ?\n"
                    + "GROUP BY sp.id_san_pham, sp.ten_sp;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, thoigian);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_san_pham = rs.getInt("id_san_pham");
                String ten_sp = rs.getString("ten_sp");
                int so_luong_ban = rs.getInt("so_luong_ban");
                int tong_doanh_thu = rs.getInt("tong_doanh_thu");
                ThongKeDonHang TKDH = new ThongKeDonHang(id_san_pham, ten_sp, so_luong_ban, tong_doanh_thu);
                ThongKeDonHangLst.add(TKDH);
            }
            return ThongKeDonHangLst;
        } catch (Exception e) { 
            e.printStackTrace();
            return ThongKeDonHangLst;
        }
    }
    public List<Integer> getListYear(){
        List<Integer> lstYear = new ArrayList<>();
        String SQL = "SELECT DISTINCT YEAR(thoi_gian) as nam FROM Don_hang";
        try(Connection conn = KetNoiDB.getConnect()){
            PreparedStatement ppStm = conn.prepareStatement(SQL);
            ResultSet rs = ppStm.executeQuery();
            while(rs.next()){
                int nam = rs.getInt("nam");
                lstYear.add(nam);
            }
            return lstYear;
        }
        catch(Exception e){
            e.printStackTrace();
            return lstYear;
        }
    }
}
