package io;

import java.io.FileWriter;
import java.io.IOException;

public class FileWrit {
    public static void main(String[] args) {
        FileWriter fw = null;
        try {
            fw = new FileWriter("copy.txt");
            fw.write("abcd");
            fw.write("abcd");
            fw.flush();//刷新流对象缓冲，数据进入到txt中

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fw != null)
                fw.close();//关闭流，关闭前会刷新，之后不能再写入
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
