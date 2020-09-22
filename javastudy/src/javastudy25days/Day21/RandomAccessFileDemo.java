package javastudy25days.Day21;

import java.io.IOException;
import java.io.RandomAccessFile;

/*
RandomAccessFile

该类不算是IO体系中子类。
而是直接继承自Object。

但是它是IO包中的成员，因为它具备读和写的功能。
内部封装了一个数组，而且通过指针对数组中的元素进行操作。
可以通过getFilePointer获取指针的位置。
同时可以通过seek改变指针的位置。


其实完成读写的原理就是内部封装了字节输入流和输出流。

通过构造函数可以看出，该类只能操作文件。

而且操作文件还有模式:只读r，读写rw等。

如果模式为只读r，不会创建文件，会去读取一个已存在文件，如果该文件不存在，则会出现异常。
如果模式为rw，操作的操作的文件不存在，会自动创建，如果存在则不会覆盖。


 */
public class RandomAccessFileDemo {
    public static void main(String[] args) throws IOException {
        writeFile();
        //readFile();

        //System.out.println(Integer.toBinaryString(258));
        //char[] a = "李四".toCharArray();
        //System.out.println(Integer.toBinaryString(a[0]));
        //System.out.println(Integer.toBinaryString(a[1]));

        writeFile_2();

    }

    public static void readFile() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("myfile\\day21\\ran.txt","r");

        //raf.write("haha".getBytes());//报错

        //调整对象中指针。
        //raf.seek(10);

        //跳过指定的字节数
        raf.skipBytes(10);

        byte[] buf = new byte[6];//UTF-8一个汉字6个字节

        raf.read(buf);

        String name = new String(buf);

        int age = raf.readInt();

        System.out.println("name="+name);
        System.out.println("age="+age);

        raf.close();
    }

    public static void writeFile_2() throws IOException {
        RandomAccessFile raf = new RandomAccessFile("myfile\\day21\\ran.txt","rw");

        raf.seek(3*10);
        raf.write("周七".getBytes());
        raf.writeInt(103);

        raf.close();
    }


    public static void writeFile() throws IOException {

        RandomAccessFile raf = new RandomAccessFile("myfile\\day21\\ran.txt","rw");

        raf.write("李四".getBytes());
        raf.writeInt(97);

        raf.write("王五".getBytes());
        raf.writeInt(99);

        raf.close();


    }

    public static void aaa()
    {























    }


}
