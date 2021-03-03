/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_bai3;

import java.util.Scanner;

/**
 *
 * @author Pham Tuan
 */
public class Main {
    public static void main(String[] args) {
    int n = 0;
    UnetiBook ab=new UnetiBook();
    UnetiBook[] ab1=null;
    do {
    ab.menu();
    System.out.println("Nhap vao lua chon cua ban :");
    Scanner sc = new Scanner(System.in);
    n = Integer.parseInt(sc.nextLine());
    switch (n) {
    case 1: {
    int m;
    System.out.println("Nhap vao n :");
    m = Integer.parseInt(sc.nextLine());
    ab1= new UnetiBook[m];
    for (int i = 0; i < m; i++) {
    ab1[i] = new UnetiBook();
    ab1[i].nhapthongtin();
    }
    break;
    }
    case 2: {
    if (ab1 == null) {
    System.out.println("ban chua nhap du lieu");
    } else {
        System.out.println("du lieu ban vua nhap la :");
        for (int i = 0; i < ab1.length; i++) {
        System.out.println("thong tin sach thu " + (i + 1));
        ab1[i].xuatthongtin();
        }
    }
    break;
    }
    case 3: {
    if (ab1 == null) {
        System.out.println("ban chua nhap du lieu");
    } else {
        ab.sort(ab1);
        System.out.println("du lieu sau khi sap xep la :");
    for (int i = 0; i < ab1.length; i++) {
        System.out.println("thong tin hang hoa thu " + (i + 1));
        ab1[i].xuatthongtin();
    }
    }
    break;
    }
    case 4:
        {
            ab.searchNameBook(ab1);
            break;
        }
    case 5:
        {
            ab.searchNameBook(ab1);
            break;
        }
    case 6:
    break;
        default:{
            System.out.println("khong co lua chon cua ban ");
            break;
        }
    }
    } while (n != 6);
    }
}
