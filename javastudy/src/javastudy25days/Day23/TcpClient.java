package javastudy25days.Day23;


import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/*
客户端。
通过查阅socket对象，发现在该对象建立时，就可以去连接指定主机。
因为tcp是面向连接的，所以在建立socket服务时。
就要有服务端存在，并连接成功，形成通路后，在该通道进行数据的传输。

需求：给服务端发送一个文本数据。

步骤：
1. 创建Socket服务，并指定要连接的主机和端口。
2.
3.


 */
public class TcpClient {
    public static void main(String[] args) throws IOException {
        //创建客户端的socket服务，指定目的主机和端口。
        Socket s = new Socket("169.254.73.155",10003);

        //为了发送数据，应该获取socket流中的输出流。
        OutputStream out = s.getOutputStream();

        out.write("tcp i am coming!".getBytes());


        s.close();
    }
}
