package supplementary.nio;


/*
һ��ͨ��(channel)������Դ�ڵ���Ŀ��ڵ�����ӡ���Java NIO�и��𻺳��������ݵĴ��䡣channel�����洢���ݣ������Ҫ��ϻ��������д��䡣


����ͨ������Ҫʵ����
java.nio.channels.Channel�ӿ�
        |--FileChannel
        |--SocketChannel
        |--ServerSocketChannel
        |--DatagramChannel


������ȡͨ��
1. Java���֧��ͨ�������ṩ��getChannel()����
    ����IO��
    FileInputStream/FileOutputStream
    RandomAccessFile

    ����IO��
    Socket
    ServerSocket
    DatagramSocket

2. ��JDK1.7�е� NIO.2 ��Ը���ͨ���ṩ�˾�̬����open()
3. ��JDK1.7�е� NIO.2 �� Files �������newByteChannel()


 */
public class TestChannel {
}
