package wangluo;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpDemo {
    public static void main(String[] args) {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(8888);
        } catch (SocketException e) {
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);

        String s = null;
        while ((s=sc.nextLine())!=null){

        if (s.equals("886"))
            break;
        byte[] data = s.getBytes();
        DatagramPacket dp =
                null;
        try {
            dp = new DatagramPacket(data, data.length, InetAddress.getByName("192.168.206.1"), 10000);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            ds.send(dp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
        ds.close();

    }


}

class UdpRece {
    public static void main(String[] args) {
        DatagramSocket ds = null;
        try {
            ds = new DatagramSocket(10000);
        } catch (SocketException e) {
            e.printStackTrace();
        }
        while (true){


        byte[] buf = new byte[1024];
        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        try {
            ds.receive(dp);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String ip = dp.getAddress().getHostAddress();
        String data = new String(dp.getData(), 0, dp.getLength());
        int port = dp.getPort();
        System.out.println(ip + ":" + port + ":" + data);

        }


    }
}
