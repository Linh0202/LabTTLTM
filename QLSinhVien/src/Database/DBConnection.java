/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;


import java.io.IOException;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author kuxut
 */

public class DBConnection {
    

    String dbName = "SinhVienTest"; //tên cơ sở dữ liệu cần kết nối
    String connString= "jdbc:sqlserver://localhost:1433;integratedSecurity=true; databaseName="+ dbName;

    public Connection GetConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection(connString);
            return conn;
        } catch (SQLException ex) {
            //Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public ResultSet GetData(String query) {
        Connection conn = GetConnection();
        if (conn == null) //nếu không thể mở kết nối
        {
            CloseConnection(conn); //Đóng kết nối
            return null;
        }
        Statement stm;
        try {
            stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(query);
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            CloseConnection(conn); //đóng kết nối
            return null;
        }
    }

    public boolean UpdateData(String query) {
        Connection conn = GetConnection();
        if (conn == null) {
            return false;
        }
        Statement stm;
        try {
            stm = conn.createStatement();
            stm.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public void CloseConnection(Connection conn) {
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
