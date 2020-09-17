package Day24;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionDemo {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://shang.qq.com/wpa/qunwpa?idkey=4627269742aee8bac1adae4a2105b5d1795b8db1265916092d46ddff9bf3a871");

        URLConnection conn = url.openConnection();
        System.out.println(conn);

        InputStream in = conn.getInputStream();

        byte[] buf = new byte[1024];

        int len = in.read(buf);

        while ((len=in.read(buf))!=-1)
        {
            System.out.println(new String(buf,0,len));

        }



        //System.out.println(new String(buf,0,len));


    }
}
