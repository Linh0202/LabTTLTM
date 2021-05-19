/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bainop;

/**
 *
 * @author Pham Tuan
 */
public class Bill {
    protected String hdso;
    protected String ngay;
    protected String maKH;
    protected double trigia;

    public Bill() {
    }

    public Bill(String hdso, String ngay, String maKH, double trigia) {
        this.hdso = hdso;
        this.ngay = ngay;
        this.maKH = maKH;
        this.trigia = trigia;
    }

    Bill(double aDouble) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getHdso() {
        return hdso;
    }

    public void setHdso(String hdso) {
        this.hdso = hdso;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public double getTrigia() {
        return trigia;
    }

    public void setTrigia(double trigia) {
        this.trigia = trigia;
    }

    @Override
    public String toString() {
        return "Bill{" + "hdso=" + hdso + ", ngay=" + ngay + ", maKH=" + maKH + ", trigia=" + trigia + '}';
    }
    
}
