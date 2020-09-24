package supplementary.nio;


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Set;


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


�ġ�ͨ��֮������ݴ���
transferFrom()
transferTo()


�塢��ɢ(Scatter)��ۼ�(Gather)
��ɢ��ȡ(Scattering Reads)����ͨ���е����ݷ�ɢ�������������
�ۼ�д��(Gathering Writes)��������������е����ݾۼ���ͨ����


�����ַ�����Charset
���룺�ַ��� -> �ַ�����
���룺�ַ����� -> �ַ���


 */
public class TestChannel {
    public static void main(String[] args) throws IOException {
        //long start = System.currentTimeMillis();
        //test1();//6ms
        //test2();//4ms
        //test3();
        //test4();
        //test5();
        test6();
        //long end = System.currentTimeMillis();
        //System.out.println("��ʱ��"+(end-start));
    }

    //�ַ���
    public static void test6() throws CharacterCodingException {
        Charset cs1 = Charset.forName("GBK");

        //��ȡ������
        CharsetEncoder ce = cs1.newEncoder();

        //��ȡ������
        CharsetDecoder cd = cs1.newDecoder();

        CharBuffer cBuf = CharBuffer.allocate(1024);
        cBuf.put("���");
        cBuf.flip();

        //����
        ByteBuffer bBuf = ce.encode(cBuf);

        for (int i = 0; i < 4; i++) {
            System.out.println(bBuf.get());
        }

        //����
        bBuf.flip();
        CharBuffer cBuf2 = cd.decode(bBuf);
        System.out.println(cBuf2.toString());


        System.out.println("------------------------------");


        Charset cs2 = Charset.forName("UTF-8");
        bBuf.flip();
        CharBuffer cBuf3 = cs2.decode(bBuf);
        System.out.println(cBuf3.toString());
    }


    //�ַ���
    public static void test5() {
        Map<String, Charset> map = Charset.availableCharsets();

        Set<Map.Entry<String, Charset>> set = map.entrySet();

        for (Map.Entry<String, Charset> entry : set
                ) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }

    //��ɢ�;ۼ�
    public static void test4() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("myfile\\nio\\1.txt","rw");

        //1.��ȡͨ��
        FileChannel channel1 = raf1.getChannel();

        //2.����ָ����С�Ļ�����
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);

        //3.��ɢ��ȡ
        ByteBuffer[] bufs = {buf1,buf2};
        long read = channel1.read(bufs);

        for (ByteBuffer buf:bufs
             ) {
            buf.flip();
        }

        System.out.println(new String(bufs[0].array(),0,bufs[0].limit()));

        System.out.println("--------------------------------");

        System.out.println(new String(bufs[1].array(),0,bufs[1].limit()));


        //�ۼ�д��
        RandomAccessFile raf2 = new RandomAccessFile("myfile\\nio\\2.txt","rw");
        FileChannel channel2 = raf2.getChannel();

        channel2.write(bufs);
    }


    //ͨ��֮������ݴ��䣨ֱ�ӻ�������
    public static void test3() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("F:\\СѼ�˵�.mp4"),StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("F:\\СѼ�˵�2.mp4"),StandardOpenOption.WRITE,StandardOpenOption.READ, StandardOpenOption.CREATE);

        //inChannel.transferTo(0, inChannel.size(), outChannel);
        outChannel.transferFrom(inChannel,0, inChannel.size());

        inChannel.close();
        outChannel.close();

    }

    //ʹ��ֱ�ӻ���������ļ��ĸ��ƣ�����ӳ���ļ�����ֻ֧��ByteBuffer��
    public static void test2() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("myfile\\supfile\\��ѩ.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("myfile\\supfile\\��ѩ3.jpg"), StandardOpenOption.WRITE,StandardOpenOption.CREATE_NEW, StandardOpenOption.READ);//CREATE�������ǣ�CREATE_NEW,���ھͱ���

        //�ڴ�ӳ���ļ�
        MappedByteBuffer inMappedBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        //ֱ�ӶԻ������������ݵĶ�д����
        byte[] dst = new byte[inMappedBuffer.limit()];
        inMappedBuffer.get(dst);
        outMappedBuffer.put(dst);

        inChannel.close();
        outChannel.close();
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
