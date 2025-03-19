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
    
    public List<DatDoDAO> readSanPham(){
        List<DatDoDAO> sanPhamLst = new ArrayList<>();
        try (Connection conn = KetNoiDB.getConnect()) {
            String getData = "";
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(getData);
            
            while (rs.next()){
//                String ma_san_pham = rs.getString("ma_san_pham");
//                String ma_the_loai = rs.getString("ma_the_loai");
//                String ten = rs.getString("ten");
//                String ten_the_loai = rs.getString("ten_the_loai");
//                int so_luong = rs.getInt("so_luong");
//                double gia = rs.getDouble("gia");
//                String mieu_ta = rs.getString("mieu_ta");
//                
//                SanPhamTheLoaiDTO sanPhamDTO = new SanPhamTheLoaiDTO(ma_the_loai, ma_san_pham, ten, ten_the_loai, gia, so_luong, mieu_ta);
//                sanPhamLst.add(sanPhamDTO);
            } return sanPhamLst;
        } catch (SQLException e){
            return sanPhamLst;
        }}
    
}
