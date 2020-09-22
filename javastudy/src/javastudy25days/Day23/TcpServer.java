package javastudy25days.Day23;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/*
需求：定义端点接收数据并打印在控制台上。

服务端：
1. 建立服务端的socket服务，ServerSocket();
    并监听一个端口。
2. 获取连接过来的客户端对象。
    通过ServerSocket的 accept方法。没有连接就会等所以这个方法时阻塞式的。

3. 客户端发过来数据，那么服务端要使用对应的客户端对象，并获取客户端对象的读取流来读取发过来的数据。
    并打印在控制台
4. 关闭服务器。(可选)

 */
public class TcpServer {
    public static void main(String[] args) throws IOException {
        //建立服务端socket服务，并监听一个端口。
        ServerSocket ss = new ServerSocket(10003);

        //通过accept方法获取连接过来的客户端对象。
        Socket s = ss.accept();

        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip+"...已连接");

        //获取客户端发送过来的数据，那么要使用客户端对象的读取流来读取数据。
        InputStream in = s.getInputStream();

        byte[] buf = new byte[1024];
        int len = in.read(buf);

        System.out.println(new String(buf,0,len));

        s.close();
        ss.close();
    }
}
