/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.function.Predicate;

/**
 *
 * @author linhn
 */
public class BookStore extends UnicastRemoteObject implements
        RMIInterface {

    private static final long serialVersionUID = 1L;
    private ArrayList<Book> bookList;

    protected BookStore(ArrayList<Book> list) throws RemoteException {
        super();
        this.bookList = list;
    }

    @Override
    public Book findBook(Book book) throws RemoteException {
        Predicate<Book> predicate = x -> x.getIsbn().equals(book.getIsbn());
        return bookList.stream().filter(predicate).findFirst().get();
    }

    @Override
    public ArrayList<Book> allBooks() throws RemoteException {
        return bookList;
    }

    private static ArrayList<Book> initializeList() {
        ArrayList<Book> list = new ArrayList<Book>();
        list.add(new Book("Head First Java, 2nd Edition", "978-0009205", 31.41));
        list.add(new Book("Java In A Nutshell", "978-059737", 10.90));
        list.add(new Book("Java:The Complete Reference", "978-8082", 40.18));
        list.add(new Book("Head First Servlets and JSP", "978-16680", 35.41));
        list.add(new Book("Java Puzzlers", "978-0321336781", 39.99));
        return list;
    }

    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.createRegistry(1122);
            BookStore bst = new BookStore(initializeList());
            reg.bind("abc", bst);
            System.err.println("Server ready");
        } catch (Exception e) {
            System.err.println("Server exception: " + e.getMessage());
        }
    }
}
