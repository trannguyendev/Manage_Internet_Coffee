/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Utils.KetNoiDB;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

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
}
