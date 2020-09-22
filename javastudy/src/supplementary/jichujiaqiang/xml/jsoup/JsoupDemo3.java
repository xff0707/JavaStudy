package supplementary.jichujiaqiang.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo3 {
    public static void main(String[] args) throws IOException {
        //Document/Element����
        //��ȡstudent.xml��path
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //��ȡDocument����
        Document document = Jsoup.parse(new File(path), "GBK");

        //3��ȡԪ�ض���
        //3.1��ȡ����student����
        Elements student = document.getElementsByTag("student");
        System.out.println(student);

        System.out.println("************************");

        //3.2��ȡ������Ϊid��Ԫ�ض�����
        Elements elements = document.getElementsByAttribute("id");
        System.out.println(elements);

        System.out.println("************************");

        //��ȡnumber����ֵΪs1��Ԫ�ض���
        Elements elem = document.getElementsByAttributeValue("number", "s1");
        System.out.println(elem);

        System.out.println("************************");

        //3.3��ȡid����ֵ��Ԫ��
        Element elet = document.getElementById("d1");
        System.out.println(elet);
    }
}
