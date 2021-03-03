/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2_bai3;

import java.io.ObjectStreamConstants;
import java.util.Scanner;

/**
 *
 * @author Pham Tuan
 */
public class Book {
    private String bookName;
    private String bookAuthor;
    private String producer;
    private int yearPublishing;
    private float price;

    public Book(String bookName, String bookAuthor, String producer, int yearPublishing, float price) {
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.producer = producer;
        this.yearPublishing = yearPublishing;
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public int getYearPublishing() {
        return yearPublishing;
    }

    public void setYearPublishing(int yearPublishing) {
        this.yearPublishing = yearPublishing;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    public void nhap(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên sách ");
        bookName = sc.nextLine();
        System.out.println("Nhập tên tác giả ");
        bookAuthor = sc.nextLine();
        System.out.println("Nhập nhà xuất bản");
        producer = sc.nextLine();
        System.out.println("Nhập năm xuất bản ");
        yearPublishing = sc.nextInt();
        System.out.println("Nhập giá ");
        price = sc.nextFloat();
    }
    public void xuat(){
        System.out.println("Tên sách "+bookName+" "+"Tên tác giả "
        +bookAuthor+" "+"Nhà xuất bản "+producer+" "+"Gía bán "+price);
    }

}
