/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Utils;
import DAO.NapTheDAO;
import java.sql.*;
/**
 *
 * @author Maximus
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        try(Connection conn = KetNoiDB.getConnect()){
            System.out.println(""+conn.getCatalog());
        }
        catch(Exception e){}
        NapTheDAO napThe = new NapTheDAO();
        napThe.returnNumberOfOrderByStatus("Thành công");
    }
    
    
}
