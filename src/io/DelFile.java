package io;

import java.io.File;

public class DelFile {
    public static void main(String[] args) {
        remDir(new File("aaa"));
    }

    public static void remDir(File dir){
        File[] files = dir.listFiles();
        for (File f:files) {
            if (f.isDirectory())
            remDir(f);
            else
                f.delete();
            
        }
        System.out.println(dir.delete());
    }
}
