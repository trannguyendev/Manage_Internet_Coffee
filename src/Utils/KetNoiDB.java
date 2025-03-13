/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;
import java.sql.*;
/**
 *
 * @author Maximus
 */
//jdbc:sqlserver://DESKTOP-NPNA5K5\\NGUYEN:1435;databaseName=PTPM_SOF2042_FINAL;user=sa;password=1234;encrypt=true;trustServerCertificate=true;
public class KetNoiDB {
    public static Connection getConnect() throws SQLException{
        String url = "jdbc:sqlserver:192.168.1.7:1435;databaseName=QLSV;user=sa;password=1234;encrypt=true;trustServerCertificate=true";
        return DriverManager.getConnection(url);
    }
}
