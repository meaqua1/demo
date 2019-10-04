package wangluo;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author hh
 * @create 2019-07-24 10:22
 */
public class NetMethod {


    public static void main(String[] args) throws UnknownHostException {
        InetAddress inet1 = InetAddress.getLocalHost();
        System.out.println(inet1);
        System.out.println(inet1.getHostAddress());//本机IP地址
        System.out.println(inet1.getHostName());

        InetAddress inet2 = InetAddress.getByName("www.baidu.com");
        System.out.println(inet2);
        System.out.println(inet2.getHostAddress());
        System.out.println(inet2.getHostName());//域名

    }

}
