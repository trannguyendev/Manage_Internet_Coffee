/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Utils.KetNoiDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Entity.DoAn;
import Entity.ListDoAn;
import Entity.ListDoUong;
public class DatDoDAO {
    public String getPrice(String ten_sp){
        String giaSp = null;
        try(Connection conn = KetNoiDB.getConnect()){
            PreparedStatement ppStm = conn.prepareStatement("select gia_sp from San_pham where ten_sp = ?");
            ppStm.setString(1, ten_sp);
            ResultSet rs = ppStm.executeQuery();
            if (rs.next()){
                giaSp = String.valueOf(rs.getInt("gia_sp"));
            }
            return giaSp;
        }
        catch(Exception e){
            e.printStackTrace();
            return giaSp;
        }
    }
    public List<ListDoAn> ListDoAn(){
        List<ListDoAn> DoAnLst = new ArrayList<>();
    try (Connection conn = KetNoiDB.getConnect()) {
        String sql = "SELECT ten_sp, gia_sp FROM San_pham WHERE id_danh_muc = 2";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            String ten_sp = rs.getString("ten_sp");
            int gia_sp = rs.getInt("gia_sp");
            ListDoAn an = new ListDoAn(ten_sp, gia_sp);
            DoAnLst.add(an);
        }
       return DoAnLst;
    } catch (Exception e) {
        System.out.println("Error: " + e);
        e.printStackTrace();
        return DoAnLst;
    }
}
    public List<ListDoUong> ListDoUong(){
        List<ListDoUong> DoUongLst = new ArrayList<>();
        try (Connection conn = KetNoiDB.getConnect()) {
            String sql = "SELECT ten_sp, gia_sp FROM San_pham WHERE id_danh_muc = 1";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                String ten_sp = rs.getString("ten_sp");
                int gia_sp = rs.getInt("gia_sp");
                ListDoUong uong = new ListDoUong(ten_sp, gia_sp);
                DoUongLst.add(uong);
            }
           return DoUongLst;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
            return DoUongLst;
        }
    }
    
    }
    
