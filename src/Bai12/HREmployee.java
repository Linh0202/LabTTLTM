/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai12;

/**
 *
 * @author Linh Nguyen
 */
public class HREmployee extends Employee {
    String tenPhongBan, maPhongBan;

    public HREmployee() {
    }

    public HREmployee(String tenPhongBan, String maPhongBan, String ten, String ma, String chucVu) {
        super(ten, ma, chucVu);
        this.tenPhongBan = tenPhongBan;
        this.maPhongBan = maPhongBan;
    }
    static String StringFormat = "%1$-20s %2$-10s";
    public String toString()
    {
        return super.toString() + String.format(StringFormat, tenPhongBan, maPhongBan);
    }
}
