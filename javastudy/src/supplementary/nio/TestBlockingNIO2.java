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



    //�ͻ���
    public static void client() throws IOException {
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("169.254.73.155", 9898));

        FileChannel inChannel = FileChannel.open(Paths.get("myfile\\nio\\����.jpg"), StandardOpenOption.READ);

        ByteBuffer buf = ByteBuffer.allocate(1024);

        while (inChannel.read(buf)!=-1)
        {
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }

        sChannel.shutdownOutput();

        //���ܷ���˷���
        int len = 0;
        while (( len=sChannel.read(buf))!=-1)
        {
            buf.flip();
            System.out.print("����ˣ�");
            System.out.println(new String(buf.array(),0,len));
            buf.clear();
        }

        inChannel.close();
        sChannel.close();

    }

    //�����
    public static void server() throws IOException {
        ServerSocketChannel ssChannel = ServerSocketChannel.open();

        FileChannel outChannel = FileChannel.open(Paths.get("myfile\\nio\\����3.jpg"), StandardOpenOption.CREATE, StandardOpenOption.WRITE);

        ssChannel.bind(new InetSocketAddress(9898));

        SocketChannel sChannel = ssChannel.accept();

        ByteBuffer buf = ByteBuffer.allocate(1024);


        while (sChannel.read(buf)!=-1)
        {
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }

        //sChannel.shutdownOutput();//AsynchronousCloseException�쳣�������д������������һ���̹߳ر��˸�ͨ��

        //���ͷ������ͻ���
        buf.put("����˽������ݳɹ�".getBytes());
        buf.flip();
        sChannel.write(buf);

        outChannel.close();
        sChannel.close();
        ssChannel.close();



    }



}
