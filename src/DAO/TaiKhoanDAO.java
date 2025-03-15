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
    public void addAccount(TaiKhoan tk){
        try(Connection conn = KetNoiDB.getConnect()){
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
        }
        catch(Exception e){
            System.out.println("Error: "+e);
            e.printStackTrace();
        }
    }
    public List<String> getData(){
        List<String> lstAccount = new ArrayList<>();
        try(Connection conn = KetNoiDB.getConnect()){
            String getData = "SELECT * FROM Tai_khoan";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(getData);
            while(rs.next()){
                int stt = rs.getInt("id_tk");
            }
            return lstAccount;
        }
        catch(Exception e){
            e.printStackTrace();
            return lstAccount;
        }
    }
}
