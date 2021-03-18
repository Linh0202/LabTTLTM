/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai1;

/**
 *
 * @author Linh Nguyen
 */
public class TestSinhvien {

    public static void main(String[] args) {
        DanhSachSinhvien qlsv = new DanhSachSinhvien();
        Sinhvien teo = new Sinhvien();
        teo.setMasv("113");
        teo.setTensv("Nguyễn Văn Tèo");
        qlsv.addSinhvien(teo);
        Sinhvien ty = new Sinhvien();
        ty.setMasv("114");
        ty.setTensv("Nguyễn Thị tý");
        qlsv.addSinhvien(ty);
        qlsv.sort();
        System.out.println(qlsv);
    }
}
