package supplementary.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/*
一、使用NIO完成网络通信的三个核心：

1.通道（Channel）：负责连接

    java.nio.channels.Channel接口
        |--SelectableChannel
            |--SocketChannel
            |--ServerSocketChannel
            |--DatagramChannel

            |--Pipe.SinkChannel
            |--Pipe.SourceChannel

2.缓冲区（Buffer）：负责数据的存取

3.选择器（Selector）：是SelectableChannel的多路复用器。用于监控SelectableChannel的IO状况

 */
public class TestBlockingNIO {
    public static void main(String[] args) {
        new Thread(()->{
            try {
                server();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(()->{
            try {
                client();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }


    //客户端
    public static void client() throws IOException {
        //1.获取通道            172.0.0.1
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("169.254.73.155", 9898));

        //
        FileChannel inChinnel = FileChannel.open(Paths.get("myfile\\nio\\心心.jpg"), StandardOpenOption.READ);

        //2.分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //3.读取本地文件并发送到服务端去
        while (inChinnel.read(buf)!=-1)
        {
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }

        //4.关闭通道
        inChinnel.close();
        sChannel.close();


    }

    //服务端
    public static void server() throws IOException {
        //1.获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();

        //
        FileChannel outChinnel = FileChannel.open(Paths.get("myfile\\nio\\心心2.jpg"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        //2.绑定连接
        ssChannel.bind(new InetSocketAddress(9898));

        //3.获取客户端连接的通道
        SocketChannel sChannel = ssChannel.accept();

        //4.分配一个指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);


        //5.接受客户端数据并保存到本地
        while (sChannel.read(buf)!=-1)
        {
           buf.flip();
           outChinnel.write(buf);
           buf.clear();
        }

        //6.关闭通道
        sChannel.close();
        outChinnel.close();
        ssChannel.close();


    }


}
