package Day20;

import java.io.*;

/*
打印流：
该流提供了打印方法，可以将各种数据类型的数据都原样打印。

字节打印流：
PrintStream
构造函数可以接收的参数类型：
1. file对象。File
2. 字符串路径。String
3. 字节输出流。OutputStream

字符打印流：
PrintWriter
构造函数可以接收的参数类型：
1. file对象。File
2. 字符串路径。String
3. 字节输出流。OutputStream
4. 字符输出流。Writer

 */
public class PrintStreamDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

        //PrintWriter out = new PrintWriter(System.out,true);
        //PrintWriter out = new PrintWriter("a.txt");
        PrintWriter out = new PrintWriter(new FileWriter("a.txt"),true);

        String line = null;

        while ((line=bufr.readLine())!=null)
        {
            if("over".equals(line))
                break;
            //out.write(line.toUpperCase());
            out.println(line.toUpperCase());
            //out.flush();
        }

        out.close();
        bufr.close();
    }
}
