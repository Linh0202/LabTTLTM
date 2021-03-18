/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai3;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Linh Nguyen
 */
public class EmployeeManagement {

    static void menu() {
        System.out.println("1. Them nhan vien vao danh sach");
        System.out.println("2. Tim kiem nhan vien theo ten");
        System.out.println("3. Xoa nhan vien ra khoi danh sach");
        System.out.println("4. Hien thi tat ca danh sach nhan vien");
        System.out.println("5. Thoat");
    }

    public static void main(String[] args) {
        int n = 0;
        ArrayList<Employee> EmployeeList = new ArrayList<>();
        do {
            menu();
            System.out.println("Nhap vao lua chon");
            Scanner sc = new Scanner(System.in);
            n = Integer.parseInt(sc.nextLine());
            switch (n) {
                case 1: {
                    int i = 0;
                    String nhap;
                    while (true) {
                        Employee ep = new Employee();
                        ep.nhap();
                        EmployeeList.add(ep);
                        System.out.println("Nhap them Y/N");
                        nhap = sc.nextLine();
                        if (nhap.equals("N") || nhap.equals("n")) {
                            break;
                        }
                    }
                }
                break;
                case 2: {
                    if (EmployeeList.isEmpty()) {
                        System.out.println("Ban chua nhap du lieu san pham !");
                    } else {
                        String m;
                         int count=0;
                        System.out.println("Nhap ten nhan vien muon tim:");
                        m=sc.nextLine();
                        for(Employee ep: EmployeeList){
                            if(ep.getTenNV().equals(m)){
                                ep.xuat();
                                break;
                            }else{
                                count++;
                            }
                        }
                        if(count == EmployeeList.size()){
                            System.out.println("Khong co nhan vien nay !");   
                        }
                    }
                }break;   
                case 3: {
                    if (EmployeeList.isEmpty()) {
                        System.out.println("Ban chua nhap du lieu san pham !");
                    } else {
                        String m;
                         int count=0;
                        System.out.println("Nhap ten nhan vien muon xoa:");
                        m=sc.nextLine();
                        for(Employee ep: EmployeeList){
                            if(ep.getTenNV().equals(m)){
                                EmployeeList.remove(ep);
                                break;
                            }else{
                                count++;
                            }
                        }
                        if(count == EmployeeList.size()){
                            System.out.println("Khong co nhan vien nay !");   
                        }
                    }
                }break;   
            case 4:{
                    System.out.println("-----------");
                    if(EmployeeList.isEmpty()){
                        System.out.println("Ban chua nhap du lieu san pham !");
                    }else{
                        int i=0;
                        System.out.println("Du lieu ban vua nhap la");
                        for(Employee ep:EmployeeList){
                            i++;
                            System.out.println("-------------------------");
                            System.out.println("Thong tin nhan vien "+i);
                            ep.xuat();
                        }
                    }
                }break;
                case 5: break;
                default:{
                    System.out.println("Khong co lua chon nay !");
                }break;
            }
        }while (n != 5);
        }
    }
