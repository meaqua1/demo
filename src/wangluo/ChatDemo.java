package wangluo;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class ChatDemo {
    public static void main(String[] args) {
        DatagramSocket sendSocket = null;
        try {
            sendSocket = new DatagramSocket();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        DatagramSocket receSocket = null;
        try {
            receSocket = new DatagramSocket(10002);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        new Thread(new Send(sendSocket)).start();
        new Thread(new Rece(receSocket)).start();

    }

}

class Send implements Runnable{
    private DatagramSocket ds;
    public Send(DatagramSocket ds){
        this.ds = ds;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        String s = null;
        while ((s=sc.nextLine())!=null){
            if (s.equals("886"))
                break;
            byte[] bytes = new byte[1024];
            DatagramPacket dp =
                    null;
            try {
                dp = new DatagramPacket(s.getBytes(),s.length(), InetAddress.getByName("192.168.1.9"),10002);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
            try {
                ds.send(dp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}

class Rece implements Runnable{
    private DatagramSocket ds;
    public Rece(DatagramSocket ds){
        this.ds = ds;
    }
    @Override
    public void run() {
        while (true){
            byte[] byt = new byte[1024];
            DatagramPacket dp = new DatagramPacket(byt,byt.length);
            try {
                ds.receive(dp);
            } catch (IOException e) {
                e.printStackTrace();
            }
            String ip = dp.getAddress().getHostAddress();
            String data = new String(dp.getData(),0,dp.getLength());
            System.out.println(ip+":"+data);
        }

    }
}
