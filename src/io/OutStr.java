package io;

import java.io.*;

public class OutStr {
    public static void main(String[] args) throws FileNotFoundException {
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("out.txt")));


        readFile();
    }

    public static void readFile() throws FileNotFoundException {


        FileInputStream fis = null;
        try {
            fis = new FileInputStream("fos.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] byt = new byte[1024];
        int ch = 0;
        try {
            while ((ch = fis.read(byt)) != -1)
                System.out.println((new String(byt, 0, ch)));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeFile() {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("fos.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            fos.write("abcde".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
