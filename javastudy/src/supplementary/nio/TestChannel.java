package supplementary.nio;


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
}
