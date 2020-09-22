package javastudy25days.Day20;

import java.io.File;

/*
删除一个带内容的目录。
删除原理：
在windows中，删除目录从里面往外删除的。

既然是从里往外删除，就需要用到递归。

 */
public class removeDir {
    public static void main(String[] args) {
        //File fir = new File("D:\\testdir");
        //removeDir(fir);
    }

    public static void removeDir(File dir)
    {
        //if(!dir.exists())

        File[] files = dir.listFiles();

        for(int x=0;x<files.length;x++)
        {
            if (files[x].isDirectory()&&files[x].isHidden())
                removeDir(files[x]);
            else
                System.out.println(files[x]+":file:"+files[x].delete());
        }

        System.out.println(dir+":dir:"+dir.delete());
    }
}
