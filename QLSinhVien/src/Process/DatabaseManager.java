/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Process;

import Database.DBConnection;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.sql.ResultSet;

/**
 *
 * @author kuxut
 */
public class DatabaseManager {// thực hiện thêm, sửa, xóa trên database

    public static boolean ThemLopHoc(String msLop, String tenLop, String gvcn) {
        DBConnection dbConn = new DBConnection();
        String qr = "Insert Into LopHoc Values('" + msLop + "',N'" + tenLop + "'  , N'" + gvcn + "'  )";

        return dbConn.UpdateData(qr);
    }

    public static boolean SuaLopHoc(String msLop, String tenLop, String gvcn) {
        DBConnection dbConn = new DBConnection();
        String qr = "Update LopHoc Set tenlop = N'" + tenLop + "', giaovienCN= N'" + gvcn + "'  Where mslop = '" + msLop + "'  ";

        return dbConn.UpdateData(qr);
    }

    public static boolean XoaLopHoc(String msLop) {
        String qr = "Delete From LopHoc Where mslop = '" + msLop + "'";
        DBConnection dbConn = new DBConnection();
        return dbConn.UpdateData(qr);
    }

    public static boolean LopHocToTable(JTable jTable) {
        try {
            DefaultTableModel dfTableModel = (DefaultTableModel) jTable.getModel();
            dfTableModel.setRowCount(0);
            DBConnection db = new DBConnection();
            java.sql.ResultSet rs = db.GetData("Select * From LopHoc");
            String[] row = new String[3];
            while (rs.next()) {
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                dfTableModel.addRow(row);
            }
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean ThemSinhVien(String mssv, String hoTen, String email, String diaChi, String msLop) {
        String qr = "Insert Into SinhVien Values('" + mssv + "',N'" + hoTen + "'  , N'" + email + "'  , N'" + diaChi + "'  , '" + msLop + "'  )";

        DBConnection dbConn = new DBConnection();
        return dbConn.UpdateData(qr) == true;
    }

    public static boolean SuaSinhVien(String mssv, String hoTen, String email, String diaChi, String msLop) {
        String qr = "Update SinhVien Set hoten = N'" + hoTen + "', email =N'" + email + "'  , diachi = N'" + diaChi + "'  , mslop = '" + msLop + "'Where masv ='" + mssv + "'  ";

        DBConnection dbConn = new DBConnection();
        return dbConn.UpdateData(qr);
    }

    public static boolean XoaSinhVien(String masv) {
        String qr = "Delete From SinhVien Where masv = '" + masv + "'";
        DBConnection dbConn = new DBConnection();
        return dbConn.UpdateData(qr);
    }

    public static boolean SinhVienToTable_ByLopHoc(JTable jTable, String msLop) {
        try {
            DefaultTableModel dfTableModel = (DefaultTableModel) jTable.getModel();
            dfTableModel.setRowCount(0);
            DBConnection db = new DBConnection();
            ResultSet rs = db.GetData("Select * From SinhVien Where mslop ='" + msLop + "'  ");

            String[] row = new String[4];
            while (rs.next()) {
                row[0] = rs.getString(1);
                row[1] = rs.getString(2);
                row[2] = rs.getString(3);
                row[3] = rs.getString(4);
                dfTableModel.addRow(row);
            }
            return true;
        } catch (Exception ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null,
                    ex);
            return false;
        }
    }

    public static int Count(String tableName, String columnName, String id) {
        String qr = "";
        if (id.length() == 0 || columnName.length() == 0) {
            qr = "Select COUNT(*) from " + tableName;
        } else {
            qr = "Select COUNT(*) from " + tableName + " Where " + columnName + " ='" + id + "'  ";

            DBConnection dbConn = new DBConnection();
            ResultSet rs = dbConn.GetData(qr);
            try {
                if (rs.next()) {
                    int count = Integer.parseInt(rs.getString(1));
                    return count;
                }
            } catch (Exception ex) {
                Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null,
                        ex);
                return -1;
            }
            return -1;
        }
        return 0;
    }
}
