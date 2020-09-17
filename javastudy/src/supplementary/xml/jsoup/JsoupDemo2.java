package supplementary.jichujiaqiang.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.net.URL;

public class JsoupDemo2 {
    public static void main(String[] args) throws IOException {
        //2.1��ȡstudent.xml��path
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //2.2����xml�ĵ��������ĵ����ڴ棬��ȡdom��-->Domcument
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
                "     ����\n" +
                "    </name> \n" +
                "    <age>\n" +
                "     24\n" +
                "    </age> \n" +
                "    <sex>\n" +
                "     ��\n" +
                "    </sex> \n" +
                "   </student> \n" +
                "   <student number=\"s2\"> \n" +
                "    <name>\n" +
                "     ����\n" +
                "    </name> \n" +
                "    <age>\n" +
                "     22\n" +
                "    </age> \n" +
                "    <sex>\n" +
                "     Ů\n" +
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
        Document d = Jsoup.parse(url,10000);//����
        System.out.println(d);


    }
}
