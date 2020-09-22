package javastudy25days.Day19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
/*
复制一个图片
思路：
1. 用字节读取流对象和图片关联。
2. 用字节写入流对象创建一个图片文件，用于储存获取到的图片数据。
3. 通过循环读写，完成数据的存储。
4. 关闭资源。
 */
public class CopyPic {
    public static void main(String[] args)  {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("吹雪.jpg");
            fos = new FileOutputStream("吹雪_副本.jpg");
            byte[] buf = new byte[1024];
            int len = 0;
            while ((len=fis.read(buf))!=-1)
            {
                fos.write(buf);
            }

        }
        catch (IOException e)
        {
            throw new RuntimeException("读取文件失败");
        }
        finally {
            try{
                if (fis!=null)
                    fis.close();
            }
            catch (IOException e)
            {
                throw new RuntimeException("读取关闭失败");
            }
            try{
                if (fos!=null)
                    fos.close();
            }
            catch (IOException e)
            {
                throw new RuntimeException("写入关闭失败");
            }
        }
    }

    public void myway() throws IOException
    {
        FileInputStream fis = new FileInputStream("吹雪.jpg");
        FileOutputStream fos = new FileOutputStream("吹雪_副本.jpg");

        byte[] buf = new byte[1024];
        int len = 0;
        while ((len=fis.read(buf))!=-1)
        {
            fos.write(buf);
        }
        fis.close();
        fos.close();
    }
}
