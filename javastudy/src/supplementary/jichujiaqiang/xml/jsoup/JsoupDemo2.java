package supplementary.jichujiaqiang.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class JsoupDemo2 {
    public static void main(String[] args) throws IOException {
        //2.1获取student.xml的path
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //2.2解析xml文档，加载文档进内存，获取dom树-->Domcument
        //Document document = Jsoup.parse(new File(path), "GBK");
        //System.out.println(document);


        /*

        //2.parse(String html)
        String str = "<!--?xml version=\"1.0\" encoding=\"GBK\" ?--><!--<!DOCTYPE students SYSTEM \"student.dtd\">--><!doctype students><!--ELEMENT student (name,age,sex)--><!--ELEMENT name (#PCDATA)--><!--ELEMENT age (#PCDATA)--><!--ELEMENT sex (#PCDATA)--><!--ATTLIST student number ID #REQUIRED-->\n" +
                "<html>\n" +
                " <head></head>\n" +
                " <body>\n" +
                "   ]&gt; <students> \n" +
                "   <student number=\"s1\"> \n" +
                "    <name>\n" +
                "     张三\n" +
                "    </name> \n" +
                "    <age>\n" +
                "     24\n" +
                "    </age> \n" +
                "    <sex>\n" +
                "     男\n" +
                "    </sex> \n" +
                "   </student> \n" +
                "   <student number=\"s2\"> \n" +
                "    <name>\n" +
                "     李四\n" +
                "    </name> \n" +
                "    <age>\n" +
                "     22\n" +
                "    </age> \n" +
                "    <sex>\n" +
                "     女\n" +
                "    </sex> \n" +
                "   </student> \n" +
                "  </students>\n" +
                " </body>\n" +
                "</html>";
        Document d = Jsoup.parse(str);
        System.out.println(d);

         */


        //3.parse?(URL url, int timeoutMillis)
        URL url = new URL("https://www.bilibili.com/video/BV1P7411F7Wr?p=11");
        Document d = Jsoup.parse(url,10000);//爬虫
        System.out.println(d);


    }
}
