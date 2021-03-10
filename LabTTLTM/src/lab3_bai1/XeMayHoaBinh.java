/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_bai1;

import java.util.Scanner;

/**
 *
 * @author Linh Nguyen
 */
public class XeMayHoaBinh extends XeMay{
    private int n;
    XeMay[] mangxe;

    public XeMayHoaBinh() {
        super();
    }

    public XeMayHoaBinh(int n, XeMay[] mangxe, String bienso, String loaixe, String mauxe, float giatien) {
        super(bienso, loaixe, mauxe, giatien);
        this.n = n;
        this.mangxe = mangxe;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public XeMay[] getMangxe() {
        return mangxe;
    }

    public void setMangxe(XeMay[] mangxe) {
        this.mangxe = mangxe;
    }

    @Override
    public void hienthi() {
        super.hienthi(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void nhap() {
        Scanner sc= new Scanner(System.in);
        System.out.println("nhap vao so luong xe may o hoa binh");
        n= Integer.parseInt(sc.nextLine());
    }
    
}