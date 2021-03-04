/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_coban;

import java.text.ChoiceFormat;
import java.util.Scanner;

/**
 *
 * @author Hung
 */
public class coban {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào một số nguyên ");
        int a = sc.nextInt();
        System.out.println("Nhập vào một số thực ");
        float b = sc.nextFloat();
         System.out.println("Nhập vào một số  ");
        double c = sc.nextDouble();
        System.out.println("Nhap mot so long:");
        long l = sc.nextLong();
        System.out.println("Nhap mot ki tu:");
        sc.nextLine(); // ki tu ket thuc nhap se bi mat
        char ch = sc.nextLine().charAt(0);
        System.out.println("Nhap mot chuoi:");
       String str = sc.nextLine();
        System.out.println("Du lieu vua nhap:");
        System.out.println("a="+a);
        System.out.println("l="+l);
        System.out.println("f="+b);
        System.out.println("ch="+ch);
        System.out.println("str="+str);
        System.out.println("d="+c);
      

    }
    
}
