package javastudy25days.Day19;

import java.io.*;

/*
通过缓冲区复制一个.java文件

 */
public class CopyTestBuf {
    public static void main(String[] args) {
        BufferedReader bufr = null;
        BufferedWriter bufw = null;

        try
        {
            bufr = new BufferedReader(new FileReader("buf.txt"));
            bufw = new BufferedWriter(new FileWriter("buf_copy.txt"));

            String line = null;

            while ((line = bufr.readLine())!=null)
            {
                bufw.write(line);
                bufw.newLine();
                bufw.flush();
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException("读写失败");
        }
        finally {
            try
            {
                if (bufr!=null)
                    bufr.close();
            }
            catch(IOException e)
            {
                throw new RuntimeException("读取关闭失败");
            }
            try
            {
                if (bufw!=null)
                    bufw.close();
            }
            catch(IOException e)
            {
                throw new RuntimeException("写入关闭失败");
            }
        }





    }
}
