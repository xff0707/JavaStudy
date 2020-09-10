package Day20;

import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;

public class SplitFile {
    public static void main(String[] args) throws IOException {
        //splitFiles();
        merge();
    }

    public static void merge() throws IOException {
        ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();

        for (int x=1;x<=207;x++)
        {
            al.add(new FileInputStream("myfile\\吹雪part\\"+x+".part"));
        }
        final Iterator<FileInputStream> it = al.iterator();

        Enumeration<FileInputStream> en = new Enumeration<FileInputStream>() {
            @Override
            public boolean hasMoreElements() {
                return it.hasNext();
            }

            @Override
            public FileInputStream nextElement() {
                return it.next();
            }
        };

        SequenceInputStream sis = new SequenceInputStream(en);

        FileOutputStream fos = new FileOutputStream("myfile//0.jpg");

        byte[] buf = new byte[1024];

        int len = 0;

        while ((len = sis.read(buf))!=-1)
        {
            fos.write(buf);
        }

        fos.close();
        sis.close();

    }

    public static void splitFiles() throws IOException {
        FileInputStream fis = new FileInputStream("吹雪.jpg");

        FileOutputStream fos = null;

        byte[] buf = new byte[1024];

        int len = 0;
        int count = 1;

        while ((len = fis.read(buf))!=-1)
        {
            fos = new FileOutputStream("myfile\\吹雪part\\"+(count++)+".part");
            fos.write(buf,0,len);
            fos.close();
        }
        fis.close();
    }

}
