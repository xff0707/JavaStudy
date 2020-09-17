package supplementary.jichujiaqiang.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo4 {
    public static void main(String[] args) throws IOException {
        /*
        1.��ȡ��Ԫ�ض���
        getElementById (String id)����id����ֵ��ȡΨһ��element����
        getElementsByTag (String tagName)���ݱ�ǩ���ƻ�ȡԪ�ض��󼯺�
        getElementsByAttribute (String key)�����������ƻ�ȡԪ�ض��󼯺�
        getElementsByAttributeValue (String key, String value)���ݶ�Ӧ��������������ֵ��ȡԪ�ض���
        2.��ȡ����ֵ
        String attr(String key)�������������ƻ�ȡ����ֵ
        3.��ȡ�ı�����
        String text()����ȡ�ı�����
        String html()����ȡ��ǩ�����������(�����ӱ�ǩ���ַ�������)
         */
        //��ȡstudent.xml��path
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //��ȡDocument����
        Document document = Jsoup.parse(new File(path), "GBK");

        //ͨ��Document�����ȡname��ǩ����ȡ���е�name��ǩ�����Ի�ȡ������
        Elements name = document.getElementsByTag("name");
        System.out.println(name.size());

        System.out.println("************************************************");

        //
        Element element_student = document.getElementsByTag("student").get(0);
        Elements ele_name = element_student.getElementsByTag("name");
        System.out.println(ele_name.size());

        System.out.println("************************************************");

        //��ȡstudent��������ֵ
        String number = element_student.attr("number");
        System.out.println(number);

        System.out.println("************************************************");

        //��ȡ�ı�����
        String text1 = ele_name.text();
        String html = ele_name.html();
        System.out.println(text1);
        System.out.println("************************************************");
        System.out.println(html);




    }
}
