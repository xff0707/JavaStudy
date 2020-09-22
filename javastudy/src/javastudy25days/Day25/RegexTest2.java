package javastudy25days.Day25;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
网页爬虫(蜘蛛)


 */
public class RegexTest2 {
    public static void main(String[] args) throws IOException {
        //getMails();
        getMail_1();
    }

    public static void getMail_1() throws IOException {
        URL url = new URL("https://www.douban.com/group/topic/23934101/");

        URLConnection conn = url.openConnection();

        BufferedReader bufIn = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String line = null;

        String mailreg = "\\w+@\\w+(\\.\\w+)+";
        Pattern p = Pattern.compile(mailreg);


        while ((line = bufIn.readLine())!=null)
        {
            Matcher m = p.matcher(line);
            while (m.find())
            {
                System.out.println(m.group());
            }

            /*
            jxinyi@163.com
            343592313@qq.com
            ralfchan328@gmail.com
            971203776@qq.com
            baoyao123@gmail.com
            newdhl@qq.com
            81822656@qq.com
            xingyunxiaowanzi@163.com
            whiterocase@163.com
            shuiyaomumu@126.com
            fengwei317@126.com
            317009380@qq.com
            372030001@qq.com
            feixidb@yeah.net
            iwbar@qq.com
            664130943@qq.com
            dimocy@126.com
            bachelorday@hotmail.com
            wbywby00@163.com
            ywywuzhou@126.com
            81631053@qq.com
            1799833815@qq.com
            9429495@qq.com
            hk339245068@126.com
            781717434@qq.com
            624643689@qq.com
            1770633871@qq.com
            tongtong19920707@126.com
            309685071@qq.com
            363520284@qq.com
            979828207@qq.com
            491862290@qq.com
            ok@163.com
            angelgk008@126.com
            daron5chan@gmail.com
            luoliwen777@sina.com
            534824575@qq.com
            fujun1818@gmail.com
            249544984@qq.com
            80550144@qq.com
            532621984@qq.com
            466890580@qq.com
            358125111@qq.com
            532781138@qq.com
            djk198116@sina.com
            42293845@qq.com
            464772817@qq.com
            261868786@qq.com
            ashesandsi@sina.com
            pengzhendeyx@163.com
            caoyanapple@gmail.com
            crazymj31@hotmail.com
            abbeycake@hotmail.com
            136114794@qq.com
            429186092@qq.com
            playboy0331@126.com
            99668290@qq.com
            hahajwjw@163.com
            374928136@qq.com
            646049852@qq.com
            735198443@qq.com
            280253512@qq.com
            437917715@qq.com
            453902381@qq.com
            346572446@qq.com
            453869514@qq.com
            564088697@qq.com
            1138395294@qq.com
            kukuzhuiqiu1@sina.com
            bsnj201107@163.com
            18638001187@126.com
            550794163@qq.com
            768801475@qq.com
            ycy4360@qq.com
            592064924@qq.com
            324587990@qq.com
            hanjwz@163.com
            847480028@qq.com
            business@douban.com

            进程已结束，退出代码 0

             */


            //System.out.println(line);
        }
    }


    /*
    获取指定文档中的邮件地址。
    使用获取功能。Pattern Matcher

     */
    public static void getMails() throws IOException {
        BufferedReader bufr = new BufferedReader(new FileReader("myfile\\day25\\mail.txt"));

        String line = null;

        String mailreg = "\\w+@\\w+(\\.\\w+)+";
        Pattern p = Pattern.compile(mailreg);


        while ((line = bufr.readLine())!=null)
        {
            Matcher m = p.matcher(line);
            while (m.find())
            {
                System.out.println(m.group());
            }




            //System.out.println(line);
        }


        //String str = "";


    }
}
