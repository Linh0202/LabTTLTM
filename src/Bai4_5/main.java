/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai4_5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Linh Nguyen
 */
public class main {

    public static void main(String[] args) {
        ArrayList<SinhVienPoly> list = new ArrayList<>();
        Scanner sb = new Scanner(System.in);
        SinhVienPoly sv = new SinhVienPoly();
        while (true) {
            String nhap;
            sv.nhap();
            list.add(sv);
            System.out.println("Nhap them Y/N?");
            nhap = sb.nextLine();
            if (nhap.equals("N")||nhap.equals("n")) {
                break;
            }
            
        }
        
        System.out.println("---------");
        int i = 0;
        for(SinhVienPoly sv1:list){
        i++;
         System.out.println("Sinh vien thu: " + i );
        sv.xuat();
        sv.Hocluc();
          System.out.println("danh sach sv loc luc gioi: ");
         
          System.out.println("-----------");
                    Collections.sort(list, new Comparator<SinhVienPoly>(){
                   public int compare(getDiem sv1, getDiem sv2){
                           return sv1.getDiem()>sv2.getDiem()?-1:1;
                       }

            @Override
            public int compare(SinhVienPoly o1, SinhVienPoly o2) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
                });
                 System.out.println("Danh sach duoc sap xep giam dan theo diem la:");
                            
                            for(SinhVienPoly pr: list){
                                System.out.println("Thong tin san pham thu "+i);
                               pr.xuat();
                               i++;
                          }
           
        }
    }
}
