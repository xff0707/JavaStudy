package javastudy25days.Day25;

import java.util.TreeSet;

public class RegexTest {
    public static void main(String[] args) {
        //test_1();
        //ipSort();
        checkMail();
    }

    /*
    需求：对邮件地址进行校验

     */
    public static void checkMail()
    {
        String mail = "abc12@sina.com.cn";

        //String reg = "[a-zA-Z0-9_]{6,12}@";
        //String reg = "[a-zA-Z0-9_]+@[]a-zA-Z0-9]+(\\.[a-zA-Z]+)+";
        String reg = "[a-zA-Z0-9_]+@[a-zA-Z0-9]+(\\.[a-zA-Z]+){1,3}";//较为精确的匹配
        reg = "\\w+@\\w+(\\.\\w+)+";//相对不太精确的匹配

        //while(mail.indexOf("@")!=-1);//只要有@就可以

        System.out.println(mail.matches(reg));
    }



    /*
    需求：
    将下列字符串转成：我要学编程

    到底使用四种功能中的哪一个呢？或者哪几个呢？
    思路方式：
    1. 如果只想知道该字符是否对或错，使用匹配。
    2. 想要将已有的字符串变成另一个字符串，替换。
    3. 想要按照自定的方式将字符串变成多个字符串，切割。获取规则以外的子串。
    4. 想要拿到符合需求的字符串子串，获取。获取符合规则的子串。

     */

    public static void test_1()
    {
        String str = "我我...我我...我要..要要...要要...学学学....学学...编编编...编程..程.程程...程...程";
        /*
        将已有字符串变成另一个字符串，使用替换功能。
        1. 可以先将 . 去掉。
        2. 再将多个重复的内容变成单个内容
         */
        str = str.replaceAll("\\.+","");//我我我我我要要要要要学学学学学编编编编程程程程程程
        str = str.replaceAll("(.)\\1+","$1");//我要学编程

        System.out.println(str);
    }

    /*
    192.68.1.254 102.49.23.013 10.10.10.10 2.2.2.2 8.109.90.30
    将IP地址进行地址段顺序的排序。


    还按照自然顺序排序，只要让他们每一段都是3位即可。
    1. 按照每一段需要的最多的0进行补齐，那么每一段就会至少保证有3位
    2. 将每一段只保留3位，这样，所有IP地址都是每一段3位。
    3.

     */
    public static void ipSort()
    {
        String ip = "192.68.1.254 102.49.23.013 10.10.10.10 2.2.2.2 8.109.90.30";

        ip = ip.replaceAll("(\\d+)","00$1");
        System.out.println(ip);

        ip = ip.replaceAll("0*(\\d{3})","$1");
        System.out.println(ip);

        String[] arr = ip.split(" +");

        TreeSet<String> ts = new TreeSet<String>();

        for (String s : arr)
        {
            ts.add(s);
        }

        for (String s : ts)
        {
            s = s.replaceAll("0*(\\d+)","$1");
            System.out.println(s);
        }
    }
}
