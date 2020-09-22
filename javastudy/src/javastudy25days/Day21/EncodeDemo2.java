package javastudy25days.Day21;

import java.io.UnsupportedEncodingException;

/*


 */
public class EncodeDemo2 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "联通";

        byte[] by = s.getBytes("gbk");

        for (byte b : by)
        {
            System.out.println(Integer.toBinaryString(b&255));
        }

        System.out.println(s);


    }
}
