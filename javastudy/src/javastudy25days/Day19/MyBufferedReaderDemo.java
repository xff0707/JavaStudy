package javastudy25days.Day19;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/*
明白了BufferedReader类中特有方法readLine的原理后，
可以自定义一个类中包含一个功能和readLine一致的方法。
来模拟以下BufferedReader
 */
class MyBufferedReader extends Reader
{

    private FileReader r;

    MyBufferedReader(FileReader r)
    {
        this.r = r;
    }

    //可以一次读一行数据的方法
    public String myReadLine() throws IOException {
        //定义一个临时容器。原BufferedReader封装的是字符数组。
        //为了演示方便，定义一个StringBuilder容器。因为最终还是要将数据变成字符串。
        StringBuilder sb = new StringBuilder();
        int ch = 0;
        while ((ch=r.read())!=-1)
        {
            if (ch=='\r')
                continue;
            if (ch=='\n')
                return sb.toString();
            else
                sb.append((char)ch);
        }
        if (sb.length()!=0)
            return sb.toString();
        return null;
    }

    public void myclose() throws IOException {
        r.close();
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return r.read(cbuf, off, len);
    }

    @Override
    public void close() throws IOException {
        r.close();
    }
}
public class MyBufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("buf.txt");

        MyBufferedReader mybuf = new MyBufferedReader(fr);

        String line = null;

        while ((line = mybuf.myReadLine())!=null)
        {
            System.out.println(line);
        }
        mybuf.myclose();
    }
}
