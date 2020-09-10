package Day19;

import java.io.*;

/*
字符流
FileReader
FileWriter

BufferedReader
BufferedWriter

字节流：
FileInputStream
FileOutputStream


BufferedInputStream
BufferedOutputStream



通过刚才(ReadIn)的键盘录入一行数据并打印其大写，发现其实就是读一行数据的原理。
也就是readLine()方法。

能不能直接使用readLine方法来完成键盘录入的一行数据的读取呢？


readLine方法是BufferedReader类中的方法。

而键盘录入的read方法是字节流InputStream的方法。

那么能不能将字节流转成字符流再使用字符流缓冲区的readLine方法呢？



 */
public class TransStreamDemo {
    public static void main(String[] args) throws IOException {
        //获取键盘录入对象
        InputStream in = System.in;

        //将字节流对象转成字符流对象，使用转换流。InputStreamReader
        InputStreamReader ist = new InputStreamReader(in);

        //为了提高效率，将字符串进行缓冲区技术高级操作，使用BufferedReader
        BufferedReader bufr = new BufferedReader(ist);

        OutputStream out = System.out;
        OutputStreamWriter osw = new OutputStreamWriter(out);
        BufferedWriter bufw = new BufferedWriter(osw);


        String line = null;

        while ((line = bufr.readLine())!=null)
        {
            if ("over".equals(line))
                break;
            //System.out.println(line.toUpperCase());
            //osw.write(line.toUpperCase()+'\n');
            //osw.write(line.toUpperCase());
            bufw.write(line.toUpperCase());
            bufw.newLine();
            bufw.flush();
            //osw.flush();
        }
        bufr.close();
    }
}
