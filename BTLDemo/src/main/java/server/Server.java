package server;

import java.net.*;
import java.io.*;
import java.util.ArrayList;

public class Server extends Thread {

    public static final String MCAST_ADDR = "230.1.1.1";// 244.0.0.0 đến 239.255.255.255 dùng cho multicast, không dùng được 244.0.0.0
    public static final int MCAST_PORT = 4000;// port
    public static final int DGRAM_BUF_LEN = 2048;//bộ đệm lưu dữ liệu datagram UDP
    private ArrayList<String> contacts;

    public void run() {
        contacts = new ArrayList();// kênh liên lạc
        String msg = "";//chuỗi thông điệp
        InetAddress group = null;// inet của group, chưa khởi tạo nên null.
        try {
            group = InetAddress.getByName(MCAST_ADDR);	// gán địa chỉ group trùng với địa chỉ multicast socket
        } catch (UnknownHostException e) {
            e.printStackTrace();//bắt lỗi
            System.exit(1);//đóng chương trình với lỗi 1
        }
        for (;;) {//for cải tiến/ vòng lặp không chứa điều kiện
            try {
                MulticastSocket socket = new MulticastSocket(MCAST_PORT);//Tạo Socket kiểu Multicast với port 4000.
                socket.joinGroup(group);//Tham gia group
                byte[] buf = new byte[DGRAM_BUF_LEN];// tạo bộ đệm cho recv để nhận dữ liệu 
                DatagramPacket recv = new DatagramPacket(buf,buf.length);//tạo gói recv chờ ở server 
                socket.receive(recv);//socket chờ nhận datagram recv từ client
                byte [] data = recv.getData();//chuyển dự liệu từ recv nhận được thành byte
                msg = new String(data);// chuyển dữ liệu từ byte mới nhận thành String
                System.out.println("Data received: " + msg);// in ra thông điệp mới nhận được.
                
                if(msg.contains("<start>")){//kiểm tra chuỗi nhận được có chuõi <start> hay không
                    msg = msg.substring(7);//lấy chuỗi con <start>
                    String ten = "";
                    int i = 0;
                    while(Character.isLetter(msg.charAt(i))){//gán chuỗi msg vào biến tên để lấy tên của từng người dùng phía boxchat client
                        ten = ten + msg.charAt(i);
                        i++;
                    }
                    contacts.add(ten);//gán tên cho arrlist liên lạc
                    String cont = "<contacts>" + contacts.toString();//chuỗi cont=<contacts>+ tên người dùng
                    System.out.println("Send: " + cont);//in ra màn hình chuỗi Send: <contacts> tên người 
                    DatagramPacket packet = new DatagramPacket( cont.getBytes(), cont.length(), group, MCAST_PORT);//tạo ra một gói tin chứa tên các người dùng hiện tại và thêm người dùng mới (lưu trong cont).
                    socket.send(packet);//gửi gói tin vừa tạo
                    socket.close();//đóng liên kết
                }else if(msg.contains("C<msj>")){//kiểm tra chuỗi vừa nhận có bao gồm chuỗi C<msj> hay không
                    msg = msg.substring(1);//lấy nhãn "C"
                    msg = "S" + msg;//gán nhãn "S" vào đầu chuỗi
                    DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.length(), group, MCAST_PORT);//tạo một gói tin mới chứa chuỗi msg vừa tạo.
                    System.out.println("Send: " + msg.toString() + " with TTL= " + socket.getTimeToLive());//in ra màn hình thông điệp Send: msg+TTL
                    socket.send(packet);//gửi gói tin vừa tạo tới các client
                    socket.close();//đóng liên kết
                }else if(msg.contains("<stop>")){//kiểm tra chuỗi vừa nhận có bao gồm chuỗi <stop> hay không
                    String stop = "";
                    int i = 6;
                    while(Character.isLetter(msg.charAt(i))){
                        stop = stop + msg.charAt(i);//gán gói tin nhận được vào chuỗi output, bỏ qua nhãn<output>
                        i++;
                    }
                    contacts.remove(stop);//loại bỏ người dùng ra khỏi kênh liên lạc sau khi người dùng thoát ra
                    String cont = "<contacts>" + contacts.toString();//dán nhãn contacts
               
                    System.out.println("Send: " + cont);//thông báo những người dùng còn lại trên hệ thống
                    DatagramPacket packet = new DatagramPacket( cont.getBytes(), cont.length(), group, MCAST_PORT);//tạo một gói tin chứa tên những người còn đang sử dụng(chuỗi cont).
        
                    socket.send(packet);// gửi gói tin đến các client còn đang sử dụng
                    socket.close(); // đóng liên kết
                }
           
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(2);// nếu phát hiện lỗi thì đóng chương trình với nhãn lỗi là 2
                
            }

            try {
                Thread.sleep(1000 * 5);// dừng run trong 5 giây.
            } catch (InterruptedException ie) {// ngoại lệ để không dừng run.
            }
        }
    }

    public static void main(String[] args) {

        try {
            Server mc2 = new Server();//tạo server
            mc2.start();// chạy server

        } catch (Exception e) {
            e.printStackTrace();// gọi ra lỗi nếu phát hiện
        }

    }
}

