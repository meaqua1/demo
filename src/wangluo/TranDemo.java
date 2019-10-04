package wangluo;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TranDemo {//客户端

    public static void main(String[] args) {
        Socket socket = null;
        try {
            socket = new Socket(InetAddress.getLocalHost().getHostAddress(), 10005);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scanner sc = new Scanner(System.in);
        String s = null;
        while ((s = sc.nextLine()) != null) {
            if (s.equals("over"))
                break;
            try {
                bw.write(s);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bw.newLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                bw.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String len = null;
            try {
                len = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(len);
        }
        try {
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

class ServerTran {
    public static void main(String[] args) throws IOException {

        ServerSocket ss = null;
        try {
            ss = new ServerSocket(10005);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Socket socket = null;
        try {
            socket = ss.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String len = null;
        while ((len = br.readLine()) != null) {
            try {
                bw.write(len.toUpperCase());
            } catch (IOException e) {
                e.printStackTrace();
            }
            bw.newLine();
            bw.flush();
        }

        socket.close();
        ss.close();
        br.close();
        bw.close();


    }
}
