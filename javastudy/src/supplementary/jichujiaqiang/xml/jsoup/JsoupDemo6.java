package supplementary.jichujiaqiang.xml.jsoup;

import java.io.IOException;

public class JsoupDemo6 {
    public static void main(String[] args) throws IOException {
/*
        //获取student.xml的path
        String path = JsoupDemo1.class.getClassLoader().getResource("student.xml").getPath();
        //获取Document对象
        Document document = Jsoup.parse(new File(path), "GBK");

        //3.根据document对象，创建JXDocument对象
        //JXDocument jxDocument = new JXDocument(document);

        //结合xpath语法查询
        //4.1查询所有student标签
        List<JXNode> jxnodes = jxDocument.selN("//student");

        for (JXNode jxnode: jxNodes
             ) {
            System.out.println(jxnode);
            Element element = jxnode.getElement();
        }

        //4.2查询所有student标签下的name标签
        List<JXNode> jxnodes2 = jxDocument.selN("//student/name");

        for (JXNode jxnode: jxNodes2
        ) {
            System.out.println(jxnode);
            Element element = jxnode.getElement();
        }

        //查询student标签下带有id属性的name标签
        List<JXNode> jxnodes3 = jxDocument.selN("//student/name[@id]");

        for (JXNode jxnode: jxnodes3
        ) {
            System.out.println(jxnode);
            Element element = jxnode.getElement();
        }


        //查询student标签下带有id属性的name标签,并且id属性值为s1
        List<JXNode> jxnodes4 = jxDocument.selN("//student/name[@id='s1']");

        for (JXNode jxnode: jxNodes4
        ) {
            System.out.println(jxnode);
            Element element = jxnode.getElement();
        }


*/
    }
}
