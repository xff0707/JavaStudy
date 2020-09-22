package javastudy25days.Day18;

import java.io.FileReader;
import java.io.IOException;

/*
第二种方式：通过字符数组进行读取
 */
public class FileReaderDemo2 {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("demo.txt");

        //定义一个字符数组，用于储存读到字符。
        //该read(char[]);返回的是读到的字符个数。
        char[] buf = new char[1024];

        int num = 0;
        while ((num = fr.read(buf))!=-1)
        {
            System.out.println(new String(buf,0,num));
        }


        /*
        int num = fr.read(buf);

        System.out.println("num:"+num+"...."+new String(buf));

        int num1 = fr.read(buf);

        System.out.println("num1:"+num1+"...."+new String(buf));

        int num2 = fr.read(buf);

        System.out.println("num2:"+num2+"...."+new String(buf,0,num2));

        int num3 = fr.read(buf);

        System.out.println("num3:"+num3+"...."+new String(buf));

         */

        fr.close();
    }
}
