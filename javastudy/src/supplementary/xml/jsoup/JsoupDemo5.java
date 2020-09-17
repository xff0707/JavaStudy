package supplementary.jichujiaqiang.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo5 {
    public static void main(String[] args) throws IOException {
        //��ȡstudent.xml��path
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //��ȡDocument����
        Document document = Jsoup.parse(new File(path), "GBK");

        //3.��ѯname��ǩ
        /*
        div{

        }
        */
        Elements elements = document.select("name");
        System.out.println(elements);

        System.out.println("*********************************");

        //��ѯidֵΪd2��Ԫ��
        Elements elements1 = document.select("#d2");
        System.out.println(elements1);

        System.out.println("*********************************");

        //��ȡstudent��ǩ��number����ֵΪs1��age�ӱ�ǩ
        //5.1 student
        Elements elements_student_num_s1 = document.select("student[number='s1']");
        //Elements elements_student_num_s2 = document.select("student[number=\"s1\"]");
        System.out.println(elements_student_num_s1);

        System.out.println("*********************************");

        //5.2 ��ȡage�ӱ�ǩ
        Elements elements_student_num_s2 = document.select("student[number='s1'] > age");
        System.out.println(elements_student_num_s2);



    }
}
