package Day18;

import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        /*
        创建一个文件读取六对象，和指定名称的文件相关联
        要保证该文件是已经存在的，如果不存在，会发生异常FileNotFoundException
        FileReader fr = new FileReader("");

        调用读取流对象的read方法
        read方法一次读一个字符，会自动往下读
        int ch = fr.read();

        if(ch==-1)
        {
            break;
        }
        else
            System.out.println("ch="+(char)ch);
        */



        /*
        int ch1 = fr.read();

        System.out.println("ch1="+(char)ch1);

        int ch2 = fr.read();

        System.out.println("ch2="+(char)ch2);

        int ch3 = fr.read();

        System.out.println("ch3="+(char)ch3);

        int ch4 = fr.read();

        System.out.println("ch4="+(char)ch4);//-1

         */

        //fr.close();

    }
}
