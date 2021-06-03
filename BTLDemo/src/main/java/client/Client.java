package client;

import client.Boxchat;
import java.io.*;
import java.net.*;

public class Client extends Thread {

    public static final String MCAST_ADDR = "230.1.1.1";//// 244.0.0.0 đến 239.255.255.255 dùng cho multicast, không dùng được 244.0.0.0
    public static final int MCAST_PORT = 4000;//port, phải trùng với port phía server
    public static final int DGRAM_BUF_LEN = 2048;//bộ đệm lưu dữ liệu datagram UDP
    Boxchat b = new Boxchat(0);// khởi tạo boxchat

    public void run() {
        InetAddress group = null;
         try {
            group = InetAddress.getByName(MCAST_ADDR);	// gán địa chỉ group trùng với địa chỉ multicast socket
        } catch (UnknownHostException e) {
            e.printStackTrace();//bắt lỗi
            System.exit(1);//đóng chương trình với lỗi 1
        }

        boolean jump = true;

        try {
            MulticastSocket socket = new MulticastSocket(MCAST_PORT);//Tạo Socket kiểu Multicast với port 4000.
            socket.joinGroup(group);//Tham gia nhóm Multicast tại địa chỉ xác định khi có người dùng ghi danh box chat
            DatagramPacket contact = new DatagramPacket(("<start>" + b.getTen()).getBytes(), ("<start>" + b.getTen()).length(), group, MCAST_PORT);//tạo gói tin chứa nhãn <start> và tên người dùng mới ghi danh
            socket.send(contact);//gửi gói tin vừa tạo
            while (jump) {
                
                if (b.getStatus() == 0) { // box chat đang sử dụng
                    socket.setSoTimeout(100);//đặt thời gian chờ cho gói tin (100 mili giây)
                    try {
                        byte[] buf = new byte[DGRAM_BUF_LEN];//khai báo bộ đệm cho gói recv ở client
                        DatagramPacket recv = new DatagramPacket(buf, buf.length);//khai báo gói recv chờ ở client
                        socket.receive(recv);//chờ nhận gói tin từ server
                        byte[] data = recv.getData();// chuyển gói tin vừa nhận sang data
                        String mess = new String(data);// chuyển từ byte thành string
                        System.out.println("Data received: " + mess);// in ra thông báo: Data recived : thông điệp
                        b.setNewMessage(mess);// gửi gói tin với các nhãn tương ứng
                    } catch (Exception e) {
                    }
                } else if (b.getStatus() == 1) {   // đóng box chat
                    String mess = "";
                    
                    if(b.getStop() == 1){
                        mess = "<stop>" + b.getTen();
                    }else{
                        if(b.getActiveTab() != 0){
                            mess = "C<msj><private><" + b.getTen() + "><" + b.getContactsChat(b.getActiveTab()) + ">" + b.getActiveMessage();
                        }else if(b.getActiveTab() == 0){
                            mess = "C<msj><" + b.getTen() + ">" + b.getActiveMessage();
                        }
                    }
                    DatagramPacket packet = new DatagramPacket(mess.getBytes(), mess.length(), group, MCAST_PORT);// tạo gói tin chứa nhãn <output> và thông tin
                    System.out.println("Send: " + mess + "  với  TTL= " + socket.getTimeToLive());// in ra màn hình thông tin output của client
                    socket.send(packet);// gửi gói tin mang nhãn <output>
                    b.setStatus(0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(2);
        }

    }//run

    public static void main(String[] args) {

        try {
            Client cliente = new Client();
            cliente.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }//main
}//class
