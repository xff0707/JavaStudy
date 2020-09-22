package javastudy25days.Day24;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
客户端通过键盘录入用户名。
服务端对这个用户名进行校检

如果该用户存在，在服务端显示xxx，已登录
并在客户端显示xxx，欢迎光临

如果该用户不存在，服务端显示xxx尝试登录
并在客户端显示xxx该用户不存在

最多就登录三次。

 */
public class LoginClient {
    public static void main(String[] args) throws IOException {
        Socket s = new Socket("169.254.73.155",10020);

        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

        PrintWriter out = new PrintWriter(s.getOutputStream());

        BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

        for (int x=0;x<3;x++)
        {
            String line = bufr.readLine();
            if (line==null)
                break;
            out.println(line+"\n");

            String info = bufIn.readLine();

            System.out.println("info:"+info);
            //if (info.contains("欢迎"))
            if (info.contains("welcome"))
                break;
        }

        bufr.close();
        s.close();

    }
}

class UserThread implements Runnable
{
    private Socket s;

    public UserThread(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        String ip = s.getInetAddress().getHostAddress();
        System.out.println(ip+"...connected");
        try
        {
            for (int x=0;x<3;x++)
            {
                BufferedReader bufIn = new BufferedReader(new InputStreamReader(s.getInputStream()));

                String name = bufIn.readLine();
                if (name==null)
                    break;

                BufferedReader bufr = new BufferedReader(new FileReader("user.txt"));

                PrintWriter out = new PrintWriter(s.getOutputStream(),true);

                String line = null;

                boolean flag = false;
                while ((line=bufr.readLine())!=null) {
                    if (line.equals(name)) {
                        flag = true;
                        break;
                    }
                }

                if (flag)
                {
                    System.out.println(name+"已登陆");
                    out.println(name+",欢迎光临");
                    break;
                }
                else
                {
                    System.out.println(name+"尝试登陆");
                    out.println(name+",用户名不存在");
                }

            }
            s.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(ip+"校验失败");
        }
    }
}

class LoginServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10008);

        while (true)
        {
            Socket s = ss.accept();

            new Thread(new UserThread(s)).start();

        }
    }
}
