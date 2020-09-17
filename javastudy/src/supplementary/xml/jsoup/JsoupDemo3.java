package supplementary.jichujiaqiang.xml.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo3 {
    public static void main(String[] args) throws IOException {
        //Document/Element对象
        //获取student.xml的path
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //获取Document对象
        Document document = Jsoup.parse(new File(path), "GBK");

        //3获取元素对象
        //3.1获取所有student对象
        Elements student = document.getElementsByTag("student");
        System.out.println(student);

        System.out.println("************************");

        //3.2获取属性名为id的元素对象们
        Elements elements = document.getElementsByAttribute("id");
        System.out.println(elements);

        System.out.println("************************");

        //获取number属性值为s1的元素对象
        Elements elem = document.getElementsByAttributeValue("number", "s1");
        System.out.println(elem);

        System.out.println("************************");

        //3.3获取id属性值的元素
        Element elet = document.getElementById("d1");
        System.out.println(elet);
    }
}
