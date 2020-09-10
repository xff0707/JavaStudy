package playmyself;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class bianma {
    //private final static String ENCODE = "GBK";
    private final static String ENCODE = "utf-8";
    public static void main(String[] args) {
        //String encode = "^quCYkpfnQq^eyJwMSI6IjEwMjM5MDh6IiwicDIiOiIiLCJwMyI6IjEwMjM5MDh4Iiwic2NoZW1lIjoidjEvZWFzeWJyb3dzZS9oeWJyaWQ/dXBncmFkZT0xJnR5cGU9aHlicmlkJnRwbF9pZD1sYW5kaW5nX2FwcC5odG1sJm5ld2Jyb3dzZXI9MSZzdHlsZT0lN0IlMjJ0b29sYmFyaWNvbnMlMjIlM0ElN0IlMjJ0aWRzJTIyJTNBJTVCJTIyNCUyMiUyQyUyMjElMjIlMkMlMjIyJTIyJTJDJTIyMyUyMiU1RCUyQyUyMm1lbnVtb2RlJTIyJTNBJTIyMiUyMiUyQyUyMmFjdGlvbkJhckNvbmZpZyUyMiUzQSU3QiUyMmV4dENhc2UlMjIlM0ElMjIwJTIyJTdEJTdEJTdEJnNsb2c9JTdCJTIyZnJvbSUyMiUzQSUyMmZlZWQlMjIlN0QmY29udGV4dD0lN0IlMjJuaWQlMjIlM0ElMjJuZXdzXzEwNDY4MTY0OTEwNTk4OTg5NTc3JTIyJTdEJmNoX3VybD1odHRwcyUzQSUyRiUyRm1iZC5iYWlkdS5jb20lMkZuZXdzcGFnZSUyRmRhdGElMkZsYW5kaW5ncmVhY3QlM0ZwYWdlVHlwZSUzRDIlMjZuaWQlM0RuZXdzXzEwNDY4MTY0OTEwNTk4OTg5NTc3JTI2c291cmNlRnJvbSUzRGxhbmRpbmdTaGFyZSZjb21tZW50SW5mbz0lN0IlMjJ0b3BpY19pZCUyMiUzQSUyMjExMDAwMDAwMjQ0MzMxNjglMjIlMkMlMjJvcGVudHlwZSUyMiUzQTIlN0QifQ==";

        //String text = "woaini";
        String encode = "eyJwMSI6IjEwMjM5MDh6IiwicDIiOiIiLCJwMyI6IjEwMjM5MDh4Iiwic2NoZW1lIjoidjEvZWFzeWJyb3dzZS9oeWJyaWQ/dXBncmFkZT0xJnR5cGU9aHlicmlkJnRwbF9pZD1sYW5kaW5nX2FwcC5odG1sJm5ld2Jyb3dzZXI9MSZzdHlsZT0lN0IlMjJ0b29sYmFyaWNvbnMlMjIlM0ElN0IlMjJ0aWRzJTIyJTNBJTVCJTIyNCUyMiUyQyUyMjElMjIlMkMlMjIyJTIyJTJDJTIyMyUyMiU1RCUyQyUyMm1lbnVtb2RlJTIyJTNBJTIyMiUyMiUyQyUyMmFjdGlvbkJhckNvbmZpZyUyMiUzQSU3QiUyMmV4dENhc2UlMjIlM0ElMjIwJTIyJTdEJTdEJTdEJnNsb2c9JTdCJTIyZnJvbSUyMiUzQSUyMmZlZWQlMjIlN0QmY29udGV4dD0lN0IlMjJuaWQlMjIlM0ElMjJuZXdzXzEwNDY4MTY0OTEwNTk4OTg5NTc3JTIyJTdEJmNoX3VybD1odHRwcyUzQSUyRiUyRm1iZC5iYWlkdS5jb20lMkZuZXdzcGFnZSUyRmRhdGElMkZsYW5kaW5ncmVhY3QlM0ZwYWdlVHlwZSUzRDIlMjZuaWQlM0RuZXdzXzEwNDY4MTY0OTEwNTk4OTg5NTc3JTI2c291cmNlRnJvbSUzRGxhbmRpbmdTaGFyZSZjb21tZW50SW5mbz0lN0IlMjJ0b3BpY19pZCUyMiUzQSUyMjExMDAwMDAwMjQ0MzMxNjglMjIlMkMlMjJvcGVudHlwZSUyMiUzQTIlN0QifQ==";

        String s = jie(encode);
        System.out.println(s);
        System.out.println(s.length());
        System.out.println(new String(s.getBytes(),1,100));

        String s1 = "%7B%22toolbaricons%22%3A%7B%22tids%22%3A%5B%224%22%2C%221%22%2C%222%22%2C%223%22%5D%2C%22menumode%22%3A%222%22%2C%22actionBarConfig%22%3A%7B%22extCase%22%3A%220%22%7D%7D%7D&slog=%7B%22from%22%3A%22feed%22%7D&context=%7B%22nid%22%3A%22news_10468164910598989577%22%7D&ch_url=https%3A%2F%2Fmbd.baidu.com%2Fnewspage%2Fdata%2Flandingreact%3FpageType%3D2%26nid%3Dnews_10468164910598989577%26sourceFrom%3DlandingShare&commentInfo=%7B%22topic_id%22%3A%221100000024433168%22%2C%22opentype%22%3A2%7D";
        String url = getURLDecoderString(s1);
        System.out.println(url);

    }
    static String bian(String text)
    {
        String encode = Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
        //System.out.println(encode);
        return encode;
    }

    static String jie(String encode)
    {
        String decode = new String(Base64.getDecoder().decode(encode), StandardCharsets.UTF_8);
        //System.out.println(decode);
        return decode;
    }
    //解码
    public static String getURLDecoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLDecoder.decode(str, ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
    //转码
    public static String getURLEncoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLEncoder.encode(str, ENCODE);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
