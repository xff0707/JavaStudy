package supplementary.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Scanner;

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
public class TestNonBlockingNIO {
    public static void main(String[] args) throws InterruptedException {
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

        /*
        Thread.sleep(1000);
        new Thread(()->{
            try {
                client();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

         */
    }

    //�ͻ���
    public static void client() throws IOException {
        //1.��ȡͨ��
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("169.254.73.155", 9898));

        //2.�л�������ģʽ
        sChannel.configureBlocking(false);

        //3.����ָ����С�Ļ�����
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //4.�������ݸ�������
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()){
            String str = scan.next();
            buf.put((LocalDateTime.now().toString()+"\r"+str).getBytes());
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }

        /*
        buf.put(LocalDateTime.now().toString().getBytes());
        buf.flip();
        sChannel.write(buf);
        buf.clear();

         */

        //5.�ر�ͨ��
        sChannel.close();
    }

    //�����
    public static void server() throws IOException {
        //1.��ȡͨ��
        ServerSocketChannel ssChannel = ServerSocketChannel.open();

        //2.�л��ɷ�����ģʽ
        ssChannel.configureBlocking(false);

        //3.������
        ssChannel.bind(new InetSocketAddress(9898));

        //4.��ȡѡ����
        Selector selector = Selector.open();

        //5.��ͨ��ע�ᵽѡ�����ϣ�����ָ�������������¼���
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);//SelectionKeyѡ���

        //6.��ѯʽ�Ļ�ȡѡ�������Ѿ���׼�����������¼�
        while (selector.select()>0) {
            //7.��ȡ��ǰѡ����������ע��ġ�ѡ������Ѿ����ļ����¼�����
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();

            while (it.hasNext())
            {
                //8.��ȡ׼�������������¼�
                SelectionKey sk = it.next();

                //9.�жϾ�����ʲô�¼�׼������
                if (sk.isAcceptable()){
                    //10.�������վ���������ȡ�ͻ�������
                    SocketChannel sChannel = ssChannel.accept();

                    //11.�л�������ģʽ
                    sChannel.configureBlocking(false);

                    //12.����ͨ��ע�ᵽѡ������
                    sChannel.register(selector,SelectionKey.OP_READ);
                }else if (sk.isReadable()){
                    //13.��ȡ��ǰѡ�����ϡ���������״̬��ͨ��
                    SocketChannel sChannel = (SocketChannel) sk.channel();

                    //14.��ȡ����
                    ByteBuffer buf = ByteBuffer.allocate(1024);

                    int len;
                    while ((len=sChannel.read(buf))>0){
                        buf.flip();
                        System.out.println(new String(buf.array(),0,len));
                        buf.clear();
                    }
                }
                //15.ȡ��ѡ���
                it.remove();
            }
        }
    }
}


/*
SelectionKey
��SelectionKey.OP_READ
дSelectionKey.OP_WRITE
����SelectionKey.OP_CONNECT
����SelectionKey.OP_ACCEPT

����¼���λ��
int interestSet = SelectionKey.OP_READ | SelectionKey.OP_WRITE
 */
