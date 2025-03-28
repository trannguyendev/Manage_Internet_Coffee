/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.NapThe;
import Utils.KetNoiDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author cunhp
 */
public class NapTheDAO {
    public boolean getTrangThai() {
        boolean trangThai;
        try (Connection conn = KetNoiDB.getConnect()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT status from Nap_the");
            while (rs.next()) {
                trangThai = rs.getBoolean("status");
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public List<NapThe> readNapThe(){
        String sql = "SELECT * FROM Nap_the";
        List<NapThe> lstNapThe = new ArrayList<>();
        try (Connection conn = KetNoiDB.getConnect();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id_nap = rs.getInt("id_nap");
                int gia = rs.getInt("gia");
                int id = rs.getInt("id_tk");
                String trangThai = rs.getString("status");
                        
                NapThe napThe = new NapThe(id_nap, gia, id, trangThai);
                lstNapThe.add(napThe);
            }
            return lstNapThe;
        } catch (Exception e) {
            e.printStackTrace();
            return lstNapThe;
        }
    }

    public int getIdNap(int gia){
        int id = 0;
        try (Connection conn = KetNoiDB.getConnect();PreparedStatement ps = conn.prepareStatement("select id_nap from Nap_the where gia = ?")){
            ps.setInt(1, gia);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                id = rs.getInt("id_nap");
            }
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return id;
        }
    }
    public void updateStatusNap(int id_nap, String status){
        String sqlUpd = "UPDATE Nap_the SET status = ? WHERE id_nap = ?";
        try(Connection conn = KetNoiDB.getConnect()){
            PreparedStatement ppStm = conn.prepareStatement(sqlUpd);
            ppStm.setString(1, status);
            ppStm.setInt(2, id_nap);
            ppStm.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
            System.out.println("Error: "+e);
        }
    }
    public void AddAccount(int menhGia, String ten_dang_nhap, String status){
        try(Connection conn = KetNoiDB.getConnect()){
            TaiKhoanDAO tkDAO = new TaiKhoanDAO();
            int id = tkDAO.getIDAccount(ten_dang_nhap);
            PreparedStatement ppStm = conn.prepareStatement("INSERT INTO Nap_the VALUES(?, ?, ?)");
            ppStm.setInt(1, menhGia);
            ppStm.setInt(2, id);
            System.out.println(id);
            ppStm.setString(3, status);
            ppStm.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
