package io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileRe {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader("demo.txt");
            try {
                int ch = 0;
                while ((ch = fr.read()) != -1) {

                    System.out.print((char) ch);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

class FileRe2 {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader("demo.txt");
            char buf[] = new char[1024];

            int num;
            while ((num = fr.read(buf)) != -1) {
                System.out.print(new String(buf, 0, num));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}