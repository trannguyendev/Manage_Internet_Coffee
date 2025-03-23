/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Utils.KetNoiDB;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import Entity.KhuVucMay;

/**
 *
 * @author Kien
 */
public class KhuVucDAO {
    public List<String> getListKhuVuc() {
        List<String> lstKhuVuc = new ArrayList<>();
        try (Connection conn = KetNoiDB.getConnect()) {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("SELECT ten_khu_vuc from Khu_vuc");
            while (rs.next()) {
                String tenKhuVuc = rs.getString("ten_khu_vuc");
                lstKhuVuc.add(tenKhuVuc);
            }
            return lstKhuVuc;
        } catch (Exception e) {
            e.printStackTrace();
            return lstKhuVuc;
        }
    }
    public List<KhuVucMay> readKhuvuc(){
        String sql = "SELECT * FROM Khu_vuc";
        List<KhuVucMay> lstKhuPC = new ArrayList<>();
        try (Connection conn = KetNoiDB.getConnect();
                PreparedStatement ps = conn.prepareStatement(sql);){
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String tenkhu = rs.getString("ten_khu_vuc");
                int gia = rs.getInt("gia_khu_vuc");
                
                KhuVucMay khuvucmay = new KhuVucMay(tenkhu, gia);
                lstKhuPC.add(khuvucmay);
            }
            return lstKhuPC;
        } catch (Exception e) {
            e.printStackTrace();
            return lstKhuPC;
        }
    }
    public int getId(String tenKhuVuc){
        int id = 0;
        try (Connection conn = KetNoiDB.getConnect();PreparedStatement ps = conn.prepareStatement("select id_khu_vuc from Khu_vuc where ten_khu_vuc = ?")){
            ps.setString(1, tenKhuVuc);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                id = rs.getInt("id_khu_vuc");
            }
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return id;
        }
    }
    public void addKhuvucPC (KhuVucMay khuvuc){
        String sql = "INSERT INTO Khu_vuc VALUES(?,?)";
        try (Connection conn = KetNoiDB.getConnect();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, khuvuc.getTen_khu_vuc());
            ps.setInt(2, khuvuc.getGia_khu_vuc());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    }
    public void updateKhuVucPC (KhuVucMay khuvuc){
        String sql = "UPDATE Khu_vuc SET ten_khu_vuc = ?, gia_khu_vuc = ? WHERE id_khu_vuc = ?";
        try (Connection conn = KetNoiDB.getConnect();
                PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, khuvuc.getTen_khu_vuc());
            ps.setInt(2, khuvuc.getGia_khu_vuc());
            ps.setInt(3, getId(khuvuc.getTen_khu_vuc()));
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    }
    public void deleteKhuVucPC (String idKhuVuc){
        String sql = "DELETE FROM Khu_vuc WHERE id_khu_vuc = ?";
        try (Connection conn = KetNoiDB.getConnect();
                PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, idKhuVuc);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    } 
    public int getIDKhuVuc(String tenKhuVuc){
        int ID = 0;
        String sqlCommand = "select id_khu_vuc from Khu_vuc where ten_khu_vuc = ?";
        try(Connection conn = KetNoiDB.getConnect()){
            PreparedStatement ppStm = conn.prepareStatement(sqlCommand);
            ppStm.setString(1, tenKhuVuc);
            ResultSet rs = ppStm.executeQuery();
            if (rs.next()){
                ID = rs.getInt("id_khu_vuc");
            }
            return ID;
        }
        catch(Exception e){
            e.printStackTrace();
            return ID;
        }
    }
    public String getTenKhuVuc(int id_khu_vuc){
        String tenKhuVuc = null;
        String sql = "select ten_khu_vuc from Khu_vuc where id_khu_vuc = ?";
        try(Connection conn = KetNoiDB.getConnect()){
            PreparedStatement ppStm = conn.prepareStatement(sql);
            ppStm.setInt(1, id_khu_vuc);
            ResultSet rs = ppStm.executeQuery();
            if (rs.next()){
                tenKhuVuc = rs.getString("ten_khu_vuc");
            }
            return tenKhuVuc;
        }
        catch(Exception e){
            e.printStackTrace();
            return tenKhuVuc;

        }
    }
}
