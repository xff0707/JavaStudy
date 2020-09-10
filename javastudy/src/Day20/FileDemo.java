package Day20;

import java.io.File;
import java.io.IOException;
/*
File类的常见方法。
1. 创建。
    boolean createNewFile();在指定位置创建文件，如果该文件已经存在，则不创建，返回false。
                            和输出流不一样，输出流对象一建立就创建文件，而且文件已经存在，会覆盖。

    boolean mkdir();创建文件夹
    boolean mkdirs();创建多级文件夹

2. 删除。
    boolean delete();删除失败返回false
    void deleteOnExit();在程序退出时删除指定文件。

3. 判断。
    boolean exists();文件是否存在。
    canExecute();是否可运行
    isFile();文件
    isDirectory();目录
    isHidden();是否隐藏
    isAbsolute();绝对路径

4. 获取信息。
    getName();
    getPath();
    getParent();

    getAbsolute();
    getAbsolutePath();
    long lastModified();
    long length();




 */

public class FileDemo {
    public static void main(String[] args) throws IOException {
        //consMethod();
        //method_1();
        //method_2();
        //method_3();
        //method_4();
        method_5();
    }

    public static void method_5()
    {
        File f1 = new File("d:\\playmyself\\Test.jpg");
        File f2 = new File("d:\\file.jpg");

        System.out.println("rename:"+f1.renameTo(f2));
    }

    public static void method_4()
    {
        File f = new File("file.txt");

        System.out.println("path:"+f.getPath());
        System.out.println("abspath:"+f.getAbsolutePath());
        System.out.println("parent:"+f.getParent());//该方法返回绝对路径中的父目录。如果获取的是相对路径，返回null。
                                                    //如果相对路径中有上一层目录，那么该目录就是返回结果。
        System.out.println("lastModified:"+f.lastModified());
    }

    public static void method_3() throws IOException {
        File f = new File("file.txt");

        //f.createNewFile();
        //f.mkdir();

        //记住在判断文件对象是否是文件或者目的时，必须要先判断该文件对象封装的内容是否存在。
        //通过exists判断
        System.out.println("dir:"+f.isDirectory());
        System.out.println("File:"+f.isFile());

        System.out.println(f.isAbsolute());//是否绝对路径
    }

    public static void method_2()
    {
        File f = new File("file.txt");

        //System.out.println("execute:"+f.canExecute());
        System.out.println("exists:"+f.exists());
    }

    public static void method_1() throws IOException {
        File f = new File("file.txt");
        //f.deleteOnExit();

        //System.out.println("create:"+f.createNewFile());
        //System.out.println("delete:"+f.delete());

        //创建文件夹
        File dir = new File("abc");
        System.out.println(dir.mkdir());

        File dir1 = new File("abc\\d\\gf\\f\\j\\j\\w\\r\\u\\s");
        System.out.println(dir1.mkdirs());

    }

    //创建File对象
    public static void consMethod()
    {
        //将a.txt封装成file对象。可以将已有的和未出现的文件或者文件夹封装成对象。
        //File f1 = new File("d:\\a.txt");
        File f1 = new File("a.txt");

        //
        File f2 = new File("d:\\abc","b.txt");

        //
        File d = new File("d:\\abc");
        File f3 = new File(d,"c.txt");

        System.out.println("f1:"+f1);
        System.out.println("f2:"+f2);
        System.out.println("f3:"+f3);

        File f4 = new File("c:\\abc\\zzz\\a.txt");
        File f5 = new File("c:/abc/zzz/a.txt");//跨平台的分隔符File.separator
        File f6 = new File("c:"+File.separator+"abc"+File.separator+"zzz"+File.separator+"a.txt");
    }
}







