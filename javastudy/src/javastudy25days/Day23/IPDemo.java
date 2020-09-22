package javastudy25days.Day23;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/*
cmd   ipconfig/all0


 */
public class IPDemo {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress i = InetAddress.getLocalHost();

        System.out.println(i.toString());
        System.out.println("address:"+i.getHostAddress());
        System.out.println("Name:"+i.getHostName());
        System.out.println(i);

        //InetAddress ia = InetAddress.getByName("169.254.73.155");
        //InetAddress ia = InetAddress.getByName("www.baidu.com");
        InetAddress[] ia = InetAddress.getAllByName("www.baidu.com");

        //System.out.println(ia.getHostAddress());
        //System.out.println(ia.getHostName());
        System.out.println(Arrays.toString(ia));//[www.baidu.com/39.156.66.14, www.baidu.com/39.156.66.18]
    }
}
