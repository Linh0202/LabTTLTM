/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bai2;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import javax.swing.JOptionPane;

 /*
 * @author linhn
 */
public class Custommer {

    private static RMIInterface rmi;

    public static void main(String[] args) throws
            MalformedURLException, RemoteException, NotBoundException {
        Registry reg = LocateRegistry.getRegistry("localhost", 1122);
        // Lấy đối tượng từ xa
        RMIInterface rmi = (RMIInterface) reg.lookup("abc");
        // Gọi phương thức từ xa
        boolean findmore;
        do {
            String[] options = {"Show All", "Find a book", "Exit"};
            int choice = JOptionPane.showOptionDialog(null, "Choose an action", "Option dialog", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
            switch (choice) {
                case 0:
                    ArrayList<Book> list = rmi.allBooks();
                    StringBuilder message = new StringBuilder();
                    list.forEach(x -> {
                        message.append(x.toString() + "\n");
                    });
                    JOptionPane.showMessageDialog(null, new String(message));
                    break;
                case 1:
                    String isbn = JOptionPane.showInputDialog("Type the isbn of the book you want to find.");
                    try {
                        Book response = rmi.findBook(new Book(isbn));
                        JOptionPane.showMessageDialog(null, "Title: " + response.getTitle()
                                + "\n" + "Cost: $" + response.getCost(), response.getIsbn(),
                                JOptionPane.INFORMATION_MESSAGE);
                    } catch (NoSuchElementException ex) {
                        JOptionPane.showMessageDialog(null, "Not found");
                    }
                    break;
                default:
                    System.exit(0);
                    break;
            }
            findmore = (JOptionPane.showConfirmDialog(null, "Do you want to exit ? ", "  Exit", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION);
        } while (findmore);
    }
}
