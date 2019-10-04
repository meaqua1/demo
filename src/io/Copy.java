package io;

import java.io.*;

public class Copy {
    public static void main(String[] args) {
        try {
            copy_5();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void copy_1() {
        FileWriter fw = null;
        FileReader fr = null;
        try {
            fw = new FileWriter("copy.txt");
            fr = new FileReader("demo.txt");
            char[] buf = new char[3];
            int len = 0;
            while ((len = fr.read(buf)) != -1) {
                System.out.println(buf[0]);
                fw.write(buf, 0, len);
                fw.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException("复制失败");
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    public static void copy_2() {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader("demo.txt"));


        } catch (FileNotFoundException e) {
            throw new RuntimeException("找不到该文件");
        }
        try {
            bw = new BufferedWriter(new FileWriter("copy1.txt"));

            try {
                String s = null;
                while ((s = br.readLine()) != null) {
                    bw.write(s);
                    bw.newLine();
                    bw.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            throw new RuntimeException("创建文件失败");
        } finally {
            if (br != null)
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            if (bw != null)
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }

    }

    public static void copy_3() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("copy3.txt", true)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream("demo.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String s = null;
        try {
            while ((s = br.readLine()) != null) {
                bw.write(s);
                bw.newLine();

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    public static void copy_4() {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("collection_pic.jpg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("copy.jpg");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] by = new byte[1024];
        int num = 0;
        try {
            while ((num = fis.read(by)) != -1) {
                fos.write(by, 0, num);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void copy_5() throws IOException {
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream("collection_pic.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedOutputStream bos = null;
        try {
            bos = new BufferedOutputStream(new FileOutputStream("copy.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] buf = new byte[1024];
        int len;
        while ((len = bis.read(buf)) != -1) {
            try {
                bos.write(buf, 0, len);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (bis != null) {
            try {
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (bos != null) {
            try {
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}
