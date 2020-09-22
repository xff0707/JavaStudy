package javastudy25days.Day25;

/*
正则表达式：符合一定规则的表达式。
    作用：用于专门操作字符串
    特点：用一些特定的符号来表示一些代码操作，这样就简化书写。
    所以学习正则表达式，就是在学习一些特殊符号的使用
    
    好处：可以简化对字符串的复杂操作
    弊端：符号定义越多，正则越长，阅读性越差


具体操作功能：

1. 匹配： String matches方法。用规则匹配整个字符串，只要有一个不符合规则，就匹配结束，返回false

2. 切割： String split方法

3. 替换： String replace方法

 */
public class RegexDemo {
    public static void main(String[] args) {
        //checkqq();
        //checkQQ();
        //demo();
        //checkTel();

        //splitDemo("zhangsan,lisi,wangwu",",");
        //splitDemo("zhangsan     lisi        wangwu"," +");
        //splitDemo("zhangsan.lisi.wangwu","\\.");
        //splitDemo("C:\\Users\\xff07\\OneDrive\\桌面\\工程测量学实验","\\\\");
        //splitDemo("angilaagnlaggkjnssvlddkfhffisf","(.)\\1+");//按照叠词完成切割，为了可以让规则的结果被重用
        //     \1表示第一位的字符                                           可以将规则封装成一个组，用()完成，组的出现都有编号
                                                                        //从1开始，想要使用已有的组可以通过 \n(n就是组的编号)的形式来获取


        //String str = "afh132165htf5452321hs511116hdgsj1556122rytsd1114Ff";//将字符串中的数字替换成#。
        //replaceAllDemo(str,"\\d{5,}","#");

        String str = "afh1122rydddtssd14Ff";//将字符串中的叠词替换成$。  //将重叠的字母替换成单个字母  zzzzzzzzzz->z
        //replaceAllDemo(str,"(.)\\1+","&");
        replaceAllDemo(str,"(.)\\1+","$1");//前一个规则中的第一个组



        //System.out.println(0x0B);//11
        //System.out.println((char)11);
    }


    public static void replaceAllDemo(String str,String reg,String newSte)
    {
        str = str.replaceAll(reg,newSte);
        System.out.println(str);
    }



    public static void splitDemo(String str,String reg)
    {
        //String str = "zhangsan,lisi,wangwu";
        //String str = "zhangsan     lisi        wangwu";
        //String str = "zhangsan.lisi.wangwu";
        //String str = "C:\\Users\\xff07\\OneDrive\\桌面\\工程测量学实验";

        //String reg = ",";
        //String reg = " +";//按照多个空格进行切割
        //String reg = "\\.";//正则表达式:\.   字符串:\\.


        String[] arr = str.split(reg);

        for (String s : arr)
        {
            System.out.println(s);
        }

    }


    /*
    匹配
    手机号段只有13xxx 15xxx 18xxx

    */
    public static void checkTel()
    {
        String tel = "15293316666";
        String telreg = "1[358]\\d{9}";
        System.out.println(tel.matches(telreg));
    }


    public static void demo()
    {
        String str = "b9";

        //String reg = "[bcd]";//一个字符，b或c或d
        //String reg = "[^bcd]";//一个字符，非b非c非d
        //String reg = "[bcd][a-z]";//两个字符，b或c或d，a到z
        //String reg = "[a-zA-Z][0-9]";//两个字符，字母数字
        //String reg = "[a-zA-Z]\\d";//两个字符，字母数字
        String reg = "[a-zA-Z]\\d?";//两个字符，字母，数字一次或一次也没有


        /*
        .   任何字符
        \d  数字[0-9]
        \D  非数字[^0-9]
        \s  空白字符[ \t\n\x0B\f\r]
        \S  非空白字符
        \w  单词字符[a-zA-Z_0-9]
        \W  非单词字符[^\w]

        X?  一次或一次也没有
        X*  零次或多次
        X+  一次或多次
        X{n}    恰好n次
        X{n,}   至少n次
        X{n,m}   至少n次，但是不能超过m次


        */

        boolean b = str.matches(reg);

        System.out.println(b);
    }


    public static void checkQQ()
    {
        String qq = "23441161249";

        //String regex = "[1-9][0-9]{4,14}";
        String regex = "[1-9]\\d{4,14}";

        boolean flag = qq.matches(regex);

        if (flag)
            System.out.println(qq+"....is ok");
        else
            System.out.println(qq+"....不合法");

    }


    /*
    对QQ号码进行校检
    要求：5~15位 0不能开头，只能是数字

    这种方式：使用了String类中的方法，进行组合完成了需求，但是代码过于复杂。
     */
    public static void checkqq()
    {
        String qq = "23441给1124";

        int len = qq.length();

        if (len>=5 && len<=15)
        {
            if (!(qq.startsWith("0")))//Integer.parseInt("2a");NumberFormatException
            {
                try
                {
                    long l = Long.parseLong(qq);
                    System.out.println("qq:"+qq);
                }
                catch (Exception e)
                {
                    System.out.println("出现非法字符。。。");
                }



                /*
                char[] arr = qq.toCharArray();
                Boolean flag = true;
                for (int x=0;x<arr.length;x++)
                {
                    if (!(arr[x]>='0' && arr[x]<='9'))
                    {
                        flag=false;
                        break;
                    }

                }
                if (flag)
                {
                    System.out.println("qq:"+qq);
                }
                else
                {
                    System.out.println("qq出现非法字符");
                }
                 */
            }
            else
            {
                System.out.println("不可以0开头");
            }

        }
        else
        {
            System.out.println("长度错误");
        }
    }

}

