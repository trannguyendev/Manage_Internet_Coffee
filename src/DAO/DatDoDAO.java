/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import DTO.ChiTietDonHangDTO;
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
import Entity.DonHang;
import Entity.ChiTietDonHang;
import Entity.DonHangNew;
import Utils.GlobalState;

public class DatDoDAO {

    public String getPrice(String ten_sp) {
        String giaSp = null;
        try (Connection conn = KetNoiDB.getConnect()) {
            PreparedStatement ppStm = conn.prepareStatement("select gia_sp from San_pham where ten_sp = ?");
            ppStm.setString(1, ten_sp);
            ResultSet rs = ppStm.executeQuery();
            if (rs.next()) {
                giaSp = String.valueOf(rs.getInt("gia_sp"));
            }
            return giaSp;
        } catch (Exception e) {
            e.printStackTrace();
            return giaSp;
        }
    }

    public List<ListDoAn> ListDoAn() {
        List<ListDoAn> DoAnLst = new ArrayList<>();
        try (Connection conn = KetNoiDB.getConnect()) {
            String sql = "SELECT id_san_pham, ten_sp, gia_sp FROM San_pham WHERE id_danh_muc = 2";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_sp = rs.getInt("id_san_pham");  // Lấy ID sản phẩm
                String ten_sp = rs.getString("ten_sp");
                int gia_sp = rs.getInt("gia_sp");
                ListDoAn an = new ListDoAn(id_sp, ten_sp, gia_sp); // Truyền thêm ID vào constructor
                DoAnLst.add(an);
            }
            return DoAnLst;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
            return DoAnLst;
        }
    }

    public List<ListDoUong> ListDoUong() {
        List<ListDoUong> DoUongLst = new ArrayList<>();
        try (Connection conn = KetNoiDB.getConnect()) {
            String sql = "SELECT id_san_pham, ten_sp, gia_sp FROM San_pham WHERE id_danh_muc = 1";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_sp = rs.getInt("id_san_pham");  // Lấy ID sản phẩm
                String ten_sp = rs.getString("ten_sp");
                int gia_sp = rs.getInt("gia_sp");
                ListDoUong uong = new ListDoUong(id_sp, ten_sp, gia_sp); // Truyền thêm ID vào constructor
                DoUongLst.add(uong);
            }
            return DoUongLst;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
            return DoUongLst;
        }
    }

    public int themHoaDon(DonHang dh) {
        //List<DonHang> DonHangLst = new ArrayList<>();
        try (Connection conn = KetNoiDB.getConnect()) {
            String sql = "INSERT INTO Don_hang VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(2, dh.getTong_tien());
            ps.setInt(1, dh.getId_tk());
            ps.setString(3, dh.getThoi_gian());
            ps.setBoolean(4, dh.isTrang_thai());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();

        }
        return 0;
    }

    public int themChiTietDonHang(ChiTietDonHang ctdh) {
        //List<DonHang> DonHangLst = new ArrayList<>();
        try (Connection conn = KetNoiDB.getConnect()) {
            String sql = "INSERT INTO Chi_tiet_don_hang VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, ctdh.getId_don_hang());
            ps.setInt(2, ctdh.getId_san_pham());
            ps.setInt(3, ctdh.getSo_luong());
            ps.setInt(4, ctdh.getGia());
            ps.setString(5, ctdh.getGhi_chu());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
        return 0;
    }

    public int getIDSanPham(String ten_sp) {
        int idSanPham = -1;
        try (Connection conn = KetNoiDB.getConnect()) {
            PreparedStatement ppStm = conn.prepareStatement("SELECT id_san_pham FROM san_pham WHERE ten_sp = ?");
            ppStm.setString(1, ten_sp);
            ResultSet rs = ppStm.executeQuery();

            if (rs.next()) {
                idSanPham = rs.getInt("id_san_pham");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idSanPham;
    }

    public int themDonHang(int tongTien) throws Exception {
        int idDonHang = -1;

        try (Connection conn = KetNoiDB.getConnect()) {
            String sqlDonHang = "INSERT INTO DonHang (tong_tien, ngay_tao) VALUES (?, NOW())";
            PreparedStatement pstmt = conn.prepareStatement(sqlDonHang, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, tongTien);
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            if (rs.next()) {
                idDonHang = rs.getInt(1);
            }
        }
        return idDonHang;
    }

    public boolean themChiTietDonHang(List<ChiTietDonHangDTO> danhSachChiTiet) {
        String sql = "INSERT INTO ChiTietDonHang (id_san_pham, ten_sp, so_luong, gia_sp, id_danh_muc) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = KetNoiDB.getConnect(); PreparedStatement ppStm = conn.prepareStatement(sql)) {

            for (ChiTietDonHangDTO chiTiet : danhSachChiTiet) {
                ppStm.setInt(1, chiTiet.getId_san_pham());
                ppStm.setString(2, chiTiet.getTen_sp());
                ppStm.setInt(3, chiTiet.getSoLuong());
                ppStm.setInt(4, chiTiet.getGia_sp());
                ppStm.setString(5, chiTiet.getId_danh_muc()); // "Đồ uống" hoặc "Đồ ăn"

                ppStm.addBatch(); // Thêm vào batch để thực thi nhiều câu lệnh cùng lúc
            }

            int[] ketQua = ppStm.executeBatch(); // Thực thi toàn bộ batch
            return ketQua.length > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean luuChiTietDonHang(int idDonHang, List<ChiTietDonHang> dsMonAn) {
        String sql = "INSERT INTO Chi_tiet_don_hang (id_don_hang, id_san_pham, so_luong, gia) VALUES (?, ?, ?, ?)";

        try (Connection conn = KetNoiDB.getConnect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

            for (ChiTietDonHang chiTiet : dsMonAn) {
                pstmt.setInt(1, idDonHang);
                pstmt.setInt(2, chiTiet.getId_san_pham());
                pstmt.setInt(3, chiTiet.getSo_luong());
                pstmt.setInt(4, chiTiet.getGia());

                pstmt.addBatch();
            }
            pstmt.executeBatch();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int insertChiTietDonHang(int idDonHang, int idSanPham, int soLuong, int gia, String ghiChu) {
        String sql = "INSERT INTO Chi_tiet_don_hang (id_don_hang, id_san_pham, so_luong, gia, ghi_chu) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = KetNoiDB.getConnect(); PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, idDonHang);
            ps.setInt(2, idSanPham);
            ps.setInt(3, soLuong);
            ps.setInt(4, gia);
            ps.setString(5, ghiChu);
            return ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getCurrentDonHangID() {
        String sql = "SELECT TOP 1 id_don_hang FROM Don_hang ORDER BY id_don_hang DESC";
        try (Connection conn = KetNoiDB.getConnect(); PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                return rs.getInt("id_don_hang");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1; // Không tìm thấy đơn hàng nào
    }

    public int taoDonHangMoi() {
        String sql = "INSERT INTO Don_hang (thoi_gian, id_tk) VALUES (?, ?)";
        TaiKhoanDAO tkDAO = new TaiKhoanDAO();
        try (Connection conn = KetNoiDB.getConnect(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            // Set the current datetime for the first placeholder
            stmt.setTimestamp(1, new java.sql.Timestamp(System.currentTimeMillis()));
            // Set the id of the account for the second placeholder
            stmt.setInt(2, tkDAO.getIDAccount(GlobalState.ten_dang_nhap));

            // Execute the update
            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                // Retrieve the generated keys
                try (ResultSet rs = stmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        int newId = rs.getInt(1);
                        System.out.println("✅ Đã tạo đơn hàng mới, ID: " + newId);
                        return newId;
                    }
                }
            }

            System.out.println("❌ Không lấy được ID đơn hàng!");
            return -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public void themChiTietDonHang(int idDonHang, int idSanPham, int soLuong, int gia, String ghiChu) {
        String sql = "INSERT INTO Chi_tiet_don_hang (id_don_hang, id_san_pham, so_luong, gia, ghi_chu) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = KetNoiDB.getConnect(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idDonHang);
            stmt.setInt(2, idSanPham);
            stmt.setInt(3, soLuong);
            stmt.setInt(4, gia);
            stmt.setString(5, ghiChu);

            int rows = stmt.executeUpdate();

            if (rows > 0) {
                System.out.println("✅ Đã lưu sản phẩm " + idSanPham + " vào đơn hàng " + idDonHang);
            } else {
                System.out.println("❌ Không thể lưu sản phẩm " + idSanPham + "!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<DonHangNew> readDonHang(){
        String sql = "SELECT * FROM Don_hang";
        List<DonHangNew> dhLst = new ArrayList<>();
        try (Connection conn = KetNoiDB.getConnect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id_don_hang = rs.getInt("id_don_hang");
                int id_tk = rs.getInt("id_tk");
                String thoi_gian = rs.getString("thoi_gian");
                DonHangNew dh = new DonHangNew(id_don_hang,id_tk, thoi_gian);
                dhLst.add(dh);
            }
         return dhLst;      
        } catch (SQLException e) {
            e.printStackTrace();
            return dhLst;
        }
    }
    
    public List<ChiTietDonHang> readChiTiet(int id){
        String sql = "SELECT * FROM Chi_tiet_don_hang where id_don_hang = ?";
        List<ChiTietDonHang> ctdhLst = new ArrayList<>();
        try (Connection conn = KetNoiDB.getConnect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){             
                int id_don_hang = rs.getInt("id_don_hang");
                int id_san_pham = rs.getInt(("id_san_pham"));
                int so_luong = rs.getInt("so_luong");
                int gia = rs.getInt("gia");
                String ghi_chu = rs.getString("ghi_chu");
                ChiTietDonHang ctdh = new ChiTietDonHang(id_don_hang, id_san_pham, so_luong, gia, ghi_chu);
                ctdhLst.add(ctdh);
            }
               return ctdhLst;
        } catch (SQLException e) {
            e.printStackTrace();
            return ctdhLst;
        }
    }
}
