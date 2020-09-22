package javastudy25days.Day21;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/*
编码：字符串变成字节数组。


解码：字节数组变成字符串。

String-->byte[]: str.getBytes(charsetName);


byte[] -->String: new String(byte[],charsetName);



 */
public class EncodeDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "你好";

        //byte[] b1 = s.getBytes();//默认"UTF-8"编码
        //[-28, -67, -96, -27, -91, -67]
        byte[] b1 = s.getBytes("GBK");
        //[-60, -29, -70, -61]
        System.out.println("b1="+Arrays.toString(b1));

        String s1 = new String(b1,"iso8859-1");//因为utf-8和gbk都试别中文会出错
        System.out.println("s1="+s1);//默认UTF-8解码，s1=���

        //对s1进行iso8859-1编码。
        byte[] b2 = s1.getBytes("iso8859-1");
        System.out.println("b2="+Arrays.toString(b2));

        String s2 = new String(b2,"GBK");
        System.out.println("s2="+s2);

    }
}
