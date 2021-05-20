/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Database.DBConnection;
import Process.ChucNang;
import Process.DatabaseManager;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.logging.Level;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author kuxut
 */
public class ThongTinLopHoc extends javax.swing.JFrame {

    DefaultTableModel dfTableModel;
    int chucNangDaChon = ChucNang.NONE;

    public ThongTinLopHoc() {
        initComponents();
        dfTableModel = (DefaultTableModel) tblDSLop.getModel();
    }
//Phương thức xử lý sự kiện khi lựa chọn ở bảng thay đổi

    void TblDSLop_SelectionChanged() {
        int row = tblDSLop.getSelectedRow();
        if (row >= 0) {
            String msLop = (String) dfTableModel.getValueAt(row, 0);
            String tenLop = (String) dfTableModel.getValueAt(row, 1);
            String gvcn = (String) dfTableModel.getValueAt(row, 2);
            txtMSLop.setText(msLop.trim());
            txtTenLop.setText(tenLop.trim());
            txtGVCN.setText(gvcn.trim());
        } else {
            {
                txtMSLop.setText("");
                txtTenLop.setText("");
                txtGVCN.setText("");
            }
            ReloadLblIndexTblDSLopHoc();
        }
    }
        //Lấy dữ liệu cho bảng lớp học
    void ReloadTaleLopHoc() {
        if (DatabaseManager.LopHocToTable(tblDSLop) == false) 
                JOptionPane.showMessageDialog(null, "Lấy dữ liệu lớp họccó lỗi", "Có lỗi xảy ra ", JOptionPane.ERROR_MESSAGE);
                ReloadLblIndexTblDSLopHoc();
            }
        //Lấy lại dữ liệu label hiện chỉ số hàng hiện tại
    void ReloadLblIndexTblDSLopHoc() {
            int rowSelected = tblDSLop.getSelectedRow();
                int totalRow = tblDSLop.getRowCount();
                lblIndexTblLopHoc.setText((rowSelected + 1) + "/" + totalRow);
            }
    void SwitchMode(int chucNang) {
            chucNangDaChon = chucNang;
                switch (chucNang) {
                    case ChucNang.ADD: {
                        boolean trangThai = true;
                        txtMSLop.setEnabled(trangThai);
                        txtTenLop.setEnabled(trangThai);
                        txtGVCN.setEnabled(trangThai);
                        txtMSLop.requestFocus();
                        btnSave.setEnabled(trangThai);
                        btnUpdate.setEnabled(!trangThai);
                        btnDelete.setEnabled(!trangThai);
                        txtMSLop.setText("");
                        txtTenLop.setText("");
                        txtGVCN.setText("");
                        btnAdd.setText("Hủy");
                        break;
                    }
                    case ChucNang.UPDATE: {
                        boolean trangThai = true;
                        txtTenLop.setEnabled(trangThai);
                        txtGVCN.setEnabled(trangThai);
                        txtTenLop.requestFocus();
                        btnSave.setEnabled(trangThai);
                        btnAdd.setEnabled(!trangThai);
                        btnDelete.setEnabled(!trangThai);
                        btnUpdate.setText("Hủy");
                        break;
                    }
                    case ChucNang.NONE: {
                        boolean trangThai = false;
                        txtMSLop.setEnabled(trangThai);
                        txtTenLop.setEnabled(trangThai);
                        txtGVCN.setEnabled(trangThai);
                        btnSave.setEnabled(trangThai);
                        btnAdd.setEnabled(true);
                        btnUpdate.setEnabled(true);
                        btnDelete.setEnabled(true);
                        btnAdd.setText("Thêm");
                        btnUpdate.setText("Sửa");
                    }
                }
            }
    boolean CheckInput() {
            String msLop = txtMSLop.getText().trim();
                String tenLop = txtTenLop.getText().trim();
                String gvcn = txtGVCN.getText().trim();
                if (msLop.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập mã số lớp", "Chưa nhập mã số lớp", JOptionPane.WARNING_MESSAGE);
                    txtMSLop.requestFocus();
                    return false;
                }
                if (tenLop.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập tên lớp",
                            "Chưa nhập tên lớp", JOptionPane.WARNING_MESSAGE);
                    txtTenLop.requestFocus();
                    return false;
                }
                if (gvcn.length() == 0) {
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập giáo viên chủ nhiệm ", "Chưa nhập giáo viên chủ nhiệm", JOptionPane.WARNING_MESSAGE
                    );
                    txtGVCN.requestFocus();
                    return false;
                }
                return true;
            }
    void Exit() {
        int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát không?", "Thoát ?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE
                );
                if (result == JOptionPane.CANCEL_OPTION) {
                    return;
                }
                this.dispose();
            }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        tblDSLop.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                TblDSLop_SelectionChanged();
            }
        });
        ReloadTaleLopHoc();
    }

    private void btnXemLopActionPerformed(java.awt.event.ActionEvent evt) {
        String msLop = txtMSLop.getText().trim();
        String tenLop = txtTenLop.getText().trim();
        if (msLop.length() == 0) {
            JOptionPane.showMessageDialog(null, "Chưa chọn lớp để xem",
                    "Chư chọn lớp", JOptionPane.WARNING_MESSAGE);
            return;
        }
        ThongTinSinhVien ttsv = new ThongTinSinhVien(msLop, tenLop);
        ttsv.setVisible(true);
    }

    private void formWindowClosing(java.awt.event.WindowEvent evt) {
        exit();
    }

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {
        if (chucNangDaChon == ChucNang.NONE) {
            SwitchMode(ChucNang.ADD);
        } else {
            SwitchMode(ChucNang.NONE);
        }
    }

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        if (tblDSLop.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(null, "Chưa chọn lớp để sửa",
                    "Chưa chọn lớp", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (chucNangDaChon == ChucNang.NONE) {
            SwitchMode(ChucNang.UPDATE);
        } else {
            SwitchMode(ChucNang.NONE);
        }
    }

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = tblDSLop.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn lớp nào để xóa", "Chưa chọn lớp", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int result = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa lớp này không ", "Xóa lớp?", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE
        );
        if (result == JOptionPane.CANCEL_OPTION) {
            return;
        }
        String msLop = (String) tblDSLop.getValueAt(selectedRow, 0);
        if (DatabaseManager.Count("SinhVien", "mslop", msLop) > 0) {
            JOptionPane.showMessageDialog(null, "Đã có sinh viên trong lớp này !", "Không thể xóa ", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (DatabaseManager.XoaLopHoc(msLop)) {
            btnAdd.requestFocus();
            SwitchMode(ChucNang.NONE);
            ReloadTaleLopHoc();
            JOptionPane.showMessageDialog(null, "Xóa thành công",
                    "Thành công", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else {
            JOptionPane.showMessageDialog(null, "Xóa thất bại", "Có lỗi xảy ra", JOptionPane.ERROR_MESSAGE);
            return;
        }
    }

    private void btnFirstActionPerformed(java.awt.event.ActionEvent evt) {
        if (tblDSLop.getRowCount() > 0) {
            tblDSLop.getSelectionModel().setSelectionInterval(0, 0);
        }
    }

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        int rowSelected = tblDSLop.getSelectedRow();
        if (rowSelected > 0) {
            rowSelected--;
            tblDSLop.getSelectionModel().setSelectionInterval(rowSelected,
                    rowSelected);
        }
    }

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {
        int rowSelected = tblDSLop.getSelectedRow();
        if (rowSelected < tblDSLop.getRowCount() - 1) {
            rowSelected++;
            tblDSLop.getSelectionModel().setSelectionInterval(rowSelected,
                    rowSelected);
        }
    }

    private void btnLastActionPerformed(java.awt.event.ActionEvent evt) {
        if (tblDSLop.getRowCount() > 0) {
            int lastRowIndex = tblDSLop.getRowCount() - 1;
            tblDSLop.getSelectionModel().setSelectionInterval(lastRowIndex,
                    lastRowIndex);
        }
    }

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {
        String msLop = txtMSLop.getText().trim();
        String tenLop = txtTenLop.getText().trim();
        String gvcn = txtGVCN.getText().trim();
        if (chucNangDaChon == ChucNang.ADD) {
            if (CheckInput() == false) {
                return;
            }
            if (DatabaseManager.Count("LopHoc", "mslop", msLop) > 0) {
                txtMSLop.requestFocus();
                JOptionPane.showMessageDialog(null, "Mã lớp bạn nhập đã tồn tại trong csdl ", "Trùng mã", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (DatabaseManager.ThemLopHoc(msLop, tenLop, gvcn)) {
                btnAdd.requestFocus();
                SwitchMode(ChucNang.NONE);
                ReloadTaleLopHoc();
                JOptionPane.showMessageDialog(null, "Thêm thành công ", "Thành công ", JOptionPane.INFORMATION_MESSAGE);
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Thêm thất bại", "Có lỗi xảy ra", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        if (chucNangDaChon == ChucNang.UPDATE) {
            if (CheckInput() == false) {
                return;
            }
            if (DatabaseManager.SuaLopHoc(msLop, tenLop, gvcn)) {
                btnUpdate.requestFocus();
                SwitchMode(ChucNang.NONE);
                ReloadTaleLopHoc();
                JOptionPane.showMessageDialog(null, "Sửa thành công", +"Thành công", JOptionPane.INFORMATION_MESSAGE);
                return;
            } else {
                JOptionPane.showMessageDialog(null, "Sửa thất bại", "Có lỗi", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
    }

    private void txtMSLopKeyTyped(java.awt.event.KeyEvent evt) {
        if ((txtMSLop.getText() + evt.getKeyChar()).length() > 15) {
            evt.consume();
        }
    }

    private void txtTenLopKeyTyped(java.awt.event.KeyEvent evt) {
        if ((txtTenLop.getText() + evt.getKeyChar()).length() > 50) {
            evt.consume();
        }
    }

    private void txtGVCNKeyTyped(java.awt.event.KeyEvent evt) {
        if ((txtGVCN.getText() + evt.getKeyChar()).length() > 50) {
            evt.consume();
        }
    }
    
}


