/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_coban;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author Pham Tuan
 */
public class ProductMenu {
    public static void main(String[] args) {
    ArrayList<Product> product = new ArrayList<>();// k t ds 
    int option;
    Scanner sc = new Scanner(System.in);
    do{
        showMenu();
        System.out.println("Nhập lựa chọn của bạn :");
        option =Integer.parseInt(sc.nextLine());
        switch(option){
            case 1:
                int n;
                System.out.println("Nhập số lượng sản phẩm ");
                n = Integer.parseInt(sc.nextLine());
                for(int i=0;i<n;i++){
                    Product pro = new Product();
                    pro.nhap();//n 1 pro
                    product.add(pro);// tt ds
                }
                break;
            case 2:
                System.out.println("Danh sách sau khi nhập ");
                for(int i=0; i<product.size();i++){
                   product.get(i).xuat();
                }
                break;
            case 3:
                 System.out.println("Sản phẩm có giá cao nhất là :");
                    Collections.sort(product,new Comparator<Product>(){
                        public int compare(Product o1, Product o2){
                            return o1.getProductPrice()>o2.getProductPrice()?-1:1;
                        }
                    });
                    for(int i=0;i<product.size();i++){
                        product.get(0).xuat();
                        break;
                    }
                    break;
             case 4:
                    System.out.println("SẮP XẾP GIẢM DẦN THEO GIÁ SẢN PHẨM");
                    Collections.sort(product,new Comparator<Product>(){
                        public int compare(Product o1, Product o2){
                            return o1.getProductPrice()>o2.getProductPrice()?-1:1;
                        }
                    });
                    for(int i=0;i<product.size();i++){
                        product.get(i).xuat();
                    }
                    break;
             case 5:
                  String SearchName;
                    int flag=0;
                    System.out.println("Nhập tên cần tìm ");
                    //sc.nextLine();
                    SearchName = sc.nextLine();
                    for(int i=0;i<product.size();i++){
                        if(SearchName.equals(product.get(i).getProductName())){
                           flag =1;
                            System.out.println("Sản phẩm có tên "+SearchName+ "là :");
                            product.get(i).xuat();
                        }
                    }
                    if(flag == 0){
                        System.out.println("Không tìm thấy tên sản phẩm đó "); 
                    }
                    break;
             case 6:
                    String manvCanXoa;
                    int flagg=0;
                    System.out.println("Nhập mã sản phẩm cần xóa ");
                    manvCanXoa = sc.nextLine();
                    for(int i=0;i<product.size();i++){
                        if(manvCanXoa.equals(product.get(i).getProductCode())){
                           product.remove(i);
                           flagg=1;
                        }
                    }
                    if(flagg == 0){
                        System.out.println("Không tìm thấy mã sản phẩm  ");
                    }
                    break;
             case 7:
                     System.out.println("SẮP XẾP GIẢM DẦN THEO TÊN SẢN PHẨM ");
                     Collections.sort(product, new Comparator<Product>() {
                     public int compare(Product sv1, Product sv2) {
                      return (sv2.getProductName().compareToIgnoreCase(sv1.getProductName()));// nếu sắp xếp TĂNG  dần chỉ cần đổi sv1.getHoTen().compareTo(sv2.getHoTen()) 
                        }
                    });

                    System.out.println("Danh sách sắp xếp giảm dần theo tên sản phẩm ");
                    for (int i = 0; i < product.size(); i++) {
                      product.get(i).xuat();
                    }
                    break;
             case 8:
                    System.exit(0);
                default:
                    System.err.println("Nhập sai !!!");
                    break;
        }
        
    }while(option!=8);
    
 }
    static void showMenu(){
        System.out.println("1.Nhập danh sách sản phẩm ");
        System.out.println("2.Hiển thị danh sách sản phẩm ");
        System.out.println("3.Tìm sản phẩm có giá cao nhất ");
        System.out.println("4.Sắp xếp giảm dần theo giá sản phẩm ");
        System.out.println("5.Tìm mặt hàng có tên là Sữa "); 
        System.out.println("6. Xóa mã sản phẩm");
        System.out.println("7. Sắp xếp danh sách giảm dần theo tên sp ");
        System.out.println("8. Thoát ");
        
    }
   
}
