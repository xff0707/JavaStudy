package javastudy25days.Day25;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;

public class RRR {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.douban.com/group/topic/23934101/");
        URLConnection conn = url.openConnection();
        BufferedReader bufIn = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
        BufferedWriter bufw = new BufferedWriter(new FileWriter("D:\\douban.txt"));
        String line = null;
        while ((line = bufIn.readLine())!=null)
        {
            //System.out.println(line);
            bufw.write(line);
            bufw.newLine();
            bufw.flush();
        }
        bufIn.close();
        bufw.close();
    }
}