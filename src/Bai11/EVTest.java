/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai11;
import java.util.*;
/**
 *
 * @author Linh Nguyen
 */
public class EVTest
{
	public static void main(String[] args) 
	{
            String word,mean,type,notes;
		EVDictionary dic = new EVDictionary();
                Scanner sc=new Scanner(System.in);
		for(int i=1; i<3; i++)
		{
                        System.out.println("Nhap tu thu"+i+": ");
                        word=sc.nextLine();
                        System.out.println("Nhap nghia: ");
                        mean=sc.nextLine();
                        System.out.println("Nhap loai: ");
                        type=sc.nextLine();
                        System.out.println("Nhap ghi chu: ");
                        notes=sc.nextLine();
			dic.addWord(new EVWordClass(word, mean, type, notes));
		}
		
		System.out.println(dic);

		//Them tu
		EVWordClass w = new EVWordClass("abc", "test", "Tu thu ", "note");
                

		if(!dic.addWord(w))
			System.out.println("Khong them duoc!");
		
		//Tra tu
		EVWordClass l = dic.lookup("abc");
		if(l != null)
			System.out.println(l.toString());
	}

}

