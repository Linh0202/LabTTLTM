/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_bai6;

/**
 *
 * @author Linh Nguyen
 */
public class KhachHangNuocNgoai extends KhachHang {
    private String QuocTich;
public KhachHangNuocNgoai()
{
super();
this.QuocTich="";
}
public KhachHangNuocNgoai(int ma, double dgia, String ngay, String hoten, 
int sl, double ttien, String qt)
{
super(ma, dgia, ngay, hoten, sl, ttien);
this.QuocTich=qt;
}
public String getQuocTich() {
return QuocTich;
}
public void setQuocTich(String quocTich) {
QuocTich = quocTich;
}
public void nhap()
{
super.nhap();
System.out.println("Quoc Tich: ");
QuocTich = in.nextLine();
}
public double TTien()
{
return this.ThanhTien = this.SoLuong*this.DonGia;
}
public String toString()
{
return "Khach Hang Nuoc Ngoai: " + super.toString() + ", QuocTich: " + 
QuocTich
+ ", ThanhTien: " + ThanhTien;
}
}
