package wangluo;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class PicDemo {//客户端

    public static void main(String[] args) throws IOException {




        Socket socket = null;
        try {
            socket = new Socket("192.168.1.9", 10007);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("collection_pic.jpg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        OutputStream out = null;
        try {
            out = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = fis.read(bytes)) != -1) {
            try {
                out.write(bytes, 0, len);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        socket.shutdownOutput();//向服务端发送信息表示图片已经传输完毕

        InputStream in = null;
        try {
            in = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        byte[] byt = new byte[1024];
        int num = 0;
        try {
            num = in.read(byt);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(new String(byt, 0, num));

        try {
            fis.close();
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

class PicThred implements Runnable {

    private Socket socket;

    public PicThred(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        int count = 0;
        String ip = socket.getInetAddress().getHostAddress();
        System.out.println(ip + "....con");
        InputStream in = null;
        try {
            in = socket.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File("copy" + count + ".jpg");
        while (file.exists()){
            file = new File("copy" + count++ + ".jpg");
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        byte[] bytes = new byte[1024];
        int len = 0;

        try {
            while ((len = in.read(bytes)) != -1) {
                try {
                    fos.write(bytes, 0, len);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        OutputStream out = null;
        try {
            out = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.write("上传成功".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fos.close();
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

class PicSever {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(10007);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            Socket socket = null;
            try {
                socket = ss.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }

            new Thread(new PicThred(socket)).start();

        }

    }


}

class Dddd{
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(12000);
        Socket socket = ss.accept();
        InputStream in = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = in.read(bytes);
        System.out.println(new String(bytes,0,len));
        PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
        printWriter.println("你好");
        socket.close();
        ss.close();



    }
}
