/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_coban;

import java.util.Scanner;

/**
 *
 * @author Pham Tuan
 */
public class Product {
    //thuộc tính 
    String productCode;
    String productName;
    float productQuantity;
    float productPrice;
    // phương thức 

    public Product() {
    }

    public Product(String productCode, String productName, float productQuantity, float productPrice) {
        this.productCode = productCode;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public float getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(float productQuantity) {
        this.productQuantity = productQuantity;
    }

    public float getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(float productPrice) {
        this.productPrice = productPrice;
    }
    public void nhap(){
       Scanner sc =new Scanner(System.in);
        System.out.println("Nhập mã sản phẩm ");
       productCode = sc.nextLine();
        System.out.println("Nhập tên sản phẩm ");
        productName = sc.nextLine();
        System.out.println("Nhập giá sản phẩm ");
        productPrice = sc.nextFloat();
        System.out.println("Nhập số lượng sản phẩm ");
        productQuantity = sc.nextFloat();
    }
    public void xuat(){
        System.out.println("Mã sản phẩm "+productCode+" "+"Tên sản phẩm "+productName
                +" "+"Gía sản phẩm "+productPrice+" "+"Số lượng sản phẩm "+productQuantity);
    }
    
}
