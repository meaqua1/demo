package io;

import java.io.File;

public class WenJian {
    public static void main(String[] args) {
        File file = new File("a.txt");
        /*try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        //file.delete();
        //file.deleteOnExit();//文件在退出时删除
        //System.out.println(file.canExecute());//文件能否被执行
        //System.out.println(file.exists());//文件是否存在
        System.out.println(file.isFile());//是否是文件
        System.out.println(file.isDirectory());//是否是目录

        /*File file2 = new File("abc");
        System.out.println(file2.mkdir()); //创建文件夹*/
        /*File file3 = new File("abc\\a\\b\\c\\d");
        file3.mkdirs();//创建多级文件夹*/

    }
}
