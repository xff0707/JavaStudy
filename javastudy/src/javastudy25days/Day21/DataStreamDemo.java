package javastudy25days.Day21;

import java.io.*;

/*
可以用于操作基本数据类型数据的流对象。
DataInputStream
DataOutputStream
 */
public class DataStreamDemo {
    public static void main(String[] args) throws IOException {
        //writeData();
        //readData();
        //writeUTFDemo();
        readUTFDemo();

        //OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("myfile\\day21\\utf.txt"),"UTF-8");
        //OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("myfile\\day21\\gbk.txt"),"gbk");

        //osw.write("你好");
        //osw.close();

    }

    public static void readUTFDemo() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("myfile\\day21\\utfdata.txt"));

        String s = dis.readUTF();

        System.out.println(s);

        dis.close();
    }

    public static void writeUTFDemo() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("myfile\\day21\\utfdata.txt"));

        dos.writeUTF("你好");

        dos.close();
    }

    public static void readData() throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream("myfile\\day21\\data.txt"));

        int num = dis.readInt();

        boolean b = dis.readBoolean();

        double d = dis.readDouble();

        dis.close();

        System.out.println("num="+num);
        System.out.println("b="+d);
        System.out.println("d="+b);
    }

    public static void writeData() throws IOException {
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("myfile\\day21\\data.txt"));

        dos.writeInt(234);
        dos.writeBoolean(true);
        dos.writeDouble(9887.543);

        dos.close();

    }
}
