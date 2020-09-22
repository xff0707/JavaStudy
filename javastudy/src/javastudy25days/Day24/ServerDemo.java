package javastudy25days.Day24;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


/*
演示客户端和服务端
1.
客户端：浏览器
服务端：自定义   http://169.254.73.155:11000/      telnet 169.254.73.155 11000


2.
客户端：浏览器
服务端：Tomcat服务器

3.
客户端：自定义
服务端：Tomcat服务器


 */
public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(11000);

        Socket s = ss.accept();
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip);

        InputStream in = s.getInputStream();

        byte[] buf = new byte[1024];

        int len = in.read(buf);

        System.out.println(new String(buf,0,len));

        PrintWriter out = new PrintWriter(s.getOutputStream());

        out.println("<font color='red' size='7'>客户端你好</font>");

        s.close();
        ss.close();
        //1.
        /*
        ServerSocket ss = new ServerSocket(11000);

        Socket s = ss.accept();
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip);

        PrintWriter out = new PrintWriter(s.getOutputStream());

        out.println("<font color='red' size='7'>客户端你好</font>");

        s.close();
        ss.close();
         */
    }
}

/*
        169.254.73.155
        GET / HTTP/1.1
        Host: 169.254.73.155:11000
        Connection: keep-alive
        Upgrade-Insecure-Requests: 1
        User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.61 Safari/537.36
        Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,* /*;q=0.8,application/signed-exchange;v=b3;q=0.9
        Accept-Encoding: gzip, deflate
        Accept-Language: zh-CN,zh;q=0.9



        一个空行分隔符后边是请求数据体，请求数据头。
*/
//                                                                                           ↑没有空格

//      GET /myweb/demo.html HTTP/1.1 版本1.0或1.1
//      Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
//      可以接收/支持的内容（没有flash）
//      Accept-Encoding: gzip, deflate
//      支持的压缩方式
















