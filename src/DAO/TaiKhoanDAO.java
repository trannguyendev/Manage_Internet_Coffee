/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.TaiKhoan;
import Utils.GlobalState;
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

    public int getIDAccount(String ten_dang_nhap) {
        int id_tk = 0;
        try (Connection conn = KetNoiDB.getConnect()) {
            PreparedStatement ppStm = conn.prepareStatement("SELECT id_tk from Tai_khoan where ten_dang_nhap = ?");
            ppStm.setString(1, ten_dang_nhap);
            ResultSet rs = ppStm.executeQuery();
            if (rs.next()) {
                id_tk = rs.getInt("id_tk");
            }
            return id_tk;
        } catch (Exception e) {
            e.printStackTrace();
            return id_tk;
        }
    }

    public int getSoDu() {
        int so_du = 0;
        String sql = "select so_du from Tai_khoan where ten_dang_nhap = ?";
        try (Connection conn = KetNoiDB.getConnect(); PreparedStatement ppStm = conn.prepareStatement(sql)) {
            ppStm.setString(1, GlobalState.ten_dang_nhap);
            ResultSet rs = ppStm.executeQuery();
            while (rs.next()) {
                so_du = rs.getInt("so_du");
            }
            return so_du;
        } catch (SQLException e) {
            e.printStackTrace();
            return so_du;
        }
    }

    public void updateAccount(TaiKhoan tk) {
        try (Connection conn = KetNoiDB.getConnect()) {
            String url = "UPDATE Tai_khoan SET vai_tro = ?, ten_dang_nhap = ?, mat_khau = ?, so_du = ?, email = ?, ho_ten = ? WHERE sdt = ?";
            PreparedStatement ppStm = conn.prepareStatement(url);
            ppStm.setBoolean(1, tk.isVai_tro());
            ppStm.setString(2, tk.getTen_dang_nhap());
            ppStm.setString(3, tk.getMat_khau());
            ppStm.setInt(4, tk.getSo_du());
            ppStm.setString(5, tk.getEmail());
            ppStm.setString(6, tk.getHo_ten());
            ppStm.setString(7, tk.getSdt());
            ppStm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    }

    public void deleteAccount(int id) {
        try (Connection conn = KetNoiDB.getConnect()) {
            String url = "DELETE FROM Tai_khoan WHERE id_tk = ?";
            PreparedStatement ppStm = conn.prepareStatement(url);
            ppStm.setInt(1, id);
            ppStm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    }

    public void updateSoDu(int soDu) {
        String sql = "update Tai_khoan set so_du = ? where ten_dang_nhap = ?";
        try (Connection conn = KetNoiDB.getConnect(); PreparedStatement ppStm = conn.prepareStatement(sql)) {
            ppStm.setInt(1, soDu);
            ppStm.setString(2, GlobalState.ten_dang_nhap);
            ppStm.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    }
    public boolean getRole(int id){
        boolean role = false;
        String sql = "select vai_tro from Tai_khoan where id_tk = ?";
        try(Connection conn = KetNoiDB.getConnect()){
            PreparedStatement ppStm = conn.prepareStatement(sql);
            ppStm.setInt(1, id);
            ResultSet rs = ppStm.executeQuery();
            if (rs.next()){
                role = rs.getBoolean("vai_tro");
            }
            return role;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
