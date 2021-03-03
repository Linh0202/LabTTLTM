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
public class UnetiBook extends Book{
   private String language;
   private int semester;

    public UnetiBook(String language, int semester, String bookName, String bookAuthor, String producer, int yearPublishing, float price) {
        super(bookName, bookAuthor, producer, yearPublishing, price);
        this.language = language;
        this.semester = semester;
    }

//    UnetiBook() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }
    
   public void nhapthongtin(){
       super.nhap();
       Scanner sc=new Scanner(System.in);
        System.out.println("nhap ngon ngu :");
        language=sc.nextLine();
        System.out.println("Nhap hoc ki :");
        semester =Integer.parseInt(sc.nextLine());
   }
   public void xuatthongtin(){
       super.xuat();
       System.out.println("Ngôn ngữ "+language+" "+"Học kì "+semester);
   }
   public void sort(UnetiBook[] b){
    for (int i = 0; i < b.length - 1; i++) {
        for (int j = i + 1; j < b.length; j++) {
            if (b[i].getYearPublishing() < b[j].getYearPublishing())
            {
            UnetiBook tem = b[i];
            b[i] = b[j];
            b[j] = tem;
            }
        }
      }
    }
   public void searchNameBook(UnetiBook[] b){
        Scanner sc=new Scanner(System.in);
        System.out.println("nhap ten sach:");
        String nameBook=sc.nextLine();
        int dem=0;
        System.out.println("thong tin sach ban muon tim la :");
        for (int i = 0; i < b.length; i++) {
            if(b[i].getBookName().equals(nameBook)){
            b[i].xuat();
            dem++;
            }
        }
        if(dem==0){
            System.out.println("khong co sach ban muon tim");
        }
     }
    public void searchNameAuthor(UnetiBook[] b){
        Scanner sc=new Scanner(System.in);
        System.out.println("nhap ten tác giả :");
        String nameAuthor=sc.nextLine();
        int dem=0;
        System.out.println("Tác giả bạn cần tìm là  :");
        for (int i = 0; i < b.length; i++) {
            if(b[i].getBookAuthor().equals(nameAuthor)){
            b[i].xuat();
            dem++;
            }
        }
        if(dem==0){
            System.out.println("Không có tên tác giả bạn cần tìm ");
        }
   }
    void menu(){
    System.out.println("1 nhap thong tin n cuon sach ");
    System.out.println("2 hien thi thong tin vua nhap");
    System.out.println("3 sap xep giam dan theo nam xuat ban");
    System.out.println("4 tim kiem theo ten sach");
    System.out.println("5 tim kiem theo ten tac gia ");
    System.out.println("6 thoat");
    }
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
