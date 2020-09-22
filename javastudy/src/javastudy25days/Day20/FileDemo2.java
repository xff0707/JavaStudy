package javastudy25days.Day20;

import java.io.File;
import java.io.FilenameFilter;

public class FileDemo2 {
    public static void main(String[] args) {
        //listRootsDemo();
        //listDemo();
        //listDemo_2();
        File dir = new File("c:\\");
        File[] files = dir.listFiles();

        for (File f :files)
        {
            System.out.println(f.getName()+":"+f.length());
        }

    }

    public static void listDemo_2()
    {
        File dir = new File("C:\\Users\\xff07\\OneDrive\\桌面\\Java\\javastudy20days.Day13");

        String[] arr = dir.list(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                //System.out.println("dir:"+dir+",name:"+name);
                /*
                if(name.endsWith(".class"))
                    return true;
                else
                    return false;
                 */
                return name.endsWith(".class");
            }
        });

        System.out.println("len:"+arr.length);
        for (String name : arr)
        {
            System.out.println(name);
        }
    }

    public static void listDemo()
    {
        File f = new File("c:\\");

        String[] names = f.list();//调用list方法的file对象必须是封装了一个目录，该目录还必须存在。
        for (String name : names)
        {
            System.out.println(name);
        }
    }

    public static void listRootsDemo()
    {
        File[] files = File.listRoots();

        for (File f :files)
        {
            System.out.println(f);
        }
    }
}
