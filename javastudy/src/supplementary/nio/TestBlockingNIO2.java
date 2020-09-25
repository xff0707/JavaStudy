package supplementary.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TestBlockingNIO2 {
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
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("169.254.73.155", 9898));

        FileChannel inChannel = FileChannel.open(Paths.get("myfile\\nio\\心心.jpg"), StandardOpenOption.READ);

        ByteBuffer buf = ByteBuffer.allocate(1024);

        while (inChannel.read(buf)!=-1)
        {
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }

        sChannel.shutdownOutput();

        //接受服务端反馈
        int len = 0;
        while (( len=sChannel.read(buf))!=-1)
        {
            buf.flip();
            System.out.print("服务端：");
            System.out.println(new String(buf.array(),0,len));
            buf.clear();
        }

        inChannel.close();
        sChannel.close();

    }

    //服务端
    public static void server() throws IOException {
        ServerSocketChannel ssChannel = ServerSocketChannel.open();

        FileChannel outChannel = FileChannel.open(Paths.get("myfile\\nio\\心心3.jpg"), StandardOpenOption.CREATE, StandardOpenOption.WRITE);

        ssChannel.bind(new InetSocketAddress(9898));

        SocketChannel sChannel = ssChannel.accept();

        ByteBuffer buf = ByteBuffer.allocate(1024);


        while (sChannel.read(buf)!=-1)
        {
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }

        //sChannel.shutdownOutput();//AsynchronousCloseException异常，如果在写操作过程中另一个线程关闭了该通道

        //发送反馈给客户端
        buf.put("服务端接受数据成功".getBytes());
        buf.flip();
        sChannel.write(buf);

        outChannel.close();
        sChannel.close();
        ssChannel.close();



    }



}
