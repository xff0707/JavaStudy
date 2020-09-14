package supplementary.jichujiaqiang.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo5 {
    public static void main(String[] args) throws IOException {
        //获取student.xml的path
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //获取Document对象
        Document document = Jsoup.parse(new File(path), "GBK");

        //3.查询name标签
        /*
        div{

        }
        */
        Elements elements = document.select("name");
        System.out.println(elements);

        System.out.println("*********************************");

        //查询id值为d2的元素
        Elements elements1 = document.select("#d2");
        System.out.println(elements1);

        System.out.println("*********************************");

        //获取student标签，number属性值为s1的age子标签
        //5.1 student
        Elements elements_student_num_s1 = document.select("student[number='s1']");
        //Elements elements_student_num_s2 = document.select("student[number=\"s1\"]");
        System.out.println(elements_student_num_s1);

        System.out.println("*********************************");

        //5.2 获取age子标签
        Elements elements_student_num_s2 = document.select("student[number='s1'] > age");
        System.out.println(elements_student_num_s2);



    }
}
