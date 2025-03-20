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
import Entity.KhuVucMay;
import Utils.GlobalState;
import Utils.KetNoiDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class MayTinhDAO {
    public List<MayTinhDAO> readPC(){
        String sql = "SELECT * FROM May_tinh"
                +"JOIN Khu_vuc"
                +"ON May_tinh.id_khu_vuc = Khu_vuc.id_khu_vuc";
        List<MayTinhDAO> lstPC = new ArrayList<>();
        try (Connection conn = KetNoiDB.getConnect();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                String tenmay = rs.getString("ten_may");
                String khuvuc = rs.getString("ten_khu_vuc");
                int gia = rs.getInt("gia_khu_vuc");
                
                MayTinhDAO maytinh = new MayTinhDAO();
                lstPC.add(maytinh);
            }
            return lstPC;
        } catch (Exception e) {
            return lstPC;
        }
    }
}
