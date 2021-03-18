/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.util.Scanner;

/**
 *
 * @author Linh Nguyen
 */
public class SanPham {
    private String ten;
    private float gia;

    public SanPham() {
    }

    public SanPham(String ten, float gia) {
        this.ten = ten;
        this.gia = gia;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public float getGia() {
        return gia;
    }

    public void setGia(float gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "SanPham{" + "ten=" + ten + ", gia=" + gia + '}';
    }
    
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten san pham:");
        ten = sc.nextLine();
        System.out.println("Nhap gia san pham:");
        gia = Float.parseFloat(sc.nextLine());
    }
    
    public void xuat(){
        System.out.println("Ten san pham:"+ten);
        System.out.println("Gia san pham:"+gia);
    }
}
