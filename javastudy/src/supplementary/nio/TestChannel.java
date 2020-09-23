package supplementary.nio;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

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
    public static void main(String[] args) {
        test1();
    }





    //����ͨ������ļ��ĸ��ƣ���ֱ�ӻ�������
    public static void test1()
    {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        //�ٻ�ȡͨ��
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            fis = new FileInputStream("myfile\\supfile\\��ѩ.jpg");
            fos = new FileOutputStream("myfile\\supfile\\��ѩ2.jpg");

            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            //�ڷ���ָ����С�Ļ�����
            ByteBuffer buf = ByteBuffer.allocateDirect(1024);

            //�۽�ͨ���е����ݴ��뻺������
            while(inChannel.read(buf)!=-1)
            {
                buf.flip();//�л���ȡ���ݵ�ģʽ
                //�ܽ��������е�����д�뵽ͨ����
                outChannel.write(buf);
                buf.clear();//��ջ�����
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
