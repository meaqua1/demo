package wangluo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author hh
 * @create 2019-07-24 13:26
 */
public class UrlTest {
    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL("https://www.bilibili.com/video/av48144058/?p=627");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
/*        System.out.println(url.getPort());
        System.out.println(url.getHost());
        System.out.println(url.getPath());
        System.out.println(url.getFile());*/
        HttpURLConnection urlConnection = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        urlConnection.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        try {
            urlConnection.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        InputStream in = null;
        FileOutputStream fos = null;
        try {
            in = urlConnection.getInputStream();
            fos = new FileOutputStream("672.blv");
            byte[] buf = new byte[1024];
            int len;
            while ((len = in.read(buf)) != -1) {
                fos.write(buf, 0, len);
            }

            System.out.println("下载完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
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

            urlConnection.disconnect();
        }


    }
}
