package javastudy25days.Day21;

import java.io.*;

public class EncodeStream {
    public static void main(String[] args) throws IOException {
        //writeText();
        readText();
    }

    public static void readText() throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("myfile\\day21\\utf.txt"),"GBK");

        char[] buf = new char[10];
        int len = isr.read(buf);

        String str = new String(buf,0,len);

        System.out.println(str);

        isr.close();

    }

    public static void writeText() throws IOException {
        //OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("myfile\\day21\\gbk.txt"),"GBK");//4字节
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("myfile\\day21\\utf.txt"),"UTF-8");//6字节

        osw.write("你好");

        osw.close();
    }

}
