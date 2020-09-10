package playmyself;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PictureDemo {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        FileInputStream fis = null;
        try
        {
            fos = new FileOutputStream("d:\\甜心战士.jpg");
            fis = new FileInputStream("d:\\甜心战士2.jpg");

            byte[] buf = new byte[333501];

            int len = 0;

            while ((len = fis.read(buf))!=-1)
            {
                fos.write(buf,0,len);
            }

        }
         catch (IOException e) {
            throw new RuntimeException("读取关闭失败");
        }
        finally {
            try{
                if(fis!=null)
                    fis.close();
            }
            catch (IOException e)
            {
                throw new RuntimeException("读取关闭失败");
            }
            try{
                if(fos!=null)
                    fos.close();
            }
            catch (IOException e)
            {
                throw new RuntimeException("写入关闭失败");
            }
            
        }
    }
}
