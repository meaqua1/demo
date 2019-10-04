import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ZhengZe {

    public static void main(String[] args) {
        /*String s = "a\\b\\c";
        String reg = ".";
        String arr[] = s.split("\\\\");
        for (String s1 : arr) {
            System.out.println(s1);
        }*/
        String s = "aaa bbb cc dd eee";
        String reg = "[a-z]{2}";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println(m.group());
            System.out.println(m.start() + "   " + m.end());
        }
    }
}

class Replace {
    public static void main(String[] args) {
        String a = "我我...我我..我要..要要.要要要....学学学..学编....编编编编....编程程";
        String b = a.replaceAll("[.]+", "");
        System.out.println(b);
        String c = b.replaceAll("(.)\\1+", "$1");//(.)任意字符  (.)封装规则为第一组  +一个或多个
        //$1调用第一组的规则
        System.out.println(c);

        String d = "0";
        System.out.println(d.matches("0*"));
    }
}

class GetEmail {


    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("a.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

class GetEmail2 {
    public static void main(String[] args) throws IOException {
        URL url = null;
        try {
            url = new URL("https://pcedu.pconline.com.cn/1193/11934709.html");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        URLConnection connection = null;
        try {
            connection = url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "gb2312"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String reg = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
        Pattern p = Pattern.compile(reg);

        String line = null;
        while ((line = br.readLine()) != null) {
            //System.out.println(line);
            Matcher m = p.matcher(line);
            while (m.find()) {
                System.out.println(m.group());
            }
        }
    }

}


class RectangleTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入一个数字");
        int len = scanner.nextInt();
        int[][] arr = new int[len][len];

        int s = len * len;
        /*
         * k = 1:向右 k = 2:向下 k = 3:向左 k = 4:向上
         */
        int k = 1;
        int i = 0, j = 0;
        for (int m = 1; m <= s; m++) {
            if (k == 1) {
                if (j < len && arr[i][j] == 0) {
                    arr[i][j++] = m;
                } else {
                    k = 2;
                    i++;
                    j--;
                    m--;
                }
            } else if (k == 2) {
                if (i < len && arr[i][j] == 0) {
                    arr[i++][j] = m;
                } else {
                    k = 3;
                    i--;
                    j--;
                    m--;
                }
            } else if (k == 3) {
                if (j >= 0 && arr[i][j] == 0) {
                    arr[i][j--] = m;
                } else {
                    k = 4;
                    i--;
                    j++;
                    m--;
                }
            } else if (k == 4) {
                if (i >= 0 && arr[i][j] == 0) {
                    arr[i--][j] = m;
                } else {
                    k = 1;
                    i++;
                    j++;
                    m--;
                }
            }
        }

        // 遍历
        for (int m = 0; m < arr.length; m++) {
            for (int n = 0; n < arr[m].length; n++) {
                System.out.print(arr[m][n] + "\t");
            }
            System.out.println();
        }
    }
}


/*class Xian implements Runnable {

    @Override
    public void run() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                sum += i;
            }
        }
    }
}*/
class XianX {
    public static void main(String[] args) {
        Xian xian = new Xian();
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.submit(xian);
        service.submit(new Xian());


        service.shutdown();
    }


}

class Xian implements Callable {

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 ==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
                sum += i;
            }

        }
        return sum;
    }

}
/*
class XianX{


    public static void main(String[] args) {
        Xian xian = new Xian();
        FutureTask futureTask = new FutureTask(xian);
        Thread t = new Thread(futureTask);
        t.start();
        try {
            Object sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}*/

