package client;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Boxchat implements ActionListener{
    public static String Ten;//tên
    public  int statusOp;//trạng thái hoạt động
    public int stop;// đóng khung chat
    private JFrame boxchat;
    private JTabbedPane chats;
    private JPanel panel;
    private ArrayList<JTextArea> chatPer;//danh sách người dùng đang hoạt động được lưu để lựa chọn chat riêng
    private ArrayList<String> contacts;//danh sách kết nối
    private ArrayList<String> contactsChat;//danh sách người dùng
    private ArrayList<JTextField> messSend;//những ô gửi tin
    private ArrayList<JButton> btnSend;// những nút gửi
    
    public Boxchat(int operacion){
        statusOp = operacion;
        stop = 0;
        Ten = JOptionPane.showInputDialog("Nhập tên người dùng ");
        while(Ten.isEmpty()){
            Ten = JOptionPane.showInputDialog("Không để trống tên người dùng");
        }
        boxchat = new JFrame();
        
        boxchat.setSize(500, 500);
        boxchat.setTitle(Ten + ": Chat multicast");
        boxchat.setLocationRelativeTo(null);
        boxchat.setResizable(false);
        boxchat.setDefaultCloseOperation(3);
        boxchat.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent we) {
                statusOp = 1;
                stop = 1;// đặt cờ cho việc đóng một cửa sổ
                try {
                    Thread.sleep(1000);//đóng luồng cho khung chat vừa đóng
                } catch (InterruptedException ex) {
                    Logger.getLogger(Boxchat.class.getName()).log(Level.SEVERE, null, ex);// mở luồng nếu có người dùng mới.
                }
            }
        });
        
        chatPer = new ArrayList();
        contactsChat = new ArrayList();
        contacts = new ArrayList();
        messSend = new ArrayList();
        btnSend = new ArrayList();
        
        KhoitaoBox();
        boxchat.setVisible(true);
    }
    
    private void KhoitaoBox(){
        panel = new JPanel();
        JLabel title = new JLabel("Box chat của: " + Ten);
        
        panel.setLayout(null);
        boxchat.getContentPane().add(panel);
        title.setBounds(10, 10, 180, 30);
        panel.add(title);
        setButtons();
        setChung();
    }
   
    private void setButtons(){
        JButton newChat = new JButton();
        newChat.addActionListener(this);
        newChat.setText("Chat rieng");
        newChat.setBounds(290, 10, 200, 30);
        panel.add(newChat);
    }
    
    private void setChung(){
        chats = new JTabbedPane();
        chats.setBounds(10, 50, 480, 400);
        newChat("Chung");
        panel.add(chats);
    }
    
    private void newChat(String ten){
        JPanel newPanel = new JPanel();
        newPanel.setLayout(null);
        chats.addTab(ten, newPanel);
        
        JTextArea chat = new JTextArea();
        chat.setEditable(false);
        chat.setForeground(Color.BLACK);
        chatPer.add(chat);
        JScrollPane scroll = new JScrollPane(chatPer.get(chatPer.size() - 1));
        scroll.setBounds(10,10,455,300);
        newPanel.add(scroll);
        
        JTextField text = new JTextField();
        messSend.add(text);
        messSend.get(messSend.size() - 1).setBounds(10, 320, 350, 39);
        newPanel.add(messSend.get(messSend.size() - 1));
        
        JButton send = new JButton("Gửi");
        btnSend.add(send);
        btnSend.get(btnSend.size() - 1).setBounds(370, 320, 95, 38);
        btnSend.get(btnSend.size() - 1).setText("Gửi");
        btnSend.get(btnSend.size() - 1).addActionListener(this);
        String butname = "Gửi" + (btnSend.size() - 1);
        System.out.println(butname);
        btnSend.get(btnSend.size() - 1).setName(butname);
        newPanel.add(btnSend.get(btnSend.size() - 1));
        
        contactsChat.add(ten);
    }
    
    public int getStatus(){
        return statusOp;
    }
    
    public int getStop(){
        return stop;
    }
    
    public void setStatus(int newStatus){
        statusOp = newStatus;
    }
    
    public String getActiveMessage(){
        int selectedIndex = chats.getSelectedIndex();
        String text = messSend.get(selectedIndex).getText();
        messSend.get(selectedIndex).setText("");
        return text;
    }
    
    public int getActiveTab(){
        
        return chats.getSelectedIndex();
    }
    
    public String getContactsChat(int index){
        return contactsChat.get(index);
    }
    
    public void setNewMessage(String mess){
        if(mess.contains("<contacts>")){
            String contact = "";
            contacts.clear();
            for(int i = 11; i < mess.length(); i++){
                System.out.println("|" + mess.charAt(i) + "|");
                if(Character.isLetter(mess.charAt(i))){                    
                    contact += mess.charAt(i);
                }else if(mess.charAt(i) == ','){
                    contacts.add(contact);
                    contact = "";
                }
            }
            contacts.add(contact);
            System.out.println(contacts);
           
        }else if(mess.startsWith("S<msj>")){
            String sender = "";
            mess = mess.substring(6);
            
            
            
            mess = mess.replace(":)", "\uD83D\uDE04");
            mess = mess.replace(":D", "\uD83D\uDE03");
            mess = mess.replace(":3", "\uD83D\uDE0A");
            mess = mess.replace(":P", "\uD83D\uDE1C");
            mess = mess.replace(":(", "\uD83D\uDE14");
            mess = mess.replace(":'(", "\uD83D\uDE22");
            mess = mess.replace("D:", "\uD83D\uDE29");
            mess = mess.replace(">:c", "\uD83D\uDE21");
            
            
            if(mess.contains("<private>")){
                String addressee = "";
                int i = 1;
                
                mess = mess.substring(9);
                while(Character.isLetter(mess.charAt(i))){
                    sender = sender + mess.charAt(i);
                    i++;
                }
                mess = mess.substring(i + 1);
                
                i = 1;
                System.out.println(mess);
                while(Character.isLetter(mess.charAt(i))){
                    addressee = addressee + mess.charAt(i);
                    i++;
                }
                mess = mess.substring(i + 1);
                System.out.println(mess);
                System.out.println("Sender: " + sender + " addressee: " + addressee);
                
                if(Ten.equals(addressee)){
                    if(contactsChat.contains(sender)){
                        int selectedIndex = contactsChat.indexOf(sender);
                        messSend.get(selectedIndex).setText("");
                        chatPer.get(selectedIndex).setText(chatPer.get(selectedIndex).getText() + "\n" + sender + ":" + mess);
                    }else{
                        newChat(sender);
                        chats.setSelectedIndex(contactsChat.indexOf(sender));
                        int selectedIndex = chats.getSelectedIndex();
                        messSend.get(selectedIndex).setText("");
                        chatPer.get(selectedIndex).setText(chatPer.get(selectedIndex).getText() + "\n" + sender + ":" + mess);
                    }
                }else if(Ten.equals(sender)){
                    int selectedIndex = chats.getSelectedIndex();
                    messSend.get(selectedIndex).setText("");
                    chatPer.get(selectedIndex).setText(chatPer.get(selectedIndex).getText() + "\n" + sender + ":" + mess);
                }
            }else{
                int selectedIndex = 0;
                messSend.get(selectedIndex).setText("");
                chatPer.get(selectedIndex).setText(chatPer.get(selectedIndex).getText() + "\n" + mess);
            }
        }
    }
    
    public String getTen(){
        return Ten;
    }

    
    @Override
    public void actionPerformed(ActionEvent ae) {
          JButton btn = (JButton) ae.getSource();
        
        if(btn.getActionCommand().equals("Chat rieng")){//kiem tra khi nhan nut chat rieng
            if(contacts.toArray().length == 0){
                JOptionPane.showMessageDialog(null, "Không có ai đang online", "Contacts", JOptionPane.ERROR_MESSAGE);
            }else{
                ArrayList<String> contactsMostrar = contacts;
                contactsMostrar.remove(Ten);
                String seleccion = (String) JOptionPane.showInputDialog(null, "New chat", "Chọn bạn chat riêng", JOptionPane.INFORMATION_MESSAGE, null, contactsMostrar.toArray(), contactsMostrar.toArray()[0]);
                if(contactsChat.contains(seleccion)){
                    chats.setSelectedIndex(contactsChat.indexOf(seleccion));
                }else{
                    newChat(seleccion);
                    chats.setSelectedIndex(contactsChat.indexOf(seleccion));
                }
                statusOp = 0;
            }
        }else if(btn.getActionCommand().equals("Gửi")){
            statusOp = 1;
        }
    }
}
