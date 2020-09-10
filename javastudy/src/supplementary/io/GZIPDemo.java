package supplementary.io;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class GZIPDemo {
    public static void main1(String[] args) throws Exception {
        String srcFile = "都怪我.mp3";
        String destFile = "myfile\\io\\都怪我.zip";
        GZIPOutputStream gout = new GZIPOutputStream(new FileOutputStream(destFile));
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
    }

    public static void main(String[] args) {
        String srcFile = "都怪我.mp3";
        String destFile = "myfile\\io\\都怪我.zip";
        //GZIPInputStream gis = null;
        FileInputStream gis = null;
        GZIPOutputStream gos = null;
        try {
            //gis = new GZIPInputStream(new FileInputStream(srcFile));
            gis = new FileInputStream(srcFile);
            gos = new GZIPOutputStream(new FileOutputStream(destFile));

            int len = 0;
            byte[] buf = new byte[1024*8];
            while((gis.read(buf))!=-1)
            {
                gos.write(buf,0,len);
                gos.flush();
            }
            System.out.println("压缩结束");


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (gis!=null)
                    gis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (gos!=null)
                    gos.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
