package supplementary.nio;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/*
一、通道(channel)：用于源节点与目标节点的连接。在Java NIO中负责缓冲区中数据的传输。channel本身不存储数据，因此需要配合缓冲区进行传输。


二、通道的主要实现类
java.nio.channels.Channel接口
        |--FileChannel
        |--SocketChannel
        |--ServerSocketChannel
        |--DatagramChannel


三、获取通道
1. Java针对支持通道的类提供了getChannel()方法
    本地IO：
    FileInputStream/FileOutputStream
    RandomAccessFile

    网络IO：
    Socket
    ServerSocket
    DatagramSocket

2. 在JDK1.7中的 NIO.2 针对各个通道提供了静态方法open()
3. 在JDK1.7中的 NIO.2 的 Files 工具类的newByteChannel()


 */
public class TestChannel {
    public static void main(String[] args) {
        test1();
    }





    //利用通道完成文件的复制（非直接缓冲区）
    public static void test1()
    {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        //①获取通道
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            fis = new FileInputStream("myfile\\supfile\\吹雪.jpg");
            fos = new FileOutputStream("myfile\\supfile\\吹雪2.jpg");

            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            //②分配指定大小的缓冲区
            ByteBuffer buf = ByteBuffer.allocateDirect(1024);

            //③将通道中的数据存入缓冲区中
            while(inChannel.read(buf)!=-1)
            {
                buf.flip();//切换读取数据的模式
                //④将缓冲区中的数据写入到通道中
                outChannel.write(buf);
                buf.clear();//清空缓冲区
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outChannel != null)
            {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inChannel!=null)
            {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis!=null)
            {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos!=null)
            {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }




        }



    }

}
