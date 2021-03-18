/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai10;

/**
 *
 * @author Linh Nguyen
 */
public class Gen2<T> extends Gen<T>{
    Gen2(T o)
    {
        super(o);
    }
    T getObject()
    {
        System.out.println("Gen2's getObject(): ");
        return ob;
    }
}
