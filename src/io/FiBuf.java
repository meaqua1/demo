package io;

import java.io.*;
import java.util.Scanner;

public class FiBuf {
    public static void main(String[] args) {

        BufferedWriter bw = null;
        Scanner sc = new Scanner(System.in);

        try {
            bw = new BufferedWriter(new FileWriter("demo.txt", true));
            bw.write("abcde");
            bw.newLine();
            bw.write(sc.nextLine());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null)
                try {
                    bw.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }
}

class bufRed {
    public static void main(String[] args) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("demo.txt"));
            try {
                /*int ch = 0;
                while ((ch = fr.read()) != -1) {

                    System.out.print((char) ch);
                }*/
                String s = null;
                while ((s = br.readLine())!=null){

                    System.out.println(s);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }
}
