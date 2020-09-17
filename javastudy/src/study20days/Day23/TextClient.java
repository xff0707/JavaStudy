package Day23;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TextClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("169.254.73.155",10008);

        BufferedReader bufr = new BufferedReader(new FileReader("myfile//day23//Demo.txt"));

        PrintWriter out = new PrintWriter(s.getOutputStream(),true);

        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        //long time = System.currentTimeMillis();

        //out.println(time);
        //dos.writeLong(time);

        String line = null;
        while ((line=bufr.readLine())!=null)
        {
            out.println(line);
        }

        s.shutdownInput();//关闭客户端输出流，相当于给流中加入一个结束标记-1

        //out.println("over");
        //dos.writeLong(time);

        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

        String str = bufIn.readLine();
        System.out.println(str);

        s.close();
    }
}

class TextServer
{
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10008);

        Socket s = ss.accept();
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip+"...is connects");

        //DataInputStream dis = new DataInputStream(s.getInputStream());
        //long l = dis.readLong();

        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

        PrintWriter out = new PrintWriter(new FileWriter("server.txt"),true);

        String line = null;

        while ((line=bufIn.readLine())!=null)
        {
            //if ("over".equals(line))
                //break;
            out.println(line);
        }

        PrintWriter pw = new PrintWriter(s.getOutputStream(),true);
        pw.println("上传成功");

        out.close();
        s.close();
        ss.close();
    }
}
