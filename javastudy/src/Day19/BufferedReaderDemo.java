package Day19;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
字符读取缓冲区。
该缓冲区提供了一个一次读一行的方法readline，方便于对文本数据的获取。
当返回null时，表示读到文件末尾。

readLine方法返回的时候只返回回车符之前的数据内容，并不返回回车符。
 */
public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        //创建一个读取流对象和文件相关联。
        FileReader fr = new FileReader("buf.txt");

        //为了提高效率，加入缓冲技术，将字符读取流对象作为参数传递给缓冲对象的构造函数。
        BufferedReader bufr = new BufferedReader(fr);

        String line = null;

        while((line=bufr.readLine())!=null)
        {
            System.out.println(line);

        }


        bufr.close();

    }
}
