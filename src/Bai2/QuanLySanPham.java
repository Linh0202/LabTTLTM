/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Linh Nguyen
 */
public class QuanLySanPham {
    static void menu(){
        System.out.println("-------------------------------------");
        System.out.println("1.Nhap danh sach san pham tu ban phim");
        System.out.println("2.Xuat danh sach vua nhap");
        System.out.println("3.Xuat danh sach ngau nhien");
        System.out.println("4.Sap xep giam dan theo gia va xuat ra man hinh");
        System.out.println("5.Tim va xoa san pham theo ten nhap tu ban phim");
        System.out.println("6.Xuat gia trung binh cua cac san pham");
        System.out.println("7.Thoat");
        System.out.println("-------------------------------------");
    }
    public static void main(String[] args) {
        int n=0;
        ArrayList<SanPham> SanPhamlst = new ArrayList<>();
        do{
            menu();
            System.out.println("Nhap vao lua chon cua ban: ");
            Scanner sc= new Scanner(System.in);
            n=Integer.parseInt(sc.nextLine());
            switch(n){
                case 1:{
                    int i=0;
                    String nhap;
                    while(true){
                        SanPham sp = new SanPham();
                        sp.nhap();
                        SanPhamlst.add(sp);
                        System.out.println("Nhap them Y/N ?");
                        nhap = sc.nextLine();
                        if(nhap.equals("N")|| nhap.equals("n")){
                            break;
                        }
                    }
                }break;
                case 2:{
                    System.out.println("-----------");
                    if(SanPhamlst.isEmpty()){
                        System.out.println("Ban chua nhap du lieu san pham !");
                    }else{
                        int i=0;
                        System.out.println("Du lieu ban vua nhap la");
                        for(SanPham sp:SanPhamlst){
                            i++;
                            System.out.println("-------------------------");
                            System.out.println("Thong tin san pham thu "+i);
                            sp.xuat();
                        }
                    }
                }break;
                case 3:{
                    System.out.println("-----------");
                    if(SanPhamlst.isEmpty()){
                        System.out.println("Ban chua nhap du lieu san pham !");
                    }else{
                         Collections.shuffle(SanPhamlst);
                        int i=0;
                        System.out.println("Danh sach ngau nhien la");
                        for(SanPham sp:SanPhamlst){
                            i++;
                            System.out.println("-------------------------");
                            System.out.println("Thong tin san pham thu "+i);
                            sp.xuat();
                        }
                    }   
                }break;
//                case 4:{
//                    System.out.println("-----------");
//                    Collections.sort(SanPhamlst, new Comparator<SanPham>(){
//                     public int compare(SanPham sp1, SanPham sp2){
//                           return sp1.getGia()>sp2.getGia()?-1:1;
//                       }
//                });
//                 System.out.println("Danh sach duoc sap xep giam dan theo gia la:")
//                            int i=1;
//                            for(SanPham pr: SanPhamlst){
//                                System.out.println("Thong tin san pham thu "+i);
//                                pr.xuat();
//                                i++;
//                            }
//                }break;
                case 5:{
                    if(SanPhamlst.isEmpty()){
                        System.out.println("Ban chua nhap du lieu san pham !");
                    }else{
                        String m;
                        int count=0;
                        System.out.println("Nhap ten san pham muon xoa:");
                        m=sc.nextLine();
                        for(SanPham sp: SanPhamlst){
                            if(sp.getTen().equals(m)){
                                SanPhamlst.remove(sp);
                                break;
                            }else{
                                count++;
                            }
                        }
                        if(count == SanPhamlst.size()){
                            System.out.println("Khong co san pham nay !");   
                        }
                    }
                }break;
                case 6:{
                    if(SanPhamlst.isEmpty()){
                        System.out.println("Ban chua nhap du lieu san pham !");
                    }else{
                        float tb=0;
                        for(SanPham sp:SanPhamlst){
                            tb+=sp.getGia();
                        }
                        tb = tb/SanPhamlst.size();
                        System.out.println("Gia trung binh cua cac san pham la: "+tb);
                    }
                }break;
                case 7:break;
                default:{
                    System.out.println("Khong co lua chon nay !");
                }break;
            }
        }while(n!=6);
    }
}
