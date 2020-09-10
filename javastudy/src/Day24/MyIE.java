package Day24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyIE {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("169.254.73.155",8080);

        PrintWriter out = new PrintWriter(s.getOutputStream());

        out.println("GET / HTTP/1.1");
        out.println("Host: 169.254.73.155:11000");
        out.println("Connection: keep-alive");
        out.println("Accept: */*");
        out.println("Accept-Language: zh-CN,zh;q=0.9");

        out.println();
        out.println();

        BufferedReader bufr = new BufferedReader(new InputStreamReader(s.getInputStream()));

        String line = null;

        while ((line=bufr.readLine())!=null)
        {
            System.out.println(line);
        }

        s.close();
    }
}

















