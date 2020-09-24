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


四、通道之间的数据传输
transferFrom()
transferTo()


五、分散(Scatter)与聚集(Gather)
分散读取(Scattering Reads)：将通道中的数据分散到多个缓冲区中
聚集写入(Gathering Writes)：将多个缓冲区中的数据聚集到通道中


六、字符集：Charset
编码：字符串 -> 字符数组
解码：字符数组 -> 字符串


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
        //System.out.println("耗时："+(end-start));
    }

    //字符集
    public static void test6() throws CharacterCodingException {
        Charset cs1 = Charset.forName("GBK");

        //获取编码器
        CharsetEncoder ce = cs1.newEncoder();

        //获取解码器
        CharsetDecoder cd = cs1.newDecoder();

        CharBuffer cBuf = CharBuffer.allocate(1024);
        cBuf.put("你好");
        cBuf.flip();

        //编码
        ByteBuffer bBuf = ce.encode(cBuf);

        for (int i = 0; i < 4; i++) {
            System.out.println(bBuf.get());
        }

        //解码
        bBuf.flip();
        CharBuffer cBuf2 = cd.decode(bBuf);
        System.out.println(cBuf2.toString());


        System.out.println("------------------------------");


        Charset cs2 = Charset.forName("UTF-8");
        bBuf.flip();
        CharBuffer cBuf3 = cs2.decode(bBuf);
        System.out.println(cBuf3.toString());
    }


    //字符集
    public static void test5() {
        Map<String, Charset> map = Charset.availableCharsets();

        Set<Map.Entry<String, Charset>> set = map.entrySet();

        for (Map.Entry<String, Charset> entry : set
                ) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }

    //分散和聚集
    public static void test4() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("myfile\\nio\\1.txt","rw");

        //1.获取通道
        FileChannel channel1 = raf1.getChannel();

        //2.分配指定大小的缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);

        //3.分散读取
        ByteBuffer[] bufs = {buf1,buf2};
        long read = channel1.read(bufs);

        for (ByteBuffer buf:bufs
             ) {
            buf.flip();
        }

        System.out.println(new String(bufs[0].array(),0,bufs[0].limit()));

        System.out.println("--------------------------------");

        System.out.println(new String(bufs[1].array(),0,bufs[1].limit()));


        //聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("myfile\\nio\\2.txt","rw");
        FileChannel channel2 = raf2.getChannel();

        channel2.write(bufs);
    }


    //通道之间的数据传输（直接缓冲区）
    public static void test3() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("F:\\小鸭运蛋.mp4"),StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("F:\\小鸭运蛋2.mp4"),StandardOpenOption.WRITE,StandardOpenOption.READ, StandardOpenOption.CREATE);

        //inChannel.transferTo(0, inChannel.size(), outChannel);
        outChannel.transferFrom(inChannel,0, inChannel.size());

        inChannel.close();
        outChannel.close();

    }

    //使用直接缓冲区完成文件的复制（内有映射文件）（只支持ByteBuffer）
    public static void test2() throws IOException {
        FileChannel inChannel = FileChannel.open(Paths.get("myfile\\supfile\\吹雪.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("myfile\\supfile\\吹雪3.jpg"), StandardOpenOption.WRITE,StandardOpenOption.CREATE_NEW, StandardOpenOption.READ);//CREATE创建覆盖，CREATE_NEW,存在就报错

        //内存映射文件
        MappedByteBuffer inMappedBuffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuffer = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        //直接对缓冲区进行数据的读写操作
        byte[] dst = new byte[inMappedBuffer.limit()];
        inMappedBuffer.get(dst);
        outMappedBuffer.put(dst);

        inChannel.close();
        outChannel.close();
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
