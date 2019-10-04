package wangluo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpDemo {//客户端
    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket(InetAddress.getLocalHost().getHostAddress(),10003);
        } catch (IOException e) {
            e.printStackTrace();
        }
        OutputStream os = null;
        try {
            os = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            os.write("Hello，你好 ".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }



        InputStream in = null;
        try {
            in = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes = new byte[1024];

        int len = 0;
        try {
            len = in.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(new String(bytes,0,len));

        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class TcpServer{
    public static void main(String[] args) {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(10003);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Socket socket = null;
        try {
            socket = ss.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream is = null;
        try {
            is = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] buf = new byte[1024];
        int len = 0;
        try {
            len = is.read(buf);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String ip = socket.getInetAddress().getHostAddress();
        System.out.println(ip);
        System.out.println(new String(buf,0,len));

        OutputStream out = null;
        try {
            out = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            out.write("收到".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            ss.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}