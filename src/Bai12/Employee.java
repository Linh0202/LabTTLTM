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
public class Employee {
    String ten, ma, chucVu;

    public Employee() {
    }

    public Employee(String ten, String ma, String chucVu) {
        this.ten = ten;
        this.ma = ma;
        this.chucVu = chucVu;
    }
    static String StringFormat = "%1$-20s %2$-10s %3$-15s";
    public String toString()
    {
        return String.format(StringFormat, ten, ma, chucVu);
    }
}
