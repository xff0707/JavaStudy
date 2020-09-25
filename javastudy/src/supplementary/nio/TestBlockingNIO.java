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
һ��ʹ��NIO�������ͨ�ŵ��������ģ�

1.ͨ����Channel������������

    java.nio.channels.Channel�ӿ�
        |--SelectableChannel
            |--SocketChannel
            |--ServerSocketChannel
            |--DatagramChannel

            |--Pipe.SinkChannel
            |--Pipe.SourceChannel

2.��������Buffer�����������ݵĴ�ȡ

3.ѡ������Selector������SelectableChannel�Ķ�·�����������ڼ��SelectableChannel��IO״��

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


    //�ͻ���
    public static void client() throws IOException {
        //1.��ȡͨ��            172.0.0.1
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("169.254.73.155", 9898));

        //
        FileChannel inChinnel = FileChannel.open(Paths.get("myfile\\nio\\����.jpg"), StandardOpenOption.READ);

        //2.����ָ����С�Ļ�����
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //3.��ȡ�����ļ������͵������ȥ
        while (inChinnel.read(buf)!=-1)
        {
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }

        //4.�ر�ͨ��
        inChinnel.close();
        sChannel.close();


    }

    //�����
    public static void server() throws IOException {
        //1.��ȡͨ��
        ServerSocketChannel ssChannel = ServerSocketChannel.open();

        //
        FileChannel outChinnel = FileChannel.open(Paths.get("myfile\\nio\\����2.jpg"), StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        //2.������
        ssChannel.bind(new InetSocketAddress(9898));

        //3.��ȡ�ͻ������ӵ�ͨ��
        SocketChannel sChannel = ssChannel.accept();

        //4.����һ��ָ����С�Ļ�����
        ByteBuffer buf = ByteBuffer.allocate(1024);


        //5.���ܿͻ������ݲ����浽����
        while (sChannel.read(buf)!=-1)
        {
           buf.flip();
           outChinnel.write(buf);
           buf.clear();
        }

        //6.�ر�ͨ��
        sChannel.close();
        outChinnel.close();
        ssChannel.close();


    }


}
