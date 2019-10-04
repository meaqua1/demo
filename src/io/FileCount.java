package io;

import java.io.*;
import java.util.Properties;

public class FileCount {
    public static void main(String[] args) {
        File file = new File("set.ini");
        if (!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Properties pro = new Properties();
        try {
            pro.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int count = 0;
        String value = pro.getProperty("time");
        if (value!=null){
            count = Integer.parseInt(value);
            if (count>=5){
                System.out.println("次数到了");
                return;
            }
            count++;
        }

        pro.setProperty("time",count+"");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            pro.store(fos,"qq");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (fis!=null){
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (fos!=null){
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
