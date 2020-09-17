package Day18;

import java.io.IOException;

/*
Runtime对象
该类中没有提供构造函数。
说明不可以new对象。那么会直接想到该类中的方法都是静态。
发现该类中还有非静态方法。
说明该类肯定会提供了方法获取本类对象，而且该方法是静态的，并返回值类型是本类类型。

由这个特点可以看出该类使用了单例设计模式完成。

该方式是static Runtime getRuntime();
 */
public class RuntimeDemo {
    public static void main(String[] args) throws IOException, InterruptedException {
        Runtime r = Runtime.getRuntime();

        //Process p = r.exec("F:\\BaiduNetdiskDownload\\GrammarlyAddInSetup.exe");

        //r.exec("D:\\Game\\QSanguosha-v2-20181004\\QSanguosha.exe");


        //Process p = r.exec("notepad.exe C:\\Users\\xff07\\OneDrive\\桌面\\工程与工业摄影测量\\讨论\\区别.txt");


        //Thread.sleep(4000);
        //p.destroy();

    }
}
