package Day23;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/*
需求：通过UDP传输方式将一段文字数据发送出去。
思路
1. 建立udpsocket服务。
2. 提供数据并将数据封装到数据包中。
3. 通过socket服务的发送功能，将数据发出去。
4. 关闭资源。

 */
class UdpSend {
    public static void main(String[] args) throws IOException {
        //1.创建一个udp服务，通过DatagramSocket对象。
        DatagramSocket ds = new DatagramSocket();

        //2. 确定数据，并封装成数据包。
        byte[] buf = "udp i am coming!".getBytes();
        DatagramPacket dp = new DatagramPacket(buf,buf.length, InetAddress.getByName("169.254.73.155"),10000);

        //3. 通过socket服务将已有的数据包发送出去，通过森达方法。
        ds.send(dp);

        //4. 关闭资源。
        ds.close();

    }
}