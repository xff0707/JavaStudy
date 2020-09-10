package Day19;

import java.io.*;

/*
演示mp3的复制，通过缓冲区
BufferedOutputStream
BufferedInputStream


 */
public class CopyMp3 {
    public static void main(String[] args) throws IOException {
        long start = System.currentTimeMillis();
        //copy_1();
        copy_2();
        long end = System.currentTimeMillis();

        System.out.println("自定义："+(end-start)+"毫秒");

        //long start2 = System.currentTimeMillis();
        //copy_1();
        //long end2 = System.currentTimeMillis();
        //System.out.println("API："+(end2-start2)+"毫秒");

    }

    public static void copy_2() throws IOException {
        MyBufferedInputStream busfis = new MyBufferedInputStream(new FileInputStream("都怪我.mp3"));
        BufferedOutputStream busfos = new BufferedOutputStream(new FileOutputStream("都怪我_副本.mp3"));

        int by = 0;

        //System.out.println("第一个字节："+busfis.myRead());

        while ((by=busfis.myRead())!=-1)
        {
            busfos.write(by);
        }

        busfis.myclose();
        busfos.close();
    }

    //通过字节流的缓冲区完成复制
    public static void copy_1() throws IOException {
        BufferedInputStream busfis = new BufferedInputStream(new FileInputStream("都怪我.mp3"));
        BufferedOutputStream busfos = new BufferedOutputStream(new FileOutputStream("都怪我_副本.mp3"));

        int by = 0;

        while ((by=busfis.read())!=-1)
        {
            busfos.write(by);
        }

        busfis.close();
        busfos.close();
    }
}
