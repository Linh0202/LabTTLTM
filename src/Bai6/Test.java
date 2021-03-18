/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai6;

import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Linh Nguyen
 */
public class Test {
    static void menu(){
        System.out.println("--------------");
        System.out.println("1.Nhap du lieu");
        System.out.println("2.Xuat du lieu");
        System.out.println("3.Tim kiem");
        System.out.println("--------------");
    }
    public static void main(String[] args) {
        int n=0;
        do{
            menu();
            System.out.println("Nhap vao lua chon cua ban:");
            Scanner sc = new Scanner(System.in);
            n= Integer.parseInt(sc.nextLine());
            switch(n){
                case 1:{
                    int i=0;
                    String nhap;
                    while (true) {                        
                        DoctorHash dh = new DoctorHash();
                        dh.Add();
                        System.out.println("Nhap them Y/N ?");
                        nhap = sc.nextLine();
                        if(nhap.equals("N")|| nhap.equals("n")){
                        break;
                        }
                    }
                }break;
                case 2:{
                     System.out.println("-----------");
                     
                }
            }
        }while(n!=3);
    }
}
