package Day24;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
    public static void main(String[] args) throws MalformedURLException {
        //URL url = new URL("http://www.baidu.com");
        //URL url = new URL("https://www.lpjsq.cn/");
        URL url = new URL("https://shang.qq.com/wpa/qunwpa?idkey=4627269742aee8bac1adae4a2105b5d1795b8db1265916092d46ddff9bf3a871");

        System.out.println("getProtocol::"+url.getProtocol());//获取此URL的协议名称
        System.out.println("getHost::"+url.getHost());//主机名
        System.out.println("getPort::"+url.getPort());//端口号，没有指定端口就是-1
        System.out.println("getPath::"+url.getPath());//路径部分
        System.out.println("getFile::"+url.getFile());//文件名
        System.out.println("getQuery::"+url.getQuery());//查询部（分）

        /*
        int port = url.getPort();
        if (port==0)
            port=80;//web默认80端口
        */
        /*
        http://localhost:63342/javastudy/Day24/demo.html?_ijt=clbgubq10o0ul70hjeq5epddhl
        http://169.254.73.155/
        其实169和localhost的映射关系就在本机上。
        C:\Windows\Systems\drivers\exc\host
         */


    }
}
