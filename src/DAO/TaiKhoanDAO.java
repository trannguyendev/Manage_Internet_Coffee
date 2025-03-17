/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.TaiKhoan;
import Utils.KetNoiDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Maximus
 */
public class TaiKhoanDAO {

    public void addAccount(TaiKhoan tk) {
        try (Connection conn = KetNoiDB.getConnect()) {
            String url = "INSERT INTO Tai_khoan VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ppStm = conn.prepareStatement(url);
            ppStm.setBoolean(1, tk.isVai_tro());
            ppStm.setString(2, tk.getTen_dang_nhap());
            ppStm.setString(3, tk.getMat_khau());
            ppStm.setInt(4, tk.getSo_du());
            ppStm.setString(5, tk.getSdt());
            ppStm.setString(6, tk.getEmail());
            ppStm.setString(7, tk.getHo_ten());
            ppStm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    }

    public List<TaiKhoan> getData() {
        List<TaiKhoan> lstAccount = new ArrayList<>();
        try (Connection conn = KetNoiDB.getConnect()) {
            String getData = "SELECT * FROM Tai_khoan";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(getData);
            while (rs.next()) {
                boolean vai_tro = rs.getBoolean("vai_tro");
                String ten_dang_nhap = rs.getString("ten_dang_nhap");
                String mat_khau = rs.getString("mat_khau");
                int so_du = rs.getInt("so_du");
                String sdt = rs.getString("sdt");
                String ho_ten = rs.getString("ho_ten");
                String email = rs.getString("email");
                TaiKhoan tk = new TaiKhoan(vai_tro, ten_dang_nhap, mat_khau, so_du, sdt, email, ho_ten);
                lstAccount.add(tk);
            }
            return lstAccount;
        } catch (Exception e) {
            e.printStackTrace();
            return lstAccount;
        }
    }

    public int getSTT(String sdt) {
        int stt = 0;
        try (Connection conn = KetNoiDB.getConnect()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from Tai_khoan where sdt = " + "'" + sdt + "'");
            while (rs.next()) {
                stt = rs.getInt("id_tk");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stt;
    }
    
    public void updateAccount(TaiKhoan tk){
        try (Connection conn = KetNoiDB.getConnect()){
            String url = "UPDATE Tai_khoan SET vai_tro = ?, ten_dang_nhap = ?, mat_khau = ?, so_du = ?, sdt = ?, email = ?, ho_ten = ? WHERE id_tk = ?";
            PreparedStatement ppStm = conn.prepareStatement(url);
            
            ppStm.setBoolean(1, tk.isVai_tro());
            ppStm.setString(2, tk.getTen_dang_nhap());
            ppStm.setString(3, tk.getMat_khau());
            ppStm.setInt(4, tk.getSo_du());
            ppStm.setString(5, tk.getSdt());
            ppStm.setString(6, tk.getEmail());
            ppStm.setString(7, tk.getHo_ten());
            ppStm.executeUpdate();
            
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    }
    
    public void deleteAccount(String sdt){
        try (Connection conn = KetNoiDB.getConnect()) {
            String url = "DELETE FROM Tai_khoan WHERE sdt = (?);";
            PreparedStatement ppStm = conn.prepareStatement(url);
            ppStm.setString(1, sdt);
            ppStm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
                
    }
}
