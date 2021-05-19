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
public class Customer {
   protected String makh;
   protected String tenkh;
   protected String dthoai;

    public Customer() {
    }

    public Customer(String makh, String tenkh, String dthoai) {
        this.makh = makh;
        this.tenkh = tenkh;
        this.dthoai = dthoai;
    }

    public String getMakh() {
        return makh;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public String getDthoai() {
        return dthoai;
    }

    public void setDthoai(String dthoai) {
        this.dthoai = dthoai;
    }

    @Override
    public String toString() {
        return "Customer{" + "makh=" + makh + ", tenkh=" + tenkh + ", dthoai=" + dthoai + '}';
    }
   
}
