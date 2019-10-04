package wangluo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class CopyDemo {
}

class TranDemo2 {//客户端

    public static void main(String[] args) throws IOException {
        Socket socket = null;
        try {
            socket = new Socket("192.168.1.9", 10005);
        } catch (IOException e) {
            e.printStackTrace();
        }

        BufferedReader br = null;
        try {
            br = new BufferedReader((new FileReader("demo.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }

        PrintWriter pw = null;
        try {
            pw = new PrintWriter(socket.getOutputStream(),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String len = null;
        while ((len = br.readLine())!=null){
            pw.println(len);
        }

/*        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String len = null;
        while ((len = br.readLine())!=null){
            bw.write(len);

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
        }*/
/*

*/

        try {
            br.close();
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

class ServerTran2 {
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
/*

*/
/*      BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter("tp.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String len = null;
        while ((len = br.readLine())!=null){
            bw.write(len);

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
        }*/
        PrintWriter out = new PrintWriter(new FileWriter("tcp.txt"),true);
        String len = null;
        while ((len = br.readLine()) != null) {

            out.println(len);
        }

        socket.close();
        ss.close();


    }
}
