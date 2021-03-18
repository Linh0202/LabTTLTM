/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai3;

import java.util.Scanner;

/**
 *
 * @author Linh Nguyen
 */
public class Employee {
    private String maNV;
    private String tenNV;
    private String chucVu;
    private float luong;
    private String startTime;

    public Employee() {
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public float getLuong() {
        return luong;
    }

    public void setLuong(float luong) {
        this.luong = luong;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Employee{" + "maNV=" + maNV + ", tenNV=" + tenNV + ", chucVu=" + chucVu + ", luong=" + luong + ", startTime=" + startTime + '}';
    }
    
    public void nhap(){
        Scanner sc= new Scanner(System.in);
        System.out.print("Nhap ma nv");
        maNV = sc.nextLine();
         System.out.print("Nhap ten nv");
         tenNV = sc.nextLine();
          System.out.print("Nhap chuc vu");
          chucVu = sc.nextLine();
           System.out.print("Nhap luong");
           luong = Float.parseFloat(sc.nextLine());
            System.out.print("Nhap start time");
              startTime = sc.nextLine();
    }
    
    public void xuat(){
        System.out.print("maNV"+maNV);
        System.out.print("tenNV"+tenNV);
        System.out.print("chuc vu"+chucVu);
        System.out.print("luong"+luong);
        System.out.print("starttime"+startTime);
    }
}
