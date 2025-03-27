/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Kien
 */
import Entity.MayTinh;
import Utils.KetNoiDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class MayTinhDAO {
    public int getIDPC(String ten_may){
        int ID_PC = 0;
        String sql = "select id_may from May_tinh where ten_may = ?";
        try(Connection conn = KetNoiDB.getConnect()){
            PreparedStatement ppStm = conn.prepareStatement(sql);
            ppStm.setString(1, ten_may);
            ResultSet rs = ppStm.executeQuery();
            if (rs.next()){
                ID_PC = rs.getInt("id_may");
            }
            return ID_PC;
        }
        catch(Exception e){
            e.printStackTrace();
            return ID_PC;
        }
    }
    //Return ListOfPC for loadUp to Table
    public List<MayTinh> parseListPC(){
        String sql = "select * from May_tinh";
        List<MayTinh> lstPC = new ArrayList<>();
        try(Connection conn = KetNoiDB.getConnect()){
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                String tenMay = rs.getString("ten_may");
                int idKhuVuc = rs.getInt("id_khu_vuc");
                MayTinh mtNew = new MayTinh(tenMay, idKhuVuc);
                lstPC.add(mtNew);
            }
            return lstPC;
        }
        catch(Exception e){
            e.printStackTrace();
            return lstPC;
        }
    }
    public void AddPC(MayTinh mt){
        String sqlCmd = "INSERT INTO May_tinh(ten_may, id_khu_vuc) VALUES (?, ?)";
        try(Connection conn = KetNoiDB.getConnect()){
            PreparedStatement ppStm = conn.prepareStatement(sqlCmd);
            ppStm.setString(1, mt.getTen_may());
            ppStm.setInt(2, mt.getId_khu_vuc());
            ppStm.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public void UpdatePCInfo(int id, String ten, int idKhuVuc){
        String sql = "UPDATE May_tinh SET ten_may = ?, id_khu_vuc = ? where id_may = ?";
        try(Connection conn = KetNoiDB.getConnect()){
            PreparedStatement ppStm = conn.prepareStatement(sql);
            ppStm.setString(1, ten);
            ppStm.setInt(2, idKhuVuc);
            ppStm.setInt(3, id);
            ppStm.executeUpdate();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    public List<String> getListPC(){
        List<String> lstPC = new ArrayList<>();
        try(Connection conn = KetNoiDB.getConnect()){
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select ten_may from May_tinh");
            while(rs.next()){
                String tenMay = rs.getString("ten_may");
                lstPC.add(tenMay);
            }
            return lstPC;
        }
        catch(Exception e){
            e.printStackTrace();
            return lstPC;
        }
    }
    public int getMoney(String tenMay) {
        int gia = 0;
        String sql = "select gia_khu_vuc from Khu_vuc join May_tinh on May_tinh.id_khu_vuc = Khu_vuc.id_khu_vuc where ten_may = ?";
        try (Connection conn = KetNoiDB.getConnect();
                PreparedStatement ps = conn.prepareStatement(sql)){
            ps.setString(1, tenMay);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                gia = rs.getInt("gia_khu_vuc");
            }
            return gia;
        } catch (Exception e) {
            e.printStackTrace();
            return gia;
        }

    public void deletePC(int id) {
    String sql = "DELETE FROM May_tinh WHERE id_may = ?";
    try (Connection conn = KetNoiDB.getConnect();
         PreparedStatement ppStm = conn.prepareStatement(sql)) {
        
        ppStm.setInt(1, id);
        ppStm.executeUpdate();
        
    } catch (Exception e) {
        System.out.println("Error: " + e);
            e.printStackTrace();
    }

    }
}
