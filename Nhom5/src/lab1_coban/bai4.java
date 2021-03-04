/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab1_coban;

import java.util.Scanner;

/**
 *
 * @author Hung
 */
public class bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số điện ");
        int n = sc.nextInt();
        double tienDien =0;
        int choice;
        System.out.println("Nhập lựa chọn của bạn");
        choice = sc.nextInt();
       switch(choice) {
        case 1:
            if(n< 50){
            tienDien = n*5000;
            System.out.println("Tiền điện"+tienDien);
            }else{
             tienDien = (50*5000)+( n- 50)*1200;
            System.out.println("Tiền điện là "+tienDien);   
            }
            break;
            default: 
                System.out.println("Số điện nhập lớn hơn 0 ");
       }

    }
}
