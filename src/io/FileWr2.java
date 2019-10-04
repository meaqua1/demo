package io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWr2 {
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("demo.txt",true);
            fw.write("\r\n1234");//   \r\n换行
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (fw!=null)
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


}
