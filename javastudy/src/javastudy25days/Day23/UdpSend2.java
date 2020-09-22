package javastudy25days.Day23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpSend2 {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = new DatagramSocket();

        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

        String line = null;

        while ((line = bufr.readLine())!=null)
        {
            if ("886".equals(line))
                break;

            byte[] buf = line.getBytes();

            //192.168.1.0网络地址，网络段
            //192.168.0.255广播地址
            DatagramPacket dp = new DatagramPacket(buf,buf.length, InetAddress.getByName("169.254.73.155"),10000);

            ds.send(dp);
        }
        ds.close();
    }
}




























