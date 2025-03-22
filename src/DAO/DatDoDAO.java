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
}
