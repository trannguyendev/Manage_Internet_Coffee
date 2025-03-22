/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Kien
 */
import Utils.KetNoiDB;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class MayTinhDAO {
    public void AddPC(){
        
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
}
